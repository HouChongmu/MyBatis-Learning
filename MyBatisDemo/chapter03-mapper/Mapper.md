#### Mapper映射     
Mybatis中映射方式有自动映射和驼峰映射       
在setting元素中可以配置的两个元素是autoMappingBehavior和mapUnderscoreToCamelCase，他们分别是控制自动映射和驼峰映射的开关，一般来说
####
1. 自动映射的autoMappingBehavior的取值范围为：   
NONE：不进行自动映射    
PARTIAL：默认值，只对没有嵌套结果集进行自动映射    
FULL:对所有的结果集进行自动映射，包括嵌套结果集     
默认情况下，使用默认的PARTIAL级别就可以了。