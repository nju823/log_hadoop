package mapreduce.system_invoke_count;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by cong on 2018-03-23.
 */
public class HourCountKey {

    private String source;

    private String target;

    private int hour;

    private String date;

    public HourCountKey(String source, String target, int hour,String date) {
        this.source = source;
        this.target = target;
        this.hour = hour;
        this.date=date;
    }

    public HourCountKey() {
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
