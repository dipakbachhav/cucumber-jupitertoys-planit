package org.jupiertoys.serenity.pageDefinitions;

import org.jupiertoys.manager.TestDataManager;
import org.jupiertoys.serenity.pageObjects.LoginPage;

public class JupiterToysLoginSteps {

    private LoginPage jupiterLoginPage = new LoginPage();
    protected TestDataManager testDataManager = new TestDataManager();

    public void theUserIsOnJuniorToysLoginScreen() {
        jupiterLoginPage.assertElementContainsText(jupiterLoginPage.loginHeader,
                testDataManager.getAssertionData("LoginPageHeader"));
    }

    public void theUserLoginWithTheValidCredentials() {

        jupiterLoginPage.setText(jupiterLoginPage.inputUserName,
                testDataManager.getTestInputData("loginCredentials.userName"));
        jupiterLoginPage.setText(jupiterLoginPage.inputUserPassword,
                testDataManager.getTestInputData("loginCredentials.password"));
        jupiterLoginPage.clickElement(jupiterLoginPage.submitButton);

    }

}
