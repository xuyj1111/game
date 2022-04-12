package xu.game.okay.entity;

import lombok.Data;

/** 
 * @Description: 对应user表
 * @Author: xuyujun
 * @Date: 2022/4/12 
 */ 
@Data
public class User {
    private Long id;
    private String name;
    private String pwd;
    private Integer record;
}
