import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileProcessor {
    public void processFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            try {
                // Open the file using try-with-resources
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Process each line (you can customize this part)
                        System.out.println("Read from file: " + line);
                    }
                } catch (IOException e) {
                    // Handle file reading exception
                    System.err.println("Error reading file: " + e.getMessage());
                }
            } catch (Exception e) {
                // Handle any other exceptions (e.g., invalid file path)
                System.err.println("Error processing file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<String> filePaths = List.of("file1.txt", "file2.txt", "file3.txt");
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFiles(filePaths);
    }
}
