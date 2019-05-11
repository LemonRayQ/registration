package cn_pzhu.registration.service;

import java.util.Map;

public interface AdminService {


    /**
     * @description: adminPage 查询管理员信息、所有科室、未审核医生
     * @author: Lemon-grass
     * @date: 2019/5/8
     */
    Map<String, Object> selectAdminPage(String id);

    /**
     * @description:更新管理员信息
     * @author: Lemon-grass
     * @date: 2019/5/8
     */
    Map<String, Object> updateAdminfo(String newId, String password, String id, String idcard, String name);

    /**
     * @description:更改医生部分基本信息
     * @author: Lemon-grass
     * @date: 2019/5/9
     */
    Map<String, Object> updateDoc(String id, int deptId);

    /**
     * @description:删除医生
     * @author: Lemon-grass
     * @date: 2019/5/9
     */
    boolean deleteDoc(String docId);

    /**
     * @description:增加医生
     * @author: Lemon-grass
     * @date: 2019/5/10
     */
    boolean insertDoc(String id, String name, int deptId);

    /**
     * @description:更新verify 字段
     * @author: Lemon-grass
     * @date: 2019/5/10
     */

    boolean updateVerify(String id, String msg);

}
