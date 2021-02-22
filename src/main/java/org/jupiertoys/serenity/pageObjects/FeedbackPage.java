package org.jupiertoys.serenity.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jupiertoys.serenity.extention.BasePageObject;

public class FeedbackPage extends BasePageObject {

    @FindBy(css = "div.container-fluid > div > div")
    public WebElementFacade feedbackMessage;

    @FindBy(className = "alert alert-success")
    public WebElementFacade success;

    @FindBy(className = "div.container-fluid > div > a")
    public WebElementFacade backButton;

    @FindBy(css = "div > strong")
    public WebElementFacade userConfirmationLabel;

}
