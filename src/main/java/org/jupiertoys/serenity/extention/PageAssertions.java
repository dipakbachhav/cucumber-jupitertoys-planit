package org.jupiertoys.serenity.extention;

import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public interface PageAssertions {

    default void assertElementContainsText(WebElementFacade element, String text) {
        try {
            Assert.assertThat(element.waitUntilVisible().waitUntilClickable().getText(), CoreMatchers.containsString(text));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Could not find element " + element);
        }
    }
}
