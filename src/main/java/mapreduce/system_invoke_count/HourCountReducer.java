package mapreduce.system_invoke_count;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import vo.SystemInvokeCountVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-23.
 */
public class HourCountReducer extends Reducer<Text,LongWritable, SystemInvokeCountVO,Text> {


    @Override
    protected void reduce(Text keyText, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        HourCountKey key= JSONObject.parseObject(keyText.toString(),HourCountKey.class);
        long sum=0;
        for(LongWritable value:values){
            sum+=value.get();
        }
        SystemInvokeCountVO countVO=new SystemInvokeCountVO(key.getSource(),
                key.getTarget(),key.getDate(),key.getHour(),sum);
        context.write(countVO,null);
    }

}
