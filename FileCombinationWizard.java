import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCombinationWizard {
    public static void main(String[] args) {
        String file1Path = "file1.txt";
        String file2Path = "file2.txt";
        String combinedFilePath = "combined.txt";

        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));
                BufferedWriter writer = new BufferedWriter(new FileWriter(combinedFilePath))
        ) {
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add a newline after each line
            }

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files combined successfully! 🌟");
        } catch (IOException e) {
            System.err.println("Error during file handling: " + e.getMessage());
        }
    }
}