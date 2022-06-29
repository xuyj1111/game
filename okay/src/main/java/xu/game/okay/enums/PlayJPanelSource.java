package xu.game.okay.enums;

/**
 * @Description: PlayJPanel 的上级界面
 * @Author: xuyujun
 * @Date: 2022/6/29
 */
public enum PlayJPanelSource {

    DEFINEJPANEL("defineJPanel"),
    MENUJPANEL("menuJPanel");

    private String value;

    PlayJPanelSource(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
