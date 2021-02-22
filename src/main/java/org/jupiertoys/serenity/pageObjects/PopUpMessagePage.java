package org.jupiertoys.serenity.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jupiertoys.serenity.extention.BasePageObject;

public class PopUpMessagePage extends BasePageObject {

    @FindBy(css = "div.modal-header > h1")
    public WebElementFacade modelHeader;
}
