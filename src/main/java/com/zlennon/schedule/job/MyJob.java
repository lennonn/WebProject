package com.zlennon.schedule.job;

import com.zlennon.business.service.DailyContentService;
import com.zlennon.webmagic.DailyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.Date;

@Component
public class MyJob{
    @Autowired
    private DailyContentService dailyContentService;
/*        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String x = jobDataMap.getString("x");
        String y = jobDataMap.getString("y");
        DailyProcessor my = new DailyProcessor(this.dailyContentService);
        Spider.create(my).addUrl("http://sentence.iciba.com/index.php?c=dailysentence&m=getTodaySentence").thread(5).run();
        logger.info("Job={}, x={}, y={}", jobDetail.getKey().getName(), x, y);*/
        @Scheduled(cron = "0 30 8 * * ?")
        public void run() {
            DailyProcessor my = new DailyProcessor(this.dailyContentService);
            Spider.create(my).addUrl("http://sentence.iciba.com/index.php?c=dailysentence&m=getTodaySentence").thread(5).run();
        }

}
