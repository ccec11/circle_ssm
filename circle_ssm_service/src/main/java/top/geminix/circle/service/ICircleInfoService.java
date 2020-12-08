package top.geminix.circle.service;

import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.RefusalCircleInfo;

import java.util.List;

public interface ICircleInfoService {
    List<CircleInfo> getBannedCircleInfo(Integer circleStatus);

    boolean modifyCircleStatusToNormal(Integer circleId,Integer circleStatus);

    boolean modifyCircleStatusToBanned(Integer circleId,Integer circleStatus);

    List<CircleInfo> getReportedCircleInfo();

    List<CircleInfo> getInvalidCircleInfo(Integer circleStatus);


    boolean modifyCircleStatusToDenied(Integer circleId,Integer circleStatus);

    boolean saveRefusalCircleInfo(RefusalCircleInfo refusalCircleInfo);

    CircleInfo getSelectedCircle(Integer circleId);
}
