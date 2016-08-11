package com.mutlibag.sets;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.multibag.sets.Parent;

import common.utils.HibernateUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
	@Test
	public void testSetup() {
		System.out.println("Hibernate multi eager bags)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testFetch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Parent william = (Parent) session.load(Parent.class, 1);
		Assert.assertEquals("william", william.getName());
				
		session.getTransaction().commit();
	}

}
