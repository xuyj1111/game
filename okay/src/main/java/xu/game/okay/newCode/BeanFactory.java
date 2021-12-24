package xu.game.okay.newCode;

import xu.game.okay.newCode.page.BasePage;
import xu.game.okay.newCode.page.InitPage;
import xu.game.okay.newCode.page.LoginPage;

public class BeanFactory {
    public static BasePage initPage = new InitPage();
    public static BasePage loginPage = new LoginPage();
}
