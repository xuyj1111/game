package xu.game.okay;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import xu.tools.toolsio.PropertyTool;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Jdbc {

    private static final String DB_PROPERTIES = "db.properties";
    private static final String URL = "datasource.url";
    private static final String USER = "datasource.username";
    private static final String PWD = "datasource.password";
    private static final String DRIVER = "datasource.driver";

    private static Jdbc instance = new Jdbc();

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet resultSet;

    //饿汉式
    private Jdbc() {
    }

    static {
        try {
            String url = PropertyTool.readProperty(DB_PROPERTIES, URL);
            String user = PropertyTool.readProperty(DB_PROPERTIES, USER);
            String pwd = PropertyTool.readProperty(DB_PROPERTIES, PWD);
            String driver = PropertyTool.readProperty(DB_PROPERTIES, DRIVER);
            Class.forName(driver);
            instance.conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            log.error("Failed to connect to mysql", e);
        }
    }

    public static Jdbc getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public void update(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStream();
        }
    }

    public String query(String sql) {
        String string = null;
        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                string = resultSet.getString(1);
            }
            return string;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeStream();
        }
    }

    public List querys(String sql) {
        ArrayList<Object> list = Lists.newArrayList();
        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeStream();
        }
    }

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
