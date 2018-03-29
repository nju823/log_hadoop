package mapreduce.service_chain_hour_statistic;

import com.alibaba.fastjson.JSONObject;
import mapreduce.service_hour_statistic.ServiceHourKey;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import util.BeanUtil;
import util.TimeUtil;
import vo.ServiceSecondStatisticVO;
import vo.StatisticVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceChainMapper extends Mapper<LongWritable,Text,Text,Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        ServiceSecondStatisticVO logVO= JSONObject.parseObject(value.toString(),ServiceSecondStatisticVO.class);
        if(logVO==null)
            return;
        ServiceChainKey serviceKey=new ServiceChainKey();
        BeanUtil.copyProperties(serviceKey,logVO);
        serviceKey.setHour(TimeUtil.getHour(logVO.getSecond()));

        StatisticVO statisticVO=new StatisticVO();
        BeanUtil.copyProperties(statisticVO,logVO);
        context.write(new Text(JSONObject.toJSONString(serviceKey)),new Text(JSONObject.toJSONString(statisticVO)));
    }


}
