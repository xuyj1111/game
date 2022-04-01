package xu.game.okay.enums;

/**
* @Description: 图形属性枚举类
* @Author: xuyujun
* @Date: 2022/3/24
*/
public enum ShapeProperty {

    ELIMINATION("elimination"),
    DOUBLE_ELIMINATION("double_elimination"),
    OBSTACLE("obstacle"),
    BLACK_HOLE("black_hole");

    private String value;

    ShapeProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
