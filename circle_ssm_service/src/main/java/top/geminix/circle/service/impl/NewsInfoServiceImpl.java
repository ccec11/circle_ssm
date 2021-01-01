package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.geminix.circle.dao.INewsInfoDao;
import top.geminix.circle.dao.IRefusalInfoDao;
import top.geminix.circle.domain.NewsInfo;
import top.geminix.circle.domain.RefusalNewsInfo;
import top.geminix.circle.service.INewsInfoService;

import java.util.List;

@Service
public class NewsInfoServiceImpl implements INewsInfoService {
    @Autowired
    private INewsInfoDao newsInfoDao;
    @Autowired
    private IRefusalInfoDao refusalInfoDao;

    /**
     * TODO 自动审核功能 需要用到 Lucene分词技术 Python 库
     *
     * @return
     */
    @Override
    public List<NewsInfo> modifyNewsInfoStatusAuto() {
        return newsInfoDao.modifyNewsInfoStatusAuto();
    }

    @Override
    public List<NewsInfo> getAllWaitNewsInfo(Integer newsStatus) {
        return newsInfoDao.getAllNewsInfo(newsStatus);
    }

    @Override
    public boolean modifyNewsInfoStatusToPass(Integer newsId, Integer newsStatus) {
        return newsInfoDao.modifyNewsInfoStatusToPass(newsId, newsStatus);
    }

    @Override
    @Deprecated
    public boolean modifyNewsInfoStatusToRefused(Integer newsId) {
        newsInfoDao.modifyNewsStatusToRefused(newsId);//写死了 -1
        return false;
    }

    @Override
    public Boolean saveRefusalNewsInfo(RefusalNewsInfo refusalNewsInfo) {
        boolean modifyResult = false;
        Integer newsId = refusalNewsInfo.getNewsId();
        Boolean saveResult = refusalInfoDao.saveRefusalNewsInfo(refusalNewsInfo);
        if (saveResult) {
//            如过保存理由成功，但是 更改状态失败怎么办呢 事务怎么回滚
            modifyResult = newsInfoDao.modifyNewsStatusToRefused(newsId);
        }

        return saveResult && modifyResult;
    }

    @Override
    public boolean modifyNewsInfoStatusToBanned(Integer newsId, Integer newsStatus) {
        return newsInfoDao.modifyNewsStatusToBanned(newsId,newsStatus);
    }

    @Override
    public NewsInfo getSelectedNews(Integer newsId) {
        return newsInfoDao.getSelectedNews(newsId);
    }


}
