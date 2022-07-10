package xu.game.okay.jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
            String url = getPropertyValue(URL);
            String user = getPropertyValue(USER);
            String pwd = getPropertyValue(PWD);
            String driver = getPropertyValue(DRIVER);
            //初始化Driver类
            Class.forName(driver);
            //生成Connection类
            instance.connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            log.error("Failed to connect to mysql", e);
        }
    }

    private static String getPropertyValue(String key) throws IOException {
        InputStream in = JdbcConfig.class.getClassLoader().getResourceAsStream(DB_PROPERTIES);
        Properties properties = new Properties();
        properties.load(in);
        return properties.getProperty(key);
    }

    //饿汉式
    private JdbcConfig() {
    }

    public static JdbcConfig getInstance() {
        return instance;
    }
}
