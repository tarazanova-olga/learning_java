package my.learning_java.addressbook.model.db_model;


import com.google.common.collect.ForwardingSet;


import java.util.*;

//создание расширенных коллекций
public class ContactsDB extends ForwardingSet <ContactDataDB> {

    private  Set<ContactDataDB> delegate;

    public ContactsDB(ContactsDB contacts) {
        this.delegate = new HashSet<ContactDataDB>(contacts.delegate);
    }

    public ContactsDB() {
        this.delegate = new HashSet<ContactDataDB>();
    }

    public ContactsDB(Collection<ContactDataDB> contacts) {
        this.delegate = new HashSet<ContactDataDB>(contacts);
    }

    @Override
    protected Set<ContactDataDB> delegate() {
        return delegate;
    }

    public ContactsDB withAdded(ContactDataDB contact){
        ContactsDB contacts = new ContactsDB(this);
        contacts.add(contact);
        return contacts;
    }

    public ContactsDB withOut(ContactDataDB contact){
        ContactsDB contacts = new ContactsDB(this);
        contacts.remove(contact);
        return contacts;
    }

}