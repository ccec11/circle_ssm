package top.geminix.circle.service;

import top.geminix.circle.domain.ReportCommentInfo;
import top.geminix.circle.domain.ReportInfo;
import top.geminix.circle.domain.ReportNewsInfo;
import top.geminix.circle.domain.ReportPostInfo;
import top.geminix.circle.service.impl.ReportInfoServiceImpl;

import java.util.List;

public interface IReportInfoService {
    List<ReportInfo> getAllReportInfo(Integer reportStatus);

    List<ReportNewsInfo> getNewsReportInfo(Integer reportStatus);

    List<ReportPostInfo> getPostReportInfo(Integer reportStatus);

    List<ReportCommentInfo> getCommentReportInfo(Integer reportStatus);
//template
    Boolean modifyReportInfoStatusToDone(ReportInfo reportInfo);
//template
    Boolean removeReportInfo(ReportInfo reportInfo);

    boolean removeReportNewsInfo(Integer id);

    boolean removeReportPostInfo(Integer id);

    boolean removeReportCommentInfo(Integer id);

    Boolean modifyReportNewsInfoStatusToDone(Integer id);

    Boolean modifyReportPostInfoStatusToDone(Integer id);

    Boolean modifyReportCommentInfoStatusToDone(Integer id);
}
