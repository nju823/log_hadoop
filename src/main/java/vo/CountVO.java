package vo;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cong on 2018-03-21.
 */
public class CountVO implements Writable,DBWritable{

    private String target;

    private long count;


    public void write(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,target);
        preparedStatement.setLong(2,count);
    }

    public void readFields(ResultSet resultSet) throws SQLException {
        this.target=resultSet.getString(1);
        this.count=resultSet.getLong(2);
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void write(DataOutput dataOutput) throws IOException {

    }

    public void readFields(DataInput dataInput) throws IOException {

    }


}
