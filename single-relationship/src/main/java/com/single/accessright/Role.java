package com.single.accessright;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", schema = "accessright")
public class Role implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	private Integer roleId;
	
	@Column(name = "ROLE_NAME", unique = true, nullable = false, length = 10)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade=CascadeType.ALL)
	private List<UserApplicationRole> userApplicationRoles = new ArrayList<UserApplicationRole>(0);
	
	public Role() {}
	
	public Role( String name) {
		this.name = name;
	}

	public Role(Integer roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserApplicationRole> getUserApplicationRoles() {
		return userApplicationRoles;
	}

	public void setUserApplicationRoles(List<UserApplicationRole> userApplicationRoles) {
		this.userApplicationRoles = userApplicationRoles;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + "]";
	}

	public Collection<User> getUsers(Application ...applications) {
		Stream<UserApplicationRole> streams = getUserApplicationRoles().stream();
		if (applications.length>0) {
			final Collection<Application> c = Arrays.asList(applications);
			streams = streams.filter(scr -> c.contains(scr.getApplication()));
		}
		return streams.map(scr -> scr.getUser()).distinct().collect(Collectors.toSet());
	}
	
	public Collection<Application> getApplications(User ...users) {
		Stream<UserApplicationRole> streams = getUserApplicationRoles().stream();
		if (users.length>0) {
			final Collection<User> c = Arrays.asList(users);
			streams = streams.filter(scr -> c.contains(scr.getUser()));
		}
		return streams.map(scr -> scr.getApplication()).distinct().collect(Collectors.toSet());
	}
}
