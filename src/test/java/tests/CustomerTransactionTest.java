package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.lang.Thread.sleep;

public class CustomerTransactionTest extends PageProvider {

    @When("^I click transaction tab$")
    public void clickTransactionTab() throws Throwable {
        getTransaction().navigateTransactionTab();
    }

    @When("^I type deposit successfully with withdrawl as (.*)$")
    public void alreadyDepositBeforeWithdrawl(String withdrawlAmount) throws Throwable {
        getCustomerWithdrawlPage().navigateToWithdrawlTab();
        Thread.sleep(2000);
        getCustomerWithdrawlPage().typeWithdrawlAmount(withdrawlAmount);
        Thread.sleep(2000);
        getCustomerWithdrawlPage().submitWithdrawl();

    }

    @Then("^I verify the data at transaction correct as(.*)$")
    public void verifyDataCorrect(String numberAmount) throws Throwable {
        System.out.println("ffffffffffffffffffffffffffffff" + getCommonPage().getDateTime());
        System.out.println("dddddddddddddddddddddddddddd" + getCommonPage().getAmount(numberAmount));
       getCommonPage().verifySuccessfullyAtTransaction(getCommonPage().getDateTime(), getCommonPage().getAmount(numberAmount));

    }



    @When("^I click reset button$")
    public void clickResetButton() throws Throwable {
       getTransaction().resetTableTransaction();
       sleep(5000);

    }

    @Then("^I verify the data transaction reseted$")
    public void verifyDataReseted() throws Throwable {
        getTransaction().verifyResetButtonSuccess();
        sleep(5000);

    }

    @When("^I click back button$")
    public void clickBackButton() throws Throwable {
        getTransaction().backButtonAtTransaction();
        sleep(5000);
    }

    @Then("^I verify page transaction backed$")
    public void verifyPageBack() throws Throwable {
        getTransaction().verifyBackButtonSuccess();
        sleep(5000);
    }





}
