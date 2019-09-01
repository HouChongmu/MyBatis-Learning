import com.yolyn.mybatislearning.bean.Employee;
import com.yolyn.mybatislearning.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author houyl
 * @description
 * @since 2019/8/31 15:53
 */
public class MyBatisTest {
    @Test
    public void test() throws IOException {
        /**1. 根据全局配置文件创建出一个SqlSessionFactory
         * SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象
         * SqlSession：sql会话（代表和数据库的一次会话）
         * */
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /**
         * 2. 获取和数据库的一次会话：getConnection()
         * */
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /**
         * 3. 使用SqlSession操作数据库，获取到dao接口的实现
         * */
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        /**4. 调用之前的方法*/
        Employee employee = employeeDao.getEmployeeById(1);
        sqlSession.close();
        System.out.println(employee);
    }

    @Test
    public void test1(){
        String tradeCompleteTime = "202009011212";
        System.out.println(tradeCompleteTime.replace(tradeCompleteTime.substring(0,8),"20190901"));
    }
}
