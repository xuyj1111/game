package xu.game.okay.page.user.defined.listener;

import xu.game.okay.page.user.defined.DefinedControls;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pointB = (JButton) e.getSource();
        //首先赋值 drawJPanel, 表示在指定的 JPanel 上绘图
        DrawBoardUtil.drawJPanel = BeanFactory.definedJPanel;
        DrawBoardUtil.logicForDraw(getIndex(pointB), pointB);
    }

    private int getIndex(JButton pointB){
        int i = 0;
        for (JButton jButton : DefinedControls.components) {
            if (pointB.equals(jButton)) {
                break;
            }
            i++;
        }
        return i;
    }
}
