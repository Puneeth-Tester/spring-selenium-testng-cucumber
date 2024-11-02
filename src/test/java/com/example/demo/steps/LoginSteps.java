package com.example.demo.steps;

import com.example.demo.models.TestUserDetails;
import com.example.demo.models.UserDetails;
import com.example.demo.pages.HomePage;
import com.example.demo.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LoginSteps {

    @Autowired
    public HomePage homePage;

    @Autowired
    public LoginPage loginPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Given("I click login in Home Page")
    public void iClickLoginInHomePage() {

        homePage.ClickLogin();

        //Scenario scope
        testUserDetails.setUserDetails(new UserDetails("admin", "password"));
    }



    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.ClickLogin();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
        Assert.assertEquals(homePage.isEmployeeDetailsExist() , true);

    }

    @And("I click logout link")
    public void iClickLogoutLink() {
        homePage.ClickLogoff();
    }

}
