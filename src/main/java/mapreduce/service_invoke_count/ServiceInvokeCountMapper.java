package mapreduce.service_invoke_count;

import com.alibaba.fastjson.JSONObject;
import mapreduce.system_invoke_count.HourCountKey;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import util.BeanUtil;
import util.TimeUtil;
import vo.ServiceSecondStatisticVO;

import javax.xml.transform.Templates;
import java.io.IOException;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceInvokeCountMapper extends Mapper<LongWritable,Text,Text,LongWritable>{


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        ServiceSecondStatisticVO logVO= JSONObject.parseObject(value.toString(),ServiceSecondStatisticVO.class);
        if(logVO==null||logVO.getParentServiceName()==null)
            return;
        ServiceInvokeCountKey serviceInvokeCountKey=new ServiceInvokeCountKey();
        BeanUtil.copyProperties(serviceInvokeCountKey,logVO);
        serviceInvokeCountKey.setHour(TimeUtil.getHour(logVO.getSecond()));
        context.write(new Text(JSONObject.toJSONString(serviceInvokeCountKey)),new LongWritable(logVO.getAccess_count()));
    }

}
