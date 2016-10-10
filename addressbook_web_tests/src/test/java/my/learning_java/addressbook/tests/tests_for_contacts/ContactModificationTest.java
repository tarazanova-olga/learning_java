package my.learning_java.addressbook.tests.tests_for_contacts;


import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().HomePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов")
                    .withPhone("89651231123").withEmail("test@test.test").withAddress("ул. Мира, д.123").withGroup("Новая группа"));
        }
    }

    @Test
    public void testContactModificationTest () {
        Set<ContactData> before =  app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData newContact = new ContactData().withName("Мария").withMiddleName("Ивановна").withLastName("Сидорова")
                .withPhone("89651231111").withEmail("test@test.test2").withAddress("ул. Мира, д.10")
                .withGroup("null").withId(modifyContact.getContactId());
        app.contact().modify(newContact);
        Set<ContactData> after =  app.contact().all();
        Assert.assertEquals(after.size(), before.size());


        before.remove(modifyContact);
        before.add(newContact);
        Assert.assertEquals(before, after);
    }
}
