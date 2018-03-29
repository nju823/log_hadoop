package vo;

import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cong on 2018-03-26.
 */
public class StatisticMaxVO implements DBWritable{

    /**
     * 本接口
     */
    private String service;

    /**
     * 源系统
     */
    private String system;

    /**
     * 日期
     */
    private String date;

    private String access_count_second;

    private String average_access_time_second;

    private String error_count_second;

    private String no_response_count_second;

    private String slow_count_second;

    private StatisticIndexVO maxIndex;

    public void write(PreparedStatement preparedStatement) throws SQLException {
        int index=1;
        preparedStatement.setString(index++,service);
        preparedStatement.setString(index++,system);
        preparedStatement.setString(index++,date);
        preparedStatement.setString(index++,access_count_second);
        preparedStatement.setString(index++,average_access_time_second);
        preparedStatement.setString(index++,error_count_second);
        preparedStatement.setString(index++,no_response_count_second);
        preparedStatement.setString(index++,slow_count_second);
        maxIndex.write(index,preparedStatement);

    }

    public void readFields(ResultSet resultSet) throws SQLException {

    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public StatisticIndexVO getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(StatisticIndexVO maxIndex) {
        this.maxIndex = maxIndex;
    }

    public String getAccess_count_second() {
        return access_count_second;
    }

    public void setAccess_count_second(String access_count_second) {
        this.access_count_second = access_count_second;
    }

    public String getAverage_access_time_second() {
        return average_access_time_second;
    }

    public void setAverage_access_time_second(String average_access_time_second) {
        this.average_access_time_second = average_access_time_second;
    }

    public String getError_count_second() {
        return error_count_second;
    }

    public void setError_count_second(String error_count_second) {
        this.error_count_second = error_count_second;
    }

    public String getNo_response_count_second() {
        return no_response_count_second;
    }

    public void setNo_response_count_second(String no_response_count_second) {
        this.no_response_count_second = no_response_count_second;
    }

    public String getSlow_count_second() {
        return slow_count_second;
    }

    public void setSlow_count_second(String slow_count_second) {
        this.slow_count_second = slow_count_second;
    }


}
