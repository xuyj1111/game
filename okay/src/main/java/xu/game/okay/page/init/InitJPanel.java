package xu.game.okay.page.init;

import xu.game.okay.page.base.BaseJPanel;
import xu.game.okay.page.init.listener.InitMouse;

import java.awt.Graphics;

/**
 * @Description: 初始界面
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
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
