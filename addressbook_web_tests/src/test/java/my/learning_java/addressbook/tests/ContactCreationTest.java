package my.learning_java.addressbook.tests;

import my.learning_java.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreationTest() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before =  app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Иван", "Иванович", "Иванов", "89651231123",
                "test@test.test", "ул. Мира, д.123", "Новая группа");
        app.getContactHelper().createContact(contact);
        List<ContactData> after =  app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byContactId = (g1, g2) -> Integer.compare(g1.getContactId(), g2.getContactId());
        before.sort(byContactId);
        after.sort(byContactId);
        Assert.assertEquals(before, after);
    }

}
