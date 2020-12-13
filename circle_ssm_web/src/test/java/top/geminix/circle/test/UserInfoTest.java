package top.geminix.circle.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.dao.IUserInfoDao;
import top.geminix.circle.domain.UserInfo;
import top.geminix.circle.service.IUserInfoService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserInfoTest {
    @Autowired
    private IUserInfoDao userInfoDao;
    @Autowired
    private IUserInfoService userInfoService;

    @Test
    public void findById() {
        UserInfo byUserId = userInfoDao.getByUserId(1);
        System.out.println(byUserId);
    }

    @Test
    public void getBanned() {
        List<UserInfo> bannedUserInfo = userInfoService.getBannedUserInfo(0);
        System.out.println(bannedUserInfo.size());
        for (UserInfo userInfo : bannedUserInfo) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void modifyPassword() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(6);
        userInfo.setUserPassword("1234");
        boolean flag = userInfoService.modifyUserPassword(userInfo);
        System.out.println(flag);
    }

}
