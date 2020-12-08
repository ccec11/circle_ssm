package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefusalCircleInfo {
//    private AdminInfo adminInfo;
    private Integer adminId;
//    private CircleInfo circleInfo;
    private Integer circleId;

    private Date refusalDate;
    private String refusalReason;


}
