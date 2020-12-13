package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.geminix.circle.domain.BadWordInfo;

import java.util.List;

public interface IBadWordInfoDao {

    /**
     * 获得所有的敏感词
     * @Author Zachary
     * @return
     */
    @Select("SELECT * FROM badWordInfo")
    List<BadWordInfo> getAllBadWord();

    /**
     * 添加一个敏感词
     * @Author Zachary
     * @param badWordContent
     * @return
     */
    @Insert("INSERT INTO badWordInfo values(null,#{badWordContent})")
    boolean addBadWordInfo(@Param("badWordContent") String badWordContent);

    /**
     * 删除一个敏感词
     * @Author Zachary
     * @param badWordId
     * @return
     */
    @Delete("DELETE FROM badWordInfo WHERE badWordId = #{badWordId}")
    boolean removeBadWordInfo(Integer badWordId);

}
