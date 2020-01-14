package tests;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CustomerWithdrawlTest extends PageProvider{


    @When("^I open withdrawl tab$")
    public void openWithdrawlTab() throws Throwable {
        Thread.sleep(2000);
       getCustomerWithdrawlPage().navigateToWithdrawlTab();
    }


    @When("^I type withdrawl as(.*)$")
    public void chooseWithdrawlAmount(String withdrawlAmount) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerWithdrawlPage().typeWithdrawlAmount(withdrawlAmount);
    }

    @When("^I click withdrawl submit button$")
    public void clickWithdrawlSubmitButton() throws InterruptedException {
        Thread.sleep(10000);
        getCustomerWithdrawlPage().submitWithdrawl();
        getCommonPage().getDateTime();
    }

    @Then("^I verify that customer withdrawl successfully as(.*)$")
    public void verifyWithdrawSuccesfully(String withdrawlAmount) throws InterruptedException {
        getCustomerWithdrawlPage().verifyMessageSuccessfully();
        Thread.sleep(5000);
        getTransaction().navigateTransactionTab();
        getCommonPage().verifySuccessfullyAtTransaction(getCommonPage().getDateTime(),getCommonPage().getAmount(withdrawlAmount));
    }

    @Then("^I verify that customer withdrawl unsuccessfully")
    public void verifyWithdrawunSuccesfully() throws InterruptedException {
        Thread.sleep(3000);
        getCustomerWithdrawlPage().verifyMessageunSuccessfully();
    }

}
