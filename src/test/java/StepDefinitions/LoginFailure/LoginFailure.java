package StepDefinitions.LoginFailure;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFailure {

    public WebDriver driver = new FirefoxDriver();

    @Given("The user name is {string}")
    public void the_user_name_is(String string) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys(String.valueOf(string));
    }
    @Given("The password is {string}")
    public void the_password_is(String string) {
        driver.findElement(By.name("password")).sendKeys(String.valueOf(string));
    }

    @When("The green login button clicked")
    public void the_green_login_button_clicked() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Login should be not success")
    public void login_should_be_not_success() {
        Assert.assertTrue(driver.findElement(By.className("error-message-container")).isDisplayed());
        driver.quit();
    }
}
