package xu.game.okay.page.register;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.*;

/**
 * @Description: 注册界面
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class RegisterJPanel extends BaseJPanel {

    @Override
    public void addControls() {
        add(RegisterControls.register);
        add(RegisterControls.userName);
        add(RegisterControls.passWord);
        add(RegisterControls.passWord2);
        add(RegisterControls.usernameF);
        add(RegisterControls.passWordF);
        add(RegisterControls.passWord2F);
        add(RegisterControls.confirm);
        add(RegisterControls.cancel);
        add(RegisterControls.question);
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.white);
        g.clearRect(0, 0, getWidth(), getHeight());
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 10,},
                0f);
        g.setStroke(dash);
        g.setColor(Color.gray);
        g.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        super.paintComponents(g);
    }
}
