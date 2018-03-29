package vo;

import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceChainStatisticVO implements DBWritable{


    /**
     * 本接口
     */
    private String serviceName;


    /**
     * 目标系统
     */
    private int hour;

    /**
     * 日期
     */
    private String date;

    /**
     * 起始调用的接口，用于标识调用链
     */
    private String rootServiceName;

    /**
     * 发起调用的接口
     */
    private String parentServiceName;

    /**
     * 目标系统
     */
    private String target;

    private StatisticIndexVO statisticIndexVO;

    public void write(PreparedStatement preparedStatement) throws SQLException {
        int index=1;
        preparedStatement.setString(index++,serviceName);
        preparedStatement.setInt(index++,hour);
        preparedStatement.setString(index++,date);
        preparedStatement.setString(index++,rootServiceName);
        preparedStatement.setString(index++,parentServiceName);
        preparedStatement.setString(index++,target);
        statisticIndexVO.write(index,preparedStatement);

    }

    public void readFields(ResultSet resultSet) throws SQLException {

    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public String getRootServiceName() {
        return rootServiceName;
    }

    public void setRootServiceName(String rootServiceName) {
        this.rootServiceName = rootServiceName;
    }

    public String getParentServiceName() {
        return parentServiceName;
    }

    public void setParentServiceName(String parentServiceName) {
        this.parentServiceName = parentServiceName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public StatisticIndexVO getStatisticIndexVO() {
        return statisticIndexVO;
    }

    public void setStatisticIndexVO(StatisticIndexVO statisticIndexVO) {
        this.statisticIndexVO = statisticIndexVO;
    }


}
