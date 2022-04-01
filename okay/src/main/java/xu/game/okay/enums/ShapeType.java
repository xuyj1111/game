package xu.game.okay.enums;

/**
* @Description: 图形类型枚举类
* @Author: xuyujun
* @Date: 2022/3/24
*/
public enum ShapeType {

    LINE("line"),
    CIRCLE("circle"),
    POLYGON("polygon");

    private String value;

    ShapeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
