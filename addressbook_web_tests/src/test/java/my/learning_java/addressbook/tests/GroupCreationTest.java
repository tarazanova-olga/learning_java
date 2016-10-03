package my.learning_java.addressbook.tests;

import my.learning_java.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreationTest() {
          app.getNavigationHelper().gotoGroupPage();
          List<GroupData> before = app.getGroupHelper().getGroupList();
          GroupData group = new GroupData("Новая группа2", "null", "null");
          app.getGroupHelper().createGroup(group);
          List<GroupData> after = app.getGroupHelper().getGroupList();
          Assert.assertEquals(after.size(), before.size() + 1);

          before.add(group);
          Comparator<? super GroupData> byGroupId = (g1, g2) -> Integer.compare(g1.getGroupId(), g2.getGroupId());
          before.sort(byGroupId);
          after.sort(byGroupId);
          Assert.assertEquals(before, after);
    }
}
