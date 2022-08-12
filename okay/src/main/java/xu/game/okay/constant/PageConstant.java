package xu.game.okay.constant;

import com.google.common.collect.Lists;
import xu.game.okay.enums.ShapeProperty;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

public class PageConstant {

    /**
     * 见下面静态代码块赋值
     */
    public static int MOUSE_OFFSET_X;
    public static int MOUSE_OFFSET_Y;

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
     * 球的初始直径
     */
    public static final int BALL_DIAMETER = 10;

    /**
     * 用户关卡数
     */
    public static final long LIMIT_NUM = 20L;

    /**
     * 图形属性枚举list，方便自增变化值
     */
    public static final List<ShapeProperty> shapeProList = Lists.newArrayList(ShapeProperty.ELIMINATION,
            ShapeProperty.DOUBLE_ELIMINATION,
            ShapeProperty.OBSTACLE,
            ShapeProperty.BLACK_HOLE);


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
