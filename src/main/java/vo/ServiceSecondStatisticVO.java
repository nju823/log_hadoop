package vo;

import mapreduce.service_sencond_statistic.ServiceSecondKey;
import util.BeanUtil;

/**
 * Created by cong on 2018-03-25.
 */
public class ServiceSecondStatisticVO extends StatisticVO{

    /**
     * 标识一条调用链
     */
    private String rootServiceName;

    /**
     * 发起调用的接口
     */
    private String parentServiceName;

    /**
     * 本接口
     */
    private String serviceName;

    /**
     * 源系统
     */
    private String source;

    /**
     * 目标系统
     */
    private String target;

    /**
     * 秒
     */
    private String second;

    /**
     * 日期
     */
    private String date;

    public ServiceSecondStatisticVO(){

    }

    public ServiceSecondStatisticVO(ServiceSecondKey serviceSecondKey, StatisticVO statisticVO){
        BeanUtil.copyProperties(this,serviceSecondKey);
        BeanUtil.copyProperties(this,statisticVO);
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
