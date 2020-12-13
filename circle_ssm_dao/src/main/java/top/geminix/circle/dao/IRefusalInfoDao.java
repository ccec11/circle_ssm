package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Insert;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.RefusalCircleInfo;
import top.geminix.circle.domain.RefusalNewsInfo;

public interface IRefusalInfoDao {
    /** 驳回资讯信息
     * @Author Zachary
     * @param refusalNewsInfo
     */
    @Insert(" INSERT INTO refusalnewsrecord (adminId, newsId, refusalDate, refusalReason) VALUES (#{adminId},#{newsId},#{refusalDate},#{refusalReason}) ")
    Boolean saveRefusalNewsInfo(RefusalNewsInfo refusalNewsInfo);

    /**驳回圈子请求
     * @Author Zachary
     * @param refusalCircleInfo
     * @return
     */
    @Insert(" INSERT INTO refusalcirclerecord (adminId, circleId, refusalDate, refusalReason) VALUES (#{adminId},#{circleId},#{refusalDate},#{refusalReason}) ")
    boolean saveRefusalCircleInfo(RefusalCircleInfo refusalCircleInfo);

}
