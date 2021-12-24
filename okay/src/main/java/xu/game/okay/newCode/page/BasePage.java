package xu.game.okay.newCode.page;

import lombok.Data;
import xu.game.okay.newCode.impl.InnerJPanel;
import xu.game.okay.newCode.impl.InnerMouse;
import xu.game.okay.newCode.jdbc.JdbcAction;
import xu.game.okay.newCode.jdbc.JdbcConfig;

/**
 * @Description: 页面基类
 * @Author: xuyujun
 * @Date: 2021/12/21
 */
@Data
public abstract class BasePage {

    JdbcAction jdbc = new JdbcAction(JdbcConfig.getInstance().getConnection());

    /**
     * @Description: 页面的显示类
     */
    InnerJPanel innerJPanel;
    /**
     * @Description: 页面的鼠标监听
     */
    InnerMouse innerMouse;
}
