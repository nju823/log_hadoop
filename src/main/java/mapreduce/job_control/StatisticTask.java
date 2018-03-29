package mapreduce.job_control;

import mapreduce.merge_request_response.MergeJob;
import mapreduce.service_chain_hour_statistic.ServiceChainJob;
import mapreduce.service_hour_statistic.ServiceHourJob;
import mapreduce.service_invoke_count.ServiceInvokeCountJob;
import mapreduce.service_max.ServiceMaxJob;
import mapreduce.service_sencond_statistic.ServiceSecondStatisticJob;
import mapreduce.system_invoke_count.HourCountJob;

/**
 * Created by cong on 2018-03-28.
 */
public class StatisticTask implements Runnable{


    private static final BaseJob[] ALL_JOB={
            new MergeJob(),
            new ServiceSecondStatisticJob(),
            new ServiceChainJob(),
            new ServiceHourJob(),
            new ServiceInvokeCountJob(),
            new ServiceMaxJob(),
            new HourCountJob()
    };

    public void run() {
        for(BaseJob job:ALL_JOB){
            job.run();
        }
    }
}
