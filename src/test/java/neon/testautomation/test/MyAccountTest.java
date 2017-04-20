package neon.testautomation.test;

import static neon.testautomation.properties.ConfigProperties.CUSTOMER_EMAIL;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_PASSWORD;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import neon.testautomation.message.Message;
import neon.testautomation.page.MyAccountPage;

public class MyAccountTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String SITE_SUBMARINO = "http://www.submarino.com.br";

    @Before
    public void openBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/brodrigo/Documentos/Ferramentas/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
        driver.navigate().to(SITE_SUBMARINO);
    }

    @Test
    public void accountAccess() throws InterruptedException, IOException {

        MyAccountPage account = new MyAccountPage();

      //@formatter:off
        account.fillEmail(Message.getProperties().getProperty(CUSTOMER_EMAIL));
        
        String loginuser = account.getValueByXpath(MyAccountPage.XPATH_EMAIL);
        assertNotNull(loginuser);
        assertFalse(loginuser.isEmpty());
      //@formatter:on

     //@formatter:off
        account.fillPassword(Message.getProperties().getProperty(CUSTOMER_PASSWORD))
               .clickSubmit();
        //@formatter:on
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}