package top.geminix.circle.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.dao.INewsInfoDao;
import top.geminix.circle.domain.NewsInfo;
import top.geminix.circle.service.INewsInfoService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class NewsInfoTest {
    @Autowired
    private INewsInfoService newsInfoService;

    @Autowired
    private INewsInfoDao newsInfoDao;

    @Test
    public void getAll() {
        List<NewsInfo> allNewsInfo = newsInfoDao.getAllNewsInfo(1);
        for (NewsInfo newsInfo : allNewsInfo) {
            System.out.println(newsInfo);
        }

    }

    @Test
    public void refusedTest() {
        boolean b = newsInfoService.modifyNewsStatusToRefused(1, -1);
        System.out.println(b);
    }

    @Test
    public void findOneTest() {
        NewsInfo selectedNews = newsInfoService.getSelectedNews(1);
        System.out.println(selectedNews);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String news_json = mapper.writeValueAsString(selectedNews);
            System.out.println(news_json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
