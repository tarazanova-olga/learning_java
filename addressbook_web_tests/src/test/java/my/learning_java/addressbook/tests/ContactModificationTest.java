package my.learning_java.addressbook.tests;


import my.learning_java.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test

    public void testContactModificationTest () {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "89651231123",
                    "test@test.test", "ул. Мира, д.123", "Новая группа"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().fillContactPage(new ContactData("Мария", "Ивановна", "Сидорова", "89651231111",
                "test@test.test2", "ул. Мира, д.10", null), false);
        app.getContactHelper().updateContactPage();
        app.getContactHelper().returnToHomePage();

    }

}
