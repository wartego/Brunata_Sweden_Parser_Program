import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FolderExplorer {

    public static void openFolderExplorer(Path path) throws IOException {
//        File directory = new File(path.toUri());
//        Desktop.getDesktop().browseFileDirectory(directory);
        Runtime.getRuntime().exec("explorer "+path);
    }
}
