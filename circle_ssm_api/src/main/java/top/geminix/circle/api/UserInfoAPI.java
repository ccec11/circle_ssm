package top.geminix.circle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.geminix.circle.domain.UserInfo;
import top.geminix.circle.domain.UserJoinCircleRecord;
import top.geminix.circle.service.IUserInfoService;

/**
 * @version 1.0.0
 * @Author Zachary
 * @createTime 2020年12月13日 16:49:00
 */
@RestController
@RequestMapping("/api/user")
public class UserInfoAPI {
    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("/modifyPassword.do")
    @ResponseBody
    public boolean modifyUserPassword(@RequestBody UserInfo userInfo) {
        boolean modifyResult = userInfoService.modifyUserPassword(userInfo);

        return modifyResult;
    }

    /**
     * TODO 把2个id 合成一个入圈信息 入圈信息表中有其他字段
     *
     * @param userId
     * @param circleId
     * @return
     */
    @RequestMapping("/userJoinCircle.do")
    @ResponseBody
    public boolean userJoinTest(@RequestParam(required = true,name = "userId") Integer userId,
                                @RequestParam(required = true,name = "circleId") Integer circleId) {
        Boolean addResult = false;
        addResult = userInfoService.addJoinCircleInfo(userId, circleId);
        return addResult;
    }
    @RequestMapping("/saveJoin.do")
    @ResponseBody
    public Boolean userJoinCircle(UserJoinCircleRecord userJoinCircleRecord) {
        Boolean result =false;
        result = userInfoService.saveJoinCircleInfo(userJoinCircleRecord);
        return result;
    }


}
