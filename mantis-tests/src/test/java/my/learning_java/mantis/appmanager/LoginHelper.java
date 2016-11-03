package my.learning_java.mantis.appmanager;


import org.openqa.selenium.By;

public class LoginHelper extends BaseHelper {

    public LoginHelper(ApplicationManager app) {
        super(app); //вызов конструктора базового класса
    }

    public void start(String username, String password) {
        wd.get(app.getProperty("web.baseURL") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Войти']"));
    }

}
