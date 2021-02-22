package org.jupiertoys.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.UnreachableBrowserException;


@Slf4j
public class FirefoxDriverWrapper implements WrappedWebDriver {
    @NotNull
    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(
                "--private"
        );

        firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        return firefoxOptions;
    }

    @Override
    public WebDriver newDriver() {
        WebDriverManager.firefoxdriver().setup();
        final FirefoxOptions firefoxOptions = getFirefoxOptions();

        try {
            return new FirefoxDriver(GeckoDriverService.createDefaultService(), firefoxOptions);
        } catch (UnreachableBrowserException e) {
            throw new UnreachableBrowserException(e.getMessage());
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}