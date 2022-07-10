package xu.game.okay.page.admin.choose;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.*;

/** 
 * @Description: 选择管理界面
 * @Author: xuyujun
 * @Date: 2022/4/12 
 */ 
public class ChooseJPanel extends BaseJPanel {

    @Override
    public void addControls() {
        add(ChooseControls.welcome);
        add(ChooseControls.manageLevel);
        add(ChooseControls.manageUser);
        add(ChooseControls.quit);
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.black);
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
