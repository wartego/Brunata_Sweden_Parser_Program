import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class csvToTxt {
    private String outputFormat =".txt";
    public csvToTxt(Path pathOutput, String fileInputName, List<FileTemplate> fileReaderCSV) throws IOException {
        System.out.println(fileReaderCSV);
        String[] fileName = fileInputName.split("\\.");
        String pathToFile = pathOutput.toString() + "\\"+ fileName[0] + outputFormat;

        //flat map
        List<String> collect = fileReaderCSV.stream()
                .map(FileTemplate::toString)
                .collect(Collectors.toList());
collect.add(0,"First Header");

        Path path = Path.of(pathToFile);



       try{
           Files.write(path, collect);
           Frame.textArea.setText(String.valueOf(Frame.builder.append("\nPoprawno wygenerowano plik!")));
       } catch (Exception e){
           Frame.textArea.setText(e.toString());
       }

       FolderExplorer.openFolderExplorer(pathOutput);


    }
}
