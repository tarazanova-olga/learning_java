package my.learning_java.addressbook.tests.db_tests;

import my.learning_java.addressbook.model.db_model.GroupDataDB;
import my.learning_java.addressbook.model.db_model.GroupsDB;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationDBTest extends TestBase {

    @BeforeMethod
    public  void ensurePrecondition() {
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.groupDB().create(new GroupDataDB().withName("test1"));
        }
    }

    @Test
    public void testGroupModificationTest(){
        GroupsDB before = app.db().groups();
        GroupDataDB modifyGroup = before.iterator().next();
        GroupDataDB group = new GroupDataDB().withId(modifyGroup.
                getGroupId()).withName("name").withHeader("header").withFooter("footer");
        app.goTo().GroupPage();
        app.groupDB().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        GroupsDB after = app.db().groups();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifyGroup).withAdded(group)));
    }
}
