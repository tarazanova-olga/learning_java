package my.learning_java.addressbook.model.db_model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@XStreamAlias("group")
@Entity //связь с БД
@javax.persistence.Table(name = "group_list")

public class GroupDataDB {
    @Expose //для указания, какие параметры нужны в json
    @Column(name="group_name")
    private String nameGroup;
    @Expose
    @Column(name="group_header")
    @Type(type = "text")
    private String groupHeader;
    @Expose
    @Column(name="group_footer")
    @Type(type = "text") //явное указание типа столбца
    private String groupFooter;
    @XStreamOmitField // для указания, что нам не нужно в xml
    @Id
    @Column(name="group_id")
    private int groupId = Integer.MAX_VALUE;


    public int getGroupId() {
        return groupId;
    }

    public String getName() {

        return nameGroup;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getFooter() {
        return groupFooter;
    }

    public GroupDataDB withName(String nameGroup) {
        this.nameGroup = nameGroup;
        return this;
    }

    public GroupDataDB withHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupDataDB withFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

    public GroupDataDB withId(int groupId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupDataDB that = (GroupDataDB) o;

        if (groupId != that.groupId) return false;
        if (nameGroup != null ? !nameGroup.equals(that.nameGroup) : that.nameGroup != null) return false;
        if (groupHeader != null ? !groupHeader.equals(that.groupHeader) : that.groupHeader != null) return false;
        return groupFooter != null ? groupFooter.equals(that.groupFooter) : that.groupFooter == null;

    }

    @Override
    public int hashCode() {
        int result = nameGroup != null ? nameGroup.hashCode() : 0;
        result = 31 * result + (groupHeader != null ? groupHeader.hashCode() : 0);
        result = 31 * result + (groupFooter != null ? groupFooter.hashCode() : 0);
        result = 31 * result + groupId;
        return result;
    }
}
