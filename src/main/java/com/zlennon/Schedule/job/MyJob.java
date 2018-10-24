package com.zlennon.schedule.job;

import com.zlennon.business.service.DailyContentService;
import com.zlennon.schedule.quartz.LoggedJob;
import com.zlennon.webmagic.DailyProcessor;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
public class MyJob extends LoggedJob {
    @Autowired
    private DailyContentService dailyContentService;
    @Override
    public void executeJob(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String x = jobDataMap.getString("x");
        String y = jobDataMap.getString("y");
        DailyProcessor my = new DailyProcessor(this.dailyContentService);
        Spider.create(my).addUrl("http://sentence.iciba.com/index.php?c=dailysentence&m=getTodaySentence").thread(5).run();
        logger.info("Job={}, x={}, y={}", jobDetail.getKey().getName(), x, y);
    }
}
