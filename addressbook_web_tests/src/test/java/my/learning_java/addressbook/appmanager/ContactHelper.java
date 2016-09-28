package my.learning_java.addressbook.appmanager;

import my.learning_java.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {super(wd);
    }

    public void submitContactPage() {click(By.name("submit"));}

    public void updateContactPage() {click(By.name("update"));}

    public void fillContactPage(ContactData contactData, boolean creation)
    {
        type(By.name("firstname"), contactData.getNameContact());
        type(By.name("middlename"), contactData.getMiddleNameContact());
        type(By.name("lastname"), contactData.getLastNameContact());
        type(By.name("home"), contactData.getPhoneContact());
        type(By.name("email"), contactData.getEmailContact());
        type(By.name("address"), contactData.getAddressContact());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {click(By.linkText("add new"));}

    public void returnToHomePage() {click(By.linkText("home page"));}

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact (){
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void editSelectedContact () {click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));}


    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactPage(contact, true);
        submitContactPage();
        returnToHomePage();
    }

}
