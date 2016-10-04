package my.learning_java.addressbook.tests.tests_for_contacts;


import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test

    public void testContactModificationTest () {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "89651231123",
                    "test@test.test", "ул. Мира, д.123", "Новая группа"));
        }
        List<ContactData> before =  app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().editSelectedContact();
        ContactData newContact = new ContactData("Мария", "Ивановна", "Сидорова", "89651231111",
                "test@test.test2", "ул. Мира, д.10", null, before.get(before.size() - 1).getContactId());
        app.getContactHelper().fillContactPage(newContact, false);
        app.getContactHelper().updateContactPage();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after =  app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(newContact);
        Comparator<? super ContactData> byContactId = (g1, g2) -> Integer.compare(g1.getContactId(), g2.getContactId());
        before.sort(byContactId);
        after.sort(byContactId);
        Assert.assertEquals(before, after);
    }
}
