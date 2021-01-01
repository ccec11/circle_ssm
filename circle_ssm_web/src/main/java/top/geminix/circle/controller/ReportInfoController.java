package top.geminix.circle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import top.geminix.circle.domain.ReportCommentInfo;
import top.geminix.circle.domain.ReportNewsInfo;
import top.geminix.circle.domain.ReportPostInfo;
import top.geminix.circle.service.IReportInfoService;

import java.util.List;

@Controller
@RequestMapping("/reportInfo")
public class ReportInfoController {
    /**
     * 此功能 等待讨论
     */
    @Autowired
    private IReportInfoService reportInfoService;

    private static final Integer REPORTINFO_STATUS_OK = 1;//已处理
    private static final Integer REPORTINFO_STATUS_DELETE = -1;//已删除
    private static final Integer REPORTINFO_STATUS_WAIT = 0;//待处理

    /**
     * 获取所有举报信息 展示在一个页面
     *
     * @return
     */
    @RequestMapping("/getAll.do")
    public ModelAndView getAllReportInfo() {
        List<ReportNewsInfo> newsReportInfo = reportInfoService.getNewsReportInfo(REPORTINFO_STATUS_WAIT);
        List<ReportPostInfo> postReportInfo = reportInfoService.getPostReportInfo(REPORTINFO_STATUS_WAIT);
        List<ReportCommentInfo> commentReportInfo = reportInfoService.getCommentReportInfo(REPORTINFO_STATUS_WAIT);

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsReportInfo", newsReportInfo);
        mv.addObject("postReportInfo", postReportInfo);
        mv.addObject("commentReportInfo", commentReportInfo);
        mv.setViewName("settleReportsInterface");
        return mv;
    }

    @RequestMapping("/done.do")
    public String modifyReportNewsInfoStatusToDone(@RequestParam(name = "id") Integer id) {
        Boolean result = reportInfoService.modifyReportNewsInfoStatusToDone(id);
        if (!result) {
            return "404";
        }
        return "redirect:getAll.do";
    }

    @RequestMapping("/done2.do")
    public String modifyReportPostInfoStatusToDone(@RequestParam(name = "id") Integer id) {
        Boolean result = reportInfoService.modifyReportPostInfoStatusToDone(id);
        if (!result) {
            return "404";
        }
        return "redirect:getAll.do";
    }

    @RequestMapping("/done3.do")
    public String modifyReportCommentInfoStatusToDone(@RequestParam(name = "id") Integer id) {
        Boolean result = reportInfoService.modifyReportCommentInfoStatusToDone(id);
        if (!result) {
            return "404";
        }
        return "redirect:getAll.do";
    }

    @RequestMapping("/remove.do")
    public String removeReportNewsInfo(@RequestParam(name = "id") Integer id) {
        boolean result = reportInfoService.removeReportNewsInfo(id);
        if (!result) {
            return "404";
        }
        return "redirect:getAll.do";
    }

    @RequestMapping("/remove2.do")
    public String removeReportPostInfo(@RequestParam(name = "id") Integer id) {
        boolean result = reportInfoService.removeReportPostInfo(id);
        if (!result) {
            return "404";
        }
        return "redirect:getAll.do";
    }

    @RequestMapping("/remove3.do")
    public String removeReportCommentInfo(@RequestParam(name = "id") Integer id) {
        boolean result = reportInfoService.removeReportCommentInfo(id);
        if (!result) {
            return "404";
        }
        return "redirect:getAll.do";
    }
}
