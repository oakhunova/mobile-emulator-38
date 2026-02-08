package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:auth.properties",
        "classpath:${mode}.properties"
})

public interface BrowserstackConfig extends Config {
    @Key("bsUsername")
    String getUsername();

    @Key("bsKey")
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