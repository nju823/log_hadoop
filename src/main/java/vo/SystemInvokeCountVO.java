package vo;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cong on 2018-03-22.
 */
public class SystemInvokeCountVO implements Writable,DBWritable {

    /**
     * 源系统，如果为null换成client
     */
    private String source_system;

    /**
     * 目标系统
     */
    private String target_system;

    /**
     * 调用日期，格式"2018-03-18"
     */
    private String invoke_date;

    /**
     * 调用的小时 0-23
     */
    private int invoke_hour;

    /**
     * 调用次数统计
     */
    private long invoke_count;

    public SystemInvokeCountVO(String source_system, String target_system, String invoke_date, int invoke_hour, long invoke_count) {
        this.source_system = source_system;
        this.target_system = target_system;
        this.invoke_date = invoke_date;
        this.invoke_hour = invoke_hour;
        this.invoke_count = invoke_count;
    }

    public SystemInvokeCountVO() {
    }

    public void write(PreparedStatement preparedStatement) throws SQLException {
        int index=1;
        preparedStatement.setString(index++,source_system);
        preparedStatement.setString(index++,target_system);
        preparedStatement.setString(index++,invoke_date);
        preparedStatement.setInt(index++,invoke_hour);
        preparedStatement.setLong(index++,invoke_count);
    }

    public void readFields(ResultSet resultSet) throws SQLException {

    }


    public void write(DataOutput dataOutput) throws IOException {

    }

    public void readFields(DataInput dataInput) throws IOException {

    }


}
