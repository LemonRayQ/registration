package cn_pzhu.registration.controller;

import cn_pzhu.registration.domain.Adminfo;
import cn_pzhu.registration.service.AdminService;
import cn_pzhu.registration.service.DocService;
import cn_pzhu.registration.service.LoginService;
import cn_pzhu.registration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: registration
 * @description: 用户信息修改
 * @author: LemonQ
 * @create: 2019-04-29 14:39
 **/
@Controller
public class UserInfoController {

    @Autowired
    PatientService patientService;
    @Autowired
    DocService docService;
    @Autowired
    LoginService loginService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/patient/update/Info")
    @ResponseBody
    public boolean updateUserInfo(HttpServletRequest request, Model model) {
        String newId = request.getParameter("newId");
        String username = request.getParameter("username");
        String newPwd = request.getParameter("newPwd");
        String idcard = request.getParameter("idcard");
        String id = (String) request.getSession().getAttribute("userId");

        request.getSession().setAttribute("userId", newId);

        Map<String, Object> map = patientService.updateUserInfo(newId, newPwd, id, idcard, username);

        model.addAttribute("patientInfo", map.get("patientInfo"));

        request.getSession().setAttribute("userPwd", map.get("user"));
        return true;
    }

    @RequestMapping("/doctor/update/Info")
    @ResponseBody
    public boolean updateDocInfo(HttpServletRequest request, Model model) {
        String newId = request.getParameter("newId");

        String userId = (String) request.getSession().getAttribute("userId");

        String username = request.getParameter("username");
        String newPwd = request.getParameter("newPwd");
        String intro = request.getParameter("intro");
        String idcard = request.getParameter("idcard");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");


        int deptId = Integer.parseInt(request.getParameter("deptId"));

        request.getSession().setAttribute("userId", newId);


        Map<String, Object> map = docService.updateDocInfo(newId, newPwd,
                userId, intro, idcard, username, sex, age, deptId);

        model.addAttribute("doctorinfo", map.get("doctorInfo"));

        model.addAttribute("patientInfos", map.get("patientInfos"));

        request.getSession().setAttribute("userPwd", map.get("user"));

        boolean b = (boolean) map.get("b");
        System.out.println("bbb" + b);
        return b;
    }

    /**
     * @description:修改管理员信息
     * @author: Lemon-grass
     * @date: 2019/5/7
     */
    @RequestMapping("/admin/update/Info")
    @ResponseBody
    public boolean updateAdminInfo(Adminfo adminfo, Model model, HttpServletRequest request) {
        String newId = adminfo.getId();
        String name = adminfo.getName();
        String password = request.getParameter("password");
        String idcard = adminfo.getIdcard();

        String userId = (String) request.getSession().getAttribute("userId");

        Map<String, Object> map = adminService.updateAdminfo(newId, password, userId, idcard, name);
        model.addAttribute("adminInfo", map.get("adminfo"));

        request.getSession().setAttribute("userId", newId);
        request.getSession().setAttribute("userPwd", map.get("user"));

        return true;
    }
}
