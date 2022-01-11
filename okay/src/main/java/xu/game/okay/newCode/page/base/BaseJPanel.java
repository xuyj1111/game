package xu.game.okay.newCode.page.base;

import xu.game.okay.newCode.jdbc.JdbcAction;
import xu.game.okay.newCode.jdbc.JdbcConfig;

public class BaseJPanel extends AbstractJPanel {

    private static JdbcAction jdbc = new JdbcAction(JdbcConfig.getInstance().getConnection());

    public BaseJPanel() {
        setLayout(null);
        setBounds(0, 0, getWidth(), getHeight());
        addMouse();
    }

    @Override
    public void addControls() {
    }

    @Override
    public void addMouse() {

    }

    @Override
    public void addComponentAdapter() {

    }
}
