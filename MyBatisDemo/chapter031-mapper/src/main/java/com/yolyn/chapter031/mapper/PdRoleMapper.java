package com.yolyn.chapter031.mapper;


import com.yolyn.chapter031.param.PdCountRoleParams;
import com.yolyn.chapter031.param.PdFindRoleParams;

public interface PdRoleMapper {

	public void countRole(PdCountRoleParams pdCountRoleParams);
	
	public void findRole(PdFindRoleParams pdFindRoleParams);
}
