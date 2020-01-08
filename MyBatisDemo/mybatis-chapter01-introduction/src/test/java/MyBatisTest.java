import com.yolyn.mybatislearning.pojo.Employee;
import com.yolyn.mybatislearning.mapper.EmployeeMapper;
import com.yolyn.mybatislearning.mapper.EmployeeMapper2;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        /**4. 调用之前的方法*/
        Employee employee = employeeMapper.getEmployeeById(1);
        sqlSession.close();
        System.out.println(employee);
    }

    @Test
    public void test1(){
        //配置连接池
        PooledDataSource dataSource=new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis_learning");
        dataSource.setDefaultAutoCommit(false);
        //采用MyBatis的JDBC事物方式
        TransactionFactory transactionFactory=new JdbcTransactionFactory();
        Environment environment=new Environment("development",transactionFactory,dataSource);
        Configuration configuration=new Configuration(environment);
        //注册一个MyBatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("emploee",Employee.class);
        //加入一个映射器
        configuration.addMapper(EmployeeMapper2.class);//通过注解实现映射器
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession=sqlSessionFactory.openSession();
//        Employee employee=sqlSession.selectOne("com.yolyn.mybatislearning.mapper.EmployeeMapper2.getEmployeeById",1);
//        System.out.println(employee);



        EmployeeMapper2 employeeMapper2=sqlSession.getMapper(EmployeeMapper2.class);
        System.out.println(employeeMapper2.getEmployeeById(1));
        sqlSession.close();

    }
}
