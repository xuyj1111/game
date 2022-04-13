package xu.game.okay.enums;

/**
 * @Description: DefinedJPanel 的上级界面的来源
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public enum JPanelSource {
    USER("user"),
    ADMIN_SYSTEM("admin_system"),
    ADMIN_USER_EDIT("admin_user_edit");

    private String value;

    JPanelSource(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
