package my.learning_java.addressbook.tests.tests_for_groups;


import my.learning_java.addressbook.model.GroupData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().GroupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModificationTest(){
        Set<GroupData> before = app.group().all();
        GroupData modifyGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifyGroup.
                getGroupId()).withName("name").withHeader("header").withFooter("footer");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifyGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }

}
