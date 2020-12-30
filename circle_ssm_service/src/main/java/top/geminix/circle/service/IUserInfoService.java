package top.geminix.circle.service;

import top.geminix.circle.domain.UserInfo;
import top.geminix.circle.domain.UserJoinCircleRecord;

import java.util.List;

public interface IUserInfoService {
    /**
     * @Author Xia
     * @Description 获取被封禁的用户
     */
    List<UserInfo> getBannedUserInfo(Integer userStatus);

    Boolean modifyUserStatusToNormal(Integer userId,Integer userStatus);

    List<UserInfo> getReportedUserInfo();

    Boolean modifyUserStatusToBanned(Integer userId,Integer userStatus);
    /**
     * 更改密码功能
     * @Author Xia
     * @Description
     */
    Boolean modifyUserPassword(UserInfo userInfo);
    /**
     * 添加进圈记录功能
     * @Author Xia
     * @Description
     */
    Boolean addJoinCircleInfo(Integer userId, Integer circleId);


    Boolean saveJoinCircleInfo(UserJoinCircleRecord userJoinCircleRecord);
}
