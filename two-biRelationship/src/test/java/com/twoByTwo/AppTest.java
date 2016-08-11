package com.twoByTwo;

import java.util.List;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.twoByTwo.Role;
import com.twoByTwo.Stock;
import com.twoByTwo.StockCategory;
import com.twoByTwo.util.HibernateUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
	@Test
	public void testSetup() {
		System.out.println("Hibernate many to many - join table + extra column (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testFetch() {
		System.out.println("Hibernate many to many - join table + extra column (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Stock stock1 = (Stock) session.load(Stock.class, 1);
		List<StockCategory> sc = stock1.getStockCategories();
		Assert.assertEquals(2, sc.size());
		
		StockCategory cat10 = sc.get(0);
		Assert.assertEquals("CAT10", cat10.getCategory().getName());
		
		List<Role> rolesForCat10 = cat10.getRoles();
		Assert.assertEquals(2, rolesForCat10.size());
		
		Role role1 = rolesForCat10.get(0);
		Assert.assertEquals("role1", role1.getName());
		
		Assert.assertEquals(2, role1.getStockCatgeory().size());
		
		session.getTransaction().commit();
	}

}
