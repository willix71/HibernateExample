package com.accessright;

//import javax.persistence.Embeddable;
//import javax.persistence.ManyToOne;

//@Embeddable
public class UserApplicationRoleId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//@ManyToOne
	private Application application;
	//@ManyToOne
	private User user;
	//@ManyToOne
	private Role role;
    
	public UserApplicationRoleId() {}
	
	public UserApplicationRoleId( User user, Application application, Role role) {
		this.application = application;
		this.user = user;
		this.role = role;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserApplicationRoleId that = (UserApplicationRoleId) o;

        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        
        return true;
    }

    public int hashCode() {
        int result;
        result = (application != null ? application.hashCode() : 0);
        result = 13 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "UserApplicationRoleId [application=" + application.getApplicationId() + ", user=" + user.getUserId() + ", role=" + role.getRoleId() + "]";
	}
    
    
}
