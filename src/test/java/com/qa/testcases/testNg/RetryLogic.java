package com.qa.testcases.testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.qa.testcases.testNg.listner.MyRetryAnalyzer;

@Test(singleThreaded = true)
public class RetryLogic {
	
	//@Test(retryAnalyzer =MyRetryAnalyzer.class)
	public void retryOnFailure() {
		Assert.assertFalse(false);
	}
	
	public void noRetryOnFailure() {
		Assert.assertFalse(true);
	}


}
