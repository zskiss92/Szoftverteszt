package StepDefinitions.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

    public WebDriver driver = new FirefoxDriver();

    @Given("The user name is standard_user")
    public void the_user_name_is_standard_user() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @Given("The password is secret_sauce")
    public void the_password_is_secret_sauce() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @When("The login button clicked")
    public void the_login_button_clicked() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Login should be success")
    public void login_should_be_success() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        driver.quit();
    }
}