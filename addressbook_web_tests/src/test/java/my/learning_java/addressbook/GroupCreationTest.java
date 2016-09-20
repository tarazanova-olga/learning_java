package my.learning_java.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreationTest() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupPage(new GroupData("Новая группа", "тест", "тест"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
