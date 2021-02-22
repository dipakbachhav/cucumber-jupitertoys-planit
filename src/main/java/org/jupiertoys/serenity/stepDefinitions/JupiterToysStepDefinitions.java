package org.jupiertoys.serenity.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.jupiertoys.manager.Properties;
import org.jupiertoys.manager.TestDataManager;
import org.jupiertoys.serenity.pageDefinitions.JupiterToysContactDetailsSteps;
import org.jupiertoys.serenity.pageDefinitions.JupiterToysFeedbackSteps;
import org.jupiertoys.serenity.pageDefinitions.JupiterToysHomePageSteps;
import org.jupiertoys.serenity.pageDefinitions.JupiterToysLoginSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JupiterToysStepDefinitions {

    protected String baseUrl = Properties.getBaseUrl();
    protected TestDataManager testDataManager = new TestDataManager();
    private Logger logger = LoggerFactory.getLogger(JupiterToysStepDefinitions.class);

    @Steps
    public JupiterToysHomePageSteps jupiterToysHomePageSteps;

    @Steps
    public JupiterToysContactDetailsSteps jupiterToysContactDetailsSteps;

    @Steps
    public JupiterToysFeedbackSteps jupiterToysFeedbackSteps;

    @Steps
    public JupiterToysLoginSteps jupiterToysLoginSteps;

    @Given("^the Guest user is on the Jupiter toys contact page$")
    public void theGuestUserIsOnContactPage() {
        logger.debug("the Guest user is on {} the jupiter toys page ::", Properties.getBaseUrl());
        final String baseUrl = Properties.getBaseUrl();
        jupiterToysHomePageSteps.navigateToPage(baseUrl);
        jupiterToysHomePageSteps.theUserSelectsContactOption();
        jupiterToysContactDetailsSteps.theUserChecksPresenceOfTheHeaderText();
    }


    @When("^the user submits the form without filling in mandatory data$")
    public void theUserSubmitFormWithoutFillingMandatoryFields() {
        jupiterToysContactDetailsSteps.theUserSubmitsTheForm();
    }

    @Then("^mandatory field required errors appear on the screen$")
    public void checkPresenceOfErrorMessages() {
        jupiterToysContactDetailsSteps.theUserCanSeeMandatoryFieldRequiredErrorMessages();
    }

    @Then("^errors should be disappeared after entering mandatory fields$")
    public void errorShouldNotPresentOnTheContactPage() {
        jupiterToysContactDetailsSteps.fillMandatoryData()
                .theUserCanSeeMessagesAreDisappeared();
    }

    @When("^the user submits feedback form with the valid data$")
    public void userSubmitsTheForm() {
        jupiterToysContactDetailsSteps.theUserSubmitTheFormWithValidData();
    }

    @Then("^feedback successfully submitted messages should be display$")
    public void feedbackSuccessfullySubmittedMessage() {
        jupiterToysFeedbackSteps.theUserCheckAlertMessage().theUserCanSeeFeedbackSuccessfullySubmitted();
    }

    @Then("^the Guest user is on the Jupiter toys login page$")
    public void theUserIsOnTheLoginScreen() {
        jupiterToysHomePageSteps.navigateToPage(baseUrl);
        jupiterToysHomePageSteps.theUserSelectsLoginOption();
        jupiterToysLoginSteps.theUserIsOnJuniorToysLoginScreen();
    }

    @When("^the user login with valid credentials$")
    public void theUserEntersValidCredentials() {
        jupiterToysLoginSteps.theUserLoginWithTheValidCredentials();
    }

    @Then("^the user should be login successfully$")
    public void loginSuccessfully() {
        jupiterToysHomePageSteps.userShouldLoginSuccessfully();
    }

}





