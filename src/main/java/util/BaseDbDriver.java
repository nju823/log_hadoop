package util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import vo.JobInitDbModel;
import vo.JobInitModel;

import java.io.IOException;

/**
 * Created by cong on 2018-03-21.
 * 输出到数据库
 */
public class BaseDbDriver extends BaseDriver{

    protected Configuration getConf(JobInitModel jobInitModel){
        Configuration configuration=jobInitModel.getConf();
        DBConfiguration.configureDB(configuration,
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://rm-wz991a6b04vm5v4q4zo.mysql.rds.aliyuncs.com:3306/pepple",
                "root","Pan12345");
        return configuration;
    }

    protected void setOutput(Job job,JobInitModel jobInitModel){
        JobInitDbModel dbModel=(JobInitDbModel)jobInitModel;
        try {
            DBOutputFormat.setOutput(job,dbModel.getTableName(),dbModel.getFileds());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
