package xu.game.okay.page.admin.userList;

import com.google.common.collect.Lists;
import lombok.Data;
import xu.game.okay.constant.FileConstant;
import xu.game.okay.entity.User;
import xu.game.okay.page.admin.userList.listener.EditMouseListener;
import xu.game.okay.page.admin.userList.listener.LogoutMouseListener;
import xu.game.okay.page.admin.userList.listener.QuitActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

public class UserListControls {
    public static JButton quit = new JButton();

    /**
     * @Description: 用户控件数量根据数据库中变化，因此不能是静态
     * userList：保存User对象
     * userJLabels：保存一个user对应的三个控件（用户名，注销，编辑）
     */
    public List<User> userList;
    public List<UserJLabel> userJLabels;

    @Data
    public class UserJLabel {
        public JLabel user;
        public JLabel logout;
        public JLabel edit;
    }

    static {
        quit.setContentAreaFilled(false);
        quit.setIcon(new ImageIcon(FileConstant.ADMIN_QUIT));
        quit.setBounds(310, 390, 50, 50);
        quit.setBorderPainted(false);
        quit.addActionListener(new QuitActionListener());
    }

    public UserListControls(List<User> userList) {
        this.userList = userList;
        userJLabels = Lists.newArrayList();
        for (int i = 0; i < userList.size(); i++) {
            UserJLabel userJLabel = new UserJLabel();
            JLabel user = new JLabel(userList.get(i).getName());
            user.setForeground(Color.gray);
            user.setFont(new Font("幼圆", 1, 15));
            if (i >= 9)
                user.setBounds(25, 25 + i * 20, 100, 15);
            else
                user.setBounds(25, 25 + i * 20, 100, 15);
            userJLabel.setUser(user);

            JLabel logout = new JLabel("注销");
            logout.setForeground(Color.gray);
            logout.setFont(new Font("宋体", 1, 15));
            logout.setBounds(300, 25 + i * 20, 40, 15);
            logout.addMouseListener(new LogoutMouseListener());
            userJLabel.setLogout(logout);

            JLabel edit = new JLabel("编辑");
            edit.setForeground(Color.gray);
            edit.setFont(new Font("宋体", 1, 15));
            edit.setBounds(340, 25 + i * 20, 40, 15);
            edit.addMouseListener(new EditMouseListener());
            userJLabel.setEdit(edit);
            userJLabels.add(userJLabel);
        }
    }
}
