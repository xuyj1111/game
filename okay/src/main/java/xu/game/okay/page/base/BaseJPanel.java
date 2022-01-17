package xu.game.okay.page.base;

public class BaseJPanel extends AbstractJPanel {

    public BaseJPanel() {
        setLayout(null);
        setBounds(0, 0, getWidth(), getHeight());
        addControls();
        addMouse();
    }

    @Override
    public void addControls() {
    }

    @Override
    public void addMouse() {

    }

    //待删
    @Override
    public void addComponentAdapter() {

    }
}
