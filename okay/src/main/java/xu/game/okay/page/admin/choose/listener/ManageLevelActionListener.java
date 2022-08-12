package xu.game.okay.page.admin.choose.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static xu.game.okay.util.BeanFactory.jFrame;
import static xu.game.okay.util.BeanFactory.adminMenuJPanel;

/** 
 * @Description: 管理关卡键
 * @Author: xuyujun
 * @Date: 2022/4/12 
 */ 
public class ManageLevelActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.setContentPane(adminMenuJPanel);
        jFrame.setVisible(true);
    }
}
