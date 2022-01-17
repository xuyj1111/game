package xu.game.okay.page.admin.userList;

import xu.game.okay.constant.IconConstant;
import xu.game.okay.entity.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

/**
 * @Description: 因为需要查询数据库中的用户，所以该Controls不同其他，需要new
 * @Author: xuyujun
 * @Date: 2022/1/17
 */
public class UserListControls {
    private static JButton quit = new JButton();
    private List<User> userList;
    private JLabel[] users;
    private JLabel[] logout;
    private JLabel[] edit;

    static {
        quit.setForeground(Color.black);
        quit.setIcon(new ImageIcon(IconConstant.ADMIN_QUIT));
        quit.setBounds(310, 390, 50, 50);
        quit.setBorderPainted(false);
    }

    public UserListControls(List<User> userList) {
        this.userList = userList;
        users = new JLabel[userList.size()];
        logout = new JLabel[userList.size()];
        edit = new JLabel[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            users[i] = new JLabel((i + 1) + ": " + userList.get(i));
            users[i].setForeground(Color.gray);
            users[i].setFont(new Font("幼圆", 1, 15));
            if (i >= 9)
                users[i].setBounds(18, 25 + i * 20, 100, 15);
            else
                users[i].setBounds(25, 25 + i * 20, 100, 15);

            logout[i] = new JLabel("注销");
            logout[i].setForeground(Color.gray);
            logout[i].setFont(new Font("宋体", 1, 8));
            logout[i].setBounds(300, 25 + i * 20, 40, 15);

            edit[i] = new JLabel("编辑");
            edit[i].setForeground(Color.gray);
            edit[i].setFont(new Font("宋体", 1, 15));
            edit[i].setBounds(340, 25 + i * 20, 40, 15);
        }
    }
}
