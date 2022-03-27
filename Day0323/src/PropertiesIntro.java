import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesIntro {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name);
        System.out.println(password);
    }
}
