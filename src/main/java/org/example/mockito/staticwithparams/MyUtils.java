package org.example.mockito.staticwithparams;

public class MyUtils {

    private MyUtils(){
        throw new IllegalStateException("Utility class");
    }

    public static String getWelcomeMessage(String username, boolean isCustomer) {
        
        if (isCustomer) {
            return "Dear " + username;
        } else {
            return "Hello " + username;
        }
    }
}