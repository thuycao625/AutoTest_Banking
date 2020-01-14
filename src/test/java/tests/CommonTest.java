package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import runner.TestRunner;

public class CommonTest extends PageProvider{

    @Given("^Open website (.*)$")
        public void userGoOnTheWeb(String website) throws InterruptedException {
        Thread.sleep(3000);
        TestRunner.driver.get(website);
        TestRunner.driver.manage().window().maximize();
    }
    @When("^I login successfully with username as (.*)$")
    public void loginBeforeWithdraw(String usernameSelected) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerLoginPage().selectUserName(usernameSelected);
        getCustomerLoginPage().clickLoginButton();
        Thread.sleep(5000);
    }


    @When("^I type deposit successfully with deposit as (.*)$")
    public void alreadyDepositBeforeWithdrawl(String depositAmount) throws Throwable {
        getCustomerDepositPage().navigateToDepositTab();
        Thread.sleep(2000);
        getCustomerDepositPage().typeDepositAmount(depositAmount);
        Thread.sleep(2000);
        getCustomerDepositPage().submitDeposit();

    }



}
