import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


public class FileReaderCSV {
    private String fileName;

//czytanie pliku Files.lines()
    public List<FileTemplate> readFiles(Path pathInput, String separator) throws IOException {
        List<FileTemplate> listString = Files.lines(pathInput)
                .map(lines -> {
                    String[] fields = lines.split(separator);
                    return new FileTemplate(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10], fields[11], fields[12], fields[13], fields[14], fields[15], fields[16], fields[17], fields[18], fields[19], fields[20], fields[21], fields[22], fields[23], fields[24], fields[25], fields[26], fields[27], fields[28], fields[29], fields[30], fields[31], fields[32], fields[33], fields[34], fields[35], fields[36], fields[37], fields[38], fields[39], fields[40], fields[41], fields[42], fields[43], fields[44] + "\n");
                })
                .collect(Collectors.toList());
return listString;

    }


}
