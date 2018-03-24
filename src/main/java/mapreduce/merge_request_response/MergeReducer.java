package mapreduce.merge_request_response;

import com.alibaba.fastjson.JSONObject;
import enumeration.AccessTypeEnum;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import vo.AccessLogVO;
import vo.MergedAccessLog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cong on 2018-03-24.
 * 将相同spanid的请求与响应合并
 */
public class MergeReducer extends Reducer<LongWritable,Text,LongWritable,Text> {

    @Override
    protected void reduce(LongWritable traceId, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //将日志分成请求，响应和错误日志三类，key是spanId
        Map<Long, AccessLogVO> requestMap=new HashMap<Long, AccessLogVO>();
        Map<Long,AccessLogVO> responseMap=new HashMap<Long, AccessLogVO>();
        Map<Long,AccessLogVO> errorMap=new HashMap<Long, AccessLogVO>();

        String rootServiceName=null;
        for(Text value:values){
            AccessLogVO accessLogVO= JSONObject.parseObject(value.toString(),AccessLogVO.class);

            if(AccessTypeEnum.isRequest(accessLogVO.getType())){
                if(accessLogVO.getParentSpanId()==-1){
                    rootServiceName=accessLogVO.getServiceName();
                    accessLogVO.setSource("client");//补全源系统字段
                }
                requestMap.put(accessLogVO.getSpanId(),accessLogVO);
            }else if(AccessTypeEnum.isResponse(accessLogVO.getType())){
                responseMap.put(accessLogVO.getSpanId(),accessLogVO);
            }else{
                errorMap.put(accessLogVO.getSpanId(),accessLogVO);
            }
        }

        //根据request的spanId在responsemap和errormap中查找对应记录
        for(AccessLogVO request:requestMap.values()){
            AccessLogVO response=responseMap.get(request.getSpanId());

            //根据parentspanid查找发起调用的接口
            String parentServiceName=null;
            AccessLogVO parentLog=requestMap.get(request.getParentSpanId());
            if(parentLog!=null)
                parentServiceName=parentLog.getServiceName();

            MergedAccessLog mergedLog=new MergedAccessLog(request,response,parentServiceName,rootServiceName);

            AccessLogVO errorLog=errorMap.get(request.getSpanId());
            if(errorLog!=null)
                mergedLog.setIsError(true);

            context.write(null,new Text(JSONObject.toJSONString(mergedLog)));
        }
    }

}
