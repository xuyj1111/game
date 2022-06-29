package xu.game.okay.page.user.menu.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;
import xu.game.okay.MainClass;
import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.enums.PlayJPanelSource;
import xu.game.okay.page.play.PlayControls;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.DrawBoardUtil;
import xu.tools.json.JsonMapper;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 用户关卡数字键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
@Slf4j
public class NumberMouseListener implements MouseListener {

    /**
     * 关卡序号颜色
     */
    private Color foreground;

    @Override
    public void mouseClicked(MouseEvent e) {
        // 判断颜色，是否点击有效
        if (foreground.equals(new Color(192, 192, 193))) {
            return;
        }
        JLabel label = (JLabel) e.getSource();
        label.setForeground(foreground);
        String map = null;
        String number = label.getText();
        List<Map<String, Object>> querys = BeanFactory.jdbc.querys("SELECT map FROM level WHERE is_system = 0 AND level_id = '%s'", number);
        if (!CollectionUtils.isEmpty(querys)) {
            map = querys.stream().map(q -> String.valueOf(q.get("map"))).collect(Collectors.toList()).get(0);
        }
        if (Strings.isBlank(map)) {
            log.error("未找到对应关卡！");
            return;
        }
        DrawBoardUtil.shapeDTOS = JsonMapper.parseList(map, ShapeDTO.class);
        DrawBoardUtil.setDefinedJPDrawnShape(BeanFactory.playJPanel);
        PlayControls.isVisible = false;
        PlayControls.returm.setVisible(false);
        PlayControls.menu.setVisible(false);
        PlayControls.question.setVisible(false);

        BeanFactory.playJPanel.source = PlayJPanelSource.MENUJPANEL;
        MainClass.jPanel = BeanFactory.playJPanel;
        MainClass.jFrame.setContentPane(MainClass.jPanel);
        MainClass.jFrame.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        foreground = label.getForeground();
        if (label.getForeground().equals(Color.black)) {
            label.setForeground(Color.lightGray);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if (label.getForeground().equals(Color.lightGray)) {
            label.setForeground(Color.black);
        }
    }
}
