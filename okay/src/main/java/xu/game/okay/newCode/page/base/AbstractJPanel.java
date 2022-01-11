package xu.game.okay.newCode.page.base;

import javax.swing.JPanel;

public abstract class AbstractJPanel extends JPanel {

    /**
     * @Description: 添加控件集
     */
    public abstract void addControls();
    /**
     * @Description: 添加鼠标监听
     */
    public abstract void addMouse();
    /**
     * @Description: 添加窗口监听
     */
    public abstract void addComponentAdapter();
}
