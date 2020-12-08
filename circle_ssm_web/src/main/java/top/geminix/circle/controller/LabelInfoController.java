package top.geminix.circle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.geminix.circle.domain.LabelInfo;
import top.geminix.circle.service.ILabelInfoService;

import java.util.List;

@Controller
@RequestMapping("/labelInfo")
public class LabelInfoController {
    @Autowired
    private ILabelInfoService labelInfoService;

    @RequestMapping("/getAll.do")
    public ModelAndView getLabelInfo() {
        ModelAndView mv = new ModelAndView();
        List<LabelInfo> labelInfos = labelInfoService.getLabelInfo();
        mv.addObject("labelInfos", labelInfos);
        mv.setViewName("manageLabel");
        return mv;
    }

    /**
     * 前台选择父类分类的时候 建议使用下拉框  然后下拉框里面装的就是分类标签的id信息
     * 这个操作比较复杂，建议配合 JQuery+AJAX 来完成操作
     * 表中有3列 labelId labelName sortId(分类id）
     * 接口测试成功 http://localhost:8080/circle_ssm/labelInfo/add.do?sid=1&lname="hello标签"
     *
     * @return
     */
    @RequestMapping("add.do")
    public String addLabelInfo(@RequestParam(required = true, name = "sid") Integer sortId, @RequestParam(required = true, name = "lname") String labelName) {
        boolean addResult = false;
        addResult = labelInfoService.addLabelInfo(sortId, labelName);
        if (addResult == true) {
            return "redirect:getAll.do";
        }
        return "404";
    }

    /**
     * <h4>注意设置一下 分组 和布局</h4>
     <button>读取分类的label</button>
     <button>点击就是选择大分类</button>
     <button>然后利用jQuery获取数据之后 AJAX 提交请求</button>
     * @return
     */
    @RequestMapping("getCategory.do")
    @ResponseBody
    public List<LabelInfo> getCategory() {
        List<LabelInfo> labelCategory = labelInfoService.getLabelCategory();
        return labelCategory;
    }


    /**
     *
     * @return
     */
    @RequestMapping("remove.do")
    public String removeLabelInfo(@RequestParam(name = "id") Integer labelId) {
        boolean removeResult = false;
//        removeResult = badWordInfoService.removeBadWordInfo(badWordId);
        removeResult = labelInfoService.removeLabelInfo(labelId);
        if (removeResult == true) {
            return "redirect:getAll.do";
        }
        return "404";

    }


}
