#### 用MyBatis操作数据库     

#### 几个核心的组件     
1. SqlSessionFactory：sqlSession构建器    
sqlSessionFactory工厂默认构建的是DefaultSqlSession（非线程安全）       
- 1. 用xml构建   
- 2. 用代码构建     

2. SqlSession      
它的作用类似于一个JDBC中的Connection对象，代表着一个连接资源的启用     
两个实现类：    
- 1. DefaultSqlSession：不是线程安全，适合单线程    
- 2. SqlSessionManager：可在多线程环境下使用，里面使用了ThreadLocal去保证线程安全     

3. 映射器（Mapper）     
- 1. 用XML实现映射器
参见EmployeeMapper     
用Mapper发送SQL      
- 2. 用注解实现映射器    
参见EmployeeMapper2     
用SqlSession发送SQL   



##### 1. 环境搭建
1. 创建工程
2. 创建测试库，测试表，以及封装数据的javaBean(Employee)，和操作数据库的dao接口(interface EmployeeDao)-封装数据库操作    
3. 用Mybatis操作数据库     
- 1. 导包    
- 2. 写配置（两个）    
>第一个配置文件：mybatis的全局配置文件，指导mybatis如何正确运行，比如连接向哪个数据库      
>第二个配置文件：编写每一个方法都如何向数据库发送sql语句，如何执行，相当于接口的实现类    
    


##### 2. 测试用例

1. 第一步写配置文件（xxx-config.xml）：(此例中的mybatis-config.xml称为mybati的全局配置文件，指导mybatis如何正确运行，比如如何连接向哪个数据库)    
2. 第二个配置（映射）文件（xxxDao.xml）：编写每一个方法都如何向数据库发送sql语句，如何执行。    
            xxxDao.xml,相当于Dao（数据库操作对象）接口的实现类   
            mapper里面的namespace：名称空间，数据库操作对象接口的全类名，相当于告诉MyBatis这个配置文件是实现的哪个接口   
            select:用来定义一个查询操作  
            id：方法名，相当于这个配置是对于某个发那个发的实现  
            resultType：指定方法运行后的返回值类型（查询操作必须指定）  
            #{属性名}：代表取出传递过来的某个参数值     
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace：名称空间，数据库操作对象接口的全类名，相当于告诉MyBatis这个配置文件是实现的哪个接口-->
<mapper namespace="com.yolyn.mybatislearning.mapper.EmployeeDao">
    <!--select:用来定义一个查询操作
        id：方法名，相当于这个配置是对于某个发那个发的实现
        resultType：指定方法运行后的返回值类型（查询操作必须指定）
        #{属性名}：代表取出传递过来的某个参数值
    -->
    <select id="getEmployeeById" resultType="com.yolyn.mybatislearning.pojo.Employee">
    select * from t_employee where id = #{id}
  </select>
</mapper>
```   
3. 我们写的dao接口的实现文件（xxxDao.xml）MyBatis默认是不知道的，需要在全局配置文件中（xxx-config.xml）注册     
```xml
    <!--引入我们自己写的每一个接口的实现文件名称-->
    <mappers>
        <!--resource标识从类路径下找资源-->
        <mapper resource="EmployeeDao.xml"/>
    </mappers>
```


4. 测试：   
```
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
```


