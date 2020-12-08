package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.geminix.circle.dao.ILabelInfoDao;
import top.geminix.circle.domain.LabelInfo;
import top.geminix.circle.service.ILabelInfoService;

import java.util.List;

@Service
@Transactional
public class LabelInfoServiceImpl implements ILabelInfoService {
    @Autowired
    private ILabelInfoDao labelInfoDao;

    @Override
    public List<LabelInfo> getLabelInfo() {
        return labelInfoDao.getLabelInfo();
    }

    @Override
    public boolean addLabelInfo(Integer sortId, String labelName) {
        return labelInfoDao.addLabelInfo(sortId, labelName);
    }

    @Override
    public List<LabelInfo> getLabelCategory() {
        return labelInfoDao.getLabelCategory();
    }

    @Override
    public boolean removeLabelInfo(Integer labelId) {
        return labelInfoDao.removeLabelInfo(labelId);
    }
}
