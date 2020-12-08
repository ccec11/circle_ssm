package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.geminix.circle.dao.ICircleInfoDao;
import top.geminix.circle.dao.IRefusalInfoDao;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.RefusalCircleInfo;
import top.geminix.circle.service.ICircleInfoService;

import java.util.List;

@Service
public class CircleInfoServiceImpl implements ICircleInfoService {
    @Autowired
    private ICircleInfoDao circleInfoDao;
    @Autowired
    private IRefusalInfoDao refusalInfoDao;

    @Override
    public boolean modifyCircleStatusToNormal(Integer circleId,Integer circleStatus) {
        return circleInfoDao.modifyCircleStatusToNormal(circleId,circleStatus);
    }

    @Override
    public boolean modifyCircleStatusToBanned(Integer circleId,Integer circleStatus) {
        return circleInfoDao.modifyCircleStatusToBanned(circleId,circleStatus);
    }

    @Override
    public List<CircleInfo> getReportedCircleInfo() {
        return circleInfoDao.getReportedCircleInfo();
    }

    @Override
    public List<CircleInfo> getBannedCircleInfo(Integer circleStatus) {
        return circleInfoDao.getBannedCircleInfo(circleStatus);
    }

    @Override
    public List<CircleInfo> getInvalidCircleInfo(Integer circleStatus) {
        return circleInfoDao.getInvalidCircleInfo(circleStatus);
    }


    @Override
    public boolean modifyCircleStatusToDenied(Integer circleId,Integer circleStatus) {
        return circleInfoDao.modifyCircleStatusToDenied(circleId,circleStatus);
    }

    @Override
    public boolean saveRefusalCircleInfo(RefusalCircleInfo refusalCircleInfo) {
        return refusalInfoDao.saveRefusalCircleInfo(refusalCircleInfo);
    }

    @Override
    public CircleInfo getSelectedCircle(Integer circleId) {
        return circleInfoDao.getSelectedCircle(circleId);
    }
}
