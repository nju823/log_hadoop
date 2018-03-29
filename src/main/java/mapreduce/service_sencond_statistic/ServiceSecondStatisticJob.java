package mapreduce.service_sencond_statistic;

import main.Main;
import mapreduce.job_control.BaseJob;
import mapreduce.job_control.PathController;
import mapreduce.merge_request_response.MergeMapper;
import mapreduce.merge_request_response.MergeReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import util.BaseDriver;
import util.HdfsUtil;
import vo.JobInitModel;

/**
 * Created by cong on 2018-03-25.
 */
public class ServiceSecondStatisticJob extends BaseJob{

    PathController pathController=new PathController();

    public void run() {
        String inputPath= pathController.getMergedLogPath();
        String outPath= pathController.getSencondStatisticPath();
        JobInitModel jobInitModel=new JobInitModel(new String[]{inputPath},outPath,new Configuration(),null,"service_second_statistic"
                , Main.class,null, ServiceSecondMapper.class, Text.class, Text.class,null,null
                , ServiceSecondReducer.class, Text.class,Text.class);

        try{
            new BaseDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
