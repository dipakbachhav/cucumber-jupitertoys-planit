package org.jupiertoys.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.CapabilityType;

@Slf4j
@AllArgsConstructor
public class ChromeDriverWrapper implements WrappedWebDriver {

    @NotNull
    private static ChromeOptions getChromeOptions() {
        final ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setAcceptInsecureCerts(true);

        chromeOptions.addArguments(
                "--disable-download-notification",
                "--incognito"
        );

        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);


        if (SystemUtils.IS_OS_LINUX) {
            chromeOptions.addArguments(
                    "--headless"
            );

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.acceptInsecureCerts();
        } else if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_WINDOWS) {
            chromeOptions.addArguments(
                    "--start-maximized"
            );
        }
        return chromeOptions;
    }

    @Override
    public WebDriver newDriver() {

        WebDriverManager.chromedriver().setup();
        final ChromeOptions chromeOptions = getChromeOptions();

        try {
            return new ChromeDriver(ChromeDriverService.createDefaultService(), chromeOptions);
        } catch (UnreachableBrowserException e) {
            throw new UnreachableBrowserException(e.getMessage());
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
