package cn_pzhu.registration.controller;

import cn_pzhu.registration.service.DeptService;
import cn_pzhu.registration.service.LoginService;
import cn_pzhu.registration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 22:04
 **/

@Controller
public class DeptController {

    /**
     * @description:查询所有科室
     * @author: Lemon-grass
     * @date: 2019/4/22
     */
    @Autowired
    private DeptService deptService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private LoginService loginService;


}
