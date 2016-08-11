package com.mutlibag.sets;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.multibag.sets.Child1;
import com.multibag.sets.Parent;

import common.utils.HibernateUtil;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
    
	@Test
	public void test01_Setup() {
		System.out.println("Hibernate multi eager bags");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Assert.assertNotNull(session);
	}
	
	@Test
	public void test02_Fetch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Parent william = (Parent) session.load(Parent.class, 1);
		Assert.assertEquals("william", william.getName());
				
		Collection<Child1> sons = william.getChild1s();
		Assert.assertEquals(2, sons.size());
		
		session.getTransaction().commit();
		
		Assert.assertEquals(2, count(session, Parent.class));
	}

	
	@Test
	public void test03_Insert_parent() {
		Parent p = new Parent("p1");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Serializable id = session.save(p);
		session.getTransaction().commit();
		
		Assert.assertNotNull(id);
		Assert.assertEquals(3, id);
		
		Assert.assertEquals(3, count(session, Parent.class));
	}
	
	@Test
	public void test04_Insert_child1() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Assert.assertEquals(2, count(session, Child1.class));
		
		session.beginTransaction();
		
		Parent william = (Parent) session.load(Parent.class, 1);
		Assert.assertEquals(2, william.getChild1s().size());

		// add new child
		william.addChild1(new Child1("owen"));

		session.getTransaction().commit();
		
		// reopen session
		session.close();
		session = HibernateUtil.getSessionFactory().openSession();

		// check addition
		Assert.assertEquals(3, count(session, Child1.class));
		
		Parent william2 = (Parent) session.load(Parent.class, 1);
		Assert.assertEquals(3, william2.getChild1s().size());
	}	
	
	@Test
	public void test05_Insert_child1_check() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Assert.assertEquals("2", session.createSQLQuery("select INDEX_COL from multibag.child1 where name='owen'").uniqueResult().toString());
	}
	
	private static int count(Session session, Class<?> clazz) {
		return ((Number) session.createQuery("select count(*) from "+clazz.getSimpleName()).uniqueResult()).intValue();
	}
}
