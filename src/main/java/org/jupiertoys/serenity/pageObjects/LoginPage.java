package org.jupiertoys.serenity.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jupiertoys.serenity.extention.BasePageObject;

public class LoginPage extends BasePageObject {

    @FindBy(css = "div.modal-header > h1")
    public WebElementFacade loginHeader;

    @FindBy(id = "loginUserName")
    public WebElementFacade inputUserName;

    @FindBy(id = "loginPassword")
    public WebElementFacade inputUserPassword;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElementFacade submitButton;

    @FindBy(className = "btn btn-cancel")
    public WebElementFacade cancelButton;
}
