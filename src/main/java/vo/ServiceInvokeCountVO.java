package vo;

import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceInvokeCountVO implements DBWritable{


    private String source;

    private String target;

    private int hour;

    private String date;

    private String serviceName;

    private String parentServiceName;

    private long count;

    public void write(PreparedStatement preparedStatement) throws SQLException {
        int index=1;
        preparedStatement.setString(index++,source);
        preparedStatement.setString(index++,target);
        preparedStatement.setInt(index++,hour);
        preparedStatement.setString(index++,date);
        preparedStatement.setString(index++,serviceName);
        preparedStatement.setString(index++,parentServiceName);
        preparedStatement.setLong(index++,count);
    }

    public void readFields(ResultSet resultSet) throws SQLException {

    }

    public String getParentServiceName() {
        return parentServiceName;
    }

    public void setParentServiceName(String parentServiceName) {
        this.parentServiceName = parentServiceName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


}
