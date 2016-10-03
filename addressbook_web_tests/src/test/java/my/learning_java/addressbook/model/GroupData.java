package my.learning_java.addressbook.model;


public class GroupData {
    private final String nameGroup;
    private final String groupHeader;
    private final String groupFooter;
    private int groupId;

    public GroupData(String nameGroup, String groupHeader, String groupFooter, int groupId) {
        this.nameGroup = nameGroup;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
        this.groupId = groupId;
    }

    public GroupData(String nameGroup, String groupHeader, String groupFooter) {
        this.groupId = Integer.MAX_VALUE;
        this.nameGroup = nameGroup;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }


    public int getGroupId() {
        return groupId;
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

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "nameGroup='" + nameGroup + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return nameGroup != null ? nameGroup.equals(groupData.nameGroup) : groupData.nameGroup == null;

    }

    @Override
    public int hashCode() {
        return nameGroup != null ? nameGroup.hashCode() : 0;
    }

}
