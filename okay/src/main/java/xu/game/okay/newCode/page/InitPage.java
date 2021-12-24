package xu.game.okay.newCode.page;

import xu.game.okay.newCode.BeanFactory;
import xu.game.okay.newCode.TestMain;
import xu.game.okay.newCode.constant.IconConstant;
import xu.game.okay.newCode.impl.InnerJPanel;
import xu.game.okay.newCode.impl.InnerMouse;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

/**
 * @Description: 初始化页面
 * 1.显示图片
 * 2.鼠标点击界面任意处两次，进入登陆页面
 * @Author: xuyujun
 * @Date: 2021/12/21
 */
public class InitPage extends BasePage {

    /**
    * @Description: 点击次数
    */
    private Integer check_num = 0;

    public InitPage() {
        innerJPanel = new InnerJPanelImpl();
        innerMouse = new InnerMouseImpl();
        innerJPanel.addMouseListener(innerMouse);
    }

    class InnerJPanelImpl extends InnerJPanel {
        private Image img;

        public InnerJPanelImpl() {
            setLayout(null);
            ImageIcon icon = new ImageIcon(IconConstant.FIRST_PAGE);
            img = icon.getImage();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    class InnerMouseImpl extends InnerMouse {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (check_num == 0) {
                JLabel lets = new JLabel("Let‘s");
                lets.setBounds(300, 130, 500, 80);
                lets.setForeground(Color.black);
                lets.setFont(new java.awt.Font("华文中宋", Font.ITALIC, 50));
                innerJPanel.add(lets);
                JLabel start = new JLabel("start...");
                start.setBounds(500, 130, 500, 80);
                start.setForeground(Color.black);
                start.setFont(new java.awt.Font("华文中宋", Font.ITALIC, 50));
                innerJPanel.add(start);
            } else {
                check_num = 0;
                TestMain.jPanel = BeanFactory.loginPage.getInnerJPanel();
                TestMain.jFrame.setContentPane(TestMain.jPanel);
                TestMain.jFrame.setVisible(true);
            }
            innerJPanel.repaint();
            check_num++;
        }
    }
}