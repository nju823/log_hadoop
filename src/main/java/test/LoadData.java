package test;


import main.Main;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import util.BaseDbDriver;
import util.HdfsUtil;
import vo.CountVO;
import vo.JobInitDbModel;
import vo.JobInitModel;

/**
 * Created by cong on 2018-03-20.
 */
public class LoadData {

    public void run() {
        String inputPath= HdfsUtil.HDFS+"log_2018318";
        JobInitDbModel jobInitModel=new JobInitDbModel(new String[]{inputPath},new Configuration(),null,"count"
        , Main.class,null,LoadDataMapper.class, Text.class, LongWritable.class,null,null
        ,LoadDataReducer.class,CountVO.class,Text.class);
        jobInitModel.setFileds(new String[]{"target","count"});
        jobInitModel.setTableName("statistic_test");
        try{
            new BaseDbDriver().initJob(new JobInitModel[]{jobInitModel});
        }catch (Exception e){

        }

    }

}
