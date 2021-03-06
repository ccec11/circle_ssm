package top.geminix.circle.dao;


import org.apache.ibatis.annotations.*;
import top.geminix.circle.domain.LabelInfo;

import java.util.List;


public interface ILabelInfoDao {
    /**
     *
     * @Author Zachary
     * @return
     */
    @Select("select * from labelinfo")
    @Results({
            @Result(property = "labelId", column = "labelId"),
            @Result(property = "labelName", column = "labelName"),
            @Result(property = "sortLabelInfo", column = "sortId", javaType = LabelInfo.class, one = @One(select = "top.geminix.circle.dao.ILabelInfoDao.getByLabelId"))
    })
    List<LabelInfo> getLabelInfo();


    //    @Results({
//            @Result(property = "labelId", column = "labelId"),
//            @Result(property = "labelName", column = "labelName")
//            @Result(property = "sortLabelInfo", column = "sortId", javaType = LabelInfo.class, one = @One(select = "top.geminix.circle.dao.ILabelInfoDao.getByLabelId"))
//    })
//FIXME 这里改了一下 不知道会不会错
    @Select("select * from labelinfo where labelId = #{labelId}")
    LabelInfo getByLabelId(Integer labelId);


    /**
     * 新建标签功能 这个有点复杂：
     * 实现这个功能之前 应该先查出所有的 标签信息  要不然怎么选择分类？
     * @Author Zachary
     * @param sortId
     * @param labelName
     * @return
     */
    @Insert("insert into labelinfo values(null,#{sortId},#{labelName})")
    boolean addLabelInfo(@Param("sortId") Integer sortId, @Param("labelName") String labelName);

    /**
     *
     * @param labelId
     * @param sortId
     * @param labelName
     * @return
     */
    @Insert("insert into labelinfo values(null,#{sortId},#{labelName})")
    boolean addTest(@Param("labelId") Integer labelId, @Param("sortId") Integer sortId, @Param("labelName") String labelName);

    /**
     * 获取分类标签
     * @Author Zachary
     * @return
     */
    @Select(" SELECT * FROM labelinfo WHERE labelId = labelinfo.sortId ")
    List<LabelInfo> getAllLabelCategory();

    /**
     * //FIXME 不能直接删除 应该假删除
     * 根据id删除一个标签
     * @Author Zachary
     * @param labelId
     * @return
     */
    @Delete(" DELETE FROM labelinfo WHERE labelId = #{labelId} ")
    boolean removeLabelInfo(Integer labelId);
}