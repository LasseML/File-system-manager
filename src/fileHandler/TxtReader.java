package fileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader {

    // takes a file path and returnes the amount of lines in the file as an int
    public static int countTxtLines(String filePath) {

        int lines = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((br.readLine()) != null) {
                lines++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return lines;
    }

    // takes a filepath and a word as a string, checks if the word is contained in the file and returnes a boolean
    public static Boolean txtContainsWord(String filePath, String containsWord) {

        Boolean exists = false;
        String line = "";
        String containsWordLower = containsWord.toLowerCase();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && exists == false) {
                
                // removes all other symbols than a-z, makes them lowercase and splits the string
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (String word : words) {
                    if(word.equals(containsWordLower)){
                        exists = true;
                    }
                }
            }

            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }


        return exists;
    }


    // takes a filepath and a word, counts the amount of thimes the word is present in the file and returns that numbar as an int
    public static int txtWordCount(String filePath, String containsWord) {

        int count = 0;
        String line = "";
        String containsWordLower = containsWord.toLowerCase();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                
                // removes all other symbols than a-z, makes them lowercase and splits the string
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (String word : words) {
                    if(word.equals(containsWordLower)){
                        count++;
                    }
                }
            }

            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }


        return count;
    }
        
}


    

