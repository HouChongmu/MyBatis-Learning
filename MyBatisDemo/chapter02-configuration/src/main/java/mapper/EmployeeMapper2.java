package mapper;

import org.apache.ibatis.annotations.Select;
import pojo.Employee;

/**
 * @author houyl
 * @description 数据库操作对象接口
 * @since 2019/8/31 15:03
 * 通过注解实现映射器  不推荐
 */
public interface EmployeeMapper2 {
     @Select("select * from t_employee where id = #{id}")
     Employee getEmployeeById(Integer id);
}
