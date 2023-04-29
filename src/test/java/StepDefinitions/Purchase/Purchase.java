package StepDefinitions.Purchase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Purchase {

    public WebDriver driver = new FirefoxDriver();

    @Given("Sign in to the site")
    public void sign_in_to_the_site() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }
    @Given("Open the details page of the item")
    public void open_the_details_page_of_the_item() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    @Given("Add the item to cart")
    public void add_the_item_to_cart() {
        driver.findElement(By.tagName("button")).click();
    }
    @Given("Open the cart page")
    public void open_the_cart_page() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
    @Given("Open the checkout page")
    public void open_the_checkout_page() {
        driver.findElement(By.id("checkout")).click();
    }
    @Given("Fill the necessary fields")
    public void fill_the_necessary_fields() {
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Smith");
        driver.findElement(By.id("postal-code")).sendKeys("1234");
        driver.findElement(By.id("continue")).click();
    }
    @When("The finish button clicked")
    public void the_finish_button_clicked() {
        driver.findElement(By.id("finish")).click();
    }
    @Then("Purchase should be success")
    public void purchase_should_be_success() {
        Assert.assertTrue(driver.findElement(By.className("complete-header")).isDisplayed());
        driver.quit();
    }
}
