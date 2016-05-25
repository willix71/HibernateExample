package com.accessright;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "user_application_role", schema = "accessright")
@AssociationOverrides({
		@AssociationOverride(name = "pk.application", 
			joinColumns = @JoinColumn(name = "APPLICATION_ID")),
		@AssociationOverride(name = "pk.user", 
			joinColumns = @JoinColumn(name = "USER_ID")),
		@AssociationOverride(name = "pk.role", 
			joinColumns = @JoinColumn(name = "ROLE_ID"))
		})
public class UserApplicationRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserApplicationRoleId pk = new UserApplicationRoleId();

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = true)
	private Date createdDate;
	
	@Column(name = "CREATED_BY", nullable = true, length = 10)
	private String createdBy;
	
	public UserApplicationRole() {}
	
	public UserApplicationRole(User user, Application application, Role role) {
		this.pk = new UserApplicationRoleId(user, application, role);
		user.getUserApplicationRoles().add(this);
		application.getUserApplicationRoles().add(this);
		role.getUserApplicationRoles().add(this);
	}

	public UserApplicationRoleId getPk() {
		return pk;
	}

	public void setPk(UserApplicationRoleId pk) {
		this.pk = pk;
	}

	@Transient
	public Application getApplication() {
		return getPk().getApplication();
	}

	public void setApplication(Application application) {
		getPk().setApplication(application);
	}

	@Transient
	public User getUser() {
		return getPk().getUser();
	}

	public void setUser(User user) {
		getPk().setUser(user);
	}

	@Transient
	public Role getRole() {
		return getPk().getRole();
	}

	public void setRole(Role role) {
		getPk().setRole(role);
	}

	
	public String getCreatedBy() {
		return this.createdBy;
	}	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserApplicationRole that = (UserApplicationRole) o;

		if (getPk() != null ? !getPk().equals(that.getPk()): that.getPk() != null) return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	@Override
	public String toString() {
		return "UserApplicationRole [pk=" + pk + "]";
	}
}