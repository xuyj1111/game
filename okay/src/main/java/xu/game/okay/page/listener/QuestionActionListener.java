package xu.game.okay.page.listener;

import cn.hutool.core.io.FileUtil;
import xu.game.okay.constant.FileConstant;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @Description: help键（全局）
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class QuestionActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File file = File.createTempFile("desc", ".md");
            FileUtil.writeFromStream(FileConstant.DESC, file, true);
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
