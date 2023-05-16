package xu.game.okay.老代码留着参考用.page.users;


import xu.game.okay.jdbc.JdbcConfig;

import javax.swing.JPanel;

/**
 * @author shkstart
 * @create 2020-03-07-12:19
 */
public class ChoosePage extends JPanel {
    public String username = null;
    JdbcConfig instance = JdbcConfig.getInstance();

    public ChoosePage(String username) {

    }

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

}
