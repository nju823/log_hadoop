package vo;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by cong on 2018-03-24.
 */
public class MergedAccessLog {

    /**
     * 是否异常
     */
    private boolean isError;

    /**
     * 是否有响应
     */
    private boolean hasResponse;

    /**
     * 发起请求的系统名称
     */
    private String source;

    /**
     * 响应请求的系统名称
     */
    private String target;

    /**
     * 调用的接口名称
     */
    private String serviceName;

    /**
     * 发起请求的接口
     */
    private String parentServiceName;

    /**
     *
     */
    private String rootServiceName;

    /**
     * 请求时间戳
     */
    private Long requestTime;

    /**
     * 响应时间戳
     */
    private Long responseTime;


    public MergedAccessLog(){

    }

    public MergedAccessLog(AccessLogVO request,AccessLogVO response,String parentServiceName,String rootServiceName){
        try {
            BeanUtils.copyProperties(this,request);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        this.parentServiceName=parentServiceName;
        this.rootServiceName=rootServiceName;
        this.requestTime=request.getCurrentMillis();
        if(response==null){
            this.isError=true;
            this.hasResponse=false;
        }else{
            this.hasResponse=true;
            this.responseTime=response.getCurrentMillis();
        }
    }

    public String getRootServiceName() {
        return rootServiceName;
    }

    public void setRootServiceName(String rootServiceName) {
        this.rootServiceName = rootServiceName;
    }

    public boolean getHasResponse() {
        return hasResponse;
    }

    public void setHasResponse(boolean hasResponse) {
        this.hasResponse = hasResponse;
    }

    public boolean getIsError() {
        return isError;
    }

    public void setIsError(boolean error) {
        isError = error;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getParentServiceName() {
        return parentServiceName;
    }

    public void setParentServiceName(String parentServiceName) {
        this.parentServiceName = parentServiceName;
    }

    public Long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Long requestTime) {
        this.requestTime = requestTime;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
}
