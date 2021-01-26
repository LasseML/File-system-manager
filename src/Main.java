import fileHandler.*;
import logger.*;
import java.util.*;

public class Main {

// The main method handles communication with the user
// The min method keeps running until the user decides to close the program
// The scanner assumes that the user enteres correct input

public static void main(String[] args) {

    String stringChoice = "";
    int choice;
    String resourcesFolder = ("./resources/");
    Scanner scanner = new Scanner(System.in);
    long startTime = 0;
    long endTime = 0;


    
    do {

        System.out.println("Please enter the number of the assignment you want to run");
        System.out.println("To see all files in the resources directory enter 1");
        System.out.println("To get all files with a specific extension enter 2");
        System.out.println("To test file manipulation enter 3");
        System.out.println("To exit the program enter 99");
        System.out.print("Your choice:");

        choice = scanner.nextInt();

        switch (choice) {
            case 1:

                System.out.println("");

                for (String string : FileReader.getDriContent(resourcesFolder)) {

                    System.out.println(string);
                    
                }
                
                System.out.println("");

                break;
            
            case 2:

                System.out.println("");
                System.out.println("The directory contains the file types: ");
                System.out.println("");

                for (String string : FileReader.uniqueFileTypes(FileReader.getDriContent(resourcesFolder))) {
                    System.out.println(string + " ");
                }

                System.out.println("");
                System.out.print("Please enter the file type you want to show: ");
                stringChoice = scanner.next();
                System.out.println("");
                System.out.print("I found these files: ");

                for (String string : FileReader.getFileByExtension(FileReader.getDriContent(resourcesFolder), stringChoice )) {

                    System.out.print(string + " ");
                    
                }

                System.out.println("");
                System.out.println("");
                
                break;

            case 3:
                do {
                    
                    String draculaFile = resourcesFolder + "/dracula.txt";
                    String stringToPrint = "";

                    System.out.println("To see the name of the file enter 1");
                    System.out.println("To see the file size enter 2");
                    System.out.println("To see the number of lines in the file enter 3");
                    System.out.println("To see if a word exists in the file enter 4");
                    System.out.println("To see the number of occurrences of a word in the file enter 5");
                    System.out.println("To return to the start of the program enter 99");
                    System.out.print("Your choice: ");
                    choice = scanner.nextInt();
                    System.out.println("");

                    switch (choice) {
                        case 1:

                            startTime = System.nanoTime();

                            stringToPrint = ("The name of the file is: " + FileReader.getFileName(draculaFile));

                            endTime = System.nanoTime();

                            System.out.println(logger.Logger.writeToLog(stringToPrint, startTime, endTime));
                            System.out.println("");

                            break;

                        case 2:

                            startTime = System.nanoTime();

                            stringToPrint = ("The size of the file is: " + FileReader.getFileSizeInKB(draculaFile) + "kB");

                            endTime = System.nanoTime();

                            System.out.println(logger.Logger.writeToLog(stringToPrint, startTime, endTime));
                            System.out.println("");

                            break;

                        case 3:

                            startTime = System.nanoTime();

                            stringToPrint = ("The number of lines in the file is: " + TxtReader.countTxtLines(draculaFile));

                            endTime = System.nanoTime();

                            System.out.println(logger.Logger.writeToLog(stringToPrint, startTime, endTime));
                            System.out.println("");

                            break;

                        case 4:

                            System.out.print("Please write the word you want to see if exists in the file: ");
                            stringChoice = scanner.next();
                            System.out.println("");

                            startTime = System.nanoTime();

                            if (TxtReader.txtContainsWord(draculaFile, stringChoice)) {

                                stringToPrint = ("The file contained the word " + stringChoice);
                                
                            } else {

                                stringToPrint = ("The file did not contain the word " + stringChoice);
                                
                            }

                            endTime = System.nanoTime();

                            System.out.println(logger.Logger.writeToLog(stringToPrint, startTime, endTime));
                            System.out.println("");

                            break;

                        case 5:

                            int wordCount = 0;

                            System.out.print("Please write the word you want to count in the file: ");
                            stringChoice = scanner.next();
                            System.out.println("");

                            startTime = System.nanoTime();

                            wordCount = TxtReader.txtWordCount(draculaFile, stringChoice);

                            stringToPrint = ("The file contained the word " + stringChoice + " " + wordCount + " times");

                            endTime = System.nanoTime();

                            System.out.println(logger.Logger.writeToLog(stringToPrint, startTime, endTime));
                            System.out.println("");

                            break;
                    
                        default:
                            break;
                    }
                
                    if(choice == 99){
                        choice = 50;
                    }
                } while (choice != 50);

                break;

            default:
                break;
        }
        

    } while (choice != 99);

}


}

