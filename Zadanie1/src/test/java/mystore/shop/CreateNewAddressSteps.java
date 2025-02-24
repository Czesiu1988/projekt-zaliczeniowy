package mystore.shop;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CreateNewAddressSteps {

    private WebDriver driver;

    @Given("User is logged in to  MyStore shop")
    public void openMyStoreShop() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        driver.findElement(By.name("email")).sendKeys("mem@wp.pl");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.id("submit-login")).click();
    }

    @When("User goes to addresses")
    public void userGoesToAddresses() {
        driver.findElement(By.linkText("Addresses")).click();
    }

    @Then("User goes to create new address")
    public void userGoesToCreateNewAddress() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

}