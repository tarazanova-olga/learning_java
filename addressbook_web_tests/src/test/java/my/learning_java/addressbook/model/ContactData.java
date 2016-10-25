package my.learning_java.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;

@XStreamAlias("contacts")
@Entity
@javax.persistence.Table(name = "addressbook")

public class ContactData {
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
    @Transient
    @Expose
    private String group;
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

    public ContactData() {
    }

    public ContactData withName(String nameContact) {
        this.name = nameContact;
        return this;
    }

    public ContactData withMiddleName(String middleNameContact) {
        this.middleName = middleNameContact;
        return this;
    }

    public ContactData withLastName(String lastNameContact) {
        this.lastName = lastNameContact;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }


    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEmail(String emailContact) {
        this.email = emailContact;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAddress(String addressContact) {
        this.address = addressContact;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public ContactData withAllInfo(String allInfo) {
        this.allInfo = allInfo;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
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

    public String getGroup() {
        return group;
    }

    public int getContactId() {return contactId;}

    public String getAllPhones() {return allPhones;}

    public String getAllEmails() {return allEmails;}

    public String getAllInfo() {return allInfo;}

    public File getPhoto() {return photo;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (contactId != that.contactId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + contactId;
        return result;
    }




}





