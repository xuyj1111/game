package xu.game.okay.page.base;

import lombok.Getter;
import lombok.Setter;

import java.awt.Graphics2D;
import java.util.function.Function;

public class BaseJPanel extends AbstractJPanel {

    /**
    * @Description: 显示绘图板中的线条（动态变化）
    */
    @Getter
    @Setter
    private Function<Graphics2D, Void> drawing;

    /**
    * @Description: 显示已构建完的图形（动态变化）
    */
    @Getter
    @Setter
    private Function<Graphics2D, Void> drawnShape;

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

    @Override
    public void addComponentAdapter() {

    }
}
