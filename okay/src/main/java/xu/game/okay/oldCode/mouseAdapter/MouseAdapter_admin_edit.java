package xu.game.okay.oldCode.mouseAdapter;


import xu.game.okay.Main;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author shkstart
 * @create 2020-03-07-18:49
 */
public class MouseAdapter_admin_edit extends MouseAdapter {
    public JLabel[] edit;
    public int i;
    public String[] username;

    public MouseAdapter_admin_edit(JLabel[] edit, int i, String username) {
        this.edit = edit;
        this.i = i;
        this.username = username.split(" ");
    }

    public void mouseEntered(MouseEvent e) {             //移入
        edit[i].setForeground(Color.blue);
    }

    public void mouseExited(MouseEvent e) {              //移除
        edit[i].setForeground(Color.gray);
    }

    public void mouseClicked(MouseEvent e) {
        Main.admin_manageUsersEdit(username[1]);
    }
}
