package com.qa.TickerTape.StepDefination;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.GemJarUtils;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;


public class TickerTapeHook {
    @Before
    public void start() throws GemException {
//        DriverManager.setUpBrowser();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox");
        DriverManager.initializeChrome(options);
        DriverAction.maximizeToDefaultBrowserSize();
        DriverAction.launchUrl(GemJarUtils.getGemJarConfigData("launch_url"));
        DriverAction.setImplicitTimeOut(Long.parseLong(GemJarGlobalVar.implicitTime));
        DriverAction.setPageLoadTimeOut(Long.parseLong(GemJarGlobalVar.pageTimeout));
        DriverAction.setScriptTimeOut(Long.parseLong(GemJarGlobalVar.scriptTimeout));
    }
}
