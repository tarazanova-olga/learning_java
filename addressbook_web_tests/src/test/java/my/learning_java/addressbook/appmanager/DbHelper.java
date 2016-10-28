package my.learning_java.addressbook.appmanager;


import my.learning_java.addressbook.model.db_model.ContactDataDB;
import my.learning_java.addressbook.model.db_model.ContactsDB;
import my.learning_java.addressbook.model.db_model.GroupDataDB;
import my.learning_java.addressbook.model.db_model.GroupsDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DbHelper {
    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public GroupsDB groups(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupDataDB> result = session.createQuery("from GroupDataDB").list();
        session.getTransaction().commit();
        session.close();
        return new GroupsDB(result);
    }

    public ContactsDB contacts(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactDataDB> result = session.createQuery("from ContactDataDB where deprecated = '0000-00-00'").list();
        session.getTransaction().commit();
        session.close();
        return  new ContactsDB(result);
    }

}