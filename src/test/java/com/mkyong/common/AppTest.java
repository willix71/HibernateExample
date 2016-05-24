package com.mkyong.common;

import java.util.List;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockCategoryRole;
import com.mkyong.util.HibernateUtil;

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
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Stock stock1 = (Stock) session.load(Stock.class, 1);
		List<StockCategoryRole> sc = stock1.getStockCategoryRoles();
		Assert.assertEquals(3, sc.size());
		
		StockCategoryRole link1 = sc.get(0);
		Assert.assertEquals("CAT10", link1.getCategory().getName());		
		Assert.assertEquals("role1", link1.getRole().getName());
		
		Assert.assertEquals(2, stock1.getCategories().size());
		Assert.assertEquals(2, stock1.getRoles(sc.get(0).getCategory()).size());
		
		session.getTransaction().commit();
	}

	@Test
	public void testMakeSure() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock2 = (Stock) session.load(Stock.class, 2);
		Assert.assertEquals(0, stock2.getStockCategoryRoles().size());
		session.getTransaction().commit();
	}

}
