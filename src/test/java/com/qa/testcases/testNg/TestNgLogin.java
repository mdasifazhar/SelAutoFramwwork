package com.qa.testcases.testNg;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class TestNgLogin extends TestNgBase{

	@Test
	public void registration() {
		System.out.println("             Registration");
	}

	@Test(dependsOnMethods = { "registration" })
	public void login() {
		System.out.println("             Login");
	}

	@Test(dependsOnMethods = { "login" }, invocationCount = 3)
	public void search() {
		System.out.println("             Searching");
	}

	@Test(dependsOnMethods = { "search" })
	public void logout() {
		System.out.println("             Logout");
	}

	@Test(invocationTimeOut = 1, dependsOnMethods = "logout", expectedExceptions = ThreadTimeoutException.class)
	public void treminate() {
		System.out.println("             Terminate");
		int i = 0;
		while (true) {

		}

	}

	@Test(expectedExceptions = ArithmeticException.class, dependsOnMethods = { "search" })
	public void exceptionHandling() {
		System.out.println("             ExceptionHandling");
		System.out.println(1 / 0);
	}
}
