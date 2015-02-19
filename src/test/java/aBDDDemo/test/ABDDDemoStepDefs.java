package aBDDDemo.test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class ABDDDemoStepDefs {

	protected WebDriver driver;

	@Before
	public void setUp() {

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

	}

	/**
	 * There is an assumption that first product, first color and first size is
	 * in stock In real life, additional checks within the selectors can be
	 * added to make a conditional decision Product/Sizes/Color with out of
	 * stock attribute can be avoided using these attributes within selectors
	 * 
	 */
	@Given("I have added a shirt to my bag")
	public void i_have_added_a_shirt_to_my_bag() throws InterruptedException {

		driver.get("http://www.marksandspencer.com");

		driver.findElement(By.id("global-search")).click();

		driver.findElement(By.id("global-search")).clear();

		driver.findElement(By.id("global-search")).sendKeys("shirt");

		driver.findElement(By.id("goButton")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div/figure/a[@class='prodAnchor'])[1]"))
				.click();

		driver.findElement(
				By.xpath("(//span[@class='glimmer-container']/parent::label/parent::li)[1]"))
				.click();

		driver.findElement(
				By.xpath("(//div[@class='size-table-wrapper']/table/tbody/tr/td/label)[1]"))
				.click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[starts-with(@id, 'basket_')]"))
				.click();

		Thread.sleep(1000);

	}

	@When("I view the contents of my bag")
	public void i_view_the_contents_of_my_bag() throws InterruptedException {

		driver.findElement(By.cssSelector("span.basket-icon")).click();

		Thread.sleep(1000);

	}

	/*
	 * Check the product description in basket and look for word Shirt in it
	 */
	@Then("I can see the contents of the bag include a shirt")
	public void i_can_see_the_contents_of_the_bag_include_a_shirt() {

		String productDescription = driver
				.findElement(By.xpath("//h3[@class='heading-product']/a"))
				.getText().trim();
		
		assertTrue(productDescription.toLowerCase().contains(
				"shirt".toLowerCase()));

	}

	@After
	public void tearDown() {
		driver.close();
	}

}