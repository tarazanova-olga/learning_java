package my.learning_java.addressbook.tests;

import my.learning_java.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreationTest() {

        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactPage(new ContactData("Иван", "Иванович", "Иванов", "89651231123", "test@test.test", "ул. Мира, д.123"));
        app.getContactHelper().submitContactPage();
        app.getContactHelper().returnToHomePage();
    }


}
