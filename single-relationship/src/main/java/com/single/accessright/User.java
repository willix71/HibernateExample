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
@Table(name = "users", schema = "accessright")
public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Integer userId;
	
	@Column(name = "NAME", nullable = false, length = 10)
	private String name;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="user", cascade=CascadeType.ALL)
	private List<UserApplicationRole> userApplicationRoles = new ArrayList<UserApplicationRole>(0);

	public User() {
	}

	public User(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public User(Integer userId, String name, String description) {
		this.userId = userId;
		this.name = name;
		this.description = description;
	}


	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserApplicationRole> getUserApplicationRoles() {
		return userApplicationRoles;
	}

	public void setUserApplicationRoles(List<UserApplicationRole> userApplicationRoles) {
		this.userApplicationRoles = userApplicationRoles;
	}
	
	public Collection<Application> getApplications(Role ...roles) {
		Stream<UserApplicationRole> streams = getUserApplicationRoles().stream();
		if (roles.length>0) {
			final Collection<Role> c = Arrays.asList(roles);
			streams = streams.filter(scr -> c.contains(scr.getRole()));
		}
		return streams.map(scr -> scr.getApplication()).distinct().collect(Collectors.toSet());
	}
	
	public Collection<Role> getRoles(Application ...applications) {
		Stream<UserApplicationRole> streams = getUserApplicationRoles().stream();
		if (applications.length>0) {
			final Collection<Application> c = Arrays.asList(applications);
			streams = streams.filter(scr -> c.contains(scr.getApplication()));
		}
		return streams.map(scr -> scr.getRole()).distinct().collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
}