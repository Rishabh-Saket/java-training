import java.io.*;
import java.util.*;
class eg1 
{
    public static void main(String[] args) 
    {

    
        //creating a properties object
        Properties properties=new Properties();

        // SETTING PROPERTIES
        properties.setProperty("username", "harry");
        properties.setProperty("password", "potter");

        try 
        {
            FileOutputStream fileOutputStream=new FileOutputStream("details.properties");
            properties.store(fileOutputStream, "DATABASE CONFIGURATION");
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
