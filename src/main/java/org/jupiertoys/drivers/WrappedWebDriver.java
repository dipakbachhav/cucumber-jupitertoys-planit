package org.jupiertoys.drivers;

import org.openqa.selenium.WebDriver;

public interface WrappedWebDriver {

    boolean takesScreenshots();
    WebDriver newDriver();

    int desiredWindowWidth = 800;
    int desiredWindowHeight = 1200;
    String windowSizeFlag = String.format("--window-size=%d,%d", desiredWindowWidth, desiredWindowHeight);

}
