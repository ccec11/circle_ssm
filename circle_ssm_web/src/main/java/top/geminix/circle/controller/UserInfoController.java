package top.geminix.circle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.geminix.circle.domain.UserInfo;
import top.geminix.circle.service.IUserInfoService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

    private static final Integer USER_STATUS_BANNED = 0;
    private static final Integer USER_STATUS_NORMAL = 1;

    @RequestMapping("/getBanned.do")
    public ModelAndView getBannedUserInfo() {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> bannedUserInfoList = userInfoService.getBannedUserInfo(USER_STATUS_BANNED);

        mv.addObject("bannedUserInfoList", bannedUserInfoList);
        mv.setViewName("manageAccountInterface-unban");
        return mv;
    }

    @RequestMapping("/getReported.do")
    public ModelAndView getReportedUserInfo() {
        ModelAndView mv = new ModelAndView();

        List<UserInfo> reportedUserInfos = userInfoService.getReportedUserInfo();
        mv.addObject("reportedUserInfos", reportedUserInfos);
        mv.setViewName("manageAccountInterface-ban");
        return mv;
    }

    /**
     * 解封账号
     * @param userId
     */
    @RequestMapping("unBan.do")
    public String modifyUserStatusToNormal(@RequestParam(required = true,name = "id")Integer userId) {
        boolean flag = false;
        flag = userInfoService.modifyUserStatusToNormal(userId,USER_STATUS_NORMAL);
        if (flag == true) {
            return "redirect:getBanned.do";
        }
        return "unBanFailed";

    }

    /**
     * /user/ban.do?id=${reportedUser.userId}
     * @param userId
     */
    @RequestMapping("/ban.do")
    public String modifyUserStatusToBanned(@RequestParam(required = true,name = "id")Integer userId) {
        boolean flag = false;
        flag = userInfoService.modifyUserStatusToBanned(userId,USER_STATUS_BANNED);
        if (flag == true) {
            return "redirect:getReported.do";
        }
        return "banFailed";
    }

    /**
     * 安卓端修改密码的 接口
     * @param userInfo
     * @return
     */
    @RequestMapping("modifyPassword.do")
    @ResponseBody
    public boolean modifyUserPassword(@RequestBody UserInfo userInfo) {
        boolean modifyResult = false;
        modifyResult = userInfoService.modifyUserPassword(userInfo);

        return modifyResult;
    }

    public void addJoinCircleInfo(Integer userId,Integer circleId) {
        boolean addResult = false;
        addResult = userInfoService.addJoinCircleInfo(userId, circleId);

    }





}
