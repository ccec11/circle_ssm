package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.geminix.circle.dao.IAdminInfoDao;
import top.geminix.circle.dao.IBadWordInfoDao;
import top.geminix.circle.domain.BadWordInfo;
import top.geminix.circle.service.IBadWordInfoService;

import java.util.List;

@Service
@Transactional
public class BadWordInfoServiceImpl implements IBadWordInfoService {

    @Autowired
    private IBadWordInfoDao badWordInfoDao;



    /**
     * 查询所有的敏感词 返回List
     * @return
     */
    @Override
    public List<BadWordInfo> getAllBadWord() {
        return badWordInfoDao.getAllBadWord();
    }

    @Override
    public boolean addBadWordInfo(String badWordContent) {
        return badWordInfoDao.addBadWordInfo(badWordContent);
    }

    @Override
    public boolean removeBadWordInfo(Integer badWordId) {
        return badWordInfoDao.removeBadWordInfo(badWordId);
    }
}
