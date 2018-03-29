package mapreduce.service_max;

import main.Main;
import mapreduce.job_control.BaseJob;
import mapreduce.job_control.PathController;
import mapreduce.service_hour_statistic.ServiceHourMapper;
import mapreduce.service_hour_statistic.ServiceHourReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import util.BaseDbDriver;
import util.HdfsUtil;
import vo.JobInitDbModel;
import vo.JobInitModel;
import vo.ServiceHourStatisticVO;
import vo.StatisticMaxVO;

/**
 * Created by cong on 2018-03-26.
 */
public class ServiceMaxJob extends BaseJob{

    PathController pathController=new PathController();

    public void run() {
        String inputPath= pathController.getSencondStatisticPath();
        JobInitDbModel jobInitModel=new JobInitDbModel(new String[]{inputPath},new Configuration(),null,"service_max_statistic"
                , Main.class,null, ServiceMaxMapper.class, Text.class, Text.class,null,null
                , ServiceMaxReducer.class, StatisticMaxVO.class,Text.class);
        jobInitModel.setFileds(new String[]{"service","system","date","access_count_second","average_access_time_second",
                "error_count_second","no_response_count_second","slow_count_second","access_count","average_access_time",
                "error_count","no_response_count","slow_count"});
        jobInitModel.setTableName("service_max");
        try{
            new BaseDbDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
