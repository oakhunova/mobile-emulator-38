
package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${mode}.properties")

public interface BrowserstackConfig extends Config {
    @Key("username")
    String getUsername();

    @Key("key")
    String getKey();

    @Key("appURL")
    String getAppURL();

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOsVersion();

    @Key("browserstackURL")
    String getBrowserstackURL();

    @Key("browserstackAPI")
    String getBrowserstackAPI();

}