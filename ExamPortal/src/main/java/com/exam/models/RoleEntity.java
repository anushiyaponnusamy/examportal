package com.exam.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="roles")
public class RoleEntity {
@Id	
private Long roleId;
private String rolename;
public RoleEntity() {
	
}
public Long getRoleId() {
	return roleId;
}
public void setRoleId(Long roleId) {
	this.roleId = roleId;
}
public String getRolename() {
	return rolename;
}
public void setRolename(String rolename) {
	this.rolename = rolename;
}
public RoleEntity(Long roleId, String rolename) {
	
	this.roleId = roleId;
	this.rolename = rolename;
}
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JsonIgnore
private Set<UserRoleEntity> userRoles=new HashSet<>();

}
