package neon.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;

    public static final String XPATH_EMAIL = "//input[contains(@name, 'email')]";
    private static final String XPATH_PASSWORD = "//input[contains(@name, 'password')]";
    private static final String XPATH_SUBMIT = "//button[contains(@name, 'submit_button')]";

    public MyAccountPage fillEmail(String email) {
        driver.findElement(By.xpath(XPATH_EMAIL)).sendKeys(email);
        return this;
    }

    public MyAccountPage fillPassword(String password) {
        driver.findElement(By.xpath(XPATH_PASSWORD)).sendKeys(password);
        return this;
    }

    public MyAccountPage clickSubmit() {
        driver.findElement(By.xpath(XPATH_SUBMIT)).click();
        return this;
    }

    public String getValueByXpath(String xpathEmail) {
        return null;
    }
}
