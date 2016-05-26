package com.accessright;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
 * from http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
 * 
 * A composite primary key must either be represented and mapped as an embeddable class (see Section 9.1.14, “EmbeddedId Annotation”) or must be represented and mapped to multiple fields or properties of the entity class (see Section 9.1.15, “IdClass Annotation”).
 * If the composite primary key class is mapped to multiple fields or properties of the entity class, the names of primary key fields or properties in the primary key class and those of the entity class must correspond and their types must be the same.
 */

// Using an IdClass 
// which is not even needed!!!

@Entity
@Table(name = "user_application_role", schema = "accessright")
//@AssociationOverrides({
//		@AssociationOverride(name = "pk.application", 
//			joinColumns = @JoinColumn(name = "APPLICATION_ID")),
//		@AssociationOverride(name = "pk.user", 
//			joinColumns = @JoinColumn(name = "USER_ID")),
//		@AssociationOverride(name = "pk.role", 
//			joinColumns = @JoinColumn(name = "ROLE_ID"))
//		})

@IdClass(UserApplicationRoleId.class)
public class UserApplicationRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
//	@EmbeddedId
//	private UserApplicationRoleId pk = new UserApplicationRoleId();
	
	@Id
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="application_id")
	private Application application;

	@Id
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = true)
	private Date createdDate;
	
	@Column(name = "CREATED_BY", nullable = true, length = 10)
	private String createdBy;
	
	public UserApplicationRole() {}
	
	public UserApplicationRole(User user, Application application, Role role) {
//		this.pk = new UserApplicationRoleId(user, application, role);

		this.user = user;
		this.application = application;
		this.role = role;
		
		user.getUserApplicationRoles().add(this);
		application.getUserApplicationRoles().add(this);
		role.getUserApplicationRoles().add(this);
	}

//	public UserApplicationRoleId getPk() {
//		return pk;
//	}
//
//	public void setPk(UserApplicationRoleId pk) {
//		this.pk = pk;
//	}
	
	// @Transient
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	// @Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// @Transient
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserApplicationRole that = (UserApplicationRole) o;

		// UserApplicationRole that = (UserApplicationRole) o;
		//
		// if (getPk() != null ? !getPk().equals(that.getPk()): that.getPk() != null) return false;

        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        
        return true;
    }

    public int hashCode() {
    	// return (getPk() != null ? getPk().hashCode() : 0);
        int result;
        result = (application != null ? application.hashCode() : 0);
        result = 13 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		// return "UserApplicationRole [pk=" + pk + "]";
		return "UserApplicationRoleId [application=" + application.getApplicationId() + ", user=" + user.getUserId() + ", role=" + role.getRoleId() + "]";
	}
}