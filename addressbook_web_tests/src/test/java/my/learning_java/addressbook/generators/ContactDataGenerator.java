package my.learning_java.addressbook.generators;

import my.learning_java.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        //генерация данных и сохранение их в файл
        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
     //   System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", contact.getName(), contact.getMiddleName(), contact.getLastName()
            , contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()
            , contact.getEmail(), contact.getEmail2(), contact.getEmail3()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactData().withName(String.format("Иван %s", i))
                .withMiddleName(" Иванович").withLastName(" Иванов")
                .withHomePhone(String.format(" 123%s", i)).withMobilePhone(String.format(" 100%s", i)).withWorkPhone(String.format(" 145%s", i))
                .withAddress(" ул.Мира, д45").withEmail(String.format(" test%s@test.test", i)).withEmail2(String.format(" 33test%s@test.test", i))
                .withEmail3(String.format(" 23test%s@test.test", i)));
        }
        return contacts;
    }
}
