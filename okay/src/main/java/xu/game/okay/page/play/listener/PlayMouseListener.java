package xu.game.okay.page.play.listener;

import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import xu.game.okay.job.BallMoveJob;
import xu.game.okay.page.play.PlayControls;
import xu.game.okay.util.RayCastUtil;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import static xu.game.okay.constant.PageConstant.BALL_DIAMETER;
import static xu.game.okay.constant.PageConstant.LINE_LENGTH;
import static xu.game.okay.util.BeanFactory.playJPanel;

/**
 * @Description: 游戏界面键
 * 1. 右键，显示或隐藏功能键
 * 2. 长按左键，拖拽小球实现拉伸线
 * 3. 松开左键，小球按拉伸方向移动
 * @Author: xuyujun
 * @Date: 2022/6/29
 */
public class PlayMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        // 右键
        if (e.getButton() == MouseEvent.BUTTON3) {
            stopBallMoving();
            PlayControls.setControlsIsVisible(!PlayControls.isVisible);
            // 延时是解决jpanel刷新页面时，小球未清除情况
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            playJPanel.repaint();
        }
    }

    @SneakyThrows
    @Override
    public void mousePressed(MouseEvent e) {
        // 左键
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (PlayControls.isVisible) {
                PlayControls.setControlsIsVisible(false);
            }
            stopBallMoving();
            playJPanel.setDragLine(this::drawline);
            playJPanel.repaint();
        }
    }

    @SneakyThrows
    @Override
    public void mouseReleased(MouseEvent e) {
        // 左键
        if (e.getButton() == MouseEvent.BUTTON1) {
            playJPanel.setDragLine(null);
            // 延时是解决jpanel刷新页面时，会出现拉伸线未清理情况
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            // 判断拉伸线的起点是否在图形内，否小球才移动
            if (Objects.isNull(RayCastUtil.isPointInside(playJPanel.getStartPoint()))) {
                // 创建定时任务
                if (Objects.isNull(playJPanel.schedulerFactory)) {
                    // 1、创建调度器Scheduler
                    playJPanel.schedulerFactory = new StdSchedulerFactory();
                    Scheduler scheduler = playJPanel.schedulerFactory.getScheduler();
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
                    scheduler.scheduleJob(jobDetail, trigger);
                    scheduler.start();
                }
                playJPanel.setBallMove(this::ballMoving);
            }
            playJPanel.repaint();
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
            // null表示不在内部则显示
            if (Objects.isNull(RayCastUtil.isBallInside(locationX, locationY, diameter))) {
                g.fillOval(locationX, locationY, diameter, diameter);
            }
        }
        playJPanel.repaint();
    }

    /**
     * @Description: 传入坐标，显示小球
     * ballX、ballY为小球坐标（左上角的位置），由BallMoveJob任务赋值
     */
    private void ballMoving(Graphics2D g, Double ballX, Double ballY) {
        int locationX = (int) (ballX - BALL_DIAMETER / 2);
        int locationY = (int) (ballY - BALL_DIAMETER / 2);
        g.setColor(Color.BLACK);
        g.fillOval(locationX, locationY, BALL_DIAMETER, BALL_DIAMETER);

//        RayCastUtil.isBallInside(locationX, locationY, BALL_DIAMETER);


        playJPanel.repaint();
    }

    /**
     * @Description: 停止小球移动
     */
    private void stopBallMoving(){
        playJPanel.setStartPoint(null);
        playJPanel.setBallMove(null);
        playJPanel.setBallX(null);
        playJPanel.setBallY(null);
        playJPanel.setMoveX(null);
        playJPanel.setMoveY(null);
    }

}
