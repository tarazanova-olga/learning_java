package my.learning_java.addressbook;

public class GroupData {
    private final String nameGroup;
    private final String groupHeader;
    private final String groupFooter;

    public GroupData(String nameGroup, String groupHeader, String groupFooter) {
        this.nameGroup = nameGroup;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public String getNameGroup() {

        return nameGroup;
    }

    public String getGroupHeader() {

        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }
}
