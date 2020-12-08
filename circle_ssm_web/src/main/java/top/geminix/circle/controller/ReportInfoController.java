package top.geminix.circle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.geminix.circle.domain.ReportInfo;
import top.geminix.circle.service.IReportInfoService;

import java.util.List;

@Controller
@RequestMapping("/reportInfo")
public class ReportInfoController {
    /**
     *此功能 等待讨论
     */
    @Autowired
    private IReportInfoService reportInfoService;

    private static final Integer REPORTINFO_STATUS_OK = 1;//已处理
    private static final Integer REPORTINFO_STATUS_WAIT = 0;//待处理

    //          获取帖子相关的
    @RequestMapping("/get_post_report")
    public void getPostReportInfo() {
        List<ReportInfo> reportInfoList = reportInfoService.getAllReportInfo(REPORTINFO_STATUS_WAIT);
    }

    //        获取举报资讯相关的
    @RequestMapping("/get_news_report")
    public void getNewsReportInfo() {
        List<ReportInfo> newsReportInfo =reportInfoService.getNewsReportInfo(REPORTINFO_STATUS_WAIT);
        List<ReportInfo> postReportInfo = reportInfoService.getPostReportInfo(REPORTINFO_STATUS_WAIT);
        List<ReportInfo> commentReportInfo = reportInfoService.getCommentReportInfo(REPORTINFO_STATUS_WAIT);
    }

}
