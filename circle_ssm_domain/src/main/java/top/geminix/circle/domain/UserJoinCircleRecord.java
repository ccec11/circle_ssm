package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @version 1.0.0
 * @Author Zachary
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinCircleRecord {
    private Integer userId;//用户Id
    private Integer circleId;//圈子Id
    private Integer userLevel;//入圈等级
    private Date userJoinDate;//加入时间

}
