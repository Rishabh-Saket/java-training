/*
 * 
The Properties class in Java provides a convenient way to manage and store configuration data in key-value pairs. The store() method of the Properties class is used to save the properties to an output stream, typically a file output stream, in a human-readable format.
 */
import java.io.*;
import java.util.*;
class eg2 
{
    public static void main(String[] args) 
    {
        // creating a properties innstance
        Properties properties=new Properties();

        //setting the property
        properties.setProperty("username", "dubugger");
        properties.setProperty("password", "123");

        File file=new File("details.properties");
        if(file.exists())
        {
            System.out.println("file already exists");
            if(file.delete())
            {
                System.out.println("deleted the existing file");
            }
            else
            {
                System.out.println("can't delete the file");
                return;
            }
        }

        try 
        {
            FileOutputStream fileOutputStream=new FileOutputStream("details.properties");
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
            System.out.println("succesfully created the configuration file");
        }catch (Exception e) 
        {
            System.out.println(e);
        }

    }
}
