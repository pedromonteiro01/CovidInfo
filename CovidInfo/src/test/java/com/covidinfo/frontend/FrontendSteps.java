package com.covidinfo.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
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

    @And("I search for {string} on the list bar")
    public void checkCovidDataOnListBar(String local) {
        driver.findElement(By.className("countriesSelect")).sendKeys(local);
    }

    @And("I search for {string}, that is not available, on the search bar")
    public void checkCovidDataOnSearchBar(String local) {
        driver.findElement(By.id("country-box")).sendKeys(local);
    }

    @And("click on the search button")
    public void searchForCovidData() {
        driver.findElement(By.className("search-button")).click();
    }
    
    @Then("Covid Data is presented at {string} section")
    public void seeCovidInformation(String results) {
        assertThat(driver.findElement(By.className("h2-title")).getText(), containsString(results));
    }

    @Then("I can see that nothing is shown at {string} section")
    public void seeThatNothingIsShown(String result) {
        assertThat(driver.findElement(By.id("search-country")).getText(), containsString(result));
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
