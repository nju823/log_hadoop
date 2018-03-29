package mapreduce.service_hour_statistic;

/**
 * Created by cong on 2018-03-25.
 */
public class ServiceHourKey {

    /**
     * 本接口
     */
    private String serviceName;

    /**
     * 源系统
     */
    private String system;

    /**
     * 目标系统
     */
    private int hour;

    /**
     * 日期
     */
    private String date;

    public ServiceHourKey() {
    }

    public ServiceHourKey(String serviceName, String system, int hour, String date) {
        this.serviceName = serviceName;
        this.system = system;
        this.hour = hour;
        this.date = date;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
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
}
