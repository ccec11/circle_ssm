package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.geminix.circle.domain.NewsInfo;

import java.util.List;

public interface INewsInfoDao {
    /**
     * 自动审核功能
     * @Author Zachary
     * @return
     */
    List<NewsInfo> modifyNewsStatusAuto();

    /**
     * @Author Zachary
     * 获取所有的资讯信息
     * @return
     * @param newsStatus
     */
    @Select("SELECT newsId,userId,newsTitle,newsContent,newsStatus,releaseDate FROM newsinfo WHERE newsStatus = #{newsStatus}")
    List<NewsInfo> getAllNewsInfo(Integer newsStatus);

    /**
     * @Author Zachary
     * 将一条资讯更改为 “已发布” 1
     * @return
     */
    @Update(" UPDATE newsinfo SET newsStatus = #{newsStatus} WHERE newsId = #{newsId} ")
    boolean modifyNewsStatusToPass(@Param("newsId")Integer newsId, @Param("newsStatus")Integer newsStatus);



    /**
     * 驳回
     * 将一条资讯状态更改为 “已封禁” -1
     * @Author Zachary
     * @param newsId
     * @return
     */
    @Update(" UPDATE newsinfo SET newsStatus = -1 WHERE newsId = #{newsId} ")
    boolean modifyNewsStatusToRefused(@Param("newsId") Integer newsId);

    @Update(" UPDATE newsinfo SET newsStatus =  #{newsStatus} WHERE newsId = #{newsId} ")
    boolean modifyNewsStatusToBanned(@Param("newsId") Integer newsId, @Param("newsStatus") Integer newsStatus);

    /**
     * @Author Zachary
     * @param newsId
     * @return
     */
    @Select(" SELECT newsId,userId,newsTitle,newsContent,newsStatus,releaseDate FROM newsinfo WHERE newsId = #{newsId} ")
    NewsInfo getSelectedNews(@Param("newsId") Integer newsId);
}
