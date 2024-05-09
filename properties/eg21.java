import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class psp {

    public static void main(String[] args) {
        // Creating a Properties object
        Properties properties = new Properties();

        // Setting properties
        properties.setProperty("username", "john_doe");
        properties.setProperty("password", "secretpassword");

        // Writing properties to a file
        try {
            FileOutputStream fileOut = new FileOutputStream("config.properties");
            properties.store(fileOut, "Database Configuration");
            fileOut.close();
            System.out.println("Properties saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing properties to file: " + e.getMessage());
        }

        // Reading properties from a file
        try {
            FileInputStream fileIn = new FileInputStream("config.properties");
            properties.load(fileIn);
            fileIn.close();
            System.out.println("Username: " + properties.getProperty("username"));
            System.out.println("Password: " + properties.getProperty("password"));
        } catch (IOException e) {
            System.err.println("Error reading properties from file: " + e.getMessage());
        }
    }
}
