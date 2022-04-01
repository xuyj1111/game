package xu.game.okay.page.base;

import lombok.Getter;
import lombok.Setter;

import java.awt.Graphics2D;
import java.util.function.Function;

public class BaseJPanel extends AbstractJPanel {

    /**
    * @Description: JPanel的paint方法中使用，可动态插入代码，实现绘图中的线条
    */
    @Getter
    @Setter
    private Function<Graphics2D, Void> drawing;

    /**
    * @Description: like drawing attribute，绘画已构建完的图形
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
