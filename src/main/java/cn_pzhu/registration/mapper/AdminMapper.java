package cn_pzhu.registration.mapper;

import cn_pzhu.registration.domain.Adminfo;
import cn_pzhu.registration.domain.Login;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    /**
     * @description:查询管理员信息
     * @author: Lemon-grass
     * @date: 2019/5/7
     */
    @Select("select * from adminfo where id=#{id}")
    Adminfo selectAdmin(@Param("id") String id);

    /**
     * @description:更改医生部分基本信息
     * @author: Lemon-grass
     * @date: 2019/5/9
     */
    @Update("update doctorinfo d set dept_id=#{deptId} where d.id=#{id}")
    boolean updateDoc(@Param("id") String id, @Param("deptId") int deptId);

    /**
     * @description:删除医生
     * @author: Lemon-grass
     * @date: 2019/5/9
     */
    @Delete("DELETE doctorinfo,login FROM doctorinfo LEFT JOIN login ON doctorinfo.`id`=login.`id` WHERE doctorinfo.`id`=#{id}")
    boolean deleteDoc(String id);

    /**
     * @description:删除医生 更新病人表的关联值
     * @author: Lemon-grass
     * @date: 2019/5/10
     */
    @Update("update patientinfo set doc_Id=null where doc_Id=#{id}")
    boolean update(String id);

    /**
     * @description:管理员添加医生
     * @author: Lemon-grass
     * @date: 2019/5/10
     */
    @Insert("INSERT INTO login (id,PASSWORD,identity,verify) VALUES(#{id},'123456',1,1)")
    boolean insertToLogin(@Param("id") String id);

    @Insert("insert into doctorinfo(id,name,dept_id) values(#{id},#{name},#{deptId})")
    boolean insertDoc(@Param("id") String id, @Param("name") String name, @Param("deptId") int deptId);

    /**
     * @description:查询未审核的医生
     * @author: Lemon-grass
     * @date: 2019/5/10
     */
    @Select("SELECT id FROM login WHERE verify=0 AND identity=1")
    List<Login> listDoc();

    /**
     * @description: 更新 verify字段
     * @author: Lemon-grass
     * @date: 2019/5/10
     */
    @Update("UPDATE login SET verify=1 WHERE id=#{id}")
    boolean updateVerify(@Param("id") String id);

    @Update("update login set verify=-1 where id=#{id}")
    boolean refuseVerify(@Param("id") String id);

}
