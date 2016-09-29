package my.learning_java.sandbox;

import java.util.Arrays;
import java.util.List;


public class Collections {

    public static void main(String[] args){
        String[] langs = {"Java", "Ruby", "C#", "C++"}; //созданный массив может хранить 4 элемента

//        for (int i = 0; i < langs.length; i++) {
//            System.out.println("Я хочу выучить " + langs[i]);
//        }

        for (String l : langs) {
            System.out.println("Я хочу выучить " + l);
        }

        List<String> languages = Arrays.asList("JAVA", "C++");

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }

//        for (int i = 0; i < languages.length; i++) {
//            System.out.println("Я хочу выучить " + languages.get(i));
//        }
    }
}
