import mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author houyl
 * @date 2020/1/8 20:42
 * @description
 */
public class chapter02Test {
    @Test
    public void Test() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployeeById(1);
            sqlSession.close();
            System.out.println(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        try {
            InputStream jdbcIs = Resources.getResourceAsStream("jdbc2.properties");
            Properties props = new Properties();
            props.load(jdbcIs);
            props.put("database.username", decode(props.getProperty("database.username")));
            props.put("database.password", decode(props.getProperty("database.password")));
            InputStream mybatisIs = Resources.getResourceAsStream("mybatis-config2.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisIs, props);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployeeById(1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object decode(String property) {
        if ("a".equalsIgnoreCase(property)) {
            return "root";
        } else {
            return "root";
        }
    }
}
