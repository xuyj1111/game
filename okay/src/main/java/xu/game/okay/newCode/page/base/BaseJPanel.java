package xu.game.okay.newCode.page.base;

import xu.game.okay.newCode.jdbc.JdbcAction;
import xu.game.okay.newCode.jdbc.JdbcConfig;

import javax.swing.JPanel;

public abstract class BaseJPanel extends JPanel {

    private static JdbcAction jdbc = new JdbcAction(JdbcConfig.getInstance().getConnection());

    public BaseJPanel() {
        setLayout(null);
        setBounds(0, 0, getWidth(), getHeight());
    }

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
