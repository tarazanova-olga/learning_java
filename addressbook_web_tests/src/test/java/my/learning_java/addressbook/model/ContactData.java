package my.learning_java.addressbook.model;

public class ContactData {
    private final String nameContact;
    private final String middleNameContact;
    private final String lastNameContact;
    private final String phoneContact;
    private final String emailContact;
    private final String addressContact;

    public ContactData(String nameContact, String middleNameContact, String lastNameContact, String phoneContact,
                       String emailContact, String addressContact) {
        this.nameContact = nameContact;
        this.middleNameContact = middleNameContact;
        this.lastNameContact = lastNameContact;
        this.phoneContact = phoneContact;
        this.emailContact = emailContact;
        this.addressContact = addressContact;
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
}
