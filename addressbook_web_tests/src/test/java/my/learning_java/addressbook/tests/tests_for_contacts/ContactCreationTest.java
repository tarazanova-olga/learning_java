package my.learning_java.addressbook.tests.tests_for_contacts;

import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreationTest() {
        app.goTo().HomePage();
        Set<ContactData> before =  app.contact().all();
        ContactData contact = new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов").withPhone("89651231123")
                .withEmail("test@test.test").withAddress("ул. Мира, д.123").withGroup("Новая группа");
        app.contact().createContact(contact);
        Set<ContactData> after =  app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((g) -> g.getContactId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
