package my.learning_java.addressbook.tests;


import my.learning_java.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeletionTest() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "89651231123",
                    "test@test.test", "ул. Мира, д.123", "Новая группа"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.closeWindow();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }

}
