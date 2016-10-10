package my.learning_java.addressbook.appmanager;

import my.learning_java.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupPage(GroupData groupDate) {
        type(By.name("group_name"), groupDate.getNameGroup());
        type(By.name("group_header"), groupDate.getGroupHeader());
        type(By.name("group_footer"), groupDate.getGroupFooter());
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

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupPage(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getGroupId());
        submitEditGroup();
        fillGroupPage(group);
        submitGroupUpdate();
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getGroupId());
        deleteSelectedGroup();
        returnToGroupPage();
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withName(name).withHeader(null).withFooter(null).withId(id));
        }
        return groups;
    }


}

