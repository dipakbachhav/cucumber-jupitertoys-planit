package org.jupiertoys.serenity.pageDefinitions;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.jupiertoys.serenity.extention.BasePageObject;

public class BaseSteps extends ScenarioSteps {

    private  BasePageObject basePageObject =new BasePageObject();

    @Step
    public BaseSteps navigateToPage(String pageUrl) {
        basePageObject.navigateTo(pageUrl);
        return this;
    }
}
