package top.geminix.circle.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.dao.IReportInfoDao;
import top.geminix.circle.domain.ReportInfo;
import top.geminix.circle.service.IReportInfoService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ReportInfoTest {
    @Autowired
    private IReportInfoService reportInfoService;

    @Autowired
    private IReportInfoDao reportInfoDao;

    @Test
    public void getAllTest() {
        Integer status = 1;
        List<ReportInfo> allReportInfo = reportInfoDao.getAllReportInfo(status);
        for (ReportInfo reportInfo : allReportInfo) {
            System.out.println(reportInfo);
        }
    }

}
