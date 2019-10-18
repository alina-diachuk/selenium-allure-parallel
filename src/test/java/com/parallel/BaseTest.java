package com.parallel;

import com.framework.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver wd;
    public WebDriverWait wait;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        if (tlDriver.get() != null) {
            wd = tlDriver.get();
            wait = new WebDriverWait(wd,10);
            return;
        }

        wd = new ChromeDriver(opt);
        wait = new WebDriverWait(wd,10);

        tlDriver.set(wd);
        wd.get(Constants.URL);
    }

    @After
    public void tearDown() {
        wd.manage().deleteAllCookies();
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    wd.quit();
                    wd = null;
                }));    }
}
