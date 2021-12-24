package xu.game.okay.oldCode.mouseAdapter;


import xu.game.okay.newCode.jdbc.JdbcConfig;
import xu.game.okay.Main;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author shkstart
 * @create 2020-03-07-18:42
 */
public class MouseAdapter_admin_logout extends MouseAdapter {
    public JLabel[] logout;
    public int i;
    public String[] username;
    JdbcConfig instance = JdbcConfig.getInstance();

    public MouseAdapter_admin_logout(JLabel[] logout, int i, String username) {
        this.logout = logout;
        this.i = i;
        this.username = username.split(" ");
    }

    @Override
    public void mouseEntered(MouseEvent e) {             //移入
        logout[i].setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {              //移除
        logout[i].setForeground(Color.gray);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        instance.update("delete from biao1 where name = " + "'" + username[1] + "'");
        instance.update("delete from biao3 where name = " + "'" + username[1] + "'");
        Main.admin_manageUsers();
    }
}
