package xu.game.okay.util;

import xu.game.okay.jdbc.JdbcAction;
import xu.game.okay.jdbc.JdbcConfig;
import xu.game.okay.page.admin.choose.ChooseJPanel;
import xu.game.okay.page.admin.menu.MenuJPanel;
import xu.game.okay.page.admin.userEdit.UserEditJPanel;
import xu.game.okay.page.admin.userList.UserListJPanel;
import xu.game.okay.page.admin.userMenu.UserMenuJPanel;
import xu.game.okay.page.defined.DefinedJPanel;
import xu.game.okay.page.init.InitJPanel;
import xu.game.okay.page.login.LoginJPanel;
import xu.game.okay.page.play.PlayJPanel;
import xu.game.okay.page.register.RegisterJPanel;

import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class BeanFactory {

    public static JFrame jFrame = new JFrame();
    public static File descFile;
    public static JdbcAction jdbc = new JdbcAction(JdbcConfig.getInstance().getConnection());
    public static InitJPanel initJPanel = new InitJPanel();
    public static LoginJPanel loginJPanel = new LoginJPanel();
    public static RegisterJPanel registerJPanel = new RegisterJPanel();
    /**
     * @Description: 以下为管理员JPanel
     */
    public static ChooseJPanel adminChooseJPanel = new ChooseJPanel();
    public static MenuJPanel adminMenuJPanel = new MenuJPanel();
    public static UserListJPanel userListJPanel = new UserListJPanel();
    public static UserEditJPanel userEditJPanel = new UserEditJPanel();
    public static UserMenuJPanel userMenuJPanel = new UserMenuJPanel();
    /**
     * @Description: 以下为用户JPanel
     */
    public static xu.game.okay.page.user.choose.ChooseJPanel userChooseJPanel = new xu.game.okay.page.user.choose.ChooseJPanel();
    public static xu.game.okay.page.user.menu.MenuJPanel menuJPanel = new xu.game.okay.page.user.menu.MenuJPanel();
    /**
     * @Description: 以下为共用JPanel
     */
    public static DefinedJPanel definedJPanel = new DefinedJPanel();
    public static PlayJPanel playJPanel = new PlayJPanel();

    static {
        try {
            descFile = File.createTempFile("desc", ".md");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
