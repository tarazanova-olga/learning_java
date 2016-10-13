package my.learning_java.addressbook.appmanager;

import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedContact (){
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }


    public void editSelectedContact (int id) {
        wd.findElement((By.cssSelector("a[href='edit.php?id=" + id + "']"))).click();
      //  WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
      //  WebElement row = checkbox.findElement(By.xpath("./../.."));
      //  List<WebElement> cells = row.findElements(By.tagName("td"));
      //  cells.get(7).findElement(By.tagName("a")).click();

    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactPage(contact, true);
        submitContactPage();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        editSelectedContact(contact.getContactId());
        fillContactPage(contact, false);
        updateContactPage();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getContactId());
        deleteSelectedContact();
        contactCache = null;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry")); // возвращение списка строк контактов
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td")); // разделяем строки на отдельные ячейки
            String name = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withName(name).withMiddleName(null).withLastName(lastname)
                    .withGroup(null).withAddress(null).withPhone(null).withEmail(null).withId(id));
        }

        return new Contacts(contactCache);
    }


    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }
}


