package xu.game.okay.enums;

/**
 * @Description: DefinedJPanel 的上级界面
 * user: 编辑用户关卡界面（用户模式）
 * admin_system: 编辑系统关卡界面（管理员模式）
 * admin_user_edit: 编辑用户关卡界面（管理员模式）
 * @Author: xuyujun
 * @Date: 2022/4/12
 */
public enum DefinedJPanelSource {
    USER("user"),
    ADMIN_SYSTEM("admin_system"),
    ADMIN_USER_EDIT("admin_user_edit");

    private String value;

    DefinedJPanelSource(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
