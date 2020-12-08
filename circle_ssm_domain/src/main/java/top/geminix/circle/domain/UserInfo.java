package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private int userId;
    private String userAccount;//注意：此处使用Account而不是userName！
    private String userPassword;
    private String userName;
    private Date userBirthday;
    private String userBirthdayStr;
    private String userImagePath;//头像url
    private String userAddress;
    private String userContent;
    private String userGender;
    private String userToken;//周的功能

    private String userPhone;
    private int userStatus;//用户状态 0=已封禁   1=正常
    private String userStatusStr;
//    private int reportedRecord;//违规被举报情况？这个应该在第三张表里面  多对多的关系？


    public String getUserStatusStr() {
            if (userStatus == 0) {
                userStatusStr = "已封禁";
            }
            if (userStatus == 1) {
                userStatusStr = "正常";
            }
        return userStatusStr;
    }
}
