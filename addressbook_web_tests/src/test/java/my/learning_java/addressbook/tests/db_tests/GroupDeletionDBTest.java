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
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.groupDB().create(new GroupDataDB().withName("test1").withHeader(null).withFooter(null));
        }
    }

    @Test
    public void testGroupDeletionTest() {
        GroupsDB before = app.db().groups();
        app.goTo().GroupPage();
        GroupDataDB deletedGroup = before.iterator().next();
        app.groupDB().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        GroupsDB after = app.db().groups();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.withOut(deletedGroup)));
    }
}
    

