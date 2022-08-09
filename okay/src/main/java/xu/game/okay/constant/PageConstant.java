package xu.game.okay.constant;

import java.awt.Dimension;
import java.awt.Toolkit;

public class PageConstant {

    public static int MOUSE_OFFSET_X;
    public static int MOUSE_OFFSET_Y;

    /**
     * 偏移量（随鼠标移动的小球有大小，需要在靠近的一定范围内就判定为在图形内部）
     */
    public static final int OFFSET_X = 50;
    public static final int OFFSET_Y = 50;

    /**
     * '点'之间的间隔
     */
    public static final int INTERVAL = 20;

    /**
     * 点阵图居中的x轴偏移量
     */
    public static final int CENTER_OFFSET_X = 50;

    /**
     * 点阵图居中的y轴偏移量
     */
    public static final int CENTER_OFFSET_Y = 25;

    /**
     * '点'的西北向为起点，到'点'中心的偏移量
     */
    public static final int POINRT_OFFSET = 8;

    /**
     * 拉伸线的长度（球的数量）
     */
    public static final int LINE_LENGTH = 6;

    /**
     * 球的初始半径
     */
    public static final int BALL_RADIUS = 10;

    /**
     * 用户关卡数
     */
    public static long LIMIT_NUM = 20L;


    /**
     * @Description: 根据屏幕尺寸，计算出鼠标与界面的偏移量
     * MainClass中设置了居中显示，界面尺寸400*500
     */
    static {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        MOUSE_OFFSET_X = (screenSize.width - 400) / 2;
        MOUSE_OFFSET_Y = (screenSize.height - 500) / 2;
    }
}
