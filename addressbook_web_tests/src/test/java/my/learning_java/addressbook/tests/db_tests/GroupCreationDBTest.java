package my.learning_java.addressbook.tests.db_tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import my.learning_java.addressbook.model.db_model.GroupDataDB;
import my.learning_java.addressbook.model.db_model.GroupsDB;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationDBTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroupsFromJSON() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.json"));) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupDataDB> groups = gson.fromJson(json, new TypeToken<List<GroupDataDB>>() {
            }.getType()); // аналогия List<GroupData>.class
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }


    @Test(dataProvider = "validGroupsFromJSON")
    public void testGroupCreationTest(GroupDataDB group) {
        app.goTo().GroupPage();
        GroupsDB before = app.db().groups();
        app.groupDB().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        GroupsDB after = app.db().groups();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo
                (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getGroupId()).max().getAsInt()))));
        verifyGroupListInUI();
    }
}
