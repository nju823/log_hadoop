package mapreduce.service_hour_statistic;

import com.alibaba.fastjson.JSONObject;
import mapreduce.service_sencond_statistic.ServiceSecondKey;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import util.BeanUtil;
import vo.ServiceHourStatisticVO;
import vo.ServiceSecondStatisticVO;
import vo.StatisticVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-25.
 */
public class ServiceHourReducer extends Reducer<Text,Text,ServiceHourStatisticVO,Text> {


    @Override
    protected void reduce(Text keyText, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        ServiceHourKey key=JSONObject.parseObject(keyText.toString(),ServiceHourKey.class);
        StatisticVO sum=new StatisticVO();
        for(Text value:values){
            StatisticVO statisticVO=JSONObject.parseObject(value.toString(),StatisticVO.class);
            sum.add(statisticVO);
        }
        ServiceHourStatisticVO vo=new ServiceHourStatisticVO();
        BeanUtil.copyProperties(vo,key);
        BeanUtil.copyProperties(vo,sum);
        vo.setInvoke_hour(key.getHour());
        vo.setService(key.getServiceName());
        vo.setAverage_access_time(sum.getAccess_time_sum()/sum.getAccess_count());
        context.write(vo,null);
    }

}
