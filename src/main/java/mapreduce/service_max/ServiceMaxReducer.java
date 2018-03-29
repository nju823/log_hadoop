package mapreduce.service_max;

import com.alibaba.fastjson.JSONObject;
import mapreduce.service_sencond_statistic.ServiceSecondKey;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import vo.StatisticIndexVO;
import vo.StatisticMaxVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-26.
 */
public class ServiceMaxReducer extends Reducer<Text,Text,StatisticMaxVO,Text>{

    @Override
    protected void reduce(Text keyText, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        ServiceMaxKey key= JSONObject.parseObject(keyText.toString(),ServiceMaxKey.class);

        StatisticMaxVO max=new StatisticMaxVO();
        max.setDate(key.getDate());
        max.setService(key.getServiceName());
        max.setSystem(key.getTarget());

        StatisticIndexVO maxIndex=new StatisticIndexVO();
        max.setMaxIndex(maxIndex);

        for(Text value:values){
            ServiceMaxValue statisticVO=JSONObject.parseObject(value.toString(),ServiceMaxValue.class);
            findMax(max, maxIndex, statisticVO);
        }

        context.write(max,null);
    }

    private void findMax(StatisticMaxVO max, StatisticIndexVO maxIndex, ServiceMaxValue statisticVO) {
        if(statisticVO.getAccess_count()>maxIndex.getAccess_count()){
            maxIndex.setAccess_count(statisticVO.getAccess_count());
            max.setAccess_count_second(statisticVO.getSecond());
        }

        if(statisticVO.getAverage_access_time()>maxIndex.getAverage_access_time()){
            maxIndex.setAverage_access_time(statisticVO.getAverage_access_time());
            max.setAverage_access_time_second(statisticVO.getSecond());
        }

        if(statisticVO.getError_count()>maxIndex.getError_count()){
            maxIndex.setError_count(statisticVO.getError_count());
            max.setError_count_second(statisticVO.getSecond());
        }

        if(statisticVO.getNo_response_count()>maxIndex.getNo_response_count()){
            maxIndex.setNo_response_count(statisticVO.getNo_response_count());
            max.setNo_response_count_second(statisticVO.getSecond());
        }

        if(statisticVO.getSlow_count()>maxIndex.getSlow_count()){
            maxIndex.setSlow_count(statisticVO.getSlow_count());
            max.setSlow_count_second(statisticVO.getSecond());
        }
    }


}
