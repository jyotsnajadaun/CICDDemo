package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegressionTests {

	
	@BeforeMethod
	public void setUp(){

		System.out.println("Setup");

	}

	@Test
	public void regressionTest1() {

		 Assert.assertEquals("test", "test");
		
		System.out.println("Regression test is running");
	}

	@AfterMethod
	public void tearDown(){

		System.out.println("Teardown");
	}
	
}
