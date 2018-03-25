package vo;

/**
 * Created by cong on 2018-03-24.
 * 访问量，响应时间累积，异常次数，超时次数，慢调用次数
 */
public class StatisticVO {

    /**
     * 访问量
     */
    private long access_count;

    /**
     * 访问时间合计,单位毫秒
     */
    private long access_time_sum;

    /**
     * 异常次数合计
     */
    private long error_count;

    /**
     * 超时次数
     */
    private long no_response_count;

    /**
     * 慢访问次数
     */
    private long slow_count;

    public StatisticVO() {
    }

    public StatisticVO(long access_count, long access_time_sum, long error_count, long no_response_count, long slow_count) {
        this.access_count = access_count;
        this.access_time_sum = access_time_sum;
        this.error_count = error_count;
        this.no_response_count = no_response_count;
        this.slow_count = slow_count;
    }

    public void add(StatisticVO statisticVO){
        access_count+=statisticVO.access_count;
        access_time_sum+=statisticVO.access_time_sum;
        error_count+=statisticVO.error_count;
        no_response_count+=statisticVO.no_response_count;
        slow_count+=statisticVO.slow_count;
    }

    public long getAccess_count() {
        return access_count;
    }

    public void setAccess_count(long access_count) {
        this.access_count = access_count;
    }

    public long getAccess_time_sum() {
        return access_time_sum;
    }

    public void setAccess_time_sum(long access_time_sum) {
        this.access_time_sum = access_time_sum;
    }

    public long getError_count() {
        return error_count;
    }

    public void setError_count(long error_count) {
        this.error_count = error_count;
    }

    public long getNo_response_count() {
        return no_response_count;
    }

    public void setNo_response_count(long no_response_count) {
        this.no_response_count = no_response_count;
    }

    public long getSlow_count() {
        return slow_count;
    }

    public void setSlow_count(long slow_count) {
        this.slow_count = slow_count;
    }
}
