package mapper;


import pojo.Employee;

/**
 * @author houyl
 * @description 数据库操作对象接口
 * @since 2019/8/31 15:03
 */
public interface EmployeeMapper {
     Employee getEmployeeById(Integer id);
}
