package my.learning_java.addressbook.appmanager;

import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {super(wd);
    }

    public void submitContactPage() {click(By.name("submit"));}

    public void updateContactPage() {click(By.name("update"));}

    public void fillContactPage(ContactData contactData, boolean creation)
    {
        type(By.name("firstname"), contactData.getName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
//        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation && contactData.getGroup() != null){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } //else {
 //           Assert.assertFalse(isElementPresent(By.name("new_group")));
 //       }
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
      //  wd.findElement((By.cssSelector(String.format("input[@value='%s']", id)))).click();

      //  WebElement checkbox = wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']"))).click();
      //  WebElement row = checkbox.findElement(By.xpath("./../.."));
      //  List<WebElement> cells = row.findElements(By.tagName("td"));
      //  cells.get(7).findElement(By.tagName("a")).click();

      //  wd.findElement((By.xpath(String.format("input[@value='%s']/../../td[8]/a", id)))).click();
      //  wd.findElement((By.xpath(String.format("//tr[.//input[@value='%s']/td[8]/a", id)))).click();

    }

    public void infoSelectedContact (int id){
        wd.findElement((By.cssSelector("a[href='view.php?id=" + id + "']"))).click();
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
            //String[] phones = cells.get(5).getText().split("\n");
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            String address = cells.get(3).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withName(name).withMiddleName(null).withLastName(lastname)
                    .withGroup(null).withId(id).withAddress(address)
                    .withAllPhones(allPhones).withAllEmails(allEmails));
        }

        return new Contacts(contactCache);
    }


    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public ContactData infoFromEditForm(ContactData contact) {
        editSelectedContact(contact.getContactId());
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
        return new ContactData().withId(contact.getContactId()).withName(name).withMiddleName(middlename).withLastName(lastname).
                withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone).withAddress(address)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    public ContactData infoFromInfoForm(ContactData contact) {
        infoSelectedContact(contact.getContactId());
        String allInfo = wd.findElement(By.id("content")).getText();

        wd.navigate().back();
        return new ContactData().withId(contact.getContactId()).withAllInfo(allInfo);
    }
}


