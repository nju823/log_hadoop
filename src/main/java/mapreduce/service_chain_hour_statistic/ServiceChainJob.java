package mapreduce.service_chain_hour_statistic;

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
import vo.ServiceChainStatisticVO;
import vo.ServiceHourStatisticVO;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceChainJob extends BaseJob{

    PathController pathController=new PathController();

    public void run() {
        String inputPath= pathController.getSencondStatisticPath();
        JobInitDbModel jobInitModel=new JobInitDbModel(new String[]{inputPath},new Configuration(),null,"service_chain_statistic"
                , Main.class,null, ServiceChainMapper.class, Text.class, Text.class,null,null
                , ServiceChainReducer.class, ServiceChainStatisticVO.class,Text.class);
        jobInitModel.setFileds(new String[]{"service","hour","date","root_service","parent_service","target","access_count","average_access_time",
                "error_count","no_response_count","slow_count"});
        jobInitModel.setTableName("service_chain_statistic_hour");
        try{
            new BaseDbDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
