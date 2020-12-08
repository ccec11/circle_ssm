package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefusalNewsInfo {
    private Integer adminId;
    //    private AdminInfo adminInfo;//展示使用
    private Integer newsId;
    //    private NewsInfo newsInfo;//展示使用

    private Date refusalDate;
    private String refusalReason;
}
