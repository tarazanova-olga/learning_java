package my.learning_java.addressbook.model;

public class ContactData {
    private String name;
    private String middleName;
    private String lastName;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String email;
    private String email2;
    private String email3;
    private String address;
    private String group;
    private int contactId = Integer.MAX_VALUE;
    private String allPhones;
    private String allEmails;

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

    @Override
    public String toString() {
        return "ContactData{" +
                "nameContact='" + name + '\'' +
                ", lastNameContact='" + lastName + '\'' +
                '}';
    }

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





