package main;

import mapreduce.system_invoke_count.HourCountJob;
import mapreduce.system_invoke_count.HourCountReducer;
import test.LoadData;

/**
 * Created by cong on 2018-03-20.
 */
public class Main {

    public static void main(String[] args){
        HourCountJob job=new HourCountJob();
        job.run();
    }
}
