package mapreduce.system_invoke_count;

import com.alibaba.fastjson.JSONObject;
import mapreduce.service_sencond_statistic.ServiceSecondStatisticJob;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import util.TimeUtil;
import vo.AccessLogVO;
import vo.HourCountKey;
import vo.ServiceSecondStatisticVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-23.
 * 统计每小时系统间调用次数
 */
public class HourCountMapper extends Mapper<LongWritable,Text,Text,LongWritable> {


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        ServiceSecondStatisticVO logVO= JSONObject.parseObject(value.toString(),ServiceSecondStatisticVO.class);
        if(logVO==null)
            return;
        HourCountKey countkey=new HourCountKey(logVO.getSource(),logVO.getTarget()
                ,Integer.parseInt(logVO.getSecond().substring(0,2)), logVO.getDate());
        context.write(new Text(JSONObject.toJSONString(countkey)),new LongWritable(logVO.getAccess_count()));
    }

}
