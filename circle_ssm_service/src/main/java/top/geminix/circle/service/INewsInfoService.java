package top.geminix.circle.service;

import top.geminix.circle.domain.NewsInfo;

import java.util.List;

public interface INewsInfoService {
    /**
     * 自动审核功能
     * @return
     */
    List<NewsInfo> modifyNewsStatusAuto();

    /**
     * 获取所有的资讯信息
     * @return
     */
    List<NewsInfo> getAllNewsInfo(Integer newsStatus);

    /**
     * 将一条资讯更改为 “已发布”
     * @return
     */
    boolean modifyNewsStatusToPass(Integer newsId,Integer newsStatus);

    /**
     * 将一条资讯状态更改为 “已封禁”
     * @return
     */
    boolean modifyNewsStatusToRefused(Integer newsId,Integer newsStatus);


    NewsInfo getSelectedNews(Integer newsId);
}
