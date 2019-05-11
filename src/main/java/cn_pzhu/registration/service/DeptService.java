package cn_pzhu.registration.service;

import cn_pzhu.registration.domain.Department;

import java.util.List;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 21:56
 **/

public interface DeptService {
    /**
     * @description:查询所有科室
     * @author: Lemon-grass
     * @date: 2019/4/22
     */
    List<Department> select();
}
