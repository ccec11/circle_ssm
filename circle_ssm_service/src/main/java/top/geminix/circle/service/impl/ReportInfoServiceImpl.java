package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.geminix.circle.dao.IReportInfoDao;
import top.geminix.circle.domain.ReportCommentInfo;
import top.geminix.circle.domain.ReportInfo;
import top.geminix.circle.domain.ReportNewsInfo;
import top.geminix.circle.domain.ReportPostInfo;
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
    public List<ReportNewsInfo> getNewsReportInfo(Integer reportStatus) {
        return reportInfoDao.getNewsReportInfo(reportStatus);
    }

    @Override
    public List<ReportPostInfo> getPostReportInfo(Integer reportStatus) {
        return reportInfoDao.getPostReportInfo(reportStatus);
    }

    @Override
    public List<ReportCommentInfo> getCommentReportInfo(Integer reportStatus) {
        return reportInfoDao.getCommentReportInfo(reportStatus);
    }


    @Override
    public Boolean modifyReportInfoStatusToDone(ReportInfo reportInfo) {
//        if (reportInfo instanceof ReportNewsInfo)
//        根据他们是什么哪个类的子类来确定 然后调用对应的dao进行处理
        return reportInfoDao.modifyReportInfoStatusToDone(reportInfo);
    }

    @Override
    public Boolean removeReportInfo(ReportInfo reportInfo) {
        return reportInfoDao.removeReportInfo(reportInfo);
    }

    @Override
    public boolean removeReportNewsInfo(Integer id) {
        return reportInfoDao.removeReportNewsInfo(id);
    }

    @Override
    public boolean removeReportPostInfo(Integer id) {
        return reportInfoDao.removeReportPostInfo(id);
    }

    @Override
    public boolean removeReportCommentInfo(Integer id) {
        return reportInfoDao.removeReportCommentInfo(id);
    }

    @Override
    public Boolean modifyReportNewsInfoStatusToDone(Integer id) {
        return reportInfoDao.modifyReportNewsInfoStatusToDone(id);
    }

    @Override
    public Boolean modifyReportPostInfoStatusToDone(Integer id) {
        return reportInfoDao.modifyReportPostInfoStatusToDone(id);
    }

    @Override
    public Boolean modifyReportCommentInfoStatusToDone(Integer id) {
        return reportInfoDao.modifyReportCommentInfoStatusToDone(id);
    }
}
