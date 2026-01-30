package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${mode}.properties")
public interface EmulatorConfig extends Config {

    @Key("device")
    @DefaultValue("Pixel 4")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

}