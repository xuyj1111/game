package xu.game.okay.newCode.page.init;

import xu.game.okay.newCode.page.base.BaseJPanel;

import java.awt.Graphics;

public class InitJPanel extends BaseJPanel {
    
    @Override
    public void addMouse() {
        addMouseListener(new InitMouse());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(InitControls.img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
