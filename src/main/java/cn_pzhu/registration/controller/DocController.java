package cn_pzhu.registration.controller;

import cn_pzhu.registration.domain.Department;
import cn_pzhu.registration.domain.DoctorInfo;
import cn_pzhu.registration.domain.PatientInfo;
import cn_pzhu.registration.service.DeptService;
import cn_pzhu.registration.service.DocService;
import cn_pzhu.registration.service.PatientService;
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
 * @description: 医生控制
 * @author: LemonQ
 * @create: 2019-04-23 17:01
 **/
@Controller
public class DocController {

    @Autowired
    DocService docService;
    @Autowired
    PatientService patientService;
    @Autowired
    DeptService deptService;


    /**
     * @description:医生页面并查询对应医生的病人信息
     * @author: Lemon-grass
     * @date: 2019/4/30
     */
    @RequestMapping("/doctor")
    public String doctorPage(HttpServletRequest request, Model model) {
        String userId = (String) request.getSession().getAttribute("userId");

        List<PatientInfo> patientInfos = docService.selectListPatient(userId);
        model.addAttribute("patientInfos", patientInfos);

        DoctorInfo doctorInfo = docService.selectDocInfo(userId);
        model.addAttribute("doctorinfo", doctorInfo);

        List<Department> departments = deptService.select();
        model.addAttribute("dept", departments);

        return "doctor";
    }

    /**
     * @description:接收病人的id
     * @author: Lemon-grass
     * @date: 2019/5/6
     */
    @RequestMapping("/doctor/writeIllness")
    @ResponseBody
    public String writeIllness(String pId, HttpServletRequest request) {
        request.getSession().setAttribute("pId", pId);

        return null;
    }

    /**
     * @description:医生提交病人病例
     * @author: Lemon-grass
     * @date: 2019/5/6
     */
    @RequestMapping("/doctor/submitIllness")
    @ResponseBody
    public Map<String, Object> submitIllness(Model model, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        String docId = (String) request.getSession().getAttribute("userId");
        String pId = (String) request.getSession().getAttribute("pId");
        String content = request.getParameter("content");

        String illness = patientService.insertFeedBackOrIllness("illness", docId, pId, content);

        model.addAttribute("illness", illness);

        return null;
    }

    /**
     * @description:显示对应病人的信息反馈
     * @author: Lemon-grass
     * @date: 2019/5/6
     */
    @RequestMapping("/doctor/showFeedBack")
    @ResponseBody
    public Map<String, Object> showFeedBack(String pId, Model model, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();

        String docId = (String) request.getSession().getAttribute("userId");

        String content = patientService.insertFeedBackOrIllness("feedback", "", pId, "");

        map.put("content", content);
        return map;
    }


}
