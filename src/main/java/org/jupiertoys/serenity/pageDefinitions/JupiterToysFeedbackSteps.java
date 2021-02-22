package org.jupiertoys.serenity.pageDefinitions;

import net.thucydides.core.annotations.Step;
import org.jupiertoys.manager.TestDataManager;
import org.jupiertoys.serenity.pageObjects.FeedbackPage;
import org.jupiertoys.serenity.pageObjects.PopUpMessagePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JupiterToysFeedbackSteps {

    private FeedbackPage feedbackPage = new FeedbackPage();
    private PopUpMessagePage popUpMessagePage = new PopUpMessagePage();
    protected TestDataManager testDataManager = new TestDataManager();
    private Logger logger = LoggerFactory.getLogger(JupiterToysFeedbackSteps.class);
    @Step
    public void theUserCanSeeFeedbackSuccessfullySubmitted() {

        feedbackPage.clickElement(feedbackPage.success);

        logger.info("Feedback Message:: {} ",feedbackPage.feedbackMessage.getText());
        feedbackPage.assertElementContainsText(feedbackPage.userConfirmationLabel,
                testDataManager.getAssertionData("UserConfirmation").concat(testDataManager.getTestInputData("contactDetails.foreName")));
        feedbackPage.assertElementContainsText(feedbackPage.feedbackMessage,
                testDataManager.getAssertionData ("FeedbackMessage"));
    }

    public JupiterToysFeedbackSteps theUserCheckAlertMessage() {

       popUpMessagePage.assertElementContainsText(popUpMessagePage.modelHeader,
               testDataManager.getAssertionData("PopUpFeedbackMessage"));
       return this;
    }
}
