package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.geminix.circle.dao.ICircleInfoDao;
import top.geminix.circle.dao.ILabelInfoDao;
import top.geminix.circle.dao.IRefusalInfoDao;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.LabelInfo;
import top.geminix.circle.domain.RefusalCircleInfo;
import top.geminix.circle.service.ICircleInfoService;

import java.util.List;

@Service
@Transactional
public class CircleInfoServiceImpl implements ICircleInfoService {
    @Autowired
    private ICircleInfoDao circleInfoDao;
    @Autowired
    private IRefusalInfoDao refusalInfoDao;
    @Autowired
    private ILabelInfoDao labelInfoDao;


    @Override
    public boolean modifyCircleStatusToNormal(Integer circleId, Integer circleStatus) {
        return circleInfoDao.modifyCircleStatusToNormal(circleId, circleStatus);
    }

    @Override
    public boolean modifyCircleStatusToBanned(Integer circleId, Integer circleStatus) {
        return circleInfoDao.modifyCircleStatusToBanned(circleId, circleStatus);
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

    /**
     * 驳回圈子请求 和 保存驳回信息合并了
     *
     * @param circleId
     * @return
     */
    @Override
    @Deprecated
    public boolean modifyCircleStatusToDenied(Integer circleId) {
        return circleInfoDao.modifyCircleStatusToDenied(circleId);
    }

//

    /**
     * FIXME 使用Transactional控制2个的提交
     * 如果保存信息成功 但是更改状态失败 name还是要返回false 但是驳回信息已经提交了 很麻烦 事务需要回滚
     * @param refusalCircleInfo
     * @return
     */
    @Override
    public boolean saveRefusalCircleInfo(RefusalCircleInfo refusalCircleInfo) {
        Integer circleId = refusalCircleInfo.getCircleId();
        boolean saveResult = false;
        boolean modifyStatusResult = false;
        saveResult = refusalInfoDao.saveRefusalCircleInfo(refusalCircleInfo);
        if (saveResult) {//保存信息成功之后才会改状态
            modifyStatusResult = circleInfoDao.modifyCircleStatusToDenied(circleId);
        }
        return saveResult && modifyStatusResult;
    }

    @Override
    public CircleInfo getCircleById(Integer circleId) {
        return circleInfoDao.getCircleById(circleId);
    }

    @Override
    public List<LabelInfo> getAllLabelCategory() {
        return labelInfoDao.getAllLabelCategory();
    }

    @Override
    public List<CircleInfo> getCircleInfoByCategory(Integer sortId) {
        return circleInfoDao.getCircleInfoByCategory(sortId);
    }
}
