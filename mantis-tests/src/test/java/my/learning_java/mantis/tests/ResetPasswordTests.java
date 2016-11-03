package my.learning_java.mantis.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResetPasswordTests extends TestBase {
    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public  void testResetPassword(){
        app.login().start("administrator", "root");
        app.user().goToUserPage();
//        String users = app.user().all();

    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){

        app.mail().stop();
    }

}
