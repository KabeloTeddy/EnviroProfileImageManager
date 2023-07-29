import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileParserTest {
    //this is for me to run tests using JUnit to see if the applcation is indeed picking up the .csv file
    @Test
    public void testCSVFileConnection() {
        String csvFileName = "file.csv";
        Resource resource = new ClassPathResource(csvFileName);

        try {
            byte[] csvData = FileCopyUtils.copyToByteArray(resource.getInputStream());
            String csvContent = new String(csvData, StandardCharsets.UTF_8);
            System.out.println("CSV File Content:");
            System.out.println(csvContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
