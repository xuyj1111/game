package xu.game.okay.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Objects;

import static xu.game.okay.util.BeanFactory.playJPanel;

/**
 * @Description: 小球的坐标自增
 * @Author: xuyujun
 * @Date: 2022/8/11
 */
public class BallMoveJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        if (Objects.nonNull(playJPanel.getBallX()) && Objects.nonNull(playJPanel.getBallY())) {
            playJPanel.setBallX(playJPanel.getBallX() + playJPanel.getMoveX());
            playJPanel.setBallY(playJPanel.getBallY() + playJPanel.getMoveY());
        }
    }
}
