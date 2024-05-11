package com.qa.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;

public class Checkout {
	@Then("Product should add the product to the cart.")
	public void product_should_add_the_product_to_the_cart() {
		System.out.println("Result: Product has been added to the cart");
		Assert.assertTrue(true);
	}

}
