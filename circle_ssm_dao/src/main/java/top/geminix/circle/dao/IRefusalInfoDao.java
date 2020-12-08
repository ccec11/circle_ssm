package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Insert;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.RefusalCircleInfo;
import top.geminix.circle.domain.RefusalNewsInfo;

public interface IRefusalInfoDao {
    @Insert(" INSERT INTO refusalnewsrecord (adminId, newsId, refusalDate, refusalReason) VALUES (#{adminId},#{newsId},#{refusalDate},#{refusalReason}) ")
    void saveRefusalNewsInfo(RefusalNewsInfo refusalNewsInfo);

    @Insert(" INSERT INTO refusalcirclerecord (adminId, circleId, refusalDate, refusalReason) VALUES (#{adminId},#{circleId},#{refusalDate},#{refusalReason}) ")
    boolean saveRefusalCircleInfo(RefusalCircleInfo refusalCircleInfo);

}
