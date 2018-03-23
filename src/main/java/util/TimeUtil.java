package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cong on 2018-03-23.
 * 解析时间戳
 */
public class TimeUtil {

    private static final String DATE_FOMART="yyyy-MM-dd";

    private static final String HOUR_FORMAT="HH";

    private static final String SECOND_FORMAT="HH:mm:ss";

    /**
     * 获取timestamp的日期
     * @param timestamp
     * @return
     */
    public static String getDate(long timestamp){
        return getFormatString(timestamp,DATE_FOMART);
    }

    /**
     * 获取timestamp的小时数 0-23
     * @param timestamp
     * @return
     */
    public static int getHour(long timestamp){
        return Integer.parseInt(getFormatString(timestamp,HOUR_FORMAT));
    }

    /**
     * 获取timestamp的秒数 13:56:45
     * @param timestamp
     * @return
     */
    public static String getSecond(long timestamp){
        return getFormatString(timestamp,SECOND_FORMAT);
    }

    private static String getFormatString(long timestamp,String format){
        Date date=new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static void main(String[] args){
        System.out.println(getHour(System.currentTimeMillis()));

    }


}
