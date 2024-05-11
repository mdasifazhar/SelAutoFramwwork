package com.qa.testcases.testNg.listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.testcases.testNg.TestNgBase;

public class MyTestListner extends TestNgBase implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" >>>>Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" >>>>Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" >>>>Failed");
		takeScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" >>>>Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" >>>>FailedWithSuceessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" >>>>Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+" >>>>Started");
	}

}
