package top.geminix.circle.service;

import top.geminix.circle.domain.NewsInfo;
import top.geminix.circle.domain.RefusalNewsInfo;

import java.util.List;

public interface INewsInfoService {
    /**
     * 自动审核功能
     * @return
     */
    List<NewsInfo> modifyNewsStatusAuto();

    /**
     * 获取所有待审核
     * @param newsStatus
     * @return
     */
    List<NewsInfo> getAllWaitNewsInfo(Integer newsStatus);


    /**
     * 将一条资讯更改为 “已发布”
     * @param newsId
     * @param newsStatus
     * @return
     */
    boolean modifyNewsStatusToPass(Integer newsId,Integer newsStatus);


    /**
     * 驳回资讯 将一条资讯状态更改为 “已封禁”
     * @param newsId
     * @return
     */
    @Deprecated
    boolean modifyNewsStatusToRefused(Integer newsId);

    /**
     * 封禁资讯 将一条资讯状态更改为 “已封禁”
     * @param newsId
     * @param newsStatus
     * @return
     */
    boolean modifyNewsStatusToBanned(Integer newsId,Integer newsStatus);

    /**
     * @Author Zachary
     * 根据id获取资讯信息
     * @param newsId
     * @return
     */
    NewsInfo getSelectedNews(Integer newsId);

    /**
     * 保存驳回 资讯信息理由 功能
     * @param refusalNewsInfo
     * @return
     */
    Boolean saveRefusalNewsInfo(RefusalNewsInfo refusalNewsInfo);
}
