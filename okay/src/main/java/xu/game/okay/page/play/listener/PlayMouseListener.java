package xu.game.okay.page.play.listener;

import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import xu.game.okay.job.BallMoveJob;
import xu.game.okay.page.play.PlayControls;
import xu.game.okay.util.BeanFactory;
import xu.game.okay.util.RayCastUtil;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import static xu.game.okay.constant.PageConstant.BALL_DIAMETER;
import static xu.game.okay.constant.PageConstant.LINE_LENGTH;

/**
 * @Description: 游戏界面键
 * 在窗口内点击，显示或隐藏功能键
 * @Author: xuyujun
 * @Date: 2022/6/29
 */
public class PlayMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            PlayControls.isVisible = !PlayControls.isVisible;
            PlayControls.returm.setVisible(PlayControls.isVisible);
            PlayControls.menu.setVisible(PlayControls.isVisible);
            PlayControls.question.setVisible(PlayControls.isVisible);
        }
    }

    @SneakyThrows
    @Override
    public void mousePressed(MouseEvent e) {
        if (PlayControls.isVisible) {
            PlayControls.isVisible = false;
            PlayControls.returm.setVisible(false);
            PlayControls.menu.setVisible(false);
            PlayControls.question.setVisible(false);
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            BeanFactory.playJPanel.setStartPoint(null);
            BeanFactory.playJPanel.setBallMove(null);
            BeanFactory.playJPanel.setBallX(null);
            BeanFactory.playJPanel.setBallY(null);
            BeanFactory.playJPanel.setMoveX(null);
            BeanFactory.playJPanel.setMoveY(null);
            BeanFactory.playJPanel.setDragLine(this::drawline);
            BeanFactory.playJPanel.repaint();
        }
    }

    @SneakyThrows
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            BeanFactory.playJPanel.setDragLine(null);
            // 延时是解决jpanel刷新页面时，会出现拉伸线未清理情况
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            // 判断拉伸线的起点是否在图形内，否小球才移动
            if (Objects.isNull(RayCastUtil.isInside(BeanFactory.playJPanel.getStartPoint()))) {
                if (Objects.isNull(BeanFactory.playJPanel.schedulerFactory)) {
                    // 1、创建调度器Scheduler
                    BeanFactory.playJPanel.schedulerFactory = new StdSchedulerFactory();
                    // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
                    JobDetail jobDetail = JobBuilder.newJob(BallMoveJob.class)
                            .withIdentity("job1", "group1").build();
                    // 3、构建Trigger实例
                    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                            .startNow()
                            .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInMilliseconds(3)
                                    .repeatForever())
                            .build();
                    //4、执行
                    BeanFactory.playJPanel.schedulerFactory.getScheduler().scheduleJob(jobDetail, trigger);
                    BeanFactory.playJPanel.schedulerFactory.getScheduler().start();
                }
                BeanFactory.playJPanel.setBallMove(this::ballMoving);
            }
            BeanFactory.playJPanel.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * @Description: 拉伸线的实现
     */
    private void drawline(Graphics2D g, Point startPoint, Point mousePoint) {
        int startX = startPoint.x;
        int startY = startPoint.y;
        int mouseX = mousePoint.x;
        int mouseY = mousePoint.y;
        // 使用double，小球跟鼠标移动精度更高
        double distanceX = startX - mouseX;
        double distanceY = startY - mouseY;

        g.setColor(Color.BLACK);
        for (int i = 0; i <= LINE_LENGTH; i++) {
            // 当前小球的直径
            int diameter = BALL_DIAMETER - i;
            // 使小球显示的中心为鼠标
            int locationX = (int) (startX - (distanceX / 6) * i - (diameter / 2));
            int locationY = (int) (startY - (distanceY / 6) * i - (diameter / 2));
            // 是否覆盖
            if (isDisplayed(locationX, locationY, diameter)) {
                g.fillOval(locationX, locationY, diameter, diameter);
            }
        }
        BeanFactory.playJPanel.repaint();
    }

    /**
     * @Description: 传入坐标，显示小球
     */
    private void ballMoving(Graphics2D g, Double ballX, Double ballY) {
        g.setColor(Color.BLACK);
        g.fillOval((int) (ballX - BALL_DIAMETER / 2), (int) (ballY - BALL_DIAMETER / 2), BALL_DIAMETER, BALL_DIAMETER);
        BeanFactory.playJPanel.repaint();
    }

    /**
     * @Description: 判断拉伸线的小球是否显示（不覆盖图形）
     */
    private boolean isDisplayed(int locationX, int locationY, int diameter) {
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX, locationY)))) {
            return false;
        }
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX + diameter, locationY)))) {
            return false;
        }
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX, locationY + diameter)))) {
            return false;
        }
        if (Objects.nonNull(RayCastUtil.isInside(new Point(locationX + diameter, locationY + diameter)))) {
            return false;
        }
        return true;
    }
}
