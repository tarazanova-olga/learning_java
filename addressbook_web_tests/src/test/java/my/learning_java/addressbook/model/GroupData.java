package my.learning_java.addressbook.model;


public class GroupData {
    private String nameGroup;
    private String groupHeader;
    private String groupFooter;
    private int groupId = Integer.MAX_VALUE;


    public int getGroupId() {
        return groupId;
    }

    public String getNameGroup() {

        return nameGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (groupId != groupData.groupId) return false;
        return nameGroup != null ? nameGroup.equals(groupData.nameGroup) : groupData.nameGroup == null;

    }

    @Override
    public int hashCode() {
        int result = nameGroup != null ? nameGroup.hashCode() : 0;
        result = 31 * result + groupId;
        return result;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public GroupData withName(String nameGroup) {
        this.nameGroup = nameGroup;
        return this;
    }

    public GroupData withHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

    public GroupData withId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "nameGroup='" + nameGroup + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }

}
