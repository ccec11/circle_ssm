package top.geminix.circle.test;
import java.util.Date;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.dao.IRefusalInfoDao;
import top.geminix.circle.domain.RefusalCircleInfo;
import top.geminix.circle.domain.RefusalNewsInfo;
import top.geminix.circle.service.ICircleInfoService;
import top.geminix.circle.util.DateUtils;
import top.geminix.circle.util.GsonTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RefusalInfoTest {
    @Autowired
    private IRefusalInfoDao refusalInfoDao;
    @Autowired
    private ICircleInfoService circleInfoService;

    @Test
    public void CircleTest() {
        //        测试成功
        RefusalCircleInfo refusalCircleInfo = new RefusalCircleInfo();
        refusalCircleInfo.setAdminId(1);
        refusalCircleInfo.setRefusalDate(new Date());
        refusalCircleInfo.setRefusalReason("理由如下");
        refusalCircleInfo.setCircleId(4);
        String jsonString = GsonTools.createJsonString(refusalCircleInfo);
        System.out.println(jsonString);


//        circleInfoService.saveRefusalCircleInfo(refusalCircleInfo);
    }

    @Test
    public void NewsTest() {
        RefusalNewsInfo refusalNewsInfo = new RefusalNewsInfo();
        refusalNewsInfo.setAdminId(1);
        refusalNewsInfo.setRefusalDate(new Date());
        refusalNewsInfo.setRefusalReason("12312");
        refusalNewsInfo.setNewsId(4);

        refusalInfoDao.saveRefusalNewsInfo(refusalNewsInfo);
//        测试成功
    }



}
