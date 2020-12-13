package top.geminix.circle.service;

import top.geminix.circle.domain.LabelInfo;

import java.util.List;

public interface ILabelInfoService {

    List<LabelInfo> getLabelInfo();

    boolean addLabelInfo(Integer sortId, String labelName);

    List<LabelInfo> getLabelCategory();
    boolean removeLabelInfo(Integer labelId);
}
