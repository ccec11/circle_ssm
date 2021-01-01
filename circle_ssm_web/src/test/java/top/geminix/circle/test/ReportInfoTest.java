package top.geminix.circle.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.dao.IReportInfoDao;
import top.geminix.circle.domain.ReportCommentInfo;
import top.geminix.circle.domain.ReportInfo;
import top.geminix.circle.domain.ReportNewsInfo;
import top.geminix.circle.domain.ReportPostInfo;
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

    @Test
    public void getAllCommentTest() {
        Integer status = 1;
        List<ReportCommentInfo> allReportInfo = reportInfoDao.getCommentReportInfo(status);
        for (ReportCommentInfo reportCommentInfo : allReportInfo) {
            System.out.println(reportCommentInfo);

        }
    }

    @Test
    public void getAllPostTest() {
        List<ReportPostInfo> postReportInfo = reportInfoDao.getPostReportInfo(1);
        for (ReportPostInfo reportPostInfo : postReportInfo) {
            System.out.println(reportPostInfo);
        }
    }

    @Test
    public void getAllNewsTest() {
        List<ReportNewsInfo> newsReportInfo = reportInfoDao.getNewsReportInfo(1);
        for (ReportNewsInfo reportNewsInfo : newsReportInfo) {
            System.out.println(reportNewsInfo);
        }
    }

}
