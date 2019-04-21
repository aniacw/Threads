package Exe1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SleepWorker extends FileProcessorWorker {
    @Override
    protected void processFile(InOutFilenames filenames) {
        try {
            List<String> contents = Files.readAllLines(Paths.get("resources\\" + filenames.in));
            Thread.sleep(Integer.parseInt(contents.get(0)));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
