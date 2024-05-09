import java.io.*;
class eg3 
{
    public static void main(String[] args) 
    {
        try 
        {
            FileOutputStream fileOutputStream=new FileOutputStream("sample.txt");
            String data="hello we are learingin wrritng to a file";
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
            System.out.println("successfully added content to the file ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
