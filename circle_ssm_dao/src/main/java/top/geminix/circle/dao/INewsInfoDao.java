package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.geminix.circle.domain.NewsInfo;

import java.util.List;

public interface INewsInfoDao {
    /**
     * 自动审核功能
     * @return
     */
    List<NewsInfo> modifyNewsStatusAuto();

    /**
     * Results@
     * 获取所有的资讯信息
     * @return
     * @param newsStatus
     */
    @Select("SELECT newsId,userId,newsTitle,newsContent,newsStatus,releaseDate FROM newsinfo WHERE newsStatus = #{newsStatus}")
    List<NewsInfo> getAllNewsInfo(Integer newsStatus);

    /**
     * 将一条资讯更改为 “已发布” 1
     * @return
     */
    @Update(" UPDATE newsinfo SET newsStatus = #{newsStatus} WHERE newsId = #{newsId} ")
    boolean modifyNewsStatusToPass(@Param("newsId")Integer newsId, @Param("newsStatus")Integer newsStatus);


    /**
     * 将一条资讯状态更改为 “已封禁” -1
     * @return
     */
    @Update(" UPDATE newsinfo SET newsStatus =  #{newsStatus} WHERE newsId = #{newsId} ")
    boolean modifyNewsStatusToRefused(@Param("newsId") Integer newsId, @Param("newsStatus") Integer newsStatus);

    @Select(" SELECT newsId,userId,newsTitle,newsContent,newsStatus,releaseDate FROM newsinfo WHERE newsId = #{newsId} ")
    NewsInfo getSelectedNews(@Param("newsId") Integer newsId);
}
