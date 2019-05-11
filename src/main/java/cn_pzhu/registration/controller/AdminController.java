package cn_pzhu.registration.controller;

import cn_pzhu.registration.domain.Department;
import cn_pzhu.registration.domain.DoctorInfo;
import cn_pzhu.registration.service.AdminService;
import cn_pzhu.registration.service.DeptService;
import cn_pzhu.registration.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: registration
 * @description:管理员管理
 * @author: LemonQ
 * @create: 2019-05-07 11:00
 **/
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    DocService docService;
    @Autowired
    DeptService deptService;

    /**
     * @description:查询管理员信息
     * @author: Lemon-grass
     * @date: 2019/5/7
     */
    @RequestMapping("/admin")
    public String selectAdmin(Model model, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");

        Map<String, Object> map = adminService.selectAdminPage(userId);
        model.addAttribute("adminInfo", map.get("adminfo"));
        model.addAttribute("departments", map.get("departments"));
        model.addAttribute("verify", map.get("verify"));

        return "admin";
    }

    /**
     * @description:查询所有科室和对应医生信息
     * @author: Lemon-grass
     * @date: 2019/5/8
     */
    @RequestMapping("/admin/selectDocByDeptId")
    @ResponseBody
    public Map<String, Object> selectDocByDeptId(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Map<String, Object> map = new HashMap<>();

        List<DoctorInfo> infos = docService.selectDoc(id);
        List<Department> departments = deptService.select();
        map.put("infos", infos);
        map.put("depts", departments);

        return map;
    }

    @RequestMapping("/admin/updateDoc")
    @ResponseBody
    public Map<String, Object> updateDoc(Model model, HttpServletRequest request) {
        int deptId = Integer.parseInt(request.getParameter("id"));
        String docId = request.getParameter("docId");

        Map<String, Object> map = adminService.updateDoc(docId, deptId);

        return null;
    }

    @RequestMapping("/admin/deleteDoc")
    @ResponseBody
    public boolean deleteDoc(Model model, HttpServletRequest request) {
        String docId = request.getParameter("docId");

        boolean b = adminService.deleteDoc(docId);

        return b;
    }

    @RequestMapping("/admin/insertDoc")
    @ResponseBody
    public boolean insertDoc(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int deptId = Integer.parseInt(request.getParameter("deptId"));

        boolean b = adminService.insertDoc(id, name, deptId);

        return b;
    }

    @RequestMapping("/admin/verify")
    @ResponseBody
    public boolean passVerify(HttpServletRequest request) {
        String docId = request.getParameter("docId");
        String msg = request.getParameter("msg");

        boolean b = adminService.updateVerify(docId, msg);

        return b;
    }
}
