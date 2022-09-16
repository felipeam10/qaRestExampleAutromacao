package support.utils;

public class Environments {
    public static String getEnvironment(){
        String environments = System.getProperty("ambiente");
        if(environments == null){
            environments = "local";
        }
        return environments;
    }
}
