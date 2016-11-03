package my.learning_java.mantis.appmanager;



public class UserHelper extends BaseHelper{

    public UserHelper(ApplicationManager app) {

        super(app); //вызов конструктора базового класса
    }

    public void goToUserPage(){
        wd.get(app.getProperty("web.baseURL") + "/manage_user_page.php");
    }
}
