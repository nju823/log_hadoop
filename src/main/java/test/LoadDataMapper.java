package test;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import vo.AccessLogVO;

import java.io.IOException;

//map将输入中的value复制到输出数据的key上,并直接输出
public class LoadDataMapper extends Mapper<Object,Text,Text,LongWritable> {
    //实现map函数

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        AccessLogVO logVO= JSONObject.parseObject(value.toString(),AccessLogVO.class);
        if(logVO.getTarget()==null)
            return;
        context.write(new Text(logVO.getTarget()),new LongWritable(1l));
    }
}