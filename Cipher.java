import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

public class Cipher {

    private static final String key = "Wikipedia is a multilingual, web-based, free-content encyclopedia project supported by the Wikimedia Foundation and based on a model of openly editable content. The name \"Wikipedia\" is a portmanteau of the words wiki (a technology for creating collaborative websites, from the Hawaiian word wiki, meaning \"quick\") and encyclopedia. Wikipedia's articles provide links designed to guide the user to related pages with additional information."; 

    public static void main(String[] args) throws IOException {
        String readFilepath = ".\\text.txt"; 
        String writeFilepath = "encrypted" + Calendar.getInstance().getTimeInMillis() + ".txt"; 

        if(args.length>0) {
            readFilepath = args[0]; 
            if(args.length>1) {
                writeFilepath = args[1]; 
            }
        }

        File file = new File(readFilepath); 
        BufferedReader reader = null; 
        try {
            reader = new BufferedReader(new FileReader(file)); 
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        String line; 
        String text = ""; 
        while ((line = reader.readLine()) != null) {
            text += line; 
            System.out.println("Reading line from file");
        }

        System.out.println("Encryption"); 
        CodingMatrix codingMatrix = new CodingMatrix(key.toUpperCase()); 
        String code = codingMatrix.codeText(text);

        System.out.println("Writing to file");
        Files.write(Paths.get(writeFilepath), code.getBytes());
        reader.close();
        // codingMatrix.debug();
    }

}