import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String image = vars.get("large");
        log.info(image);
        URL url = new URL(image);
        InputStream input = url.openStream();
        String pathPhoto = "C:\\Users\\Viktor\\Desktop\\1\\" + nameFirst + ".png";
        Path path = Path.of(pathPhoto);
        try {
            Files.copy(input, path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileUtils.writeByteArrayToFile(new File("/path/to/the/file.jpg"),data);
        FileWriter
        FileWriter fw = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

        File csvFile = new File("asdf");
        FileOutputStream fileOutputStream = new FileOutputStream(csvFile);
        FileWriter fw = new OutputStreamWriter(fileOutputStream , "UTF8");


    }
}