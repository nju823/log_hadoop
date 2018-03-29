package mapreduce.service_max;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import util.BeanUtil;
import vo.ServiceSecondStatisticVO;
import vo.StatisticIndexVO;
import vo.StatisticMaxVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-26.
 * 统计每天的每秒最大最小值
 */
public class ServiceMaxMapper extends Mapper<LongWritable,Text,Text,Text>{


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        ServiceSecondStatisticVO logVO= JSONObject.parseObject(value.toString(),ServiceSecondStatisticVO.class);
        if(logVO==null)
            return;
        ServiceMaxKey serviceSecondKey=new ServiceMaxKey();
        BeanUtil.copyProperties(serviceSecondKey,logVO);
        ServiceMaxValue statisticIndexVO=new ServiceMaxValue();
        BeanUtil.copyProperties(statisticIndexVO,logVO);
        statisticIndexVO.setAverage_access_time(logVO.getAccess_time_sum()/logVO.getAccess_count());
        context.write(new Text(JSONObject.toJSONString(serviceSecondKey)),new Text(JSONObject.toJSONString(statisticIndexVO)));
    }


}
