import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;
import test.LoadDataMapper;
import test.LoadDataReducer;

/**
 * 测试数据说明 CDRID;CDRType;Phone1;Phone2;SMS Status Code
 * 655209;1;796764372490213;804422938115889;6
 * 353415;0;356857119806206;287572231184798;4
 * 835699;1;252280313968413;889717902341635;0
 * 
 */
public class MapperReducerTest {
	/*Configuration conf = new Configuration();
	MapDriver<Object,Text,Text,LongWritable> mapDriver;
	ReduceDriver<Text,LongWritable,Text,LongWritable> reduceDriver;
	MapReduceDriver<Object,Text,Text, LongWritable,Text,LongWritable> mapReduceDriver;

	@Before
	public void setUp() {

		//测试mapreduce
		LoadDataMapper mapper = new LoadDataMapper();
		LoadDataReducer reducer = new LoadDataReducer();
		mapDriver = MapDriver.newMapDriver(mapper);
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
		mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
		
		//测试配置参数
		mapDriver.setConfiguration(conf);
		conf.set("myParameter1", "20");
		conf.set("myParameter2", "23");
		
	}*/

	/*@Test
	public void testMapper() throws IOException {
		mapDriver.withInput(new LongWritable(), new Text(
				"655209;1;796764372490213;804422938115889;6;6;7"));
		mapDriver.withOutput(new Text("output"),new Text("655209;1;796764372490213;804422938115889;6;6;7"));
		mapDriver.runTest();
	}

	@Test
	public void testReducer() throws IOException {
		List<Text> values = new ArrayList<Text>();
		values.add(new Text("1"));
		values.add(new Text("1"));
		reduceDriver.withInput(new Text("6"), values);
		reduceDriver.withOutput(new Text("6"), new Text("1"));
		reduceDriver.runTest();
	}
	
	@Test
	public void testMapperReducer() throws IOException {
		mapReduceDriver.addInput(new LongWritable(),new Text("1"));
		mapReduceDriver.addInput(new LongWritable(),new Text("1"));
		mapReduceDriver.addInput(new LongWritable(),new Text("2"));
		mapReduceDriver.withOutput(new Text("1"), new Text("2")).withOutput(new Text("2"), new Text("2")).runTest();
	}*/


}