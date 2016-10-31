package my.learning_java.addressbook.model.db_model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contacts")
@Entity
@javax.persistence.Table(name = "addressbook")

public class ContactDataDB {
    @Expose
    @Column(name="firstname")

    private String name;
    @Expose
    @Column(name="middlename")

    private String middleName;
    @Expose
    @Column(name="lastname")

    private String lastName;
    @Expose
    @Type(type = "text")
    @Column(name="home")
    private String homePhone;
    @Expose
    @Column(name="mobile")
    @Type(type = "text")
    private String mobilePhone;
    @Expose
    @Column(name="work")
    @Type(type = "text")
    private String workPhone;
    @Expose
    @Type(type = "text")
    @Column(name="email")
    private String email;
    @Expose
    @Type(type = "text")
    @Column(name="email2")
    private String email2;
    @Expose
    @Type(type = "text")
    @Column(name="email3")
    private String email3;
    @Expose
    @Column(name="address")
    @Type(type = "text")
    private String address;
    @XStreamOmitField
    @Id
    @Column(name="id")
    private int contactId = Integer.MAX_VALUE;
    @Expose
    @Transient
    private String allPhones;
    @Expose
    @Transient
    private String allEmails;
    @Expose
    @Transient
    private String allInfo;
    @Expose
    @Transient
    private File photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupDataDB> groups = new HashSet<GroupDataDB>();

    public ContactDataDB() {
    }

    public ContactDataDB withName(String nameContact) {
        this.name = nameContact;
        return this;
    }

    public ContactDataDB withMiddleName(String middleNameContact) {
        this.middleName = middleNameContact;
        return this;
    }

    public ContactDataDB withLastName(String lastNameContact) {
        this.lastName = lastNameContact;
        return this;
    }

    public ContactDataDB withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactDataDB withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }


    public ContactDataDB withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactDataDB withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactDataDB withEmail(String emailContact) {
        this.email = emailContact;
        return this;
    }

    public ContactDataDB withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactDataDB withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactDataDB withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactDataDB withAddress(String addressContact) {
        this.address = addressContact;
        return this;
    }

    public ContactDataDB withId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public ContactDataDB withAllInfo(String allInfo) {
        this.allInfo = allInfo;
        return this;
    }

    public ContactDataDB withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactDataDB inGroup(GroupDataDB group){
        groups.add(group);
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public GroupsDB getGroup() {
        return new GroupsDB(groups);
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {return email2;}

    public String getEmail3() {return email3;}

    public String getAddress() {
        return address;
    }

    public int getContactId() {return contactId;}

    public String getAllPhones() {return allPhones;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDataDB that = (ContactDataDB) o;

        if (contactId != that.contactId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + contactId;
        return result;
    }

    public String getAllEmails() {return allEmails;}

    public String getAllInfo() {return allInfo;}

    public File getPhoto() {return photo;}

}





