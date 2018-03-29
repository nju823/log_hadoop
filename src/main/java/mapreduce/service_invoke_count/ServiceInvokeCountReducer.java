package mapreduce.service_invoke_count;

import com.alibaba.fastjson.JSONObject;
import mapreduce.system_invoke_count.HourCountKey;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import util.BeanUtil;
import vo.ServiceInvokeCountVO;
import vo.SystemInvokeCountVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceInvokeCountReducer extends Reducer<Text,LongWritable, ServiceInvokeCountVO,Text>{

    @Override
    protected void reduce(Text keyText, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        ServiceInvokeCountKey key= JSONObject.parseObject(keyText.toString(),ServiceInvokeCountKey.class);
        long sum=0;
        for(LongWritable value:values){
            sum+=value.get();
        }
        ServiceInvokeCountVO countVO=new ServiceInvokeCountVO();
        BeanUtil.copyProperties(countVO,key);
        countVO.setCount(sum);
        context.write(countVO,null);
    }

}
