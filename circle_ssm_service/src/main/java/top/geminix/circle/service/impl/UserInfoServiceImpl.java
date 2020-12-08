package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.geminix.circle.dao.IUserInfoDao;
import top.geminix.circle.domain.UserInfo;
import top.geminix.circle.service.IUserInfoService;

import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private IUserInfoDao userInfoDao;

    @Override
    public List<UserInfo> getBannedUserInfo(Integer userStatus) {
        return userInfoDao.getBannedUserInfo(userStatus);
    }

    @Override
    public boolean modifyUserStatusToNormal(Integer userId, Integer userStatus) {
        return userInfoDao.modifyUserStatusToNormal(userId,userStatus);
    }

    @Override
    public List<UserInfo> getReportedUserInfo() {
        return userInfoDao.getReportedUserInfo();
    }

    @Override
    public boolean modifyUserStatusToBanned(Integer userId,Integer userStatus) {
        return userInfoDao.modifyUserStatusToBanned(userId,userStatus);
    }

    @Override
    public boolean modifyUserPassword(UserInfo userInfo) {
        return userInfoDao.modifyUserPassword(userInfo);
    }

    @Override
    public boolean addJoinCircleInfo(Integer userId, Integer circleId) {
        return userInfoDao.addJoinCircleInfo(userId, circleId);
    }
}
