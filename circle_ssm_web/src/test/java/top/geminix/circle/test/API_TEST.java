package top.geminix.circle.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.service.ICircleInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0.0
 * @Author Zachary
 * @createTime 2020年12月13日 16:39:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class API_TEST {
    @Resource
    private ICircleInfoService circleInfoService;

    @Test
    public void apiTest1() {
        List<CircleInfo> circleInfoByCategory = circleInfoService.getCircleInfoByCategory(3);//6
        for (CircleInfo circleInfo : circleInfoByCategory) {
            System.out.println(circleInfo);
        }
    }

}
