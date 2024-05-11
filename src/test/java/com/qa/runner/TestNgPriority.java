package com.qa.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgPriority {
	@Test
	public void testZ() {
		System.out.println("Testcase: Z");
	}
	@Test
	public void testA() {
		System.out.println("Testcase: A");

	}
	@Test
	public void testB() {
		System.out.println("Testcase: B");

	}

	@Test(priority = 1)
	public void testC() {
		System.out.println("Testcase: C");

	}
	
	@Test(priority = 0)
	public void testD() {
		System.out.println("Testcase: D");

	}
	
	@Test(priority = -1)
	public void testG() {
		System.out.println("Testcase: G");

	}
	
	@Test(priority = -1,dependsOnMethods = "testD")
	public void testF() {
		System.out.println("Testcase: F");

	}
	
	@Test(dataProvider = "inputdata",enabled = true)
	public void testReadDataProvider(int i,int j,int k) {
		System.out.println(i+"-"+j+"-"+k);
	}
	
	
	@DataProvider(name="inputdata")
	public Object[][] dataprovider(){
		return new Object[][] {{1,2,3},{5,6,7}};
	}
	
}
