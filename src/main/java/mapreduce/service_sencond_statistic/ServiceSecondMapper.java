package mapreduce.service_sencond_statistic;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.hdfs.util.EnumCounters;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import util.BeanUtil;
import util.LoggerUtil;
import util.TimeUtil;
import vo.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by cong on 2018-03-24.
 * 调用链上单服务每秒指标统计
 */
public class ServiceSecondMapper extends Mapper<LongWritable,Text,Text,Text>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        MergedAccessLog log=JSONObject.parseObject(value.toString(),MergedAccessLog.class);
        if(log==null){
            return;
        }
        //复制维度信息
        ServiceSecondKey serviceSecondKey=new ServiceSecondKey();
        BeanUtil.copyProperties(serviceSecondKey,log);
        serviceSecondKey.setDate(TimeUtil.getDate(log.getRequestTime()));
        serviceSecondKey.setSecond(TimeUtil.getSecond(log.getRequestTime()));

        //计算统计指标
        long accessTime=60000;
        if(log.getResponseTime()!=null){
            accessTime=log.getResponseTime()-log.getRequestTime();
        }
        long errorCount=log.getIsError() ? 1 : 0;
        long noResponseCount=log.getHasResponse() ? 0 : 1;
        long slowCount=accessTime<20000 ? 0 : 1;//默认超过20s未慢访问
        StatisticVO statisticVO=new StatisticVO(1,accessTime,errorCount,noResponseCount,slowCount);

        context.write(new Text(JSONObject.toJSONString(serviceSecondKey)),new Text(JSONObject.toJSONString(statisticVO)));
    }


}
