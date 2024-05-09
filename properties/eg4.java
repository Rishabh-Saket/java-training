import java.io.*;
import java.util.*;
class eg4 
{
    public static void main(String[] args) 
    {
        Properties properties=new Properties();

        try 
        {
            FileInputStream fileInputStream=new FileInputStream("config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
            System.out.println("Username: "+properties.getProperty("username"));
            System.out.println("Password: "+properties.getProperty("password"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
