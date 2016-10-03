package my.learning_java.addressbook.tests;


import my.learning_java.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test

    public void testGroupModificationTest()
    {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereGroup()){
            app.getGroupHelper().createGroup(new GroupData("Новая группа", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().submitEditGroup();
        GroupData group = new GroupData("Новая группа", "изменение1", "изменение2", before.get(before.size() - 1).getGroupId());
        app.getGroupHelper().fillGroupPage(group);
        app.getGroupHelper().submitGroupUpdate();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> byGroupId = (g1, g2) -> Integer.compare(g1.getGroupId(), g2.getGroupId());
        before.sort(byGroupId);
        after.sort(byGroupId);
        Assert.assertEquals(before, after);
    }
}
