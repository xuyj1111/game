package xu.game.okay.page.defined.listener;

import xu.game.okay.enums.PlayJPanelSource;
import xu.game.okay.page.play.PlayControls;
import xu.game.okay.util.DrawBoardUtil;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.playJPanel;

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
        PlayControls.setControlsIsVisible(false);

        playJPanel.source = PlayJPanelSource.DEFINEJPANEL;
        DrawBoardUtil.setDefinedJPDrawnShape(playJPanel);
        jFrame.setContentPane(playJPanel);
        jFrame.setVisible(true);
    }
}
