package neon.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerRegistryPage {

    private WebDriver driver;

    private static final String CLASS_NEW_REGISTER = "usr-signup";
    private static final String XPATH_EMAIL = "//input[contains(@name, 'email')]";
    private static final String XPATH_PASSWORD = "(//input[contains(@name, 'password')])[1]";
    private static final String XPATH_PASSWORD_CONFIRM = "//input[contains(@name, 'password_repeat')]";
    private static final String XPATH_NAME = "//input[contains(@name, 'name')]";
    private static final String XPATH_GENDER = "//input[contains(@id, 'gender_male')]";
    public static final String XPATH_CPF = "//input[contains(@name, 'cpf')]";
    private static final String XPAHT_BIRTHDAY = "//input[contains(@name, 'birthday')]";
    private static final String XPATH_PHONE = "//input[contains(@name, 'tel')]";
    private static final String XPATH_ZIPCODE = "//input[contains(@name, 'cep')]";
    public static final String XPATH_ADDRESS_NUMBER = "//input[contains(@name, 'number')]";
    private static final String XPATH_REFERENCE = "//input[contains(@name, 'reference')]";
    private static final String XPATH_SUBMIT = "//button[contains(@name, 'submit_button')]";

    public CustomerRegistryPage clickNewRegister() {
        driver.findElement(By.xpath(CLASS_NEW_REGISTER)).click();
        return this;
    }

    public CustomerRegistryPage fillEmail(String email) {
        driver.findElement(By.xpath(XPATH_EMAIL)).sendKeys(email);
        return this;
    }

    public CustomerRegistryPage fillPassword(String password) {
        driver.findElement(By.xpath(XPATH_PASSWORD)).sendKeys(password);
        return this;
    }

    public CustomerRegistryPage fillPasswordConfirm(String passwordConfirm) {
        driver.findElement(By.xpath(XPATH_PASSWORD_CONFIRM)).sendKeys(passwordConfirm);
        return this;
    }

    public CustomerRegistryPage fillName(String name) {
        driver.findElement(By.xpath(XPATH_NAME)).sendKeys(name);
        return this;
    }

    public CustomerRegistryPage clickGender() {
        driver.findElement(By.xpath(XPATH_GENDER)).click();
        return this;
    }

    public CustomerRegistryPage fillCPF(String cpf) {
        driver.findElement(By.xpath(XPATH_CPF)).sendKeys(cpf);
        return this;
    }

    public CustomerRegistryPage fillBirthday(String birthday) {
        driver.findElement(By.xpath(XPAHT_BIRTHDAY)).sendKeys(birthday);
        return this;
    }

    public CustomerRegistryPage fillPhone(String phone) {
        driver.findElement(By.xpath(XPATH_PHONE)).sendKeys(phone);
        return this;
    }

    public CustomerRegistryPage fillZipCode(String zipCode) {
        driver.findElement(By.xpath(XPATH_ZIPCODE)).sendKeys(zipCode);
        return this;
    }

    public CustomerRegistryPage fillNumber(String number) {
        driver.findElement(By.xpath(XPATH_ADDRESS_NUMBER)).sendKeys(number);
        return this;
    }

    public CustomerRegistryPage fillReference(String address) {
        driver.findElement(By.xpath(XPATH_REFERENCE)).sendKeys(address);
        return this;
    }

    public CustomerRegistryPage clickSubmit() {
        driver.findElement(By.xpath(XPATH_SUBMIT)).click();
        return this;
    }

    public String getValueByXpath(String xpathCpf) {
        return null;
    }
}
