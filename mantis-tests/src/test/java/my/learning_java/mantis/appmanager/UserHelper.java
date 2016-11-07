package my.learning_java.mantis.appmanager;


import org.openqa.selenium.By;

public class UserHelper extends BaseHelper{

    public UserHelper(ApplicationManager app) {

        super(app); //вызов конструктора базового класса
    }

    public void goToUserPage(){
        wd.get(app.getProperty("web.baseURL") + "/manage_user_edit_page.php?user_id=2");
    }

    public String parseNameSelectedUser(){
       String name = wd.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
        return name;
    }

    public String parseEmailSelectedUser(){
        String email = wd.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
        return email;
    }

    public void resetPassword(){
        click(By.xpath("//input[@value='Сбросить пароль']"));
    }

}
