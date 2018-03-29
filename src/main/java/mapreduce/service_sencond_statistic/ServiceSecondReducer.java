package mapreduce.service_sencond_statistic;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import vo.*;

import java.io.IOException;

/**
 * Created by cong on 2018-03-24.
 */
public class ServiceSecondReducer extends Reducer<Text,Text,Text,Text>{


    @Override
    protected void reduce(Text keyText, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        ServiceSecondKey serviceSecondKey=JSONObject.parseObject(keyText.toString(),ServiceSecondKey.class);
        StatisticVO sum=new StatisticVO();
        for(Text value:values){
            StatisticVO statisticVO=JSONObject.parseObject(value.toString(),StatisticVO.class);
            sum.add(statisticVO);
        }
        ServiceSecondStatisticVO statistic=new ServiceSecondStatisticVO(serviceSecondKey,sum);
        context.write(new Text(JSONObject.toJSONString(statistic)),null);

    }

}
