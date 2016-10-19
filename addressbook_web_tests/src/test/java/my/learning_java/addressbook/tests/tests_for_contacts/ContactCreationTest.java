package my.learning_java.addressbook.tests.tests_for_contacts;

import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.model.Contacts;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreationTest() {
        app.goTo().HomePage();
        Contacts before =  app.contact().all();
        File photo = new File("src/test/resources/ленин.jpg");
        ContactData contact = new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов").withHomePhone("89651231123")
                .withEmail("test@test.test").withAddress("ул. Мира, д.123").withPhoto(photo);
        app.contact().createContact(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after =  app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo
                (before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getContactId()).max().getAsInt()))));
    }

    //определение текущей директории  и проверка существования файла
    @Test(enabled = false)
    public void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/ленин.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
