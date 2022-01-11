package xu.game.okay.newCode.page.init;

import xu.game.okay.newCode.constant.IconConstant;
import xu.game.okay.newCode.page.base.BaseJPanel;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class InitJPanel extends BaseJPanel {

    @Override
    public void addControls() {
    }

    @Override
    public void addMouse() {
        addMouseListener(new InitMouse());
    }

    @Override
    public void addComponentAdapter() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
