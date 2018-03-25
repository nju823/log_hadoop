package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by cong on 2018-03-25.
 * 执行定时任务
 */
public class TimerUtil {

    private static final ScheduledExecutorService EXECUTOR= Executors.newSingleThreadScheduledExecutor();

    private static final int ONE_DAY=1000*60*60*24;

    public void excuteDaily(Runnable runnable){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nextDay=TimeUtil.getDate(new Date().getTime()+ONE_DAY);
        long delay=0;
        try {
            Date executeTime=dateFormat.parse(nextDay+" "+"04:00:00");
            delay=executeTime.getTime()-System.currentTimeMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EXECUTOR.scheduleAtFixedRate(runnable,delay,ONE_DAY, TimeUnit.MILLISECONDS);
    }

}
