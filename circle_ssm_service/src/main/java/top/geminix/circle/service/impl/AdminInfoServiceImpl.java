package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.geminix.circle.dao.IAdminInfoDao;
import top.geminix.circle.domain.AdminInfo;
import top.geminix.circle.service.IAdminInfoService;

@Service
//@Transactional
public class AdminInfoServiceImpl implements IAdminInfoService {
    @Autowired
    private IAdminInfoDao adminInfoDao;

    @Override
    public AdminInfo queryAdminInfoByNameAndPassword(String adminName, String adminPassword) {
        return adminInfoDao.queryAdminInfoByNameAndPassword(adminName,adminPassword);
    }
}
