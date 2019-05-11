package cn_pzhu.registration.mapper;

import cn_pzhu.registration.domain.PatientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     * @description:修改和增加病人个人信息
     * @author: Lemon-grass
     * @date: 2019/4/29
     */
    @Update("UPDATE patientinfo p,login l,doctorinfo d SET " +
            "d.`p_id`=#{newId} ,p.`idcard`=#{idcard}, p.`id`= #{newId}," +
            "l.`id`=#{newId},l.`password`=#{password}, p.`name`=#{name} " +
            "WHERE p.`id` =#{id} AND L.`id`=#{id} AND d.`p_id`=#{id}")
    boolean updateUserInfo(@Param("newId") String newId,
                           @Param("password") String password, @Param("id") String id,
                           @Param("idcard") String idcard, @Param("name") String name);

    /**
     * @description:修改和增加医生个人信息
     * @author: Lemon-grass
     * @date: 2019/5/5
     */
    @Update("UPDATE doctorinfo d,login l,patientinfo p SET " +
            "p.`doc_Id`=#{newId} ,d.intro=#{intro},d.`idcard`=#{idcard},d.dept_id=#{deptId}, " +
            "d.`id`= #{newId},l.`id`=#{newId},l.`password`=#{password}, d.`name`=#{name},d.`age`= #{age},d.`sex`=#{sex} " +
            "WHERE  d.`id` =#{id} AND L.`id`=#{id} AND  p.`doc_Id`= #{id} ")
    boolean updateDocInfo(@Param("newId") String newId, @Param("password") String password,
                          @Param("id") String id, @Param("intro") String intro,
                          @Param("idcard") String idcard, @Param("name") String name, @Param("sex") String sex, @Param("age") String age, @Param("deptId") int deptId);

    @Update("UPDATE doctorinfo d,login l,patientinfo p SET " +
            "d.intro=#{intro},d.`idcard`=#{idcard},d.dept_id=#{deptId}, " +
            "d.`id`= #{newId},l.`id`=#{newId},l.`password`=#{password}, d.`name`=#{name},d.`age`= #{age},d.`sex`=#{sex} " +
            "WHERE  d.`id` =#{id} AND L.`id`=#{id}")
    boolean updateDocInfo1(@Param("newId") String newId, @Param("password") String password,
                           @Param("id") String id, @Param("intro") String intro,
                           @Param("idcard") String idcard, @Param("name") String name, @Param("sex") String sex, @Param("age") String age, @Param("deptId") int deptId);

    /**
     * @description:查询 是否有病人挂号该医生
     * @author: Lemon-grass
     * @date: 2019/5/10
     */
    @Select("SELECT id FROM patientinfo WHERE doc_id=#{docId}")
    List<PatientInfo> selectDocIdOfPatient(String docId);

    /**
     * @description:更改管理员基本信息
     * @author: Lemon-grass
     * @date: 2019/5/7
     */
    @Update("update adminfo a,login l set a.id = #{newId},l.id=#{newId}, " +
            "a.name=#{name},a.idcard=#{idcard},l.password=#{password} where a.id = #{id} and l.id=#{id}")
    boolean updateAdminfo(@Param("newId") String newId, @Param("id") String id, @Param("name") String name, @Param("password") String password, @Param("idcard") String idcard);

}
