package my.learning_java.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletionTest() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroup();
        returnToGroupPage();
    }

}
    

