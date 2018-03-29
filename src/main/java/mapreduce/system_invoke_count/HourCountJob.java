package mapreduce.system_invoke_count;

import main.Main;
import mapreduce.job_control.BaseJob;
import mapreduce.job_control.PathController;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import test.LoadDataMapper;
import test.LoadDataReducer;
import util.BaseDbDriver;
import util.HdfsUtil;
import vo.CountVO;
import vo.JobInitDbModel;
import vo.JobInitModel;
import vo.SystemInvokeCountVO;

/**
 * Created by cong on 2018-03-23.
 */
public class HourCountJob extends BaseJob{

    PathController pathController=new PathController();

    public void run() {
        String inputPath= pathController.getSencondStatisticPath();
        JobInitDbModel jobInitModel=new JobInitDbModel(new String[]{inputPath},new Configuration(),null,"system_invoke_count"
                , Main.class,null, HourCountMapper.class, Text.class, LongWritable.class,null,null
                , HourCountReducer.class, SystemInvokeCountVO.class,Text.class);
        jobInitModel.setFileds(new String[]{"source_system","target_system","invoke_date","invoke_hour","invoke_count"});
        jobInitModel.setTableName("system_invoke_hour_count");
        try{
            new BaseDbDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){

        }

    }

}
