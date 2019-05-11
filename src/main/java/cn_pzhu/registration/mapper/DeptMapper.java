package cn_pzhu.registration.mapper;

import cn_pzhu.registration.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: registration
 * @description: Department CRUD
 * @author: LemonQ
 * @create: 2019-04-22 21:50
 **/
@Mapper
public interface DeptMapper {
    @Select("select * from department")
    List<Department> select();


}
