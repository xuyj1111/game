package xu.game.okay;

import xu.game.okay.newCode.jdbc.JdbcConfig;
import xu.game.okay.page.LoginPage;
import xu.game.okay.page.login.RegisterPage;
import xu.game.okay.page.other.NumberPage;
import xu.game.okay.page.users.DefinedMenuPage;
import xu.game.okay.page.users.DefinedPage;
import xu.game.okay.page.users.GametimeMenuPage;
import xu.game.okay.page.users.GametimePage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.util.Objects;

/**
 * @author shkstart
 * @create 2020-03-06-22:03
 */
public class Main {
    public static JPanel jPanel = new JPanel();
    public static JFrame jFrame = new JFrame();

    public static int moo;
    public static String username;
    public static GametimePage gametimePage;
    public static int guan;
    public static int nguan;
    public static int num;
    public static boolean admin = false;

    public static void start() {
//        jPanel = new InitPage();
//        MouseAdapter_start mouseAdapter_start = new MouseAdapter_start(jPanel);
//        jPanel.addMouseListener(mouseAdapter_start);
    }

    public static void login() {
        jPanel = new LoginPage();
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void register() {
        jPanel = new RegisterPage();
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void number() {
        jPanel = new NumberPage(num);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    //*****************************user*****************************
    public static void user_choose() {
        jPanel = new xu.game.okay.page.users.ChoosePage(username);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void user_defined() {
        jPanel = new DefinedPage(username);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void user_defined_menu() {
        jPanel = new DefinedMenuPage(username);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void user_gametime() {
        gametimePage = new GametimePage(username, guan, nguan);
        jPanel = gametimePage;
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void user_gametime_menu() {
        jPanel = new GametimeMenuPage(username);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    //    *****************************user*****************************
//    *****************************admin*****************************
    public static void admin_choose() {
//        jPanel = new ChoosePage();
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void admin_manageGametimeMenu() {
        jPanel = new xu.game.okay.page.admin.ManageGametimeMenuPage();
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void admin_manageUsers() {
        jPanel = new xu.game.okay.page.admin.ManageUsersPage();
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void admin_manageUsersEdit(String username) {
        jPanel = new xu.game.okay.page.admin.ManageUsersEditPage(username);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void admin_manageDefinedMenu() {
        jPanel = new xu.game.okay.page.admin.ManageDefinedMenuPage(username);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public static void admin_defined() {
        jPanel = new xu.game.okay.page.admin.ManageDefinedPage();
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }
//    *****************************admin*****************************


    public static void main(String[] args) throws Exception {
        JdbcConfig jdbcConfig = JdbcConfig.getInstance();
        Connection connection = jdbcConfig.getConnection();
        if (Objects.isNull(connection)) {
            throw new Exception("连接数据库失败！");
        }


        start();

        jFrame.setDefaultLookAndFeelDecorated(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(600, 10, 800, 1000);
        jFrame.setLayout(new FlowLayout());
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }
}
