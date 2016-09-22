package my.learning_java.addressbook.tests;


import my.learning_java.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test

    public void testGroupModificationTest()
    {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().submitEditGroup();
        app.getGroupHelper().fillGroupPage(new GroupData("Измененное название группы", "изменение1", "изменение2"));
        app.getGroupHelper().submitGroupUpdate();
        app.getGroupHelper().returnToGroupPage();
    }
}
