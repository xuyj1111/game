package xu.game.okay.oldCode.page.admin;

import xu.game.okay.Main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 * @author shkstart
 * @create 2020-03-07-12:19
 */
public class ChoosePage extends JPanel {

    public ChoosePage() {
        setLayout(null);

        JLabel welcome = new JLabel("Welcome  " + "admin");
        welcome.setForeground(Color.gray);
        welcome.setFont(new Font("幼圆", 1, 80));
        welcome.setBounds(100, 100, 700, 80);
        add(welcome);

        JButton manage_checkpoint = new JButton();
        manage_checkpoint.setForeground(Color.black);
        manage_checkpoint.setIcon(new ImageIcon("图标/admin/管理关卡.jfif"));
        manage_checkpoint.setBounds(250, 200, 300, 300);
        manage_checkpoint.setBorderPainted(false);
        add(manage_checkpoint);

        JButton manage_users = new JButton();
        manage_users.setForeground(Color.black);
        manage_users.setIcon(new ImageIcon("图标/admin/管理用户.jfif"));
        manage_users.setBounds(250, 500, 300, 300);
        manage_users.setBorderPainted(false);
        add(manage_users);

        JButton out = new JButton();
        out.setForeground(Color.black);
        out.setIcon(new ImageIcon("图标/admin/退出.jfif"));
        out.setBounds(620, 780, 100, 100);
        out.setBorderPainted(false);
        add(out);


        mouse(manage_checkpoint, manage_users, out);
    }

    public void mouse(JButton manage_checkpoint, JButton manage_users, JButton out) {
        manage_checkpoint.addActionListener(e -> {
            Main.admin_manageGametimeMenu();
        });
        manage_users.addActionListener(e -> {
            Main.admin_manageUsers();
        });
        out.addActionListener(e -> {
            Main.admin = false;
            Main.login();
        });
    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.black);
        g.clearRect(0, 0, getWidth(), getHeight());
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 10,},
                0f);
        g.setStroke(dash);
        g.setColor(Color.gray);
        g.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        super.paintComponents(g);
    }
}
