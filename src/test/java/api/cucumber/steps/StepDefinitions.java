package api.cucumber.steps;

import cucumber.runtime.StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    private WebDriver driver;
    static Logger logger = Logger.getLogger(StepDefinition.class);

    @Given("browser is open")
    public void browser_is_open() {
        // PropertyConfigurator.configure("target/log4j.properties");
        logger.info("user is on home page");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        //driver.get("https://https://secure-sandbox.modulrfinance.com/");
        driver.get("https://secure-sandbox.modulrfinance.com/");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("user missing enter username field and  password")
    public void user_missing_enter_username_field_and_password() {
        driver.findElement(By.id("signInSubmitButton")).click();
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        String error_Msg = driver.findElement(By.xpath("//*[@id=\"signInSubmitButton\"]")).getText();
        String expected_Error = "The username or password is incorrect";
        logger.info(error_Msg);
        //Assert.assertEquals(error_Msg, expected_Error);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.quit();

    }

    @When("user enters incorrect username")
    public void user_enters_incorrect_username() {
        driver.findElement(By.id("username-inp")).sendKeys("varsha.ghanate");
        driver.findElement(By.id("password-inp")).sendKeys("Yashkanna@0404");
        driver.findElement(By.id("signInSubmitButton")).click();

    }

    @Then("This field is required")
    public void warning_will_be_displayed_incorrect_username() {
        driver.findElement(By.id("signInSubmitButton")).click();
        String actual_warning = driver.findElement(By.id("signInSubmitButton")).getText();
        String expected_warning = "This field is required";
        Assert.assertEquals(actual_warning, expected_warning);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.quit();
    }


   @When("user enters correct username and incorrect password")
    public void user_enters_correct_username_and_incorrect_password() {
        driver.navigate().to("https://secure-sandbox.modulrfinance.com/");
        driver.findElement(By.id("username-inp")).sendKeys("varsha.ghanate35");
        driver.findElement(By.id("password-inp")).sendKeys("Yashkanna@04");
        driver.findElement(By.id("signInSubmitButton")).click();
       Assert.assertEquals("This field is required",driver.findElement(By.id("//body/app-root[1]/app-signin[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/app-validated-input[1]/div[1]/app-error-message[1]/div[1]")).getText());

    }


    @Then("This is field required")
    public void warning_will_be_displayed_incorrect_password() {
       driver.findElement(By.id("signInSubmitButton")).click();
       String actual_warning=driver.findElement(By.id("signInsSubmitbutton")).getText();
        String expected_warning="This field is required";
        Assert.assertEquals("This field is required",driver.findElement(By.id("//body/app-root[1]/app-signin[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/app-validated-input[1]/div[1]/app-error-message[1]/div[1]")).getText());
        //driver.quit();

    }

    @When("User enters correct username and correct password")
    public void user_enters_correct_username_and_correct_password() {
        driver.findElement(By.id("username-inp")).sendKeys("varsha.ghanate35");
        driver.findElement(By.id("password-inp")).sendKeys("Yashkanna@0404");
        driver.findElement(By.id("signInSubmitButton")).click();

    }

    @When("Click on Sign in button")
    public void click_on_sign_in_button() {
        driver.findElement(By.id("signInSubmitButton")).click();
    }
    @Given("user is logged in")
    public void user_is_logged_in() {
        driver.findElement(By.id("username-inp")).sendKeys("varsha.ghanate35");
        driver.findElement(By.id("password-inp")).sendKeys("Yashkanna@0404");
        driver.findElement(By.id("signInSubmitButton")).click();
       // WebElement element=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        //Assert.assertTrue(element.isDisplayed());

    }
    @Then("User is navigated to the homepage")
    public void user_is_navigated_to_the_homepage()  {
        driver.findElement(By.xpath("//span[contains(text(),'varsha ghanate')]")).isDisplayed();
        Assert.assertEquals("varsha ghanate",driver.findElement(By.xpath("//span[contains(text(),'varsha ghanate')]")).getText());
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        driver.quit();
    }

    @When("user is logged in another webpage")
    public void user_is_logged_in_another_webpage() {
        driver.navigate().to("https://secure-sandbox.modulrfinance.com/");
        driver.findElement(By.id("username-inp")).sendKeys("varsha.ghanate35");
        driver.findElement(By.id("password-inp")).sendKeys("Yashkanna@0404");
    }

    @Then("Sign in button should be disabled")
    public void sign_in_button_should_be_disabled() throws InterruptedException {
        try {
            WebElement login_button = driver.findElement(By.id("login-button"));
            boolean actualvalue = login_button.isEnabled();
            if (actualvalue)
                logger.info("Login button is enabled. It should be disabled");
            throw new Exception();
        } catch (Exception e) {
            logger.info(e);
        }
        driver.quit();
    }


    @When("User click on reset password button")
    public void user_click_on_reset_password_button() {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/a[1]")).click();

    }

    @When("User is navigated to the request a reset password page")
    public void user_is_navigated_to_the_request_a_reset_password_page() {
        WebElement element=driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("Allows user to request a reset password email")
    public void allows_user_to_request_a_reset_password_email() {
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("email.googlemail.com");
        driver.quit();
    }


    @Then("Warning will be displayed incorrect username")
    public void warningWillBeDisplayedIncorrectUsername() {
    }

    @Then("Warning will be displayed incorrect password")
    public void warningWillBeDisplayedIncorrectPassword() {
        
    }

    @Then("Error massage should be displayed")
    public void errorMessageShouldBeDisplayed() {
    }
}