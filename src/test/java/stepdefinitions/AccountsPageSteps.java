package stepdefinitions;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user has already logged in to application")  //dataTable got already created with credentials username/password and got changet to credTable
    public void user_has_already_logged_in_to_application(DataTable credTable) {
       List<Map<String, String>> credList = credTable.asMaps();
       String userName = credList.get(0).get("username");
       String password = credList.get(0).get("password");

        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doLogin(userName, password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts page title is: " + title);
    }

    @Then("user gets accounts section")  //this already was verified in loginPageSteps // dataTable was changed to sectionsTable
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expAccountSectionsList = sectionsTable.asList();
        System.out.println("Expected accounts section list: " + expAccountSectionsList); //is coming from feature file
        List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
        System.out.println("Actual accounts section list: " + actualAccountSectionsList); // is coming from the Page class

        Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
    }

    @Then("accounts section count should be {int}") //expected count is coming from feature file
    public void accounts_section_count_should_be(Integer expectedSectionCount) {
     Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);

    }
}
