package my.learning_java.addressbook.tests.tests_for_groups;

import my.learning_java.addressbook.model.GroupData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreationTest() {
          app.goTo().GroupPage();
          Set<GroupData> before = app.group().all();
          GroupData group = new GroupData().withName("test").withFooter("123").withHeader("987");
          app.group().create(group);
          Set<GroupData> after = app.group().all();
          Assert.assertEquals(after.size(), before.size() + 1);

          group.withId(after.stream().mapToInt((g) -> g.getGroupId()).max().getAsInt());
          before.add(group);
          Assert.assertEquals(before, after);
    }
}
