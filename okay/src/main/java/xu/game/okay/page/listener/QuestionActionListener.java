package xu.game.okay.page.listener;

import xu.game.okay.constant.IconConstant;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class QuestionActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new File(IconConstant.DESC);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
