package xu.game.okay.page.user.defined.listener;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pointB = (JButton) e.getSource();
        pointB.setBorderPainted(!pointB.isBorderPainted());
    }
}
