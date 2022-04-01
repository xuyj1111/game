package xu.game.okay.util;

import xu.game.okay.jdbc.JdbcAction;
import xu.game.okay.jdbc.JdbcConfig;
import xu.game.okay.page.admin.choose.ChooseJPanel;
import xu.game.okay.page.admin.menu.MenuJPanel;
import xu.game.okay.page.admin.userEdit.UserEditJPanel;
import xu.game.okay.page.admin.userList.UserListJPanel;
import xu.game.okay.page.admin.userMenu.UserMenuJPanel;
import xu.game.okay.page.init.InitJPanel;
import xu.game.okay.page.login.LoginJPanel;
import xu.game.okay.page.register.RegisterJPanel;
import xu.game.okay.page.user.defined.DefinedJPanel;

public class BeanFactory {

    public static JdbcAction jdbc = new JdbcAction(JdbcConfig.getInstance().getConnection());
    public static InitJPanel initJPanel = new InitJPanel();
    public static LoginJPanel loginJPanel = new LoginJPanel();
    public static RegisterJPanel registerJPanel = new RegisterJPanel();
    //管理员
    public static ChooseJPanel adminChooseJPanel = new ChooseJPanel();
    public static MenuJPanel adminMenuJPanel = new MenuJPanel();
    public static UserListJPanel userListJPanel = new UserListJPanel();
    public static UserEditJPanel userEditJPanel = new UserEditJPanel();
    public static UserMenuJPanel userMenuJPanel = new UserMenuJPanel();
    //用户
    public static xu.game.okay.page.user.choose.ChooseJPanel userChooseJPanel = new xu.game.okay.page.user.choose.ChooseJPanel();
    public static DefinedJPanel definedJPanel = new DefinedJPanel();
    public static xu.game.okay.page.user.menu.MenuJPanel menuJPanel = new xu.game.okay.page.user.menu.MenuJPanel();
}
