package my.learning_java.addressbook.model;

public class ContactData {
    private final String nameContact;
    private final String middleNameContact;
    private final String lastNameContact;
    private final String phoneContact;
    private final String emailContact;
    private final String addressContact;
    private String group;
    private int contactId;



    public ContactData(String nameContact, String middleNameContact, String lastNameContact, String phoneContact,
                       String emailContact, String addressContact, String group) {
        this.nameContact = nameContact;
        this.middleNameContact = middleNameContact;
        this.lastNameContact = lastNameContact;
        this.phoneContact = phoneContact;
        this.emailContact = emailContact;
        this.addressContact = addressContact;
        this.group = group;
        this.contactId = Integer.MAX_VALUE;
    }

    public ContactData(String nameContact, String middleNameContact, String lastNameContact, String phoneContact,
                       String emailContact, String addressContact, String group, int contactId) {
        this.nameContact = nameContact;
        this.middleNameContact = middleNameContact;
        this.lastNameContact = lastNameContact;
        this.phoneContact = phoneContact;
        this.emailContact = emailContact;
        this.addressContact = addressContact;
        this.group = group;
        this.contactId = contactId;
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

        if (nameContact != null ? !nameContact.equals(that.nameContact) : that.nameContact != null) return false;
        return lastNameContact != null ? lastNameContact.equals(that.lastNameContact) : that.lastNameContact == null;

    }

    @Override
    public int hashCode() {
        int result = nameContact != null ? nameContact.hashCode() : 0;
        result = 31 * result + (lastNameContact != null ? lastNameContact.hashCode() : 0);
        return result;
    }


}
