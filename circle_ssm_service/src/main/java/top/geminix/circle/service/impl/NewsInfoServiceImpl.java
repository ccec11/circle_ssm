package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.geminix.circle.dao.INewsInfoDao;
import top.geminix.circle.domain.NewsInfo;
import top.geminix.circle.service.INewsInfoService;

import java.util.List;
@Service
public class NewsInfoServiceImpl implements INewsInfoService {
    @Autowired
    private INewsInfoDao newsInfoDao;

    /**
     * TODO 自动审核功能 需要用到 Lucene分词技术 Python 库
     *
     * @return
     */
    @Override
    public List<NewsInfo> modifyNewsStatusAuto() {
        return null;
    }

    @Override
    public List<NewsInfo> getAllNewsInfo(Integer newsStatus) {
        return newsInfoDao.getAllNewsInfo(newsStatus);
    }

    @Override
    public boolean modifyNewsStatusToPass(Integer newsId,Integer newsStatus) {
        return newsInfoDao.modifyNewsStatusToPass(newsId,newsStatus);
    }

    @Override
    public boolean modifyNewsStatusToRefused(Integer newsId,Integer newsStatus) {
        return newsInfoDao.modifyNewsStatusToRefused(newsId,newsStatus);
    }

    @Override
    public NewsInfo getSelectedNews(Integer newsId) {
        return newsInfoDao.getSelectedNews(newsId);
    }
}
