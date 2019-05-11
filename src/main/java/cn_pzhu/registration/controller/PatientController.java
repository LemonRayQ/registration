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
 * @description:
 * @author: LemonQ
 * @create: 2019-04-28 17:20
 **/
@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @Autowired
    DocService docService;

    @Autowired
    DeptService deptService;

    @RequestMapping("/patient")
    public String selectDept(Model model, HttpServletRequest request) {
        List<Department> selectDept = deptService.select();
        model.addAttribute("dept", selectDept);

        /* 获取病人信息*/
        String userId = (String) request.getSession().getAttribute("userId");

        PatientInfo patientInfo = patientService.selectPatientInfo(userId);
        model.addAttribute("patientInfo", patientInfo);

        /*获取信息反馈的最新内容*/
        try {
            String content = patientService.insertFeedBackOrIllness("feedback", "", userId, "");
            model.addAttribute("feedBack", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*获取病人的病例情况     */
        String illness = patientService.insertFeedBackOrIllness("illness", "", userId, "");
        model.addAttribute("illness", illness);

        return null;
    }

    /**
     * @description:根据科室查询对应医生
     * @author: Lemon-grass
     * @date: 2019/4/25
     */
    @RequestMapping(value = "/patient/selectDocByDeptId")
    @ResponseBody
    public Map<String, Object> selectDoctor(Integer deptId, HttpServletRequest request) {
        String patientId = (String) request.getSession().getAttribute("userId");

        List<DoctorInfo> infos = docService.selectDoc(deptId);

        Map<String, Object> map = new HashMap<>();
        map.put("list", infos);
        map.put("patientId", patientId);

        return map;
    }

    /**
     * @description: 病人选择对应医生
     * @author: Lemon-grass
     * @date: 2019/4/25
     */
    @RequestMapping(value = "/patient/chooseDoc")
    @ResponseBody
    public Boolean listDoctorByDeptId(String docId, String pId, HttpServletRequest request, Model model) {
        Boolean b = docService.updateRegisterSuccess(docId, pId);

        model.addAttribute("docId", docId);
        //request.getSession().setAttribute("docId", docId);
        return b;
    }

    /**
     * @description:病人填写信息反馈
     * @author: Lemon-grass
     * @date: 2019/4/30
     */
    @RequestMapping("/patient/submitFeedBack")
    @ResponseBody
    public Map<String, Object> submitFeedBack(HttpServletRequest request, Model model) {
        String userId = (String) request.getSession().getAttribute("userId");

        PatientInfo patientInfo = patientService.selectPatientInfo(userId);

        String docId = patientInfo.getDocId();

        String feedback = request.getParameter("feedback");

        HashMap<String, Object> map = new HashMap<>();
        if (docId != null) {
            String content = patientService.insertFeedBackOrIllness("feedback", docId, userId, feedback);
            model.addAttribute("feedBack", content);

            map.put("status", "yes");

            return map;
        } else {
            map.put("status", "no");

            return map;
        }
    }
}
