package com.app.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTests {

	@BeforeMethod
	public void setUp(){

		System.out.println("Setup");

	}

	@Test
	public void smokeTest1() {

		 Assert.assertEquals("test", "test");
		
		System.out.println("Smoke Test is running");
	}

	@AfterMethod
	public void tearDown(){

		System.out.println("Teardown");
	}

}
