import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileSplitter {

    private static final long MAX_LENGTH = 4294967296L;
    private static FileSplitter INSTANCE = null;

    private FileSplitter() {
    }

    public static FileSplitter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileSplitter();
        }
        return INSTANCE;
    }

    public void split(Path path) throws IOException {

        long fileSize = Files.size(path);

        long max = Long.max(MAX_LENGTH, fileSize);

        int numberOfFiles = (int) (max / MAX_LENGTH);

        byte[] bytes = Files.readAllBytes(path);

        for (int count = 0; count < numberOfFiles; count++) {

            int from = 0;
            int to = 1;

            byte[] fileBytes = Arrays.copyOfRange(bytes, from, to);

            Files.write(path, fileBytes);

        }
    }
}
