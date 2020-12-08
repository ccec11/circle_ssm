package top.geminix.circle.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.geminix.circle.domain.AdminInfo;

public interface IAdminInfoDao {


    @Select("SELECT * FROM admininfo WHERE adminName = #{adminName}&&adminPassword = #{adminPassword}")
    AdminInfo queryAdminInfoByNameAndPassword(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);

}
