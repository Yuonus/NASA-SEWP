package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sewp.qa.internal.factory.DriverFactory;
import sewp.qa.internal.pages.LoginPage;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage (DriverFactory.getDriver());
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://test-internal.sewp.nasa.gov/sewp5internal/security/login.sa");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Internal Log in page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}
	
	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	
	// ******************* Login with negative credentials***********
	
	@When("user enters wrong username {string}")
	public void user_enters_wrong_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters wrong password {string}")
	public void user_enters_wrong_password(String pwd) {
	   loginPage.enterPassword(pwd);
	}

	@Then("the user gets the error message {string}")
	public void the_user_gets_the_error_message(String errorMsg) {
	    String actualErrorMessage = loginPage.getErrorMessage();
	    String expectedErrorMsg = "Username/Password does not match for QATesters12";
	    
	    Assert.assertEquals(actualErrorMessage, expectedErrorMsg);
	    System.out.println("The error message thrown after wrong credentials is: " + actualErrorMessage);
	}
	
}
