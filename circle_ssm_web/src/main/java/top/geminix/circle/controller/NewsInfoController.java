package top.geminix.circle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.geminix.circle.domain.NewsInfo;
import top.geminix.circle.service.INewsInfoService;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsInfoController {

    private final static Integer NEWS_STATUS_PASS = 1;//已经发布
    private final static Integer NEWS_STATUS_WAIT = 2;//等待审核
    private final static Integer NEWS_STATUS_REFUSED = 0;//驳回
    private final static Integer NEWS_STATUS_BANNED = -1;//封禁

    @Autowired
    private INewsInfoService newsInfoService;

    @RequestMapping("/getAll.do")
    public ModelAndView getAllNewsInfo() {
        List<NewsInfo> allNewsInfo = newsInfoService.getAllNewsInfo(NEWS_STATUS_WAIT);

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
            return "redirect:getAll.do";
        }
        return "404";
    }

    @RequestMapping("/refuse.do")
    public String modifyNewsStatusToRefused(@RequestParam(required = true, name = "newsId") Integer newsId) {
        boolean result = false;
        result = newsInfoService.modifyNewsStatusToRefused(newsId,NEWS_STATUS_REFUSED);
        if (result == true) {
            return "redirect:getAll.do";
        }
        return "404";
    }

    @RequestMapping("/getSelectJson.do")
    @ResponseBody
    public NewsInfo getSelectedNewsJson(@RequestParam(required = true,name = "newsId") Integer newsId) {
        NewsInfo newsInfo = newsInfoService.getSelectedNews(newsId);
        return newsInfo;

    }

    @RequestMapping("/getSelect.do")
    public ModelAndView getSelectedNews(@RequestParam(required = true,name = "newsId") Integer newsId) {
        NewsInfo newsInfo = newsInfoService.getSelectedNews(newsId);

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsInfo", newsInfo);
        mv.setViewName("newsDetailsInterface");
        return mv;
    }


}
