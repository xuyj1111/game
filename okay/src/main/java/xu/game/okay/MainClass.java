package xu.game.okay;

import xu.game.okay.jdbc.JdbcConfig;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.util.Objects;

import static xu.game.okay.util.BeanFactory.initJPanel;
import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.jdbc;

public class MainClass {

    private static final String INIT = "init";
    private static final String TRUE = "true";

    public static void main(String[] args) throws Exception {
        JdbcConfig jdbcConfig = JdbcConfig.getInstance();
        Connection connection = jdbcConfig.getConnection();
        if (Objects.isNull(connection)) {
            throw new Exception("连接数据库失败！");
        }
        try {
            String init = System.getProperty(INIT);
            if (TRUE.equalsIgnoreCase(init)) {
                jdbc.init();
            }
        } catch (Exception e) {
            throw new Exception("初始化数据库错误！", e);
        }
        // 窗口不可调节大小
        jFrame.setResizable(false);
        // 窗口不可移动（隐藏窗口标题栏后实现不可移动，但是标题栏有高度，影响显示）
//        jFrame.setUndecorated(true);
        // 关闭时退出
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口大小
        jFrame.setBounds(0, 0, 400, 500);
        // 居中显示
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        jFrame.setContentPane(initJPanel);
        jFrame.setVisible(true);
    }
}
