package xu.game.okay.newCode.jdbc;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description: jdbc增删改查类
* @Author: xuyujun
* @Date: 2021/12/24
*/
@Slf4j
public class JdbcAction {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet resultSet;

    public JdbcAction(Connection conn) {
        this.conn = conn;
    }

    /**
    * @Description: 执行'增删改'sql
    */
    public void update(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            log.error("Failed to update database", e);
        } finally {
            closeStream();
        }
    }

    /**
    * @Description: 查询单条记录
    */
    public Map<String, Object> query(String sql) {
        HashMap<String, Object> result = Maps.newHashMap();
        try {
            //配置：1.游标可移动，即支持last()和first()方法 2.并发只读
            ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //执行sql
            resultSet = ps.executeQuery();
            //游标跳转到最后一行
            resultSet.last();
            //判断行数，大于1错误
            if (resultSet.getRow() != 1) {
                throw new Exception("Result set cannot be greater than 1");
            }
            //游标跳转到第一行
            resultSet.first();
            ResultSetMetaData metaData = resultSet.getMetaData();
            Class<? extends ResultSet> resultSetClass = resultSet.getClass();
            //遍历列，result赋值字段名+字段值
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //sql字段类型对应的Java类名
                String className = ResultSetMapping.toClass(metaData.getColumnType(i)).getSimpleName();
                //sql字段名
                String columnName = metaData.getColumnName(i);
                //调用拼接的方法
                Object value = resultSetClass.getDeclaredMethod("get" + className, int.class).invoke(resultSet, i);
                result.put(columnName, value);
            }
            return result;
        } catch (Exception e) {
            log.error("Failed to query database", e);
            return null;
        } finally {
            closeStream();
        }
    }

    /**
    * @Description: 查询多条记录
    */
    public List<Map<String, Object>> querys(String sql) {
        List<Map<String, Object>> result = Lists.newArrayList();
        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            Class<? extends ResultSet> resultSetClass = resultSet.getClass();
            while (resultSet.next()) {
                HashMap<String, Object> map = Maps.newHashMap();
                //遍历列，result赋值字段名+字段值
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    //sql字段类型对应的Java类名
                    String className = ResultSetMapping.toClass(metaData.getColumnType(i)).getSimpleName();
                    //sql字段名
                    String columnName = metaData.getColumnName(i);
                    //调用拼接的方法
                    Object value = resultSetClass.getDeclaredMethod("get" + className, int.class).invoke(resultSet, i);
                    map.put(columnName, value);
                }
                result.add(map);
            }
            return result;
        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeStream();
        }
    }

    /**
    * @Description: 关闭流
    */
    private void closeStream() {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
