package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.geminix.circle.domain.UserInfo;

import java.util.List;

public interface IUserInfoDao {

    /**根据id查用户
     * @Author Zachary
     * @param userId
     * @return
     */
    @Select("SELECT * FROM userinfo WHERE userId = #{userId}")
    UserInfo getByUserId(Integer userId);

    /**根据用户状态 获取被封禁的用户
     * @Author Zachary
     * @param userStatus
     * @return
     */
    @Select("SELECT * FROM userinfo WHERE userStatus = #{userStatus}")
    List<UserInfo> getBannedUserInfo(Integer userStatus);

    /** 改变用户状态为正常
     * @Author Zachary
     * @param userId
     * @param userStatus
     * @return
     */
    @Update("UPDATE userinfo set userStatus = #{userStatus} WHERE userId = #{userId}")
    boolean modifyUserStatusToNormal(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);

    /**
     * 根据资讯举报信息news_report 找到相关的newsId s ，也就找到了newsInfos
     * 然后用newsInfos 中的作者（userId）去用户表查circleInfo
     * 就是我们想要找的被举报的相关用户 举报评论 举报帖子 中都有用户
     * @Author Zachary
     */
//    @Select("SELECT * FROM userinfo WHERE userId IN (SELECT userId FROM newsinfo WHERE newsId IN (SELECT newsId FROM news_report))")
    @Select("SELECT *\n" +
            "FROM userinfo\n" +
            "WHERE userId IN (SELECT userId\n" +
            "                 FROM newsinfo\n" +
            "                 WHERE newsId IN (SELECT newsId\n" +
            "                                  FROM news_report)\n" +
            "                 UNION SELECT userId\n" +
            "                       FROM postinfo\n" +
            "                       WHERE postId IN (SELECT postId\n" +
            "                                        FROM post_report)\n" +
            "                 UNION SELECT userId\n" +
            "                       FROM commentsinfo\n" +
            "                       WHERE commentId IN (SELECT commentId\n" +
            "                                           FROM comment_report));")
    List<UserInfo> getReportedUserInfo();

    /**根据用户id 更改状态为 封禁
     * @Author Zachary
     * @param userId
     * @param userStatus
     * @return
     */
    @Update("UPDATE userinfo set userStatus = #{userStatus} WHERE userId = #{userId}")
    boolean modifyUserStatusToBanned(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);

    /**安装端 更改用户登录密码
     * @Author Zachary
     * @param userInfo
     * @return
     */
    @Update(" UPDATE userinfo SET userPassword = #{userPassword} WHERE userId = #{userId} ")
    boolean modifyUserPassword(UserInfo userInfo);

    /**用户进圈答题 通过考试 插入一条记录表示用户加入了圈子
     * @Author Zachary
     * @param userId
     * @param circleId
     * @return
     */
    //FIXME 建议用一个bean来封装 而不是两个Id
    @Insert(" INSERT INTO userjoincirclerecord(userId,circleId) VALUES (#{userId}, #{circleId}, 1, NULL) ")
    boolean addJoinCircleInfo(@Param("userId") Integer userId, @Param("circleId") Integer circleId);

}
