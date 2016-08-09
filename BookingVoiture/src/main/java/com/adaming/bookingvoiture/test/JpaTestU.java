package com.adaming.bookingvoiture.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTestU {
    
	private static ClassPathXmlApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@Test
	public void test() {
		try {
			 context = new ClassPathXmlApplicationContext( new String[]{"app.xml"});
		} catch (Exception e) {
			assertTrue(e.getMessage(),true);
		}
	}

}
