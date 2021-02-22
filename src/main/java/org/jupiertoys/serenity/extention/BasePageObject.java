package org.jupiertoys.serenity.extention;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;
import org.jupiertoys.manager.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePageObject extends PageObject implements PageAssertions {

    private final Logger logger = LoggerFactory.getLogger(BasePageObject.class);

    public void setText(WebElementFacade element, String text) {

        for (int i = 0; i <= 2; i++) {
            try {
                if (!element.getText().isEmpty()) {
                    element.clear();
                }
                element.waitUntilEnabled().sendKeys(text);
                break;
            } catch (InvalidElementStateException e) {
                logger.debug(e.getMessage());
            }
        }
    }

    public void navigateTo(String url) {
        openUrl(url);
    }

    public void clickElement(final WebElementFacade element) {

        for (int i = 0; i <= 2; i++) {
            try {
                element.waitUntilVisible().waitUntilClickable().click();
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException | NoSuchElementException
                    | ElementShouldBeEnabledException e) {
                logger.debug(e.getMessage());
            }
        }
    }

    public void waitForAjaxSpinner() {
        try {
            final ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) evaluateJavascript("return jQuery.active") == 0);
            final boolean jqueryReady = (Boolean) evaluateJavascript("return (window.jQuery != null) && (jQuery.active === 0);");
            if (!jqueryReady) {
                new WebDriverWait(getDriver(), Properties.serenityTimeout()).until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
            logger.debug(ignored.getMessage());
        }
    }

    public void javascriptClickElement(final WebElementFacade element) {
        evaluateJavascript("arguments[0].click()", element.waitUntilVisible().waitUntilClickable());
    }
}

