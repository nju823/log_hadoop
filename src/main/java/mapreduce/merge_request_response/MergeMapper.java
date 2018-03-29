package mapreduce.merge_request_response;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import vo.AccessLogVO;

import java.io.IOException;

/**
 * Created by cong on 2018-03-24.
 * 将日志按traceid分类
 */
public class MergeMapper extends Mapper<LongWritable,Text,LongWritable,Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        AccessLogVO logVO= JSONObject.parseObject(value.toString(),AccessLogVO.class);
        context.write(new LongWritable(logVO.getTraceId()),value);
    }


}
