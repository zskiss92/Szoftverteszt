package StepDefinitions.Cart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cart {

    public WebDriver driver = new FirefoxDriver();

    @Given("Open the site and login")
    public void open_the_site_and_login() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }
    @When("Add product to cart with {string} button")
    public void add_product_to_cart_with_button(String string) {
        driver.findElement(By.id(string)).click();
    }
    @When("Open the cart")
    public void open_the_cart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
    @Then("Remove the product from the cart with {string} button")
    public void remove_the_product_from_the_cart_with_button(String string) {
        driver.findElement(By.id(string)).click();
        driver.quit();
    }
}
