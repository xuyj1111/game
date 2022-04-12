package xu.game.okay.page.user.choose;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.*;

/** 
 * @Description: 用户模式选择界面
 * @Author: xuyujun
 * @Date: 2022/4/12 
 */ 
public class ChooseJPanel extends BaseJPanel {

    public String userName;
    public ChooseControls chooseControls;

    @Override
    public void addControls() {
        removeAll();
        chooseControls = new ChooseControls(userName);
        add(chooseControls.welcome);
        add(ChooseControls.through);
        add(ChooseControls.defined);
        add(ChooseControls.quit);
        add(ChooseControls.question);
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
