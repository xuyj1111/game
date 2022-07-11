package xu.game.okay.constant;

import cn.hutool.core.io.IoUtil;

/**
 * @Description: 图片路径常量
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class IconConstant {

    public static final String BASE_PATH = "file/";
    public static byte[] INIT = getByteArr(BASE_PATH + "init.jpg");
    public static final byte[] MENU = getByteArr(BASE_PATH + "menu.jpg");
    public static final byte[] BREAK_THROUGH = getByteArr(BASE_PATH + "break_through.jpg");
    public static final byte[] LANDING = getByteArr(BASE_PATH + "landing.jpg");
    public static final byte[] RETURN = getByteArr(BASE_PATH + "return.jpg");
    public static final byte[] START = getByteArr(BASE_PATH + "start.jpg");
    public static final byte[] CANCEL = getByteArr(BASE_PATH + "cancel.jpg");
    public static final byte[] CONFIRM = getByteArr(BASE_PATH + "confirm.jpg");
    public static final byte[] CONFIRM_SMALL = getByteArr(BASE_PATH + "confirm_small.jpg");
    public static final byte[] DELETE = getByteArr(BASE_PATH + "delete.jpg");
    public static final String DESC = BASE_PATH + "desc.md";
    public static final byte[] QUIT = getByteArr(BASE_PATH + "quit.jpg");
    public static final byte[] QUESTION = getByteArr(BASE_PATH + "question.jpg");
    public static final byte[] CUSTOMER_DEFINE = getByteArr(BASE_PATH + "customer_define.jpg");
    public static final byte[] POINT = getByteArr(BASE_PATH + "point.png");

    //以下是管理员界面的图片
    public static final String ADMIN_PATH = BASE_PATH + "admin/";
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

    private static byte[] getByteArr(String fileName) {
        return IoUtil.readBytes(IconConstant.class.getClassLoader().getResourceAsStream(fileName));
    }
}
