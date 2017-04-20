package neon.testautomation.test;

import static neon.testautomation.properties.ConfigProperties.CUSTOMER_EMAIL;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_PASSWORD;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_PASSWORD_CONFIRM;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_NAME;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_BIRTHDAY;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_PHONE;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_ZIPCODE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static neon.testautomation.page.CustomerRegistryPage.XPATH_ADDRESS_NUMBER;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_NUMBER;
import static neon.testautomation.properties.ConfigProperties.CUSTOMER_REFERENCES;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import neon.testautomation.document.DocumentGenerator;
import neon.testautomation.message.Message;
import neon.testautomation.page.CustomerRegistryPage;

public class CustomerRegistryTest {

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
    public void userRegistration() throws InterruptedException, IOException {

        CustomerRegistryPage customer = new CustomerRegistryPage();

        final String cpf = DocumentGenerator.createCPF();

      //@formatter:off
        customer.clickNewRegister()
                .fillEmail(Message.getProperties().getProperty(CUSTOMER_EMAIL))
                .fillPassword(Message.getProperties().getProperty(CUSTOMER_PASSWORD))
                .fillPasswordConfirm(Message.getProperties().getProperty(CUSTOMER_PASSWORD_CONFIRM))
                .fillName(Message.getProperties().getProperty(CUSTOMER_NAME))
                .clickGender()
                .fillCPF(cpf);
                
                String cpfPreenchido = customer.getValueByXpath(CustomerRegistryPage.XPATH_CPF);
                assertNotNull(cpfPreenchido);
                assertFalse(cpfPreenchido.isEmpty());
                assertEquals(cpf, cpfPreenchido.replaceAll("[^0-9]+", ""));
       //@formatter:on

      //@formatter:off         
        customer.fillBirthday(Message.getProperties().getProperty(CUSTOMER_BIRTHDAY))
                .fillPhone(Message.getProperties().getProperty(CUSTOMER_PHONE))
                .fillZipCode(Message.getProperties().getProperty(CUSTOMER_ZIPCODE));
      //@formatter:on

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_ADDRESS_NUMBER)));

      //@formatter:off
        customer.fillNumber(Message.getProperties().getProperty(CUSTOMER_NUMBER))
                .fillReference(Message.getProperties().getProperty(CUSTOMER_REFERENCES))
                .clickSubmit();
      //@formatter:on
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}