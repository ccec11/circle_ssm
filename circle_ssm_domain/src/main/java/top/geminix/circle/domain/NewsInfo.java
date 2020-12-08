package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.geminix.circle.util.DateUtils;

import java.util.Date;

/**
 * newsInfoList  资讯信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsInfo {
    private Integer newsId;
    private Integer userId;
    private String newsTitle;
    private String newsContent;//内容包含图片newsImagePath字段应该删除

    private Integer newsStatus;//1=已发布 0=待审核 -1=已封禁
    private String newsStatusStr;
    private Date releaseDate;
    private String releaseDateStr;

    private LabelInfo labelInfo;//怎么插入？
    private float badWordPercentage;//敏感词频率字段 float

    public String getNewsStatusStr() {
        if (newsStatus == 1) {
            newsStatusStr = "已发布";
        }
        if (newsStatus == 0) {
            newsStatusStr = "已驳回";
        }
        if (newsStatus == -1) {
            newsStatusStr = "已封禁";
        }
        if (newsStatus == 2) {
            newsStatusStr = "等待审核";
        }
        return newsStatusStr;
    }

    public String getReleaseDateStr() {
        if (releaseDate != null) {
            releaseDateStr = DateUtils.date2String(releaseDate, "yyyy-MM-dd HH:mm:ss");
        }
        return releaseDateStr;
    }
}
