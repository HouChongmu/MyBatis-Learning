
import com.yolyn.chapter03.mapper.Chapter03Mapper;
import com.yolyn.chapter03.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
    public void mapperTest() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Chapter03Mapper chapter03Mapper = sqlSession.getMapper(Chapter03Mapper.class);
            System.out.println(chapter03Mapper.queryEmail("yolyn"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试分页查询
     */
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

    /**
     * 测试主键回填
     */
    @Test
    public void insertTest() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Chapter03Mapper employeeMapper = sqlSession.getMapper(Chapter03Mapper.class);
            Employee employee = new Employee();
            employee.setEmpName("jingjing");
            employee.setEmail("jingjing@outlook.com");
            employee.setGender(2);
            employeeMapper.addEmployee(employee);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试自定义主键
     */
    @Test
    public void selectKeyTest() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Chapter03Mapper chapter03Mapper = sqlSession.getMapper(Chapter03Mapper.class);
            Employee employee = new Employee();
            employee.setEmpName("jingjing");
            employee.setEmail("jingjing@outlook.com");
            employee.setGender(2);
            chapter03Mapper.insertEmployee(employee);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试sql元素参数传递
     */
    @Test
    public void sqlAliasTest() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Chapter03Mapper chapter03Mapper = sqlSession.getMapper(Chapter03Mapper.class);
            Employee employee = new Employee();
            employee.setId(2);
            Employee queryedEmp = chapter03Mapper.sqlAliasTest(employee);
            System.out.println(queryedEmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
