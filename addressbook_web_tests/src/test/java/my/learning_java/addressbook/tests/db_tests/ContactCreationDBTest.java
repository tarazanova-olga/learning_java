package my.learning_java.addressbook.tests.db_tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import my.learning_java.addressbook.model.db_model.ContactDataDB;
import my.learning_java.addressbook.model.db_model.ContactsDB;
import my.learning_java.addressbook.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationDBTest extends TestBase{

    @DataProvider //реализация провайдера для чтения данных из файла формата csv
    public Iterator<Object[]> validContactsFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"))){
            String line = reader.readLine();
            while (line != null){
                String[] split = line.split(";");
                list.add(new Object[]{ new ContactDataDB().withName(split[0]).withMiddleName(split[1]).withLastName(split[2])
                        .withHomePhone(split[3]).withMobilePhone(split[4]).withWorkPhone(split[5])
                        .withEmail(split[6]).withEmail2(split[7]).withEmail3(split[8])
                        .withAddress(split[9])});
                line = reader.readLine();
            }
            return list.iterator();
        }
    }


    @DataProvider
    public Iterator<Object[]> validContactsFromXML() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"));){
            String xml = "";
            String line = reader.readLine();
            while (line != null){
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactDataDB.class);
            List<ContactDataDB> groups = (List<ContactDataDB>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJSON() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.json"));){
            String json = "";
            String line = reader.readLine();
            while (line != null){
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactDataDB> contacts = gson.fromJson(json, new TypeToken<List<ContactDataDB>>(){}.getType()); // аналогия List<ContactData>.class
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validContactsFromJSON")
    public void testContactCreationTest(ContactDataDB contact) {
        app.goTo().HomePage();
        ContactsDB before =  app.contactDB().all();
        app.contactDB().createContact(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        ContactsDB after =  app.contactDB().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo
                (before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getContactId()).max().getAsInt()))));
    }

    //определение текущей директории  и проверка существования файла
    @Test(enabled = false)
    public void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/ленин.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
