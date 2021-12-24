package xu.game.okay.oldCode.page.users;

import xu.game.okay.newCode.jdbc.JdbcConfig;
import xu.game.okay.Main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-07-13:32
 */
public class DefinedMenuPage extends JPanel {
    public String username;
    JdbcConfig instance = JdbcConfig.getInstance();

    public DefinedMenuPage(String username) {
        this.username = username;
        setLayout(null);

        JButton back = new JButton();
        back.setForeground(Color.black);
        back.setIcon(new ImageIcon("图标/返回.jpg"));
        back.setBounds(100, 820, 50, 50);
        back.setBorderPainted(false);
        add(back);

        JButton question_icon = new JButton();
        question_icon.setForeground(Color.black);
        question_icon.setIcon(new ImageIcon("图标/问号.jpg"));
        question_icon.setBounds(700, 50, 30, 30);
        question_icon.setBorderPainted(false);
        add(question_icon);

        JLabel label[] = new JLabel[20];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int zhi = i * 4 + j;
                String string;
                string = instance.query("select nguan from biao3 where name = '" + username
                        + "' AND nguan = " + (zhi + 1) + ";");
                if (string != null) {
                    if (label[zhi] == null)
                        label[zhi] = new JLabel(String.valueOf(zhi + 1));
                    else label[zhi].setText(String.valueOf(zhi + 1));
                } else {
                    if (label[zhi] == null)
                        label[zhi] = new JLabel("×");
                    else label[zhi].setText("×");
                }


                if (label[zhi].getText().equals("×")) {
                    label[zhi].setForeground(Color.black);
                } else
                    label[zhi].setForeground(Color.lightGray);

                label[zhi].setBounds(100 + j * 175, 100 + i * 150, 110, 50);
                label[zhi].setFont(new Font("幼圆", 1, 50));
                add(label[zhi]);
            }
        }
        mouse(back, question_icon, label);
    }

    public void mouse(JButton back, JButton question_icon, JLabel label[]) {
        back.addActionListener(e -> {
            instance.update("delete from biao4 where number > 0;");
            instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
            Main.user_defined();
        });

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int zhi = i * 4 + j;
                label[zhi].addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {             //移入
                        if (!label[zhi].getText().equals("×"))
                            label[zhi].setForeground(Color.black);
                    }

                    public void mouseExited(MouseEvent e) {              //移除
                        if (!label[zhi].getText().equals("×"))
                            label[zhi].setForeground(Color.lightGray);
                    }

                    public void mouseClicked(MouseEvent e) {             //单击
                        instance.update("delete from biao4 where number > 0;");
                        instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
                        if (e.getButton() == MouseEvent.BUTTON1 && (!label[zhi].getText().equals("×"))) {       //开始游戏
                            Main.guan = 0;
                            Main.nguan = zhi + 1;
                            Main.user_gametime();
                        }
                        if (e.getButton() == MouseEvent.BUTTON3 && (!label[zhi].getText().equals("×"))) {      //删除
                            instance.update("delete from biao3 where nguan = " + (zhi + 1)
                                    + " AND name = '" + username + "';");
                            label[zhi].setText("×");
                        }
                    }
                });
            }
        }
        question_icon.addActionListener(e -> {
            File file = new File("图标/说明.txt");
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setBackground(Color.white);
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
