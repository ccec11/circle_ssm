package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Select;
import top.geminix.circle.domain.ReportInfo;

import java.util.List;

public interface IReportInfoDao {
// ========下面全是查询语句=========
    @Select(" SELECT * FROM post_report WHERE reportStatus = #{reportStatus} ")
    List<ReportInfo> getAllReportInfo(Integer reportStatus);

    @Select(" SELECT * FROM news_report WHERE reportStatus = #{reportStatus} ")
    List<ReportInfo> getNewsReportInfo(Integer reportStatus);

    @Select(" SELECT * FROM post_report WHERE reportStatus = #{reportStatus} ")
    List<ReportInfo> getPostReportInfo(Integer reportStatus);

    @Select(" SELECT * FROM comment_report WHERE reportStatus = #{reportStatus} ")
    List<ReportInfo> getCommentReportInfo(Integer reportStatus);
    //    ========下面全是更改状态的语句=========
//UPDATE news_report SET reportStatus = 0
// WHERE reportId = 1;FIXME 需要举报表的id

}
