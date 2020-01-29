package com.yolyn.chapter031.mapper;


import com.yolyn.chapter031.pojo.Employee;

public interface EmployeeMapper {

	Employee getEmployee(Long id);
	
	Employee getEmployee2(Long id);
}
