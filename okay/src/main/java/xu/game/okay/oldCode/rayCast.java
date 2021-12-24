package xu.game.okay; /**
 * @author shkstart
 * @create 2019-10-22-15:53
 */


import xu.game.okay.newCode.jdbc.JdbcConfig;
import xu.game.okay.page.users.GametimePage;

import java.util.ArrayList;
import java.util.List;

class Point2d {
    public int x;
    public int y;

    public Point2d(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}

/**
 * 判断一个点是否在一个多边形里面 *
 *
 * @author
 */
public class rayCast {
    List<Point2d> list = new ArrayList<Point2d>();
    Point2d p = null;
    GametimePage gametimePage = null;
    int number;
    JdbcConfig instance = JdbcConfig.getInstance();

    public void rayCastadd(int xx[], int yy[], int x, int y, GametimePage gametimePage, int number) {
        this.number = number;
        this.gametimePage = gametimePage;
        // list为多边形边界,p为一个待测点
        if (p == null)
            p = new Point2d(x, y);
        else {
            p.x = x;
            p.y = y;
        }
        list.clear();
        for (int i = 0; i < 10; i++) {
            if (yy[i] > 5) {
                list.add(new Point2d(xx[i], yy[i]));
            }
        }
    }

    /*
     * p为待测点  list为多边形边界
     */
    public boolean rayCasting(boolean yes_no) {
        double px = p.x, py = p.y;
        boolean flag = false;
        int tuxnumb;
        for (int i = 0, l = list.size(), j = l - 1; i < l; j = i, i++) {
            //取出边界的相邻两个点
            double sx = list.get(i).x,
                    sy = list.get(i).y,
                    tx = list.get(j).x,
                    ty = list.get(j).y;
            // 点与多边形顶点重合
            if ((sx == px && sy == py) || (tx == px && ty == py)) {
                return true;
            }
            // 判断线段两端点是否在射线两侧
            //思路:作p点平行于y轴的射线 作s,t的平行线直线  如果射线穿过线段，则py的值在sy和ty之间
            if ((sy < py && ty >= py) || (sy >= py && ty < py)) {
                // 线段上与射线 Y 坐标相同的点的 X 坐标 ,即求射线与线段的交点
                double x = sx + (py - sy) * (tx - sx) / (ty - sy);
                // 点在多边形的边上
                if (x == px) {
                    if (yes_no == true && gametimePage.fan_tan_x > 0) {
                        double zhi1, zhi2;
                        zhi1 = Math.sqrt(Math.pow(Math.abs(gametimePage.fan_tan_x - sx), 2) + Math.pow(Math.abs(gametimePage.fan_tan_y - sy), 2));
                        zhi2 = Math.sqrt(Math.pow(Math.abs(gametimePage.fan_tan_x - tx), 2) + Math.pow(Math.abs(gametimePage.fan_tan_y - ty), 2));
                        if (zhi1 >= zhi2) {
                            gametimePage.fan_tan_xx = sx;
                            gametimePage.fan_tan_yy = sy;
                        } else {
                            gametimePage.fan_tan_xx = tx;
                            gametimePage.fan_tan_yy = ty;
                        }
                    }
                    return true;
                }
                // 射线穿过多边形的边界
                if (x > px)
                    flag = !flag;
            }
            //思路:作p点平行于x轴的射线
            else if ((sx < px && tx >= px) || (sx >= px && tx < px)) {
                // 线段上与射线 Y 坐标相同的点的 X 坐标 ,即求射线与线段的交点
                double y = sy + (px - sx) * (ty - sy) / (tx - sx);
                // 点在多边形的边上
                if (y == py) {
                    if (yes_no == true && gametimePage.fan_tan_x > 0) {
                        double zhi1, zhi2;
                        zhi1 = Math.sqrt(Math.pow(Math.abs(gametimePage.fan_tan_x - sx), 2) + Math.pow(Math.abs(gametimePage.fan_tan_y - sy), 2));
                        zhi2 = Math.sqrt(Math.pow(Math.abs(gametimePage.fan_tan_x - tx), 2) + Math.pow(Math.abs(gametimePage.fan_tan_y - ty), 2));
                        if (zhi1 >= zhi2) {
                            gametimePage.fan_tan_xx = sx;
                            gametimePage.fan_tan_yy = sy;
                        } else {
                            gametimePage.fan_tan_xx = tx;
                            gametimePage.fan_tan_yy = ty;
                        }
                    }
                    return true;
                }
                // 射线穿过多边形的边界
            }
        }
        if (flag == true && yes_no == true && gametimePage.fan_tan_x > 0 && gametimePage.moo == 6) {
            int whitch = 0;
            double zhi1 = 0;
            for (tuxnumb = 1; tuxnumb <= 20; tuxnumb++) {
                String zhi;
                zhi = instance.query("select count(*) from biao4 where number = " +
                        (number + 1) + " AND x" + String.valueOf(tuxnumb) + " >0" + ";");
                if (Integer.valueOf(zhi) == 0) break;
            }
            tuxnumb--;
            for (int i = 0; i < tuxnumb; i++) {
                String zhix, zhiy;
                double zhi;
                zhix = instance.query("select " + "x" + String.valueOf(i + 1) + " from biao4 where number = " +
                        (number + 1) + ";");
                zhiy = instance.query("select " + "y" + String.valueOf(i + 1) + " from biao4 where number = " +
                        (number + 1) + ";");
                zhi = Math.sqrt(Math.pow(Math.abs(gametimePage.fan_tan_x - (Integer.valueOf(zhix))), 2) + Math.pow(Math.abs(gametimePage.fan_tan_y - (Integer.valueOf(zhiy))), 2));
                if (i == 0) zhi1 = zhi;
                else if (zhi < zhi1) {
                    zhi1 = zhi;
                    whitch = i;
                }
            }
            gametimePage.fan_tan_xx = Integer.valueOf(instance.query("select " + "x" + String.valueOf(whitch + 1) + " from biao4 where number = " +
                    String.valueOf(number + 1) + ";")) + 5;
            gametimePage.fan_tan_yy = Integer.valueOf(instance.query("select " + "y" + String.valueOf(whitch + 1) + " from biao4 where number = " +
                    String.valueOf(number + 1) + ";")) + 5;
        }
        return flag ? true : false;
    }

}