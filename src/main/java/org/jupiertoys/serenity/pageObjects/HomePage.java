package org.jupiertoys.serenity.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jupiertoys.serenity.extention.BasePageObject;

public class HomePage extends BasePageObject {

    @FindBy(css = "li#nav-contact > a")
    public WebElementFacade contactOption;

    @FindBy(css = "li#nav-login a")
    public WebElementFacade loginOption;

    @FindBy(css = "li#nav-user > a")
    public WebElementFacade loggedInUser;

}
