package my.learning_java.addressbook.tests.tests_for_groups;

import my.learning_java.addressbook.model.GroupData;
import my.learning_java.addressbook.model.Groups;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer 1")});
        list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer 2")});
        list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer 3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreationTest(GroupData group) {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo
                (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getGroupId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreationTest() {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test'").withFooter("123").withHeader("987");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
