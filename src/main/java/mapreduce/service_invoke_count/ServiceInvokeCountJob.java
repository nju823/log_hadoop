package mapreduce.service_invoke_count;

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
import vo.ServiceInvokeCountVO;
import vo.SystemInvokeCountVO;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceInvokeCountJob extends BaseJob{

    PathController pathController=new PathController();

    public void run() {
        String inputPath= pathController.getSencondStatisticPath();
        JobInitDbModel jobInitModel=new JobInitDbModel(new String[]{inputPath},new Configuration(),null,"service_invoke_count"
                , Main.class,null, ServiceInvokeCountMapper.class, Text.class, LongWritable.class,null,null
                , ServiceInvokeCountReducer.class, ServiceInvokeCountVO.class,Text.class);
        jobInitModel.setFileds(new String[]{"source","target","hour","date","service","parent_service","count"});
        jobInitModel.setTableName("service_invoke_hour_count");
        try{
            new BaseDbDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
