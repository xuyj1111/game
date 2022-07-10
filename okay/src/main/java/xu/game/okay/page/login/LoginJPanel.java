package xu.game.okay.page.login;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.*;

/**
 * @Description: 登陆界面
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class LoginJPanel extends BaseJPanel {

    @Override
    public void addControls() {
        add(LoginControls.login);
        add(LoginControls.userName);
        add(LoginControls.passWord);
        add(LoginControls.userNameF);
        add(LoginControls.passWordF);
        add(LoginControls.register);
        add(LoginControls.loginJ);
        add(LoginControls.question);
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
        g.drawRect(10, 10, getWidth() - 20, getHeight() - 20);
        super.paintComponents(g);
    }
}
