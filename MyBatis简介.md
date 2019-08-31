#### MyBatis简介

##### 1. 原始和框架的比较     

原生流程   
获取连接--->获取PreparedStatement--->写sql--->预编译参数--->执行sql--->封装结果

（1） 从原始的JDBC->dbUtils（QueryRunner）->JdbcTemplate->xxx；称之为工具（很少用）     
（2） 工具： 一些功能的简单封装   
（3） 框架： 某个领域的整体解决方案，考虑部分字段映射的问题。  
（4） 所以不用原生JDBC的原因：   
- 原生很麻烦，框架能提高开发效率   
- sql语句是硬编码在程序中的，这样耦合很严重（数据库层和java编码耦合）


##### 2. MyBatis
MyBatis ： 和数据库进行交互，持久化层框架（SQL映射框架）  

（1） MyBatis将重要的步骤抽取出来可以人工定制（写sql），其他步骤框架自动化   
（2） 重要步骤都是写在配置文件中（好维护）  
（3） 完全解决数据库的优化问题   
（4） MyBatis底层就是对原生JDBC的封装   
（5） 既既将java编码与sql抽取出来，还不会失去自动化功能，半自动的持久化框架

##### 3. Hibernate
Hibernate：数据库交互的框架（ORM框架）全自动框架---全黑箱操作  
ORM（Object Relation Mapping）对象关系映射：创建好javaBean直接@Table("user")，这样项目启动的时候框架就会自动去数据库创建表，更新或添加字段：  

```
@ Table("emloyee")
class Employee{
  private Integer empId;
  private String empName
}
```   
缺点：   
（1） 定制SQL麻烦，有一种解决办法：HQL  
（2） 全映射框架，做分字段映射困难
