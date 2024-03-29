package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class RetailSignInSteps extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	
	
//	In here you notice that we don not have @Given step
//	That is because that step has already been defined in our other POM class (RetailSteps)
//	So Cucumber will automatically detect that step
//	you do not need to define it over again
//	or it will give you duplicate error when you run your test
	
	
//	Scenario 1: Passed
	
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		
		click(factory.signInPage().signInBtn);
		logger.info("User clicked on signin button");
	}
	
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String emailValue, String passwordValue) {
		click(factory.signInPage().emailField);
		sendText(factory.signInPage().emailField, emailValue);
		click(factory.signInPage().passwordField);
		sendText(factory.signInPage().passwordField, passwordValue);
		logger.info("This is the email user entered: " + emailValue + " , This is the password user enterd: " + passwordValue);
		
		
	}
	
	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.signInPage().logInBtn);
		logger.info("User clicked on login button");
		
		
	}
	
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().accountBtn));
		logger.info("User is logged into account");
		
	    
	}
	
	
	
	

//	Scenario 2: Passed
	
	
	
	@And("User click on Create new Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().createAccountBtn);
		logger.info("User clicked on Create new account button");
	}
	
	@And("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		
		List<Map<String, String>> signUpInformation = dataTable.asMaps(String.class, String.class);
		sendText(factory.signInPage().signUpNameField, DataGeneratorUtility.data(signUpInformation.get(0).get("name")));
		sendText(factory.signInPage().signUpEmailField, DataGeneratorUtility.data(signUpInformation.get(0).get("email")));
		sendText(factory.signInPage().signUpPassField, signUpInformation.get(0).get("password"));
		sendText(factory.signInPage().signUpConfirmPassField, signUpInformation.get(0).get("confirmPassword"));
		logger.info("User filled the signUp information");
		
	}
	
	@And("User click on signUp button")
	public void userClickOnSignUpButton() {
		click(factory.signInPage().signUpFormBtn);
		logger.info("User clicked on sign up button");
		
	}
	
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().yourProfileText));
//		Assert.assertTrue(isElementDisplayed(factory.accountPage().profileImage));
		logger.info("User is logged into Account page");
		
	}

	
	
	
	
	
	

}
