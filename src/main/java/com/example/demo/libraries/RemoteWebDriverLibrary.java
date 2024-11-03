package com.example.demo.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.URL;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverLibrary {

    @Value("${grid.url}")
    private URL remoteUrl;


    @Value("${browser}")
    private String browser;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Scope("driverscope")
    public WebDriver getRemoteWebDriverForChrome() {
        return new RemoteWebDriver(remoteUrl, new FirefoxOptions());
//        return new RemoteWebDriver(remoteUrl, new ChromeOptions());
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Scope("driverscope")
    public WebDriver getRemoteWebDriverForFirefox() {
        return new RemoteWebDriver(remoteUrl, new ChromeOptions());
    }

}
