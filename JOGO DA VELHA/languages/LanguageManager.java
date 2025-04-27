package languages;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    private static ResourceBundle bundle;

    public static void setLanguage(Locale locale){
        bundle = ResourceBundle.getBundle("languages.resources.messages", locale);
    }

    public static String get(String key){
        return bundle.getString(key);
    }
}