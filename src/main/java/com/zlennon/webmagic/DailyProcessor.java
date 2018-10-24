package com.zlennon.webmagic;

import com.zlennon.business.model.DailyContent;
import com.zlennon.business.service.DailyContentService;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.Date;


public class DailyProcessor implements PageProcessor {
    int myid = 0;
    int size =10;
    // 抓取网站的相关配置，可以包括编码、抓取间隔1s、重试次数等
    private Site site = Site.me().setCharset("utf8").setRetryTimes(1000).setSleepTime(1000);
    @Override
    public Site getSite() {
        return site;
    }
    private  DailyContentService dailyContentService;

    public DailyProcessor(DailyContentService dailyContentService){
        this.dailyContentService=dailyContentService;
    }

    @Override
    public void process(Page page) {
        //Html html = page.getHtml();
       // div[@class="daily-box"]/div[@class="daily-cn"]/a/text()
        String cnContent = new JsonPathSelector("$.note").select(page.getRawText());//内容
        String zhContent = new JsonPathSelector("$.content").select(page.getRawText());//内容
        System.out.println("cnContent: "+ cnContent);
        System.out.println("zhContent: "+ zhContent);
        DailyContent dailyContent = new DailyContent();
        dailyContent.setContent(zhContent+"\\n"+cnContent);
        dailyContent.setType("01");
        dailyContent.setCreateTime(new Date());
        dailyContentService.insert(dailyContent);

    }
    public static void main(String[] args) {
/*        DailyProcessor my = new DailyProcessor();
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(my).addUrl("http://sentence.iciba.com/index.php?c=dailysentence&m=getTodaySentence").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒");*/
    }
}