package xu.game.okay.page.defined.listener;

import xu.game.okay.page.defined.DefinedControls;
import xu.game.okay.util.DrawBoardUtil;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: `点`键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class PointActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pointB = (JButton) e.getSource();
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
