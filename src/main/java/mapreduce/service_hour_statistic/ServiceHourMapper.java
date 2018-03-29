package mapreduce.service_hour_statistic;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import util.BeanUtil;
import util.TimeUtil;
import vo.ServiceSecondStatisticVO;
import vo.StatisticVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-25.
 */
public class ServiceHourMapper extends Mapper<LongWritable,Text,Text,Text> {


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        ServiceSecondStatisticVO logVO= JSONObject.parseObject(value.toString(),ServiceSecondStatisticVO.class);
        if(logVO==null)
            return;
        ServiceHourKey serviceHourKey=new ServiceHourKey(logVO.getServiceName(),
                logVO.getTarget(), TimeUtil.getHour(logVO.getSecond()),logVO.getDate());
        StatisticVO statisticVO=new StatisticVO();
        BeanUtil.copyProperties(statisticVO,logVO);
        context.write(new Text(JSONObject.toJSONString(serviceHourKey)),new Text(JSONObject.toJSONString(statisticVO)));
    }

}
