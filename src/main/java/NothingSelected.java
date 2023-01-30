import javax.swing.*;

public class NothingSelected {

    public static void NothingSelected(){
        String msg = "<html><font size = 4><center>" +
                "<b>Please" +
                "<br>choose:" +
                "<br> output file format!!!" +
                "<center>" +
                "</font>" +
                "</html>";
        JOptionPane.showMessageDialog(null, msg,"No output file format",JOptionPane.ERROR_MESSAGE);
    }
}
