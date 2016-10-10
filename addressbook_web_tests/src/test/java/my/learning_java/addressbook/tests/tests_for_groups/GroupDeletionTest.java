package my.learning_java.addressbook.tests.tests_for_groups;

import my.learning_java.addressbook.model.GroupData;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().GroupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test2").withFooter("null").withHeader("null"));
        }
    }

    @Test
    public void testGroupDeletionTest() {
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }
}
    

