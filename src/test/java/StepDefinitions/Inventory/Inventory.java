package StepDefinitions.Inventory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Inventory {

    public WebDriver driver = new FirefoxDriver();
    public String testValue = "";

    @Given("Open the inventory")
    public void open_the_inventory() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }
    @When("The value of product sort container is {string}")
    public void the_value_of_product_sort_container_is(String string) {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue(string);
        testValue = string;
    }
    @Then("The products should be sorted")
    public void the_products_should_be_sorted() {
        if(testValue.equals("az")){
            List<WebElement> myList = driver.findElements(By.className("inventory_item_name"));
            Assert.assertEquals(myList.get(0).getText(), "Sauce Labs Backpack");
        }
        else if(testValue.equals("za")){
            List<WebElement> myList = driver.findElements(By.className("inventory_item_name"));
            Assert.assertEquals(myList.get(0).getText(), "Test.allTheThings() T-Shirt (Red)");
        }
        else if(testValue.equals("hilo")){
            List<WebElement> myList = driver.findElements(By.className("inventory_item_name"));
            Assert.assertEquals(myList.get(0).getText(), "Sauce Labs Fleece Jacket");
        }
        else if(testValue.equals("lohi")){
            List<WebElement> myList = driver.findElements(By.className("inventory_item_name"));
            Assert.assertEquals(myList.get(0).getText(), "Sauce Labs Onesie");
        }

        driver.quit();
    }
}
