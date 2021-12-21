package xu.game.okay.newPlace.page;

import xu.game.okay.newPlace.impl.InnerJPanel;
import xu.game.okay.newPlace.impl.InnerMouse;

/**
 * @Description: 页面基础类
 * @Author: xuyujun
 * @Date: 2021/12/21
 */
public abstract class BasePage {

    /**
     * @Description: 页面的显示类
     */
    InnerJPanel innerJPanel;
    /**
     * @Description: 页面的鼠标监听
     */
    InnerMouse innerMouse;

    public InnerJPanel getInnerJPanel() {
        return innerJPanel;
    }

    public InnerMouse getInnerMouse() {
        return innerMouse;
    }
}
