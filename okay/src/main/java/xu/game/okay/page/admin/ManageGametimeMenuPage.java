package xu.game.okay.page.admin;


import xu.game.okay.Jdbc;
import xu.game.okay.Main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author shkstart
 * @create 2020-03-07-15:47
 */
public class ManageGametimeMenuPage extends JPanel {
    public ManageGametimeMenuPage() {

        JLabel label[] = new JLabel[20];
        setLayout(null);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                label[i * 4 + j] = new JLabel(String.valueOf(i * 4 + j + 1));
            }
        }


        JButton back = new JButton();
        back.setForeground(Color.black);
        back.setIcon(new ImageIcon("图标/admin/返回.jpg"));
        back.setBounds(100, 820, 50, 50);
        back.setBorderPainted(false);
        add(back);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int zhi = i * 4 + j;
                if (zhi + 1 <= 20) {
                    if (zhi < 16)
                        label[zhi].setForeground(Color.gray);
                    else
                        label[zhi].setForeground(Color.red);
                } else {
                    label[zhi].setForeground(Color.lightGray);
                }
                label[zhi].setBounds(100 + j * 175, 100 + i * 150, 110, 50);
                label[zhi].setFont(new Font("幼圆", 1, 50));
                add(label[zhi]);
            }
        }
        mouse(back, label);
    }

    public void mouse(JButton back, JLabel label[]) {
        back.addActionListener(e -> {
            Jdbc.update("delete from biao4 where number > 0;");
            Jdbc.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
            Main.admin_choose();
        });

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int zhi = i * 4 + j;
                label[zhi].addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {             //鼠标移入
                        if (zhi + 1 <= 20)
                            label[zhi].setForeground(Color.lightGray);
                    }

                    public void mouseExited(MouseEvent e) {              //鼠标移除
                        if (zhi + 1 <= 20) {
                            if (zhi < 16)
                                label[zhi].setForeground(Color.gray);
                            else
                                label[zhi].setForeground(Color.red);
                        }
                    }

                    public void mouseClicked(MouseEvent e) {             //鼠标单击
                        if (e.getButton() == MouseEvent.BUTTON1 && zhi + 1 <= 20) {//预览关卡
                            Main.guan = zhi + 1;
                            Main.nguan = 0;
                            Main.user_gametime();
                        }

                        if (e.getButton() == MouseEvent.BUTTON3) {      //修改关卡
                            ManageDefinedPage.admin_guan = zhi + 1;
                            Main.admin_defined();
                        }
                    }
                });
            }
        }
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
