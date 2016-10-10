package my.learning_java.addressbook.model;

public class ContactData {
    private String nameContact;
    private String middleNameContact;
    private String lastNameContact;
    private String phoneContact;
    private String emailContact;
    private String addressContact;
    private String group;
    private int contactId = Integer.MAX_VALUE;

    public ContactData withName(String nameContact) {
        this.nameContact = nameContact;
        return this;
    }

    public ContactData withMiddleName(String middleNameContact) {
        this.middleNameContact = middleNameContact;
        return this;
    }

    public ContactData withLastName(String lastNameContact) {
        this.lastNameContact = lastNameContact;
        return this;
    }

    public ContactData withPhone(String phoneContact) {
        this.phoneContact = phoneContact;
        return this;
    }

    public ContactData withEmail(String emailContact) {
        this.emailContact = emailContact;
        return this;
    }

    public ContactData withAddress(String addressContact) {
        this.addressContact = addressContact;
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

    public String getNameContact() { return nameContact; }

    public String getMiddleNameContact() {
        return middleNameContact;
    }

    public String getLastNameContact() {
        return lastNameContact;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public String getAddressContact() {
        return addressContact;
    }

    public String getGroup() {
        return group;
    }

    public int getContactId() { return contactId; }

    @Override
    public String toString() {
        return "ContactData{" +
                "nameContact='" + nameContact + '\'' +
                ", lastNameContact='" + lastNameContact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (contactId != that.contactId) return false;
        if (nameContact != null ? !nameContact.equals(that.nameContact) : that.nameContact != null) return false;
        return lastNameContact != null ? lastNameContact.equals(that.lastNameContact) : that.lastNameContact == null;

    }

    @Override
    public int hashCode() {
        int result = nameContact != null ? nameContact.hashCode() : 0;
        result = 31 * result + (lastNameContact != null ? lastNameContact.hashCode() : 0);
        result = 31 * result + contactId;
        return result;
    }
}
