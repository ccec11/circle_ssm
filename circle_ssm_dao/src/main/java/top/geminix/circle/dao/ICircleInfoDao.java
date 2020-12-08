package top.geminix.circle.dao;

import org.apache.ibatis.annotations.*;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.LabelInfo;
import top.geminix.circle.domain.RefusalCircleInfo;
import top.geminix.circle.domain.UserInfo;

import java.util.List;

public interface ICircleInfoDao {

    @Update(" UPDATE circleinfo SET circleStatus = #{circleStatus} WHERE circleId = #{circleId} ")
    boolean modifyCircleStatusToDenied(@Param("circleId") Integer circleId, @Param("circleStatus")Integer circleStatus);

    @Update(" update circleinfo SET circleStatus = #{circleStatus} WHERE circleId = #{circleId} ")
    boolean modifyCircleStatusToNormal(@Param("circleId") Integer circleId, @Param("circleStatus")Integer circleStatus);

    @Update(" update circleinfo SET circleStatus = #{circleStatus} WHERE circleId = #{circleId} ")
    boolean modifyCircleStatusToBanned(@Param("circleId") Integer circleId, @Param("circleStatus")Integer circleStatus);

    /**
     * FIXME 根据状态获取圈子信息 建议合并
     * 获取封禁 + 获取待审核
     * @return
     */
    @Select("select * from circleinfo where circleStatus = #{circleStatus}")
    @Results({
            @Result(property = "circleId", column = "circleId"),
            @Result(property = "labelInfo", column = "labelId", javaType = LabelInfo.class, one = @One(select = "top.geminix.circle.dao.ILabelInfoDao.getByLabelId")),
            @Result(property = "userInfo", column = "userId", javaType = UserInfo.class, one = @One(select = "top.geminix.circle.dao.IUserInfoDao.getByUserId")),
            @Result(property = "circleName", column = "circleName"),
            @Result(property = "circleDescription", column = "circleDescription"),
            @Result(property = "circleImagePath", column = "circleImagePath"),
            @Result(property = "submitDate", column = "submitDate"),
            @Result(property = "circleStatus", column = "circleStatus")
    })
    List<CircleInfo> getBannedCircleInfo(@Param("circleStatus") Integer circleStatus);

    /**
     * FIXME 待维护
     * 获得 与举报相关的圈子
     * 包含 举报帖子 举报评论 举报资讯（这个好像不用）
     * @return
     */
    @Select("SELECT * FROM circleinfo WHERE circleId IN (SELECT circleId FROM postinfo WHERE postId IN (SELECT postId FROM post_report))")
    @Results({
            @Result(property = "circleId", column = "circleId"),
            @Result(property = "labelInfo", column = "labelId", javaType = LabelInfo.class, one = @One(select = "top.geminix.circle.dao.ILabelInfoDao.getByLabelId")),
            @Result(property = "userInfo", column = "userId", javaType = UserInfo.class, one = @One(select = "top.geminix.circle.dao.IUserInfoDao.getByUserId")),
            @Result(property = "circleName", column = "circleName"),
            @Result(property = "circleDescription", column = "circleDescription"),
            @Result(property = "circleImagePath", column = "circleImagePath"),
            @Result(property = "submitDate", column = "submitDate"),
            @Result(property = "circleStatus", column = "circleStatus")
    })
    List<CircleInfo> getReportedCircleInfo();

    /**
     * 根据状态获取 圈子信息
     * @param circleStatus
     * @return
     */
    @Select("select * from circleinfo where circleStatus = #{circleStatus}")
    @Results({
            @Result(property = "circleId", column = "circleId"),
            @Result(property = "labelInfo", column = "labelId", javaType = LabelInfo.class, one = @One(select = "top.geminix.circle.dao.ILabelInfoDao.getByLabelId")),
            @Result(property = "userInfo", column = "userId", javaType = UserInfo.class, one = @One(select = "top.geminix.circle.dao.IUserInfoDao.getByUserId")),
            @Result(property = "circleName", column = "circleName"),
            @Result(property = "circleDescription", column = "circleDescription"),
            @Result(property = "circleImagePath", column = "circleImagePath"),
            @Result(property = "submitDate", column = "submitDate"),
            @Result(property = "circleStatus", column = "circleStatus")
    })
    List<CircleInfo> getInvalidCircleInfo(@Param("circleStatus") Integer circleStatus);

    @Select(" SELECT * FROM circleinfo WHERE circleId = #{circleId} ")
    @Results({
            @Result(property = "circleId", column = "circleId"),
            @Result(property = "labelInfo", column = "labelId", javaType = LabelInfo.class, one = @One(select = "top.geminix.circle.dao.ILabelInfoDao.getByLabelId")),
            @Result(property = "userInfo", column = "userId", javaType = UserInfo.class, one = @One(select = "top.geminix.circle.dao.IUserInfoDao.getByUserId")),
            @Result(property = "circleName", column = "circleName"),
            @Result(property = "circleDescription", column = "circleDescription"),
            @Result(property = "circleImagePath", column = "circleImagePath"),
            @Result(property = "submitDate", column = "submitDate"),
            @Result(property = "circleStatus", column = "circleStatus")
    })
    CircleInfo getSelectedCircle(@Param("circleId") Integer circleId);

//    @Insert(" INSERT INTO refusalcirclerecord (adminId, circleId, refusalDate, refusalReason) VALUES (#{adminId},#{circleId},#{refusalDate},#{refusalReason}) ")
//    boolean saveRefusalCircleInfo(RefusalCircleInfo refusalCircleInfo);
}
