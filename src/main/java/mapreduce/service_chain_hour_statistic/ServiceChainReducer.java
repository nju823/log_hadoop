package mapreduce.service_chain_hour_statistic;

import com.alibaba.fastjson.JSONObject;
import mapreduce.service_hour_statistic.ServiceHourKey;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import util.BeanUtil;
import vo.ServiceChainStatisticVO;
import vo.ServiceHourStatisticVO;
import vo.StatisticIndexVO;
import vo.StatisticVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceChainReducer extends Reducer<Text,Text, ServiceChainStatisticVO,Text>{


    @Override
    protected void reduce(Text keyText, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        ServiceChainKey key= JSONObject.parseObject(keyText.toString(),ServiceChainKey.class);
        StatisticVO sum=new StatisticVO();
        for(Text value:values){
            StatisticVO statisticVO=JSONObject.parseObject(value.toString(),StatisticVO.class);
            sum.add(statisticVO);
        }
        ServiceChainStatisticVO vo=new ServiceChainStatisticVO();
        BeanUtil.copyProperties(vo,key);

        StatisticIndexVO statisticIndexVO=new StatisticIndexVO();
        BeanUtil.copyProperties(statisticIndexVO,sum);
        statisticIndexVO.setAverage_access_time(sum.getAccess_time_sum()/sum.getAccess_count());

        vo.setStatisticIndexVO(statisticIndexVO);
        context.write(vo,null);
    }

}
