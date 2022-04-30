package com.covidinfo.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.*;

public class FrontendSteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver = WebDriverManager.chromedriver().create();
        driver.get(url);
    }

    @And("user searches for {string} on the list bar")
    public void checkCovidData(String local) {
        driver.findElement(By.className("countriesSelect")).sendKeys(local);
    }

    @And("clicks on the search button")
    public void searchForCovidData() {
        driver.findElement(By.className("search-button")).click();
    }
    
    @Then("Covid Data is presented at {string}")
    public void seeCovidInformation(String results) {
        assertThat(driver.findElement(By.className("h2-title")).getText(), containsString(results));
    }
}
