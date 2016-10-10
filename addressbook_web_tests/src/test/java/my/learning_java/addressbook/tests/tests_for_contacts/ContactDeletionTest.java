package my.learning_java.addressbook.tests.tests_for_contacts;


import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().HomePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов")
                            .withPhone("89651231123").withEmail("test@test.test").withAddress("ул. Мира, д.123").withGroup("Новая группа"));
        }
    }

    @Test
    public void testDeletionTest() {
        Set<ContactData> before =  app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.closeWindow();
        app.goTo().HomePage();
        Set<ContactData> after =  app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }

}
