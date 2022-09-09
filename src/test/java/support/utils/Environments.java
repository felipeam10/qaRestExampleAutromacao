package support.utils;

public class Environments {
    public static String getEnvironment(){
        String environments = System.getProperty("ambiente");
        return environments;
    }
}
