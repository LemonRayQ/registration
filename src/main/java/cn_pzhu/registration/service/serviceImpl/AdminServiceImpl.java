package cn_pzhu.registration.service.serviceImpl;

import cn_pzhu.registration.domain.Adminfo;
import cn_pzhu.registration.domain.Department;
import cn_pzhu.registration.domain.Login;
import cn_pzhu.registration.mapper.*;
import cn_pzhu.registration.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-05-07 11:07
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    DocMapper docMapper;

    @Override
    public Map<String, Object> selectAdminPage(String id) {
        Map<String, Object> map = new HashMap<>();
        Adminfo adminfo = adminMapper.selectAdmin(id);
        map.put("adminfo", adminfo);
        /*查询所有科室*/
        List<Department> departments = deptMapper.select();
        map.put("departments", departments);
        /*查询所有未审核的医生*/
        List<Login> list = adminMapper.listDoc();
        map.put("verify", list);
        return map;
    }

    @Override
    public Map<String, Object> updateAdminfo(String newId, String password, String id, String idcard, String name) {
        Map<String, Object> map = new HashMap<>();
        boolean b = userInfoMapper.updateAdminfo(newId, id, name, password, idcard);

        Adminfo adminfo = adminMapper.selectAdmin(newId);
        map.put("adminfo", adminfo);

        Login user = loginMapper.getUser(newId);
        map.put("user", user);



        /*查询科室对应的医生*/
        return map;
    }

    @Override
    public Map<String, Object> updateDoc(String id, int deptId) {
        boolean b = adminMapper.updateDoc(id, deptId);

        return null;
    }

    @Override
    public boolean deleteDoc(String docId) {
        boolean b = adminMapper.deleteDoc(docId);
        if (b) {
            boolean b1 = adminMapper.update(docId);
            return b1;
        }
        return b;
    }

    @Override
    public boolean insertDoc(String id, String name, int deptId) {
        boolean b = adminMapper.insertDoc(id, name, deptId);
        if (b) {
            boolean b1 = adminMapper.insertToLogin(id);
            return b1;
        }
        return b;
    }

    @Override
    public boolean updateVerify(String id, String msg) {
        if (msg.equals("true")) {
            boolean b = adminMapper.updateVerify(id);
            adminMapper.insertDoc(id, null, 1);
            return b;
        } else {
            boolean b = adminMapper.refuseVerify(id);
            return b;
        }

    }


}
