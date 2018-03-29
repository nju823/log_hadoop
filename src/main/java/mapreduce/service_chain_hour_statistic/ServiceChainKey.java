package mapreduce.service_chain_hour_statistic;

/**
 * Created by cong on 2018-03-27.
 */
public class ServiceChainKey {

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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
}
