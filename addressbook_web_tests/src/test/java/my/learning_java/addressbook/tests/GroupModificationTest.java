package my.learning_java.addressbook.tests;


import my.learning_java.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test

    public void testGroupModificationTest()
    {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereGroup()){
            app.getGroupHelper().createGroup(new GroupData("Новая группа", null, null));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().submitEditGroup();
        app.getGroupHelper().fillGroupPage(new GroupData("Новая группа", "изменение1", "изменение2"));
        app.getGroupHelper().submitGroupUpdate();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
