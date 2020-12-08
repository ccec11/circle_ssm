package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.geminix.circle.util.DateUtils;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportInfo {
//    private Integer reportInfoId;
//   能否定义抽象类 然后让具体的三个类去实现他们？
    private Integer ObjectId;//被举报的是什么？资讯 帖子 评论？
//    private Object object;
    private Integer userId;//举报人的id
//    private UserInfo userInfo;//举报人id对应的实体类

    private String reportTitle;
    private String reportContent;

    private Date reportDate;
    private String reportDateStr;//字符串形式来表示
    private Integer reportStatus;//0=待处理  1=已处理
    private String reportStatusStr;
    private String reportImagePath;//张荀 举报图片路径

    public String getReportDateStr() {
        if (reportDate != null) {
            reportDateStr = DateUtils.date2String(reportDate, "yyyy-MM-dd HH:mm:ss");
        }
        return reportDateStr;
    }

    public String getReportStatusStr() {
        if (reportStatus == 0) {
            reportStatusStr = "待处理";
        } if (reportStatus == 1) {
            reportStatusStr = "已处理";
        }
        return reportStatusStr;
    }
}
