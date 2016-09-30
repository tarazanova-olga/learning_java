package my.learning_java.addressbook.tests;

import my.learning_java.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreationTest() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("Новая группа", null, null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }
}
