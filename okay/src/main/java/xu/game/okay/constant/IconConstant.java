package xu.game.okay.constant;

import cn.hutool.core.io.IoUtil;

/**
 * @Description: 图片路径常量
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public class IconConstant {

    public static final String BASE_PATH = "file/";
    public static byte[] INIT = getImgByteArr(BASE_PATH + "init.jpg");
    public static final byte[] MENU = getImgByteArr(BASE_PATH + "menu.jpg");
    public static final byte[] BREAK_THROUGH = getImgByteArr(BASE_PATH + "break_through.jpg");
    public static final byte[] LANDING = getImgByteArr(BASE_PATH + "landing.jpg");
    public static final byte[] RETURN = getImgByteArr(BASE_PATH + "return.jpg");
    public static final byte[] START = getImgByteArr(BASE_PATH + "start.jpg");
    public static final byte[] CANCEL = getImgByteArr(BASE_PATH + "cancel.jpg");
    public static final byte[] CONFIRM = getImgByteArr(BASE_PATH + "confirm.jpg");
    public static final byte[] CONFIRM_SMALL = getImgByteArr(BASE_PATH + "confirm_small.jpg");
    public static final byte[] DELETE = getImgByteArr(BASE_PATH + "delete.jpg");
    public static final byte[] DESC = getImgByteArr(BASE_PATH + "desc.md");
    public static final byte[] QUIT = getImgByteArr(BASE_PATH + "quit.jpg");
    public static final byte[] QUESTION = getImgByteArr(BASE_PATH + "question.jpg");
    public static final byte[] CUSTOMER_DEFINE = getImgByteArr(BASE_PATH + "customer_define.jpg");
    public static final byte[] POINT = getImgByteArr(BASE_PATH + "point.png");

    //以下是管理员界面的图片
    public static final String ADMIN_PATH = BASE_PATH + "admin/";
    public static final byte[] ADMIN_CANCEL = getImgByteArr(ADMIN_PATH + "cancel.jpg");
    public static final byte[] ADMIN_CONFIRM = getImgByteArr(ADMIN_PATH + "confirm.jpg");
    public static final byte[] ADMIN_COMFIRM_SMALL = getImgByteArr(ADMIN_PATH + "confirm_small.jpg");
    public static final byte[] ADMIN_DELETE = getImgByteArr(ADMIN_PATH + "delete.jpg");
    public static final byte[] ADMIN_LANDING = getImgByteArr(ADMIN_PATH + "landing.jpg");
    public static final byte[] ADMIN_MANAGE_LEVEL = getImgByteArr(ADMIN_PATH + "manage_level.jpg");
    public static final byte[] ADMIN_MANAGE_USER = getImgByteArr(ADMIN_PATH + "manage_user.jpg");
    public static final byte[] ADMIN_MENU = getImgByteArr(ADMIN_PATH + "menu.jpg");
    public static final byte[] ADMIN_QUESTION = getImgByteArr(ADMIN_PATH + "question.jpg");
    public static final byte[] ADMIN_QUIT = getImgByteArr(ADMIN_PATH + "quit.jpg");
    public static final byte[] ADMIN_RETURN = getImgByteArr(ADMIN_PATH + "return.jpg");
    public static final byte[] ADMIN_START = getImgByteArr(ADMIN_PATH + "start.jpg");

    private static byte[] getImgByteArr(String fileName) {
        return IoUtil.readBytes(IconConstant.class.getClassLoader().getResourceAsStream(fileName));
    }
}
