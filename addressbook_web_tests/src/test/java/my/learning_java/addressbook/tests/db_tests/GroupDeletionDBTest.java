package my.learning_java.addressbook.tests.db_tests;

import my.learning_java.addressbook.model.db_model.GroupDataDB;
import my.learning_java.addressbook.model.db_model.GroupsDB;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionDBTest extends TestBase {

    @BeforeMethod
    public  void ensurePrecondition() {
        app.goTo().GroupPage();
        if (app.groupDB().all().size() == 0) {
            app.groupDB().create(new GroupDataDB().withName("test2").withFooter("null").withHeader("null"));
        }
    }

    @Test
    public void testGroupDeletionTest() {
        GroupsDB before = app.groupDB().all();
        GroupDataDB deletedGroup = before.iterator().next();
        app.groupDB().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        GroupsDB after = app.groupDB().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.withOut(deletedGroup)));
    }
}
    

