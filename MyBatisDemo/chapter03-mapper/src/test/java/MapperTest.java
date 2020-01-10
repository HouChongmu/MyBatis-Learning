import mapper.Chapter03Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author houyl
 * @date 2020/1/10 10:46
 * @description
 */
public class MapperTest {
    @Test
    public void mapperTest(){
        try {
            InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession= sqlSessionFactory.openSession();
            Chapter03Mapper chapter03Mapper=sqlSession.getMapper(Chapter03Mapper.class);
            System.out.println(chapter03Mapper.queryEmail("yolyn"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rowBoundsTest() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Chapter03Mapper employeeMapper = sqlSession.getMapper(Chapter03Mapper.class);
            RowBounds rowBounds = new RowBounds(1, 1);
            List<Employee> employees = employeeMapper.findByRowBounds(1, rowBounds);
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insertTest(){
        try {
            InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            Chapter03Mapper employeeMapper=sqlSession.getMapper(Chapter03Mapper.class);
            Employee employee=new Employee();
            employee.setEmpName("jingjing");
            employee.setEmail("jingjing@outlook.com");
            employee.setGender(2);
            employeeMapper.addEmployee(employee);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
