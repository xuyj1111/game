//package xu.game.okay.page.other;
//
//
//import xu.game.okay.newPlace.jdbc.JdbcConfig;
//import xu.game.okay.Main;
//
//import javax.swing.JPanel;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * @author shkstart
// * @create 2019-11-12-16:27
// */
//public class NumberPage extends JPanel {
//    public int num;
//    public String[] num_string;
//    private int zb1 = -250, zb2 = 0;
//    private int moo = 0;
//    public Timer timer;
//    JdbcConfig instance = JdbcConfig.getInstance();
//
//    public NumberPage(int num) {
//        this.num = num;
//        num_string = new String[]{String.valueOf(num), String.valueOf(num - 1)};
//        timer = new Timer();
//        TimerTask t = new TimerTask() {
//            @Override
//            public void run() {
//                if (moo > 0) {
//                    if (moo == 1) {
//                        zb1++;
//                        if (zb1 >= 520) moo = 2;
//                    } else if (moo == 2) {
//                        zb1--;
//                        if (zb1 <= 480) moo = 3;
//                    } else if (moo == 3) {
//                        zb1++;
//                        if (zb1 >= 510) moo = 4;
//                    } else if (moo == 4) {
//                        zb1--;
//                        if (zb1 <= 490) moo = 5;
//                    } else if (moo == 5) {
//                        zb1++;
//                        if (zb1 >= 500) moo = 6;
//                    }
//                    repaint();
//                }
//                if (moo == 6) {
//                    instance.update("delete from biao4 where number > 0;");
//                    instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//                    Main.guan = num;
//                    Main.nguan = 0;
//                    timer.cancel();
//                    timer = null;
//                    Main.user_gametime();
//                }
//            }
//        };
//        timer.scheduleAtFixedRate(t, 50, 3);
//    }
//
//    public void paint(Graphics gr) {
//        Graphics2D g = (Graphics2D) gr;
//        if (moo == 0) {
//            g.setBackground(Color.white);
//            g.clearRect(0, 0, getWidth(), getHeight());
//            moo = 1;
//        }
//        if (moo > 0) {
//            int zhi_x;
//            g.setFont(new Font("幼圆", 1, 300));
//            if (num < 10) zhi_x = 300;
//            else zhi_x = 230;
//            g.setColor(Color.white);
////            g.drawString(num_string[0], zhi_x, zb2);
//            g.clearRect(0, 0, getWidth(), getHeight());
//            g.setColor(Color.lightGray);
//            g.drawString(num_string[0], zhi_x, zb1);
//
//            if (num < 11) zhi_x = 300;
//            else zhi_x = 230;
//            if (num > 1 && zb2 < 500) {
//                g.setColor(Color.white);
//                g.drawString(num_string[1], zhi_x, zb2 + 750);
//                g.setColor(Color.lightGray);
//                g.drawString(num_string[1], zhi_x, zb1 + 750);
//            }
//
//            zb2 = zb1;
//        }
//    }
//}
