package top.geminix.circle.service;

import top.geminix.circle.domain.NewsInfo;
import top.geminix.circle.domain.RefusalNewsInfo;

import java.util.List;

public interface INewsInfoService {
    /**
     * 自动审核功能
     * @Author Zachary
     * @return
     */
    List<NewsInfo> modifyNewsInfoStatusAuto();

    /**
     * 获取所有待审核
     * @Author Zachary
     * @param newsStatus
     * @return
     */
    List<NewsInfo> getAllWaitNewsInfo(Integer newsStatus);


    /**
     * @Author Zachary
     * 将一条资讯更改为 “已发布”
     * @param newsId
     * @param newsStatus
     * @return
     */
    boolean modifyNewsInfoStatusToPass(Integer newsId,Integer newsStatus);


    /**
     * 驳回资讯 将一条资讯状态更改为 “已封禁”
     * 已经停用，该服务和 保存驳回信息一起使用
     * @Author Zachary
     * @param newsId
     * @return
     */
    @Deprecated
    boolean modifyNewsInfoStatusToRefused(Integer newsId);

    /**
     * 封禁资讯 将一条资讯状态更改为 “已封禁”
     * @Author Zachary
     * @param newsId
     * @param newsStatus
     * @return
     */
    boolean modifyNewsInfoStatusToBanned(Integer newsId,Integer newsStatus);

    /**
     * 根据id获取资讯信息
     * @Author Zachary
     * @param newsId
     * @return
     */
    NewsInfo getSelectedNews(Integer newsId);

    /**
     * 保存驳回 资讯信息理由 功能
     * @Author Zachary
     * @param refusalNewsInfo
     * @return
     */
    Boolean saveRefusalNewsInfo(RefusalNewsInfo refusalNewsInfo);
}
