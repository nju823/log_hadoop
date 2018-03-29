package main;

import mapreduce.job_control.StatisticTask;
import mapreduce.merge_request_response.MergeJob;
import mapreduce.service_chain_hour_statistic.ServiceChainJob;
import mapreduce.service_hour_statistic.ServiceHourJob;
import mapreduce.service_invoke_count.ServiceInvokeCountJob;
import mapreduce.service_max.ServiceMaxJob;
import mapreduce.service_sencond_statistic.ServiceSecondStatisticJob;
import mapreduce.system_invoke_count.HourCountJob;
import mapreduce.system_invoke_count.HourCountReducer;
import test.LoadData;
import util.TimerUtil;
import vo.ServiceInvokeCountVO;

/**
 * Created by cong on 2018-03-20.
 */
public class Main {

    public static void main(String[] args){
        TimerUtil.excuteDaily(new StatisticTask());
    }
}
