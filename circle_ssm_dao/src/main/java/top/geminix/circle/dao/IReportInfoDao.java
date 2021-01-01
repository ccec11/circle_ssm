package top.geminix.circle.dao;

import org.apache.ibatis.annotations.*;
import top.geminix.circle.domain.*;

import java.util.List;

public interface IReportInfoDao {
// ========下面全是查询语句=========
    @Select(" SELECT * FROM post_report WHERE reportStatus = #{reportStatus} ")
    List<ReportInfo> getAllReportInfo(Integer reportStatus);

    @Select(" SELECT * FROM news_report WHERE reportStatus = #{reportStatus} ")
    @Results(
            @Result(property = "userInfo", column = "userId", javaType = UserInfo.class, one = @One(select = "top.geminix.circle.dao.IUserInfoDao.getByUserId"))

    )
    List<ReportNewsInfo> getNewsReportInfo(Integer reportStatus);

    @Select(" SELECT * FROM post_report WHERE reportStatus = #{reportStatus} ")
    @Results(
            @Result(property = "userInfo", column = "userId", javaType = UserInfo.class, one = @One(select = "top.geminix.circle.dao.IUserInfoDao.getByUserId"))

    )
    List<ReportPostInfo> getPostReportInfo(Integer reportStatus);

    @Select(" SELECT * FROM comment_report WHERE reportStatus = #{reportStatus} ")
    @Results(
            @Result(property = "userInfo", column = "userId", javaType = UserInfo.class, one = @One(select = "top.geminix.circle.dao.IUserInfoDao.getByUserId"))

    )
    List<ReportCommentInfo> getCommentReportInfo(Integer reportStatus);

    //    ========下面全是更改状态 已处理的语句=========
    Boolean modifyReportInfoStatusToDone(ReportInfo reportInfo);

    /**
     * 更改 举报资讯信息 为 已处理
     * @param reportNewsInfoId
     * @return
     */
    @Update(" UPDATE news_report SET reportStatus = 1 WHERE reportNewsInfoId = #{reportNewsInfoId} ")
    Boolean modifyReportNewsInfoStatusToDone(Integer reportNewsInfoId);

    /**
     * 更改 举报帖子信息 为 已处理
     * @param reportPostInfoId
     * @return
     */
    @Update(" UPDATE post_report SET reportStatus = 1 WHERE reportPostInfoId = #{reportPostInfoId} ")
    Boolean modifyReportPostInfoStatusToDone(Integer reportPostInfoId);

    /**
     * 更改 举报评论信息 为 已处理
     * @param reportCommentInfoId
     * @return
     */
    @Update(" UPDATE comment_report SET reportStatus = 1 WHERE reportCommentInfoId = #{reportCommentInfoId} ")
    Boolean modifyReportCommentInfoStatusToDone(Integer reportCommentInfoId);


    //    ========下面全是删除状态 的语句=========
    Boolean removeReportInfo(ReportInfo reportInfo);

    @Update(" UPDATE news_report SET reportStatus = -1 WHERE reportNewsInfoId = #{reportNewsInfoId} ")
    Boolean removeReportNewsInfo(Integer reportNewsInfoId);

    @Update(" UPDATE post_report SET reportStatus = -1 WHERE reportPostInfoId = #{reportPostInfoId} ")
    Boolean removeReportPostInfo(Integer reportPostInfoId);

    @Update(" UPDATE comment_report SET reportStatus = -1 WHERE reportCommentInfoId = #{reportCommentInfoId} ")
    Boolean removeReportCommentInfo(Integer reportCommentInfoId);
}
