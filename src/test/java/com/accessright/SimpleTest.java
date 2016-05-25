package com.accessright;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.accessright.Application;
import com.accessright.Role;
import com.accessright.User;
import com.accessright.UserApplicationRole;

public class SimpleTest {
	User w = new User(1, "william", null);
	User r = new User(2, "ralph", null);

	Application lsa = new Application(10, "LSA", "Lausashop");
	Application com = new Application(20, "COM", "mon compte");

	Role admin = new Role(100, "admin");
	Role user = new Role(200, "user");
	Role guest = new Role(300, "guest");
	
	{
		new UserApplicationRole(w, lsa, admin);
		new UserApplicationRole(w, com, user);
		new UserApplicationRole(r, lsa, guest);
	}

	@Test
	public void testApplication() {
		Application lausashop = lsa;
		List<UserApplicationRole> sc = lausashop.getUserApplicationRoles();
		Assert.assertEquals(2, sc.size());

		Assert.assertEquals(2, lausashop.getUsers().size()); // william and ralph
		Assert.assertEquals(2, lausashop.getRoles().size()); // admin and guest
	}

	@Test
	public void testUser() {
		User ralph = r;
		Assert.assertEquals("ralph", ralph.getName());

		Collection<Application> apps = ralph.getApplications();
		Assert.assertEquals(1, apps.size());

		Application monCompte = apps.iterator().next();

		Collection<Role> roles = ralph.getRoles(monCompte);
		Assert.assertEquals(1, roles.size());

		Assert.assertEquals("guest", roles.iterator().next().getName());
	}
}
