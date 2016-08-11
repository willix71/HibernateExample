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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "application", schema = "accessright", uniqueConstraints = {
		@UniqueConstraint(columnNames = "APPLICATION_CODE"),
		@UniqueConstraint(columnNames = "APPLICATION_NAME")
		})
public class Application implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "APPLICATION_ID", unique = true, nullable = false)
	private Integer applicationId;
	
	@Column(name = "APPLICATION_CODE", unique = true, nullable = false, length = 10)
	private String applicationCode;
	
	@Column(name = "APPLICATION_NAME", unique = true, nullable = false, length = 20)
	private String applicationName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "application", cascade=CascadeType.ALL)
	private List<UserApplicationRole> userApplicationRoles = new ArrayList<UserApplicationRole>(0);

	public Application() {
	}

	public Application(String applicationCode, String applicationName) {
		this.applicationCode = applicationCode;
		this.applicationName = applicationName;
	}

	public Application(Integer applicationId, String applicationCode, String applicationName) {
		this.applicationId = applicationId;
		this.applicationCode = applicationCode;
		this.applicationName = applicationName;
	}

	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationCode() {
		return this.applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public List<UserApplicationRole> getUserApplicationRoles() {
		return userApplicationRoles;
	}

	public void setUserApplicationRoles(List<UserApplicationRole> userApplicationRoles) {
		this.userApplicationRoles = userApplicationRoles;
	}
	
	public Collection<User> getUsers(Role ...roles) {
		Stream<UserApplicationRole> streams = getUserApplicationRoles().stream();
		if (roles.length>0) {
			final Collection<Role> c = Arrays.asList(roles);
			streams = streams.filter(scr -> c.contains(scr.getRole()));
		}
		return streams.map(scr -> scr.getUser()).distinct().collect(Collectors.toSet());
	}
	
	public Collection<Role> getRoles(User ...users) {
		Stream<UserApplicationRole> streams = getUserApplicationRoles().stream();
		if (users.length>0) {
			final Collection<User> c = Arrays.asList(users);
			streams = streams.filter(scr -> c.contains(scr.getUser()));
		}
		return streams.map(scr -> scr.getRole()).distinct().collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicationCode=" + applicationCode + ", applicationName=" + applicationName + "]";
	}
	
	
}