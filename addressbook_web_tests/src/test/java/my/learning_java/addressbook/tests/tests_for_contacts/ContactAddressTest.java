package my.learning_java.addressbook.tests.tests_for_contacts;


import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().HomePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов")
                    .withHomePhone("89651231123").withEmail("test@test.test").withAddress("ул. Мира, д.123").withGroup("Новая группа"));
        }
    }

    @Test
    public void testContactPage(){
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next(); //загружаем множество контактов
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddress()), equalTo(address((contactInfoFromEditForm))));
    }

    private String address (ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public  static String cleaned(String phone){return phone.replaceAll("\\s","");

    }
}
