package org.jupiertoys.drivers;

import net.thucydides.core.webdriver.DriverSource;
import org.jupiertoys.manager.Properties;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedDriver implements DriverSource {

    private WrappedWebDriver wrappedWebDriver;
    private final Logger logger = LoggerFactory.getLogger(SharedDriver.class);

    @Override
    public WebDriver newDriver() {

        final String platform = Properties.getPlatform();
        String driver = Properties.getDriver();

        if (null == driver) {

            throw new IllegalArgumentException("Must specify web driver");
        } else {
            switch (driver.toLowerCase()) {
                case "chrome":
                    this.wrappedWebDriver = new ChromeDriverWrapper();

                    break;
                case "firefox":
                    this.wrappedWebDriver = new FirefoxDriverWrapper();
                    break;
                default:
                    throw new IllegalArgumentException(driver + " is not a supported driver.");
            }
        }

        logger.info(String.format("Launching %s on %s using", driver, platform));

        return this.wrappedWebDriver.newDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return this.wrappedWebDriver.takesScreenshots();
    }

}