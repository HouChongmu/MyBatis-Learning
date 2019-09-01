package com.yolyn.mybatislearning.dao;

import com.yolyn.mybatislearning.bean.Employee;

/**
 * @author houyl
 * @description 数据库操作对象接口
 * @since 2019/8/31 15:03
 */
public interface EmployeeDao {
     Employee getEmployeeById(Integer id);
}
