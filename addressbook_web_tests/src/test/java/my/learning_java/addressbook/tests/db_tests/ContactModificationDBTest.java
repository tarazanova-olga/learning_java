package my.learning_java.addressbook.tests.db_tests;

import my.learning_java.addressbook.model.db_model.ContactDataDB;
import my.learning_java.addressbook.model.db_model.ContactsDB;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationDBTest extends TestBase {

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().HomePage();
        if (app.contactDB().all().size() == 0) {
            app.contactDB().createContact(new ContactDataDB().withName("Иван").withMiddleName("Иванович").withLastName("Иванов")
                    .withHomePhone("89651231123").withEmail("test@test.test").withAddress("ул. Мира, д.123").withGroup("Новая группа"));
        }
    }

    @Test
    public void testContactModificationTest () {
        ContactsDB before =  app.contactDB().all();
        ContactDataDB modifyContact = before.iterator().next();
        ContactDataDB newContact = new ContactDataDB().withName("Мария").withMiddleName("Ивановна").withLastName("Сидорова")
                .withHomePhone("89651231111").withEmail("test@test.test2").withAddress("ул. Мира, д.10")
                .withGroup("null").withId(modifyContact.getContactId());
        app.contactDB().modify(newContact);
        assertThat(app.contactDB().count(), equalTo(before.size()));
        ContactsDB after =  app.contactDB().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifyContact).withAdded(newContact)));
    }
}
