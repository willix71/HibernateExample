package com.accessright;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.accessright.Application;
import com.accessright.Role;
import com.accessright.User;
import com.accessright.UserApplicationRole;
import com.accessright.util.HibernateUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
	@Test
	public void testSetup() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testFetch() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		session.beginTransaction();
		
		Application lausashop = (Application) session.load(Application.class, 10);
		List<UserApplicationRole> sc = lausashop.getUserApplicationRoles();
		Assert.assertEquals(2, sc.size());
		
		Assert.assertEquals(2, lausashop.getUsers().size()); // william and ralph
		Assert.assertEquals(2, lausashop.getRoles().size()); // admin and guest
		
		session.getTransaction().commit();
	}

	@Test
	public void testMakeSure() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User ralph = (User) session.load(User.class, 2);
		Assert.assertEquals("ralph", ralph.getName());
		
		Collection<Application> apps = ralph.getApplications();
		Assert.assertEquals(1, apps.size());
		
		Application monCompte = apps.iterator().next();
		
		Collection<Role> roles = ralph.getRoles(monCompte);
		Assert.assertEquals(1, roles.size());
		
		Assert.assertEquals("guest", roles.iterator().next().getName());
		
		session.getTransaction().commit();
	}

}
