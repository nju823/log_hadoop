package mapreduce.service_hour_statistic;

import main.Main;
import mapreduce.job_control.BaseJob;
import mapreduce.job_control.PathController;
import mapreduce.system_invoke_count.HourCountMapper;
import mapreduce.system_invoke_count.HourCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import util.BaseDbDriver;
import util.HdfsUtil;
import vo.JobInitDbModel;
import vo.JobInitModel;
import vo.ServiceHourStatisticVO;
import vo.SystemInvokeCountVO;

/**
 * Created by cong on 2018-03-26.
 */
public class ServiceHourJob extends BaseJob{

    PathController pathController=new PathController();

    public void run() {
        String inputPath= pathController.getSencondStatisticPath();
        JobInitDbModel jobInitModel=new JobInitDbModel(new String[]{inputPath},new Configuration(),null,"service_hour_statistic"
                , Main.class,null, ServiceHourMapper.class, Text.class, Text.class,null,null
                , ServiceHourReducer.class, ServiceHourStatisticVO.class,Text.class);
        jobInitModel.setFileds(new String[]{"service","system","invoke_hour","date","access_count","average_access_time",
                "error_count","no_response_count","slow_count"});
        jobInitModel.setTableName("service_statistic_hour");
        try{
            new BaseDbDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
