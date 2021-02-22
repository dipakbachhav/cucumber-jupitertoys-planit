package org.jupiertoys.serenity.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jupiertoys.serenity.extention.BasePageObject;

public class ContactPage extends BasePageObject {

    @FindBy(css = "div#header-message strong")
    public WebElementFacade headerMessage;

    @FindBy(id = "forename")
    public WebElementFacade inputForeName;

    @FindBy(id = "surname")
    public WebElementFacade inputSurname;

    @FindBy(id = "email")
    public WebElementFacade inputEmail;

    @FindBy(id = "telephone")
    public WebElementFacade inputTelephone;

    @FindBy(id = "message")
    public WebElementFacade inputMessage;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    public WebElementFacade submitButton;

    @FindBy(id = "forename-err")
    public WebElementFacade foreNameError;

    @FindBy(id = "email-err")
    public WebElementFacade emailError;

    @FindBy(id = "message-err")
    public WebElementFacade messageError;

}
