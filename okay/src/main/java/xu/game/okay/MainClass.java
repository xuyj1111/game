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

    public static void main(String[] args) throws Exception {
        JdbcConfig jdbcConfig = JdbcConfig.getInstance();
        Connection connection = jdbcConfig.getConnection();
        if (Objects.isNull(connection)) {
            throw new Exception("连接数据库失败！");
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
