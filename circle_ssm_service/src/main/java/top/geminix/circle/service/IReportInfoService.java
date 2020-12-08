package top.geminix.circle.service;

import top.geminix.circle.domain.ReportInfo;

import java.util.List;

public interface IReportInfoService {
    List<ReportInfo> getAllReportInfo(Integer reportStatus);

    List<ReportInfo> getNewsReportInfo(Integer reportStatus);

    List<ReportInfo> getPostReportInfo(Integer reportStatus);

    List<ReportInfo> getCommentReportInfo(Integer reportStatus);
}
