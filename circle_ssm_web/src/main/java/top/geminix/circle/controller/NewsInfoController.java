package top.geminix.circle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.geminix.circle.domain.NewsInfo;
import top.geminix.circle.domain.RefusalNewsInfo;
import top.geminix.circle.service.INewsInfoService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsInfoController {

    private final static Integer NEWS_STATUS_PASS = 1;//已经发布
    private final static Integer NEWS_STATUS_WAIT = 0;//等待审核
    private final static Integer NEWS_STATUS_REFUSED = 2;//驳回
    private final static Integer NEWS_STATUS_BANNED = -1;//封禁

    @Autowired
    private INewsInfoService newsInfoService;

    @RequestMapping("/getAllWait.do")
    public ModelAndView getAllWaitNewsInfo() {
        List<NewsInfo> allNewsInfo = newsInfoService.getAllWaitNewsInfo(NEWS_STATUS_WAIT);

        ModelAndView mv = new ModelAndView();
        mv.addObject("allNewsInfo", allNewsInfo);
        mv.setViewName("reviewNewsInfo");
        return mv;
    }

    @RequestMapping("/auto.do")
    public void modifyNewsStatusAuto() {
        newsInfoService.modifyNewsStatusAuto();
    }

    @RequestMapping("/pass.do")
    public String modifyNewsStatusToPass(@RequestParam(required = true, name = "newsId") Integer newsId) {
        boolean result = false;
        result = newsInfoService.modifyNewsStatusToPass(newsId,NEWS_STATUS_PASS);
        if (result == true) {
            return "redirect:getAllWait.do";
        }
        return "404";
    }
//驳回新闻 和 驳回圈子一样  需要先进入一个填写理由的界面 或者弹窗
//    获取管理员 输入的理由  然后提交到保存信息表单的controller 然后再service层 进行保存理由 更改状态等操作

    @RequestMapping("/refuse.do")
    public String modifyNewsStatusToRefused(@RequestParam(required = true, name = "newsId") Integer newsId) {
        boolean result = false;
        result = newsInfoService.modifyNewsStatusToRefused(newsId);
        if (result == true) {
            return "redirect:getAllWait.do";
        }
        return "404";
    }

    @RequestMapping("/saveReason.do")
    @ResponseBody
    public boolean saveRefusalNewsInfo(RefusalNewsInfo refusalNewsInfo) {
        refusalNewsInfo.setRefusalDate(new Date());//初始化日期
        Boolean saveResult = false;
        saveResult = newsInfoService.saveRefusalNewsInfo(refusalNewsInfo);

        return saveResult;
    }

    @RequestMapping("/ban.do")
    public String modifyNewsStatusToBanned(@RequestParam(required = true, name = "newsId") Integer newsId) {
        boolean result = false;
        result = newsInfoService.modifyNewsStatusToBanned(newsId,NEWS_STATUS_BANNED);
        if (result == true) {
            return "redirect:getAllWait.do";
        }
        return "404";
    }

    @RequestMapping("/getSelectJson.do")
    @ResponseBody
    public String getSelectedNewsJson(@RequestParam(required = true,name = "newsId") Integer newsId) {
        NewsInfo newsInfo = newsInfoService.getSelectedNews(newsId);
        String newsContent = newsInfo.getNewsContent();
        return newsContent;

    }

    @RequestMapping("/getSelect.do")
    public ModelAndView getSelectedNewsTest(@RequestParam(required = true,name = "newsId") Integer newsId) {
        NewsInfo newsInfo = newsInfoService.getSelectedNews(newsId);
        ModelAndView mv = new ModelAndView();

        mv.addObject("newsInfo", newsInfo);
        mv.setViewName("newsDetailsInterface");
        return mv;
    }

    @RequestMapping("/getOne.do")
    public ModelAndView getSelectedNewsInfo(@RequestParam(required = true,name = "id") Integer newsId) {
        NewsInfo newsInfo = newsInfoService.getSelectedNews(newsId);
//        结果合法性判断
        ModelAndView mv = new ModelAndView();
        if (newsInfo != null) {
            mv.addObject("newsInfo",newsInfo);
//            mv.setViewName("saveRefusalCircleInfo");
            mv.setViewName("saveRefusalNewsInfo");
            return mv;
        }
        mv.setViewName("404");
        return mv;
    }


}
