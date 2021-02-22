package org.jupiertoys.serenity.pageDefinitions;

import net.thucydides.core.annotations.Step;
import org.jupiertoys.manager.TestDataManager;
import org.jupiertoys.serenity.pageObjects.HomePage;

public class JupiterToysHomePageSteps extends BaseSteps{

    private HomePage jupiterToysHomePage = new HomePage();
    protected TestDataManager testDataManager = new TestDataManager();

    @Step
    public JupiterToysHomePageSteps theUserSelectsContactOption() {
        jupiterToysHomePage.clickElement(jupiterToysHomePage.contactOption);
        return this;
    }

    public JupiterToysHomePageSteps theUserSelectsLoginOption() {
        jupiterToysHomePage.clickElement(jupiterToysHomePage.loginOption);
        return this;
    }

    public void userShouldLoginSuccessfully() {
        jupiterToysHomePage.assertElementContainsText(jupiterToysHomePage.loggedInUser,
                testDataManager.getTestInputData("loginCredentials.userName"));
    }
}
