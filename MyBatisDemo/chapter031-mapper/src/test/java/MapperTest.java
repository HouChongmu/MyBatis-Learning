import com.yolyn.chapter031.mapper.EmployeeMapper;
import com.yolyn.chapter031.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.management.monitor.StringMonitor;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author houyl
 * @date 2020/1/15 15:18
 * @description
 */
public class MapperTest {
    @Test
    public void getEmployeeTest1() {
        Logger logger = Logger.getLogger(MapperTest.class);
        try {
            InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployee(1L);
            System.out.println(employee.getRealName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
