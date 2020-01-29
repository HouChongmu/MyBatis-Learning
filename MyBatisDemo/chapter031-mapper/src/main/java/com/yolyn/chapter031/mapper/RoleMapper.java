package com.yolyn.chapter031.mapper;


import com.yolyn.chapter031.param.PageParams;
import com.yolyn.chapter031.param.RoleParams;
import org.apache.ibatis.annotations.Param;
import com.yolyn.chapter031.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
	
	public Role getRole(Long id);
	
	public List<Role> findRolesByMap(Map<String, Object> parameterMap);
	
	public List<Role> findRolesByAnnotation(@Param("roleName") String rolename, @Param("note") String note);
	
	public List<Role> findRolesByBean(RoleParams roleParam);
	
	public List<Role> findByMix(@Param("params") RoleParams roleParams, @Param("page") PageParams PageParam);
	
	public Role getRoleUseResultMap(Long id);
	
	public int insertRole(Role role);
	
	public int insertRole2(Role role);
	
	public int updateRole(Role role);
	
	public int deleteRole(Long id);
}
