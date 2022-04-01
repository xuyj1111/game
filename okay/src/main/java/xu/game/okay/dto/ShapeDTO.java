package xu.game.okay.dto;

import lombok.Builder;
import lombok.Data;
import xu.game.okay.enums.ShapeProperty;
import xu.game.okay.enums.ShapeType;

import java.util.List;

/**
* @Description: 绘图板`图形`的dto
* @Author: xuyujun
* @Date: 2022/3/24
*/
@Data
@Builder
public class ShapeDTO {

    private ShapeType type;
    private ShapeProperty property;
    //仅为圆使用
    private Integer size;
    private List<PointDTO> point;
}
