package my.learning_java.addressbook.model;

public class ContactData {
    private final String nameContact;
    private final String middleNameContact;
    private final String lastNameContact;
    private final String phoneContact;
    private final String emailContact;
    private final String addressContact;
    private String group;

    public ContactData(String nameContact, String middleNameContact, String lastNameContact, String phoneContact,
                       String emailContact, String addressContact, String group) {
        this.nameContact = nameContact;
        this.middleNameContact = middleNameContact;
        this.lastNameContact = lastNameContact;
        this.phoneContact = phoneContact;
        this.emailContact = emailContact;
        this.addressContact = addressContact;
        this.group = group;
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
}
