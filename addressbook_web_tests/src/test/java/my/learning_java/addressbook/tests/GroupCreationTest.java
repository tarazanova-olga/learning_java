package my.learning_java.addressbook.tests;

import my.learning_java.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
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

          group.setGroupId(after.stream().max((o1, o2) -> Integer.compare(o1.getGroupId(), o2.getGroupId())).get().getGroupId());
          before.add(group);
          Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
