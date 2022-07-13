package xu.game.okay.constant;

import cn.hutool.core.io.IoUtil;

import java.io.InputStream;

/**
 * @Description: 图片路径常量
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class FileConstant {

    public static final String USER_PATH = "file/user/";
    public static byte[] INIT = getByteArr(USER_PATH + "init.jpg");
    public static final byte[] MENU = getByteArr(USER_PATH + "menu.jpg");
    public static final byte[] BREAK_THROUGH = getByteArr(USER_PATH + "break_through.jpg");
    public static final byte[] LANDING = getByteArr(USER_PATH + "landing.jpg");
    public static final byte[] RETURN = getByteArr(USER_PATH + "return.jpg");
    public static final byte[] START = getByteArr(USER_PATH + "start.jpg");
    public static final byte[] CANCEL = getByteArr(USER_PATH + "cancel.jpg");
    public static final byte[] CONFIRM = getByteArr(USER_PATH + "confirm.jpg");
    public static final byte[] CONFIRM_SMALL = getByteArr(USER_PATH + "confirm_small.jpg");
    public static final byte[] DELETE = getByteArr(USER_PATH + "delete.jpg");
    public static final byte[] QUIT = getByteArr(USER_PATH + "quit.jpg");
    public static final byte[] QUESTION = getByteArr(USER_PATH + "question.jpg");
    public static final byte[] CUSTOMER_DEFINE = getByteArr(USER_PATH + "customer_define.jpg");
    public static final byte[] POINT = getByteArr(USER_PATH + "point.png");

    //以下是管理员界面的图片
    public static final String ADMIN_PATH = "file/admin/";
    public static final byte[] ADMIN_CANCEL = getByteArr(ADMIN_PATH + "cancel.jpg");
    public static final byte[] ADMIN_CONFIRM = getByteArr(ADMIN_PATH + "confirm.jpg");
    public static final byte[] ADMIN_COMFIRM_SMALL = getByteArr(ADMIN_PATH + "confirm_small.jpg");
    public static final byte[] ADMIN_DELETE = getByteArr(ADMIN_PATH + "delete.jpg");
    public static final byte[] ADMIN_LANDING = getByteArr(ADMIN_PATH + "landing.jpg");
    public static final byte[] ADMIN_MANAGE_LEVEL = getByteArr(ADMIN_PATH + "manage_level.jpg");
    public static final byte[] ADMIN_MANAGE_USER = getByteArr(ADMIN_PATH + "manage_user.jpg");
    public static final byte[] ADMIN_MENU = getByteArr(ADMIN_PATH + "menu.jpg");
    public static final byte[] ADMIN_QUESTION = getByteArr(ADMIN_PATH + "question.jpg");
    public static final byte[] ADMIN_QUIT = getByteArr(ADMIN_PATH + "quit.jpg");
    public static final byte[] ADMIN_RETURN = getByteArr(ADMIN_PATH + "return.jpg");
    public static final byte[] ADMIN_START = getByteArr(ADMIN_PATH + "start.jpg");

    public static final InputStream DESC = getInputStream("file/desc.md");
    public static final InputStream INIT_SQL = getInputStream("script/init.sql");

    private static byte[] getByteArr(String fileName) {
        return IoUtil.readBytes(FileConstant.class.getClassLoader().getResourceAsStream(fileName));
    }

    private static InputStream getInputStream(String fileName) {
        return FileConstant.class.getClassLoader().getResourceAsStream(fileName);
    }
}
