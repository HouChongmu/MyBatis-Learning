package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pojo.Employee;

import java.util.List;

/**
 * @author houyl
 * @date 2020/1/10 10:35
 * @description
 */
public interface Chapter03Mapper {
    String queryEmail(@Param("name") String name);
    List<Employee> findByRowBounds(@Param("gender")Integer gender , RowBounds rowBounds);
    Integer addEmployee(Employee employee);
}
