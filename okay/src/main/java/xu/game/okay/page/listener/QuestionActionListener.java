package xu.game.okay.page.listener;

import cn.hutool.core.io.FileUtil;
import xu.game.okay.constant.FileConstant;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static xu.game.okay.util.BeanFactory.descFile;

/**
 * @Description: help键（全局）
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class QuestionActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (FileUtil.isEmpty(descFile)) {
                FileUtil.writeFromStream(FileConstant.DESC, descFile, true);
            }
            Desktop.getDesktop().open(descFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
