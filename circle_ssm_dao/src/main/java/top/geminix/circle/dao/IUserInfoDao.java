package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.geminix.circle.domain.UserInfo;

import java.util.List;

public interface IUserInfoDao {
    /**
     * @Author Xia
     * @Description
     */
    @Select("SELECT * FROM userinfo WHERE userId = #{userId}")
    UserInfo getByUserId(Integer userId);

    @Select("SELECT * FROM userinfo WHERE userStatus = #{userStatus}")
    List<UserInfo> getBannedUserInfo(Integer userStatus);

    @Update("UPDATE userinfo set userStatus = #{userStatus} WHERE userId = #{userId}")
    boolean modifyUserStatusToNormal(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);

    /**
     * 根据资讯举报信息news_report 找到相关的newsId s ，也就找到了newsInfo s
     * 然后用newsInfos 中的作者（userId）去用户表查circleInfo
     * 就是我们想要找的被举报的相关用户
     *
     * @return
     */
    @Select("SELECT * FROM userinfo WHERE userId IN (SELECT userId FROM newsinfo WHERE newsId IN (SELECT newsId FROM news_report))")
    List<UserInfo> getReportedUserInfo();

    @Update("UPDATE userinfo set userStatus = #{userStatus} WHERE userId = #{userId}")
    boolean modifyUserStatusToBanned(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);

    @Update(" UPDATE userinfo SET userPassword = #{userPassword} WHERE userId = #{userId} ")
    boolean modifyUserPassword(UserInfo userInfo);

    /**
     * @Author Xia
     * @Description
     */
    //FIXME 建议用一个bean来封装 而不是两个Id
    @Insert(" INSERT INTO userjoincirclerecord(userId,circleId) VALUES (#{userId}, #{circleId}, 1, NULL) ")
    boolean addJoinCircleInfo(@Param("userId") Integer userId, @Param("circleId") Integer circleId);

}
