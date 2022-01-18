package xu.game.okay.factory;

import xu.game.okay.jdbc.JdbcAction;
import xu.game.okay.jdbc.JdbcConfig;
import xu.game.okay.page.admin.choose.ChooseJPanel;
import xu.game.okay.page.admin.userEdit.UserEditJPanel;
import xu.game.okay.page.admin.userList.UserListJPanel;
import xu.game.okay.page.init.InitJPanel;
import xu.game.okay.page.login.LoginJPanel;
import xu.game.okay.page.register.RegisterJPanel;

public class BeanFactory {

    public static JdbcAction jdbc = new JdbcAction(JdbcConfig.getInstance().getConnection());
    public static InitJPanel initJPanel = new InitJPanel();
    public static LoginJPanel loginJPanel = new LoginJPanel();
    public static RegisterJPanel registerJPanel = new RegisterJPanel();
    public static ChooseJPanel adminChooseJPanel = new ChooseJPanel();
    public static UserListJPanel userListJPanel = new UserListJPanel();
    public static UserEditJPanel userEditJPanel = new UserEditJPanel();
}
