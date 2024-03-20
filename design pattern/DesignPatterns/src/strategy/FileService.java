package strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class FileService {
    public void load(Consumer<String> done,Consumer<String> error) {
        String content = null;
        try {
            content = Files.readString(Paths.get("employee.txtx"));
            done.accept(content);
        } catch (IOException e) {
            error.accept(e.getMessage());
        }
    }
}
