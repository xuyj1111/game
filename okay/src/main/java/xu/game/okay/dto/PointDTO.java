package xu.game.okay.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.JButton;
import java.io.Serializable;

/**
* @Description: 绘图板`点`的dto
* @Author: xuyujun
* @Date: 2022/3/24
*/
@Data
@NoArgsConstructor
public class PointDTO implements Serializable {

    private static final long serialVersionUID = -7540063795606609401L;

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
     * equals比较，来判断是否已点击
    */
    @JsonIgnore
    private JButton pointB;
}
