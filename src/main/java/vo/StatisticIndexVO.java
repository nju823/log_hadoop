package vo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by cong on 2018-03-25.
 */
public class StatisticIndexVO {

    /**
     * 访问量
     */
    protected long access_count;

    /**
     * 平均访问时间
     */
    protected long average_access_time;

    /**
     * 异常次数合计
     */
    protected long error_count;

    /**
     * 超时次数
     */
    protected long no_response_count;

    /**
     * 慢访问次数
     */
    protected long slow_count;

    protected void write(int index,PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(index++,access_count);
        preparedStatement.setLong(index++,average_access_time);
        preparedStatement.setLong(index++,error_count);
        preparedStatement.setLong(index++,no_response_count);
        preparedStatement.setLong(index++,slow_count);
    }

    public long getAccess_count() {
        return access_count;
    }

    public void setAccess_count(long access_count) {
        this.access_count = access_count;
    }

    public long getAverage_access_time() {
        return average_access_time;
    }

    public void setAverage_access_time(long average_access_time) {
        this.average_access_time = average_access_time;
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
