package tests;

import org.openqa.selenium.support.PageFactory;
import pages.*;
import runner.TestRunner;

public class PageProvider {

    private static CustomerLoginPage customerLoginPage;
    private static CommonPage commonPage;
    private static CustomerDepositPage customerDepositPage;
    private static CustomerWithdrawlPage customerWithdrawlPage;
    private static TransactionsPage transactionsPage;

    public static CustomerLoginPage getCustomerLoginPage(){
        if (customerLoginPage == null) {
            customerLoginPage = PageFactory.initElements(TestRunner.driver, CustomerLoginPage.class);
        }
        return customerLoginPage;
    }

    public static CommonPage getCommonPage(){
        if (commonPage == null) {
            commonPage = PageFactory.initElements(TestRunner.driver, CommonPage.class);
        }
        return commonPage;
    }

    public static CustomerDepositPage getCustomerDepositPage(){
        if (customerDepositPage == null) {
            customerDepositPage = PageFactory.initElements(TestRunner.driver, CustomerDepositPage.class);
        }
        return customerDepositPage;
    }



    public static CustomerWithdrawlPage getCustomerWithdrawlPage(){
        if (customerWithdrawlPage == null) {
            customerWithdrawlPage = PageFactory.initElements(TestRunner.driver, CustomerWithdrawlPage.class);
        }
        return customerWithdrawlPage;
    }



    public static TransactionsPage getTransaction(){
        if (transactionsPage == null) {
            transactionsPage = PageFactory.initElements(TestRunner.driver, TransactionsPage.class);
        }
        return transactionsPage;
    }


}
