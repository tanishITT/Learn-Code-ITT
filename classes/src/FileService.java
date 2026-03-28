import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class FileService {
    public List<String> readAllLines(String path) throws IOException {
        Path filePath = Paths.get(path);
        return Files.exists(filePath) ? Files.readAllLines(filePath) : Collections.emptyList();
    }

    public void writeLines(String path, List<String> lines) throws IOException {
        Files.write(Paths.get(path), lines);
    }


}