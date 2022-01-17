package xu.game.okay.zoldCode.page.users;


import javax.swing.JPanel;

/**
 * @author shkstart
 * @create 2020-03-07-12:19
 */
public class ChoosePage extends JPanel {
//    public String username = null;
//    JdbcConfig instance = JdbcConfig.getInstance();
//
//    public ChoosePage(String username) {
//        this.username = username;
//        setLayout(null);
//
//        JLabel welcome = new JLabel("Welcome  " + username);
//        welcome.setForeground(Color.gray);
//        welcome.setFont(new java.awt.Font("幼圆", 1, 80));
//        welcome.setBounds(100, 100, 700, 80);
//        add(welcome);
//
//        JButton recruit_model = new JButton();
//        recruit_model.setForeground(Color.black);
//        recruit_model.setIcon(new ImageIcon("图标/闯关.jfif"));
//        recruit_model.setBounds(250, 200, 300, 300);
//        recruit_model.setBorderPainted(false);
//        add(recruit_model);
//
//        JButton user_defined = new JButton();
//        user_defined.setForeground(Color.black);
//        user_defined.setIcon(new ImageIcon("图标/自定义.jfif"));
//        user_defined.setBounds(250, 500, 300, 300);
//        user_defined.setBorderPainted(false);
//        add(user_defined);
//
//        JButton out = new JButton();
//        out.setForeground(Color.black);
//        out.setIcon(new ImageIcon("图标/退出.jfif"));
//        out.setBounds(620, 780, 100, 100);
//        out.setBorderPainted(false);
//        add(out);
//
//        JButton question_icon = new JButton();
//        question_icon.setForeground(Color.black);
//        question_icon.setIcon(new ImageIcon("图标/问号.jpg"));
//        question_icon.setBounds(680, 70, 30, 30);
//        question_icon.setBorderPainted(false);
//        add(question_icon);
//
//        mouse(recruit_model, user_defined, out, question_icon);
//    }
//
//    public void mouse(JButton recruit_model, JButton user_defined, JButton out, JButton question_icon) {
//        recruit_model.addActionListener(e -> {
//            String string;
//            string = instance.query("select guan from biao1 where name = '"
//                    + username + "';");
//            Main.num = Integer.valueOf(string);
//            Main.number();
//        });
//        user_defined.addActionListener(e -> {
//            instance.update("delete from biao4 where number > 0;");
//            instance.update("ALTER TABLE biao4 AUTO_INCREMENT= 1;");
//            Main.user_defined();
//        });
//        out.addActionListener(e -> Main.login());
//
//        question_icon.addActionListener(e -> {
//            File file = new File("图标/说明.txt");
//            try {
//                Desktop.getDesktop().open(file);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
//    }
//
//    public void paint(Graphics gr) {
//        Graphics2D g = (Graphics2D) gr;
//        g.setBackground(Color.white);
//        g.clearRect(0, 0, getWidth(), getHeight());
//        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 10,},
//                0f);
//        g.setStroke(dash);
//        g.setColor(Color.gray);
//        g.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
//        super.paintComponents(g);
//    }
}
