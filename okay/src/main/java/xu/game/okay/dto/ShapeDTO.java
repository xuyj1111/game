package xu.game.okay.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import xu.game.okay.enums.ShapeProperty;
import xu.game.okay.enums.ShapeType;

import java.io.Serializable;
import java.util.List;

/**
* @Description: 绘图板`图形`的dto
* @Author: xuyujun
* @Date: 2022/3/24
*/
@Data
@NoArgsConstructor
public class ShapeDTO implements Serializable {

    private static final long serialVersionUID = 5902513291096462641L;
    private ShapeType type;
    private ShapeProperty property;
    // 仅为圆使用，圆的半径
    private Integer size;
    private List<PointDTO> points;
}
