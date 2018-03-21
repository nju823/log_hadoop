package vo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.*;

/**
 * Created by cong on 2018-03-21.
 */
public class JobInitDbModel extends JobInitModel{

    private String[] fileds;

    private String tableName;

    public JobInitDbModel(String[] inPaths, Configuration conf, Job job, String jobName
            , Class<?> jarClass, Class<? extends InputFormat> inputFormatClass, Class<? extends Mapper> mapper
            , Class<?> mapOutKeyClass, Class<?> mapOutValueClass, Class<? extends Partitioner> partitionerClass
            , Class<? extends Reducer> combiner, Class<? extends Reducer> reducer, Class<?> reduceOutKeyClass
            , Class<?> reduceOutValueClass) {
        this.outPath = null;
        this.inPaths = inPaths;
        this.conf = conf;
        this.job = job;
        this.jobName = jobName;
        this.jarClass = jarClass;
        this.inputFormatClass = inputFormatClass;
        this.mapper = mapper;
        this.mapOutKeyClass = mapOutKeyClass;
        this.mapOutValueClass = mapOutValueClass;
        this.partitionerClass = partitionerClass;
        this.combinerClass = combiner;
        this.reducer = reducer;
        this.reduceOutKeyClass = reduceOutKeyClass;
        this.reduceOutValueClass = reduceOutValueClass;
    }

    public String[] getFileds() {
        return fileds;
    }

    public void setFileds(String[] fileds) {
        this.fileds = fileds;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
