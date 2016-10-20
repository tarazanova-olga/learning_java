package my.learning_java.addressbook.tests.tests_for_contacts;

import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.model.Contacts;
import my.learning_java.addressbook.model.GroupData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

   @DataProvider
    public Iterator<Object[]> validContacts(){
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/ленин.jpg");
        list.add(new Object[] {new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов").withHomePhone("89651231123")
                .withEmail("test@test.test").withAddress("ул. Мира, д.123").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов").withHomePhone("89651231123")
                .withEmail("test@test.test").withAddress("ул. Мира, д.123").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов").withHomePhone("89651231123")
                .withEmail("test@test.test").withAddress("ул. Мира, д.123").withPhoto(photo)});
        return list.iterator();
    }


/*   @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[]{ new ContactData().withName(split[0]).withMiddleName(split[1]).withLastName(split[2])
                    .withHomePhone(split[3]).withEmail(split[4]).withAddress(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
*/
    @Test(dataProvider = "validContacts")
    public void testContactCreationTest(ContactData contact) {
        app.goTo().HomePage();
        Contacts before =  app.contact().all();
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
