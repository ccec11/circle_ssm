package top.geminix.circle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import top.geminix.circle.domain.BadWordInfo;
import top.geminix.circle.service.IBadWordInfoService;

import java.util.List;


@Controller
@RequestMapping("/badWord")
public class BadWordInfoController {

    @Autowired
    private IBadWordInfoService badWordInfoService;


    @RequestMapping("getAll.do")
    public ModelAndView getAllBadWord() {
        ModelAndView mv = new ModelAndView();
        List<BadWordInfo> allBadWord = badWordInfoService.getAllBadWord();
        mv.addObject("badWordList", allBadWord);
        mv.setViewName("manageBadWords");
        return mv;
    }


    @RequestMapping("add.do")
    public String addBadWordInfo(@RequestParam(name = "badWordContent") String badWordContent) {
        boolean addResult = false;
        addResult = badWordInfoService.addBadWordInfo(badWordContent);
        if (addResult == true) {
            return "redirect:getAll.do";
        }
        return "404";
    }

    @RequestMapping("remove.do")
    public String removeBadWordInfo(@RequestParam(name = "bid") Integer badWordId) {
        boolean removeResult = false;
        removeResult = badWordInfoService.removeBadWordInfo(badWordId);
        if (removeResult == true) {
            return "redirect:getAll.do";
        }
        return "404";
    }


}
