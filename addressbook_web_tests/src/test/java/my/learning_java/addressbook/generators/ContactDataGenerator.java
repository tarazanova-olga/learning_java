package my.learning_java.addressbook.generators;

import gw.internal.ext.com.beust.jcommander.JCommander;
import gw.internal.ext.com.beust.jcommander.Parameter;
import gw.internal.ext.com.beust.jcommander.ParameterException;
import my.learning_java.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public  int count;

    @Parameter(names = "-f", description = "Target file")
    public String file; //тип String так как jcommander не поддерживает тип File

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        //генерация данных и сохранение их в файл
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
     //   System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getName(), contact.getMiddleName(), contact.getLastName(),
             contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
             contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getAddress()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactData().withName(String.format("Иван%s", i))
                .withMiddleName("Иванович").withLastName("Иванов")
                .withHomePhone(String.format("123%s", i)).withMobilePhone(String.format("233%s", i)).withWorkPhone(String.format("765%s", i))
                .withEmail(String.format("test%s@test.test", i)).withEmail2(String.format("2test%s@test.test", i)).withEmail3(String.format("3test%s@test.test", i))
                .withAddress("ул.Мира, д45"));
        }
        return contacts;
    }
}
