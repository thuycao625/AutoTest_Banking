package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.lang.Thread.sleep;


public class CustomerDepositTest extends PageProvider{

    @When("^I click deposit tab$")
    public void clickDepositTab() throws InterruptedException {
        sleep(2000);
        getCustomerDepositPage().navigateToDepositTab();
    }

    @When("^I type the depsit as (.*)$")
    public void chooseDepositAmount(String depositAmount) throws InterruptedException {
        sleep(2000);
        getCustomerDepositPage().typeDepositAmount(depositAmount);

    }


    @When("^I click deposit submit button$")
    public void clickDepositSubmitButton() throws InterruptedException {
        sleep(10000);
        getCustomerDepositPage().submitDeposit();
        sleep(500);
        getCommonPage().getDateTime();
    }

    @Then("^I verify that customer deposit successfully (.*)$")
    public void verifyDepositSuccesfully(String depositAmount) throws InterruptedException {
        sleep(2000);
        getCustomerDepositPage().verifyMessageSuccessfully();
        sleep(5000);
        getTransaction().navigateTransactionTab();
        getCommonPage().verifySuccessfullyAtTransaction(getCommonPage().getDateTime(), getCommonPage().getAmount(depositAmount));

    }

    @Then("^I verify that customer deposit unsuccessfully$")
    public void verifyDepositunSuccesfully() throws InterruptedException {
        sleep(3000);
        getCustomerDepositPage().verifyMessageunSuccessfully();
    }
}
