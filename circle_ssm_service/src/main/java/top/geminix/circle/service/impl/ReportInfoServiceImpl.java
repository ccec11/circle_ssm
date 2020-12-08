package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.geminix.circle.dao.IReportInfoDao;
import top.geminix.circle.domain.ReportInfo;
import top.geminix.circle.service.IReportInfoService;

import java.util.List;

@Service
public class ReportInfoServiceImpl implements IReportInfoService {
    @Autowired
    private IReportInfoDao reportInfoDao;
    @Override
    public List<ReportInfo> getAllReportInfo(Integer reportStatus) {
        return reportInfoDao.getAllReportInfo(reportStatus);
    }

    @Override
    public List<ReportInfo> getNewsReportInfo(Integer reportStatus) {
        return reportInfoDao.getNewsReportInfo(reportStatus);
    }

    @Override
    public List<ReportInfo> getPostReportInfo(Integer reportStatus) {
        return reportInfoDao.getPostReportInfo(reportStatus);
    }

    @Override
    public List<ReportInfo> getCommentReportInfo(Integer reportStatus) {
        return reportInfoDao.getCommentReportInfo(reportStatus);
    }
}
