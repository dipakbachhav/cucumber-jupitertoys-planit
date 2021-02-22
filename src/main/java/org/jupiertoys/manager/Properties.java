package org.jupiertoys.manager;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class Properties {

    private static EnvironmentVariables vars = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();

    public static String getBaseUrl() {
       return (String.format(getProperty("webdriver.base.url")));
    }

    public static Integer serenityTimeout() {
        return Integer.valueOf(getProperty("serenity.timeout"));
    }

    public static String getProperty(String property) { return vars.getProperty(property); }

    public static String getDriver() {
        return getProperty("webdriver.managed.driver");
    }

    public static String getPlatform() {
        return getProperty("target.platform");
    }

}

