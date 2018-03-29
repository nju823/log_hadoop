package mapreduce.job_control;

import util.HdfsUtil;
import util.TimeUtil;

/**
 * Created by cong on 2018-03-28.
 */
public class PathController {

    public static final String HDFS = "hdfs://106.15.177.156:8020/";

    private static final String ACCESS_LOG_PATH="log_";

    private static final String MERGED_LOG_PATH="_merged";

    private static final String STATISTIC_PATH="_statistic";

    /**
     * 获取原始日志的文件夹路径
     * @return
     */
    public String getAccessLogPath(){
        String date= TimeUtil.yesterday();
        return HDFS+ACCESS_LOG_PATH+date;
    }

    /**
     * 获取合并后日志的文件夹路径
     * @return
     */
    public String getMergedLogPath(){
        String date= TimeUtil.yesterday();
        return HDFS+ACCESS_LOG_PATH+date+MERGED_LOG_PATH;
    }

    public String getSencondStatisticPath(){
        String date= TimeUtil.yesterday();
        return HDFS+ACCESS_LOG_PATH+date+STATISTIC_PATH;
    }



}
