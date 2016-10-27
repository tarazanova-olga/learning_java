package my.learning_java.addressbook.appmanager;

import my.learning_java.addressbook.model.db_model.GroupDataDB;
import my.learning_java.addressbook.model.db_model.GroupsDB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelperDB extends BaseHelper {

    public GroupHelperDB(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupPage(GroupDataDB groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getGroupHeader());
        type(By.name("group_footer"), groupDate.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }


    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
                }

    public void submitEditGroup () {click(By.name("edit"));}

    public void submitGroupUpdate () {click(By.name("update"));}

    public void create(GroupDataDB group) {
        initGroupCreation();
        fillGroupPage(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupDataDB group) {
        selectGroupById(group.getGroupId());
        submitEditGroup();
        fillGroupPage(group);
        submitGroupUpdate();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(GroupDataDB group) {
        selectGroupById(group.getGroupId());
        deleteSelectedGroup();
        groupCache = null;
        returnToGroupPage();
    }

    private GroupsDB groupCache = null;


    public GroupsDB all() {
        if (groupCache != null){
            return new GroupsDB(groupCache);
        }
        groupCache = new GroupsDB();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupDataDB().withId(id).withName(name));
        }
        return new GroupsDB(groupCache);
    }

    public int count() {
        return  wd.findElements(By.name("selected[]")).size();
    }
}

