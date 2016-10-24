package my.learning_java.addressbook.tests;


import my.learning_java.addressbook.appmanager.ApplicationManager;
import org.apache.bcel.classfile.Method;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun=true)
    public void tearDown() {

        app.stop();
    }

    @BeforeMethod
    public void logTestStart(java.lang.reflect.Method m, Object[] p){
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun=true) //чтобы метод всегда выполнялся
    public void logTestStop(java.lang.reflect.Method m){
        logger.info("Stop test " + m.getName());
    }
}
