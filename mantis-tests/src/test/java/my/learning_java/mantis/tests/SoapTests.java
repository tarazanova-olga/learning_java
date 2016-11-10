package my.learning_java.mantis.tests;

import my.learning_java.mantis.model.Issue;
import my.learning_java.mantis.model.Project;
import org.testng.annotations.Test;


import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class SoapTests extends TestBase{

    @Test

    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project : projects) {
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException{
        skipIfNotFixed(0000001);
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Text issue")
                .withDescription("Text issue description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
        }

    }
