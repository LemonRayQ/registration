package cn_pzhu.registration.mapper;

import cn_pzhu.registration.domain.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 21:20
 **/
@Mapper
@Transactional
public interface LoginMapper {

    @Select("select * from login where id = #{id}")
    Login getUser(@Param("id") String id);

    /**
     * @description: 注册功能, 将数据插入到login表中
     * @author: Lemon-grass
     * @date: 2019/4/27
     */
    @Insert("INSERT INTO login(id,PASSWORD,identity) VALUES(#{id},#{password},#{identity}) ")
    boolean register(@Param("id") String id, @Param("password") String password, @Param("identity") int identity);

    /**
     * @description:根据不同的身份将数据插入到对应的信息表中
     * @author: Lemon-grass
     * @date: 2019/4/28
     */
    @Insert("insert into ${tableName}(id,name,sex,age,createTime) value(#{id},#{name},#{sex},#{age},NOW())")
    boolean insertOfIndentity(@Param("tableName") String tableName, @Param("id") String id, @Param("name") String name, @Param("sex") String sex, @Param("age") int age);

}
