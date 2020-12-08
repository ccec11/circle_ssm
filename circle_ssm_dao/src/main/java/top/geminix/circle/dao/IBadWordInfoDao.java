package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.geminix.circle.domain.BadWordInfo;

import java.util.List;

public interface IBadWordInfoDao {


    @Select("SELECT * FROM badWordInfo")
    List<BadWordInfo> getAllBadWord();

    @Insert("INSERT INTO badWordInfo values(null,#{badWordContent})")
    boolean addBadWordInfo(@Param("badWordContent") String badWordContent);

    @Delete("DELETE FROM badWordInfo WHERE badWordId = #{badWordId}")
    boolean removeBadWordInfo(Integer badWordId);

}
