package xu.game.okay.page.defined.listener;

import xu.game.okay.dto.ShapeDTO;
import xu.game.okay.util.DrawBoardUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 删除键
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class DeleteActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        List<ShapeDTO> shapeDTOS = DrawBoardUtil.shapeDTOS;
        DrawBoardUtil.shapeDTOS = shapeDTOS.stream().filter(s -> !s.getIsSelected()).collect(Collectors.toList());
    }
}
