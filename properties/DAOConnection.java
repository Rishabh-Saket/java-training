import java.io.*;
import java.sql.*;
import java.util.*;
public class DAOConnection 
{
    private DAOConnection(){}

    public static Connection getConnection() throws Exception
    {
        return loadConnection();
    }

    private static Properties loadProperties() throws Exception
    {
        Properties properties=new Properties();
        FileInputStream file=new FileInputStream("config.properties");
        properties.load(file);
        file.close();
        return properties;
    }

    private static Connection loadConnection() throws Exception
    {
        Properties properties=loadProperties();
        String url=properties.getProperty("url");
        String username=properties.getProperty("username");
        String password=properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
}
