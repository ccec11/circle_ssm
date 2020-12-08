package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * RefusalInfo 驳回信息
 * 和圈子 资讯相关
 *
 * 父类 已停用
 */

@Deprecated
public class RefusalInfoBase {
    private AdminInfo adminInfo;//谁处理的驳回
    private Date refusalDate;
    private String refusalReason;

}
