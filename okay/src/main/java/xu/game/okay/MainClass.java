package xu.game.okay;

import xu.game.okay.jdbc.JdbcConfig;
import xu.game.okay.util.BeanFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.util.Objects;

public class MainClass {

    public static JFrame jFrame = new JFrame();
    public static JPanel jPanel = BeanFactory.initJPanel;
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
                BeanFactory.jdbc.init();
            }
        } catch (Exception e) {
            throw new Exception("初始化数据库错误！", e);
        }
        // 设置窗口不可调节大小
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(0, 0, 400, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }
}
