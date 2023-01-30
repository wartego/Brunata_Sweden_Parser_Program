import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


public class Frame extends javax.swing.JFrame implements ActionListener{
    public String fileInputName;
    public Path pathInput;
    public Path pathOutput;
    public String csvSeparator = ";"; // todo
    JLabel pictureLabel;
JComboBox<String> comboBox;
JButton generteFileButton ,chooseFile;
static JTextArea textArea;
JFileChooser fileChooser, folderChooser;
static StringBuilder builder = new StringBuilder();
public static final File DOWNLOAD_PATH = new File(String.format("C:\\Users\\%s\\Downloads", System.getProperty("user.name")));
    FileReaderCSV fileReaderCSV;
    public Frame(){
        setSize(600,500);
        setTitle("Brunata Parser");
        setLayout(null);


        //ComboBox
        String[] boxFormatTypeList = {"","csv to Txt","Frubo","Repab","Real Kron","Vitec"};
        comboBox = new JComboBox<>(boxFormatTypeList);
        comboBox.setBounds(20,20,150,30);
        comboBox.setBackground(Color.white);
        comboBox.addActionListener(this);
        add(comboBox);


        //Button
        generteFileButton = new JButton("Generate File");
        generteFileButton.setBounds(20,400,150,30);
        add(generteFileButton);
        generteFileButton.addActionListener(this);


        chooseFile = new JButton("Choose File");
        chooseFile.setBounds(20,300,150,30);
        add(chooseFile);
        chooseFile.addActionListener(this);

        //TextField
        textArea = new JTextArea("");
        textArea.setBounds(200,100,350,300);
        add(textArea);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5,5,5,5));
        textArea.setFont(new Font("Arial", Font.BOLD,9));
        textArea.setBackground(null);


        //File Chooser
        fileChooser = new JFileChooser(DOWNLOAD_PATH);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Files", "txt","csv","xml","xlx","xlx","xls");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setDialogTitle("Choose File to Parse");
        Action details = fileChooser.getActionMap().get("viewTypeDetails");
        details.actionPerformed(null);
        //sorted fileChooser
        JTable table = SwingUtils.getDescendantsOfType(JTable.class, fileChooser).get(0);
        table.getRowSorter().toggleSortOrder(3);
        table.getRowSorter().toggleSortOrder(3);






        // File Folder Output
        folderChooser = new JFileChooser(DOWNLOAD_PATH);
       // folderChooser.setCurrentDirectory(DOWNLOAD_PATH);
        folderChooser.setDialogTitle("Choose output Folder");
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);


        //Picture
        pictureLabel = new JLabel("");
        pictureLabel.setIcon(new ImageIcon("LogoBrunata.png"));
        pictureLabel.setBounds(250,10,250,40);
        add(pictureLabel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //comboBox
//        if(e.getSource() == comboBox){
//            int index = comboBox.getSelectedIndex();
//            switch (index){
//                case 0 -> new csvToTxt(pathOutput,fileInputName);
//                case 1 -> System.out.println();
//                case 2 -> System.out.println();
//                case 3 -> System.out.println();
//            }
//        }
        //File Chooser
        if(e.getSource() == chooseFile){
            int result = fileChooser.showOpenDialog(null);
            switch (result){
                case JFileChooser.APPROVE_OPTION:
                    File file = fileChooser.getSelectedFile();
                    pathInput = Path.of(file.getAbsolutePath());
                    fileInputName = file.getName();
                    //System.out.println(path);
                    textArea.setText(String.valueOf(builder.append(pathInput + "\n")));
                    break;
                case JFileChooser.CANCEL_OPTION:
                    System.out.println("Cancel clicked");
                    break;
                case JFileChooser.ERROR_OPTION:
                    System.out.println("error");
                    break;

            }
        }
        //GenerateFile
        if(e.getSource() == generteFileButton){
            System.out.println(System.getProperty("user.name"));

            if (comboBox.getSelectedIndex()==0){
                NothingSelected.NothingSelected();
            } else{
                extracted();
            }

        }
    }

    private void extracted() {
        int result = folderChooser.showOpenDialog(null);
        switch (result){
            case JFileChooser.APPROVE_OPTION:
                File file = folderChooser.getSelectedFile();
                 pathOutput = Path.of(file.getAbsolutePath());

                 fileReaderCSV = new FileReaderCSV();
//                    try {
//                        fileReaderCSV.readFiles(pathInput,csvSeparator);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }

                switch(comboBox.getSelectedIndex()){
                    case 1 -> {
                        try {
                            new csvToTxt(pathOutput,fileInputName,fileReaderCSV.readFiles(pathInput,csvSeparator));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }




        }
    }
}

