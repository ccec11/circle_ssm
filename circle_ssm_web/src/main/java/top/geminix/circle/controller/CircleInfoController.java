package top.geminix.circle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.RefusalCircleInfo;
import top.geminix.circle.service.ICircleInfoService;

import java.util.Date;
import java.util.List;

//FIXME 优化getCircleInfo（Integer circleStatus）根据传入的参数不同，返回的圈子类型不同 可以减少代码量
@Controller
@RequestMapping("/circle")
public class CircleInfoController {
    @Autowired
    private ICircleInfoService circleInfoService;
    private final static Integer CIRCLE_STATUS_WAIT = 0;//待审核
    private final static Integer CIRCLE_STATUS_PASS = 1;//正常
    private final static Integer CIRCLE_STATUS_BANNED = -1;//封禁
    private final static Integer CIRCLE_STATUS_REFUSED = -2;//被驳回 先不用

    /**
     * 获取被封禁的圈子
     *
     * @return
     */
    @RequestMapping("/getBanned.do")
    public ModelAndView getBannedCircleInfo() {
        ModelAndView mv = new ModelAndView();
        List<CircleInfo> bannedCircleList = circleInfoService.getBannedCircleInfo(CIRCLE_STATUS_BANNED);
        mv.addObject("bannedCircleList", bannedCircleList);
        mv.setViewName("manageCircleStatus");
        return mv;
    }

    /**
     * 根据圈子id 解封一个圈子
     * FIXME 返回json格式的布尔到前端 然后根据结果 js弹框
     *
     * @param circleId
     * @return
     */
    @RequestMapping("/unBan.do")
    public String modifyCircleStatusToNormal(@RequestParam(required = true, name = "id") Integer circleId) {
        boolean flag = false;
        flag = circleInfoService.modifyCircleStatusToNormal(circleId, CIRCLE_STATUS_PASS);
        if (flag == true) {
            return "redirect:getBanned.do";
        }
        return "unBanFailed";
    }

    /**
     * 根据圈子id封禁一个一个圈子
     *
     * @param circleId
     * @return
     */
    @RequestMapping("/ban.do")
    public String modifyCircleStatusToBanned(@RequestParam(required = true, name = "id") Integer circleId) {
        boolean flag = false;
        flag = circleInfoService.modifyCircleStatusToBanned(circleId, CIRCLE_STATUS_BANNED);
        if (flag == true) {
            return "redirect:getReported.do";//重新定向到某个getAll的controller上面即可
        }
        return "banFailed";
    }


    /**
     *
     * @return
     */
    @RequestMapping("/getReported.do")
    public ModelAndView getReportedCircleInfo() {
        ModelAndView mv = new ModelAndView();
        List<CircleInfo> reportedCircleList = circleInfoService.getReportedCircleInfo();
        mv.addObject("reportedCircleList", reportedCircleList);
        mv.setViewName("manageCircleStatus-ban");
        return mv;
    }

    /**
     * 查找未审核的圈子信息
     */
    @RequestMapping("getInvalid.do")
    public ModelAndView getInvalidCircleInfo() {
        List<CircleInfo> invalidCircleList = circleInfoService.getInvalidCircleInfo(CIRCLE_STATUS_WAIT);
        ModelAndView mv = new ModelAndView();
        mv.addObject("invalidCircleList", invalidCircleList);
        mv.setViewName("verifyRequestInterface");
        return mv;
    }

    /**
     * 通过 创圈审核 和解封一样的
     *
     * @param circleId
     * @return
     */
    @RequestMapping("/pass.do")
    public String modifyCircleStatusToValid(@RequestParam(required = true, name = "id") Integer circleId) {
        boolean flag = false;
        flag = circleInfoService.modifyCircleStatusToNormal(circleId, CIRCLE_STATUS_PASS);
        if (flag == true) {
            return "redirect:getInvalid.do";//重新定向到某个getAll的controller上面即可
        }
        return "500";
    }

    /**
     * 驳回  提交驳回理由 && 更改一个圈子状态
     * TODO 驳回还要提交驳回的理由
     *
     * @param circleId
     * @return
     */
    @RequestMapping("/refuse.do")
    @Deprecated
    public String modifyCircleStatusToDenied(@RequestParam(required = true, name = "id") Integer circleId) {
        boolean flag = false;
        flag = circleInfoService.modifyCircleStatusToDenied(circleId);

        if (flag == true) {
            return "redirect:getInvalid.do";//重新定向到某个getAll的controller上面即可
        }
        return "500";
    }

    /**
     * TODO 不建议使用弹窗
     * 应该跳转到一个页面 findCircleById 然后活得circleId 根据登录session拿到adminId 管理员填写表单，提交表单
     * 如果异步-提交表单成功 返回一个 布尔给前端， 如果成功则更改圈子状态，失败 不改状态
     * @return
     */
    @RequestMapping("/saveReason.do")
    @ResponseBody
    public boolean saveRefusalCircleInfo(RefusalCircleInfo refusalCircleInfo) {
        boolean saveResult = false;
        refusalCircleInfo.setRefusalDate(new Date());
        saveResult = circleInfoService.saveRefusalCircleInfo(refusalCircleInfo);
        return saveResult;
    }


    @RequestMapping("/getOne.do")
    public ModelAndView getSelectedCircle(@RequestParam(required = true,name = "id") Integer circleId) {
        CircleInfo circleInfo = circleInfoService.getSelectedCircle(circleId);
//        结果合法性判断
        ModelAndView mv = new ModelAndView();
        if (circleInfo != null) {
            mv.addObject("circleInfo",circleInfo);
            mv.setViewName("saveRefusalCircleInfo");
            return mv;
        }
        mv.setViewName("404");
        return mv;
    }




}
