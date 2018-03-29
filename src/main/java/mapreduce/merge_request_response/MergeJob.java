package mapreduce.merge_request_response;

import main.Main;
import mapreduce.job_control.BaseJob;
import mapreduce.job_control.PathController;
import mapreduce.system_invoke_count.HourCountMapper;
import mapreduce.system_invoke_count.HourCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import util.BaseDbDriver;
import util.BaseDriver;
import util.HdfsUtil;
import vo.JobInitDbModel;
import vo.JobInitModel;
import vo.SystemInvokeCountVO;

/**
 * Created by cong on 2018-03-24.
 */
public class MergeJob extends BaseJob{

    PathController pathController=new PathController();

    public void run() {
        String inputPath= pathController.getAccessLogPath();
        String outPath= pathController.getMergedLogPath();
        JobInitModel jobInitModel=new JobInitModel(new String[]{inputPath},outPath,new Configuration(),null,"merge_request_response"
                , Main.class,null, MergeMapper.class, LongWritable.class, Text.class,null,null
                , MergeReducer.class, LongWritable.class,Text.class);

        try{
            new BaseDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
