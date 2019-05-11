package cn_pzhu.registration.domain;

import java.io.Serializable;

/**
 * @program: registration
 * @description: 分页基础类
 * @author: LemonQ
 * @create: 2019-05-06 18:15
 **/

public class Pagination implements Serializable {
    private static final long serialVersionUID = 7449222528161234590L;
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 当前页大小
     */
    private Integer pageSize;
    /**
     * 总条数
     */
    private Long total;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageIndex() {
        return pageNum;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageNum = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
