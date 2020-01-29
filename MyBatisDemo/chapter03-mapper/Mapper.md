#### Mapper映射     
Mybatis中映射方式有自动映射和驼峰映射       
在setting元素中可以配置的两个元素是autoMappingBehavior和mapUnderscoreToCamelCase，他们分别是控制自动映射和驼峰映射的开关，一般来说
####
1. 自动映射的autoMappingBehavior的取值范围为：   
NONE：不进行自动映射    
PARTIAL：默认值，只对没有嵌套结果集进行自动映射    
FULL:对所有的结果集进行自动映射，包括嵌套结果集     
默认情况下，使用默认的PARTIAL级别就可以了。    

#####  1. select     
1. 自动映射和驼峰映射   
2. 传递多个参数   
- 1. 用map接口传递参数（不推荐，可读性差、业务性质不强）   
- 2. 用@Params注解传递（参数小于等于5可用）     
- 3. 通过Java Bean传递     
- 4. 注解和Java Bean混合使用    
3. 使用resultMap映射结果集
4. 传参和RowBounds分页查询详情查阅Demo代码    


##### 2. insert     
1. 简单SQL可查看Chapter03Mapper.xml中的例3    
2. 主键回填可查看Chapter03Mapper.xml中的例3      
3. 自定义主键可查看Chapter03Mapper.xml中的例4    


##### 3. update元素和delete元素   
略     

##### 4. sql元素    
sql元素可以定义一处，然后多处引用，通常情况下可用于select、insert场景     
sql元素支持参数传递

