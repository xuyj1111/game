package xu.game.okay.dto;

import lombok.Builder;
import lombok.Data;

import javax.swing.JButton;

/**
* @Description: 绘图板`点`的dto
* @Author: xuyujun
* @Date: 2022/3/24
*/
@Data
@Builder
public class PointDTO {

    /**
    * @Description: 序号
    */
    private Integer number;

    /**
    * @Description: x轴
    */
    private Integer x;

    /**
    * @Description: y轴
    */
    private Integer y;

    /**
    * @Description: `点`按钮
    */
    private JButton pointB;
}
