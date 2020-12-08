package top.geminix.circle.service;

import top.geminix.circle.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {
    /**
     * @Author Xia
     * @Description 获取被封禁的用户
     */
    List<UserInfo> getBannedUserInfo(Integer userStatus);

    boolean modifyUserStatusToNormal(Integer userId,Integer userStatus);

    List<UserInfo> getReportedUserInfo();

    boolean modifyUserStatusToBanned(Integer userId,Integer userStatus);

    boolean modifyUserPassword(UserInfo userInfo);
    /**
     * @Author Xia
     * @Description
     */
    boolean addJoinCircleInfo(Integer userId, Integer circleId);



}
