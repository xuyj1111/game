package xu.game.okay.newCode.jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import xu.tools.toolsio.PropertyTool;

import java.io.IOException;
import java.sql.*;

/**
* @Description: jdbc配置类
 * 生成connection对象赋值给JdbcAction类使用
* @Author: xuyujun
* @Date: 2021/12/24
*/
@Data
@Slf4j
public class JdbcConfig {

    private static final String DB_PROPERTIES = "db.properties";
    private static final String URL = "datasource.url";
    private static final String USER = "datasource.username";
    private static final String PWD = "datasource.password";
    private static final String DRIVER = "datasource.driver";
    private static JdbcConfig instance = new JdbcConfig();
    private Connection connection;

    static {
        try {
            //获得配置信息
            String url = PropertyTool.readProperty(DB_PROPERTIES, URL);
            String user = PropertyTool.readProperty(DB_PROPERTIES, USER);
            String pwd = PropertyTool.readProperty(DB_PROPERTIES, PWD);
            String driver = PropertyTool.readProperty(DB_PROPERTIES, DRIVER);
            //初始化Driver类
            Class.forName(driver);
            //生成Connection类
            instance.connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            log.error("Failed to connect to mysql", e);
        }
    }

    //饿汉式
    private JdbcConfig() {
    }
    public static JdbcConfig getInstance() {
        return instance;
    }
}
