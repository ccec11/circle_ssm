package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelInfo implements Serializable {
    private Integer labelId;
    private String labelName;
    private LabelInfo sortLabelInfo;//父 标签
//    private String sortID;//自关联的 指向自身


}