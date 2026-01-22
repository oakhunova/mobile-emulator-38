package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${mode}.properties")
public interface EmulatorConfig extends Config {

    @Key("device.name")
    @DefaultValue("Pixel 4")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

}