import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.mapreduce.Mapper;  
import org.apache.hadoop.mapreduce.Reducer;  
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;  
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import test.LoadDataMapper;
import test.LoadDataReducer;

import java.io.IOException;

/**
 * 数据去重 
 */  
public class Main1 {
  
    public static void main(String[] args) throws  Exception{

        //输入路径
        String dst = "hdfs://106.15.177.156:8020/stormtohdfs";
        //输出路径，必须是不存在的，空文件夹也不行。
        String dstOut = "hdfs://106.15.177.156:8020/result";
        Configuration configuration = new Configuration();
        configuration.set("fs.hdfs.impl",
                org.apache.hadoop.hdfs.DistributedFileSystem.class.getName()
        );
        configuration.set("fs.file.impl",
                org.apache.hadoop.fs.LocalFileSystem.class.getName()
        );

        Job job = new Job(configuration,"Count system invoke");
        job.setJarByClass(Main1.class);
        //设置Map,Combine和Reduce处理类
        job.setMapperClass(LoadDataMapper.class);
        job.setCombinerClass(LoadDataReducer.class);
        job.setReducerClass(LoadDataReducer.class);

        //设置输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //设置输出目录
        FileInputFormat.addInputPath(job,new Path(dst));
        FileOutputFormat.setOutputPath(job, new Path(dstOut));

        System.exit(job.waitForCompletion(true) ? 0 : 1);


    }  
  
}