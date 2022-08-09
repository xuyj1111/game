package xu.game.okay.page.defined.listener;

import xu.game.okay.MainClass;
import xu.game.okay.enums.PlayJPanelSource;
import xu.game.okay.page.play.PlayControls;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 开始键（预览）
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class StartActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (DrawBoardUtil.shapeDTOS.size() == 0) {
            JOptionPane.showMessageDialog(null, "请添加图形");
            return;
        }
        // 清除所有选中
        DrawBoardUtil.shapeDTOS.forEach(shapeDTO -> shapeDTO.setIsSelected(false));
        PlayControls.isVisible = false;
        PlayControls.returm.setVisible(false);
        PlayControls.menu.setVisible(false);
        PlayControls.question.setVisible(false);

        BeanFactory.playJPanel.source = PlayJPanelSource.DEFINEJPANEL;
        DrawBoardUtil.setDefinedJPDrawnShape(BeanFactory.playJPanel);
        MainClass.jPanel = BeanFactory.playJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }
}
