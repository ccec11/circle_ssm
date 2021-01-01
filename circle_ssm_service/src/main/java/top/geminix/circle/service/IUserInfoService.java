package top.geminix.circle.service;

import top.geminix.circle.domain.UserInfo;
import top.geminix.circle.domain.UserJoinCircleRecord;

import java.util.List;

public interface IUserInfoService {
    /**
     * @Author Zachary
     * @Description 获取被封禁的用户
     */
    List<UserInfo> getBannedUserInfo(Integer userStatus);

    /**
     * @Author Zachary
     * @Description 获取被举报的用户
     */
    List<UserInfo> getReportedUserInfo();

    /**
     * @Author Zachary
     * @Description 更改用户状态为正常
     */
    Boolean modifyUserStatusToNormal(Integer userId,Integer userStatus);

    /**
     * @Author Zachary
     * @Description 更改用户状态为封禁
     */
    Boolean modifyUserStatusToBanned(Integer userId,Integer userStatus);

    /**
     * 更改密码功能
     * @Author Zachary
     * @Description
     */
    Boolean modifyUserPassword(UserInfo userInfo);
    /**
     * 添加进圈记录功能
     * @Author Zachary
     * @Description
     */
    Boolean addJoinCircleInfo(Integer userId, Integer circleId);

    /**
     * 添加进圈记录功能
     * @Author Zachary
     * @Description
     */
    Boolean saveJoinCircleInfo(UserJoinCircleRecord userJoinCircleRecord);

    Boolean checkOldPassword(UserInfo userInfo);
}
