package xu.game.okay;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
    private static String URL = "jdbc:mysql://localhost:3306/my_game?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
    private static String USER = "root";
    private static String PSD = "root";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static java.sql.Connection conn;
    private static PreparedStatement ps;
    private static ResultSet resultSet;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static java.sql.Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USER, PSD);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void update(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStream();
        }
    }

    public static String query(String sql) {
        String string = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
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

    public static String[] querys(String sql) {
        String[] string = new String[Integer.valueOf(Jdbc.query("select count(*) from biao1 where name != 'admin'"))];
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                string[i] = resultSet.getString(1);
                i++;
            }
            return string;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeStream();
        }
    }

    private static void closeStream() {
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
