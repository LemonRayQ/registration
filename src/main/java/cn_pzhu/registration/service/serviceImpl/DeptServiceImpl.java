package cn_pzhu.registration.service.serviceImpl;

import cn_pzhu.registration.domain.Department;
import cn_pzhu.registration.mapper.DeptMapper;
import cn_pzhu.registration.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 21:58
 **/
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Department> select() {
        List<Department> list = deptMapper.select();
        return list;
    }
}
