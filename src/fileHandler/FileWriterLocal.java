package fileHandler;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileWriterLocal {

    //takes a filepath and creates a new file with the name 
    private static void createFile(String filePath) {

        try {
            
            File newFile = new File(filePath);

            if (newFile.createNewFile()) {

                System.out.println("Created the file: " + newFile.getName());
                
            } else {

                System.out.println("The file coulden be created, it might already exist");
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // takes a filename and a string, writes the string to the file, if the file dosent exist, it is created
    public static void writeStringToFile(String fileName, String stringToWrite) {

        File file = new File(fileName);

        if(!file.exists()){
            createFile(fileName);
        }

        try {

            // creates a new fileWriter objest that can append files 
            FileWriter writer = new FileWriter(fileName, true);
            
            
            writer.write(stringToWrite);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
