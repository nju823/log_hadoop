package test;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import vo.CountVO;

import java.io.IOException;

//reduce将输入中的key复制到输出数据的key上,并直接输出
public  class LoadDataReducer extends Reducer<Text,LongWritable, CountVO,Text> {
    //实现reduce函数

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long sum=0l;
        for(LongWritable count:values){
            sum+=count.get();
        }
        CountVO countVO=new CountVO();
        countVO.setCount(sum);
        countVO.setTarget(key.toString());
        context.write(countVO,null);
    }
}