package vo;

import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cong on 2018-03-25.
 */
public class ServiceHourStatisticVO extends StatisticIndexVO implements DBWritable{


    /**
     * 本接口
     */
    private String service;

    /**
     * 源系统
     */
    private String system;

    /**
     * 目标系统
     */
    private int invoke_hour;

    /**
     * 日期
     */
    private String date;

    public void write(PreparedStatement preparedStatement) throws SQLException {
        int index=1;
        preparedStatement.setString(index++,service);
        preparedStatement.setString(index++,system);
        preparedStatement.setInt(index++,invoke_hour);
        preparedStatement.setString(index++,date);
        write(index,preparedStatement);
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

    public int getInvoke_hour() {
        return invoke_hour;
    }

    public void setInvoke_hour(int invoke_hour) {
        this.invoke_hour = invoke_hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
