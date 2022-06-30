package xu.game.okay.util;

/**
 * @Description: 创建三个入参的Function
 * @Author: xuyujun
 * @Date: 2022/6/30
 */
@FunctionalInterface
public interface Function3<A, B, C> {
    void apply(A a, B b, C c);
}
