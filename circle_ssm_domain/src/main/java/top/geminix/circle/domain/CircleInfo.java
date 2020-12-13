package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.geminix.circle.util.DateUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircleInfo {
//FIXME 聚合labelId  和userId  是方便保存数据用  聚合labelInfo userInfo 是方便展示数据
    private Integer circleId;
//    private Integer labelId;
//    private Integer sortId;
    private LabelInfo labelInfo;//只有单个标签 不知道分类
//    private Integer userId;
    private UserInfo userInfo;//圈主
    private String circleName;
    private String circleDescription;//
    private String circleImagePath;//圈子头像路径
    private Date submitDate;//时间的工具类
    private String submitDateStr;//时间的工具类
    private int circleStatus;//默认 待审核 已驳回？
    private String circleStatusStr;//封禁圈子 状态 0=待审核   1=正常  -1=已封禁

    public String getCircleStatusStr() {
        if (circleStatus == 0) {
            circleStatusStr = "待审核";
        }
        if (circleStatus == -1) {
            circleStatusStr = "已封禁";
        }
        if (circleStatus == 1) {
            circleStatusStr = "正常";
        }
        return circleStatusStr;
    }

    public String getSubmitDateStr() {
        if (submitDate != null) {
            submitDateStr = DateUtils.date2String(submitDate, "yyyy-MM-dd HH:mm:ss");
        }
        return submitDateStr;
    }

    public void setSubmitDateStr(String submitDateStr) {
        this.submitDateStr = submitDateStr;
    }

    //    private String circleHeat;//圈子热度
    //    private QuestionInfo questionInfo //题目信息


}
