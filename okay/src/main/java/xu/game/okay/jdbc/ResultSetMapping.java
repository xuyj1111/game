package xu.game.okay.jdbc;

import java.sql.Types;

/**
 * @Description: 将字符串的类转化成 Types 枚举
 * ResultSet类获取sql查询结果，只能通过getXxx类型的方法，因此使用反射实现以传入字符串参数，转换成对应的getXxx方法
 * @Author: xuyujun
 * @Date: 2022/3/15
 */
public class ResultSetMapping {

    public static Class<?> toClass(int type) {
        Class<?> result = Object.class;
        switch (type) {
            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
                result = String.class;
                break;
            case Types.NUMERIC:
            case Types.DECIMAL:
                result = java.math.BigDecimal.class;
                break;
            case Types.BIT:
                result = Boolean.class;
                break;
            case Types.TINYINT:
                result = Byte.class;
                break;
            case Types.SMALLINT:
                result = Short.class;
                break;
            case Types.INTEGER:
                result = Integer.class;
                break;
            case Types.BIGINT:
                result = Long.class;
                break;
            case Types.REAL:
            case Types.FLOAT:
                result = Float.class;
                break;
            case Types.DOUBLE:
                result = Double.class;
                break;
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
                result = Byte[].class;
                break;
            case Types.DATE:
                result = java.sql.Date.class;
                break;
            case Types.TIME:
                result = java.sql.Time.class;
                break;
            case Types.TIMESTAMP:
                result = java.sql.Timestamp.class;
                break;
            default:
                break;
        }
        return result;
    }
}
