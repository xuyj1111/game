package xu.game.okay.page.user.choose;

import xu.game.okay.page.base.BaseJPanel;

import java.awt.*;

/** 
 * @Description: 用户模式选择界面
 * @Author: xuyujun
 * @Date: 2022/4/12 
 */ 
public class ChooseJPanel extends BaseJPanel {

    /**
     * 用户名
     */
    public String userName;

    /**
     * 由于用户名是动态变化，因此不能为静态
     */
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
        g.drawRect(10, 10, getWidth() - 20, getHeight() - 20);
        super.paintComponents(g);
    }
}
