package my.learning_java.addressbook.appmanager;

import my.learning_java.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {super(wd);
    }

    public void submitContactPage() {
        click(By.xpath("//div[@id='content']/form/input[21]"));

    }

    public void fillContactPage(ContactData contactData)
    {
        type(By.name("firstname"), contactData.getNameContact());
        type(By.name("middlename"), contactData.getMiddleNameContact());
        type(By.name("lastname"), contactData.getLastNameContact());
        type(By.name("home"), contactData.getPhoneContact());
        type(By.name("email"), contactData.getEmailContact());
        type(By.name("address"), contactData.getAddressContact());

    }

    public void initContactCreation() {
        click(By.linkText("add new"));

    }

    public void returnToHomePage() {
        click(By.linkText("home page"));

    }
}
