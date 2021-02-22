package org.jupiertoys.serenity.pageDefinitions;

import net.thucydides.core.annotations.Step;
import org.jupiertoys.manager.TestDataManager;
import org.jupiertoys.serenity.pageObjects.ContactPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class JupiterToysContactDetailsSteps {

    protected TestDataManager testDataManager = new TestDataManager();
    private ContactPage jupiterContactPage = new ContactPage();

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd.HHmmss");

    private Logger logger = LoggerFactory.getLogger(JupiterToysContactDetailsSteps.class);

    @Step
    public JupiterToysContactDetailsSteps theUserChecksPresenceOfTheHeaderText() {

        jupiterContactPage.assertElementContainsText(jupiterContactPage.headerMessage,
                testDataManager.getAssertionData("ContactPageHeader"));

        return this;
    }

    @Step
    public void theUserSubmitsTheForm() {

        logger.info("the Guest user submit the form");
        jupiterContactPage.clickElement(jupiterContactPage.submitButton);
    }

    @Step
    public void theUserCanSeeMandatoryFieldRequiredErrorMessages() {

        logger.info("the user can see mandatory fields required error messages");

        jupiterContactPage.assertElementContainsText(jupiterContactPage.foreNameError,
                testDataManager.getAssertionData("ForeNameError"));
        jupiterContactPage.assertElementContainsText(jupiterContactPage.emailError,
                testDataManager.getAssertionData("EmailError"));
        jupiterContactPage.assertElementContainsText(jupiterContactPage.messageError,
                testDataManager.getAssertionData("MessageError"));
    }

    @Step
    public void theUserCanSeeMessagesAreDisappeared() {

        logger.info("Mandatory fields required error messages should be disappeared");

        jupiterContactPage.foreNameError.shouldNotBeCurrentlyVisible();
        jupiterContactPage.emailError.shouldNotBeCurrentlyVisible();
        jupiterContactPage.messageError.shouldNotBeCurrentlyVisible();

    }

    @Step
    public void theUserSubmitTheFormWithValidData() {

        jupiterContactPage.setText(jupiterContactPage.inputForeName,
                testDataManager.getTestInputData("contactDetails.foreName"));
        jupiterContactPage.setText(jupiterContactPage.inputSurname,
                testDataManager.getTestInputData("contactDetails.surname"));
        jupiterContactPage.setText(jupiterContactPage.inputEmail,
                testDataManager.getTestInputData("contactDetails.emailAddress"));
        jupiterContactPage.setText(jupiterContactPage.inputTelephone,
                testDataManager.getTestInputData("contactDetails.telephone"));
        jupiterContactPage.setText(jupiterContactPage.inputMessage,
                testDataManager.getTestInputData("contactDetails.message"));

        jupiterContactPage.javascriptClickElement(jupiterContactPage.submitButton);
    }


    public JupiterToysContactDetailsSteps fillMandatoryData() {

        String userEmail = "test_".concat(dateFormat.format(timestamp)).concat("@test.com");
        logger.info("Customer email-id ::" + userEmail);

        jupiterContactPage.setText(jupiterContactPage.inputForeName,
                testDataManager.getTestInputData("contactDetails.foreName"));

        jupiterContactPage.setText(jupiterContactPage.inputEmail,userEmail);

        jupiterContactPage.setText(jupiterContactPage.inputMessage,
                testDataManager.getTestInputData("contactDetails.message"));

        return this;
    }
}
