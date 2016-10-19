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
                    .withHomePhone("89651231123").withEmail("test@test.test").withAddress("ул. Мира, д.123"));
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
        String homePhone = contact.getHomePhone();
        if (homePhone != null && !homePhone.isEmpty()){
            homePhone = "H:" + homePhone;
        }
        String mobilePhone = contact.getMobilePhone();
        if (mobilePhone != null && !mobilePhone.isEmpty() ){
            mobilePhone = "M:" + mobilePhone;
        }
        String workPhone = contact.getWorkPhone();
        if (workPhone != null && !workPhone.isEmpty()){
            workPhone = "W:" + workPhone;
        }
        String email = contact.getEmail();
        if (email != null && !email.isEmpty()){
            email = email + "www."+ email.substring(email.indexOf("@")+1);
        }
        String email2 = contact.getEmail2();
        if (email2 != null && !email2.isEmpty()){
            email2 = email2 + "www."+ email2.substring(email2.indexOf("@")+1);
        }
        String email3 = contact.getEmail3();
        if (email3 != null && !email3.isEmpty()){
            email3 = email3 + "www."+ email3.substring(email3.indexOf("@")+1);
        }

        return Arrays.asList((contact.getName()), contact.getMiddleName(), contact.getLastName()
                , contact.getAddress(), homePhone, mobilePhone, workPhone,
                email, email2, email3)
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