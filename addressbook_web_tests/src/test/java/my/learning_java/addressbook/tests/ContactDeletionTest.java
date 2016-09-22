package my.learning_java.addressbook.tests;


import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeletionTest()
    {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.closeWindow();
    }


}
