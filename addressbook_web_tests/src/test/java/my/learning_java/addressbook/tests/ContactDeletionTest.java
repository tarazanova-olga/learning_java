package my.learning_java.addressbook.tests;


import my.learning_java.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeletionTest() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "89651231123",
                    "test@test.test", "ул. Мира, д.123", "Новая группа"));
        }
        List<ContactData> before =  app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.closeWindow();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after =  app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
