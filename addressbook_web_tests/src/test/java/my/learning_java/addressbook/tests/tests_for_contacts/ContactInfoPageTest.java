package my.learning_java.addressbook.tests.tests_for_contacts;


import my.learning_java.addressbook.model.ContactData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoPageTest extends TestBase{

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().HomePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().withName("Иван").withMiddleName("Иванович").withLastName("Иванов")
                    .withHomePhone("89651231123").withEmail("test@test.test").withAddress("ул. Мира, д.123").withGroup("Новая группа"));
        }
    }

    // (enable = false)
    @Test
    public void testContactPage(){
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next(); //загружаем множество контактов
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        ContactData contactInfoFromInfoForm = app.contact().infoFromInfoForm(contact);
        assertThat(cleaned(mergeAllContactInfoFromEditForm(contactInfoFromEditForm)),
                equalTo(cleaned(mergeAllContactInfoFromInfoForm(contactInfoFromInfoForm))));

    }

    private String mergeAllContactInfoFromEditForm(ContactData contact) {
        String getHomePhone = contact.getHomePhone();
        if (getHomePhone != null){
            getHomePhone = "H:" + getHomePhone;
        }
        String getMobilePhone = contact.getMobilePhone();
        if (getMobilePhone != null){
            getMobilePhone = "M:" + getMobilePhone;
        }
        String getWorkPhone = contact.getWorkPhone();
        if (getWorkPhone != null){
            getWorkPhone = "W:" + getWorkPhone;
        }
        String getEmail = contact.getEmail();
        if (getEmail != null){
            getEmail = getEmail + "www."+ getEmail.substring(getEmail.indexOf("@")+1);
        }
        String getEmail2 = contact.getEmail2();
        if (getEmail2 != null){
            getEmail2 = getEmail2 + "www."+ getEmail2.substring(getEmail2.indexOf("@")+1);
        }
        String getEmail3 = contact.getEmail3();
        if (getEmail3 != null){
            getEmail3 = getEmail3 + "www."+ getEmail3.substring(getEmail3.indexOf("@")+1);
        }


        return Arrays.asList((contact.getName()), contact.getMiddleName(), contact.getLastName()
                , contact.getAddress(), getHomePhone, getMobilePhone, getWorkPhone,
                getEmail, getEmail2, getEmail3)
                .stream().filter((s) -> s != null && !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeAllContactInfoFromInfoForm(ContactData contact) {
        return Arrays.asList(contact.getAllInfo())
                .stream().filter((s) -> s != null && !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public  static String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("\n","");
    }
}