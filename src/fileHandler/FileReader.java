package fileHandler;
import java.io.File;
import java.util.ArrayList;

public class FileReader {

    // takes a pats as a string and returnes a file object
    protected static File getFile(String path) {
        
        File file = new File(path);

        return file;
    }


    // takes a path to a directory and returnes an Array list of the files found in the folder
    public static ArrayList<String> getDriContent(String path) {
        
        ArrayList<String> fileNameList = new ArrayList<>();

        try {
            
            File[] files = getFile(path).listFiles();

            for (File file : files) {
                fileNameList.add(file.getName());
                
            }

    
        } catch (Exception e) {

            e.printStackTrace();
        }

        return fileNameList;
    }

    // takes a filename and returnes the extension without the .
    private static String getFileExtension(String fileName) {


        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

        return fileExtension;

    }

    // takes a list of files and returnes a list of uniques extensions 
    public static ArrayList<String> uniqueFileTypes(ArrayList<String> fileList) {

        ArrayList<String> uniqueFileExtension = new ArrayList<>();

        for (String fileName : fileList) {

            String extension = getFileExtension(fileName);

            if(!uniqueFileExtension.contains(extension)) {
                uniqueFileExtension.add(extension);
            }
            
        }

        return uniqueFileExtension;
        
    }

    // takes a list of files and an extension as a string, returnes all the files with the same extension, as a list
    public static ArrayList<String> getFileByExtension(ArrayList<String> fileList, String extension) {

        ArrayList<String> filesWithExtension = new ArrayList<>();

        for (String fileName : fileList) {

            String fileExtension = getFileExtension(fileName);

            if(fileExtension.equals(extension)) {
                filesWithExtension.add(fileName);
            }
            
        }

        return filesWithExtension;
        
    }

    // takes a filepath and returnes the filename
    public static String getFileName(String path) {

        File file = getFile(path);

        return file.getName();

    }

    // takes a filepath and returnes the file size ad kilo bytes
    public static long getFileSizeInKB(String path) {

        File file = getFile(path);

        return  file.length() / 1024;

    }


}
