package xu.game.okay.newCode;

import xu.game.okay.newCode.jdbc.JdbcConfig;
import xu.game.okay.newCode.page.InitPage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.util.Objects;

public class TestMain {

    public static JFrame jFrame = new JFrame();
    public static JPanel jPanel = new InitPage().getInnerJPanel();

    public static void main(String[] args) throws Exception {
        JdbcConfig jdbcConfig = JdbcConfig.getInstance();
        Connection connection = jdbcConfig.getConnection();
        if (Objects.isNull(connection)) {
            throw new Exception("连接数据库失败！");
        }
        jFrame.setDefaultLookAndFeelDecorated(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(600, 10, 800, 1000);
        jFrame.setLayout(new FlowLayout());
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }
}
