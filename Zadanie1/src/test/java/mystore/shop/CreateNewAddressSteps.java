package mystore.shop;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static java.nio.file.Paths.get;

public class CreateNewAddressSteps {

    private WebDriver driver;

    @Given("User is logged in to MyStore shop")
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
        driver.findElement(By.id("addresses-link")).click();
    }

    @Then("User goes to create new address")
    public void userGoesToCreateNewAddress() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    @And("User fills in the form with {string} {string} {string} {string} {string} {string}")
    public void userFillsInTheFormWith(String alias, String address, String city, String zip, String country, String phone) {
        driver.findElement(By.id("field-alias")).sendKeys(alias);
        driver.findElement(By.id("field-address1")).sendKeys(address);
        driver.findElement(By.id("field-city")).sendKeys(city);
        driver.findElement(By.id("field-postcode")).sendKeys(zip);
        WebElement countryDropdown = driver.findElement(By.id("field-id_country"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
        driver.findElement(By.id("field-phone")).sendKeys(phone);

    }

    @And("Save progress")
    public void saveProgress() {
        driver.findElement(By.className("form-control-submit")).click();

    }
}
