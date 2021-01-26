package logger;
import java.time.LocalDateTime;
import fileHandler.FileWriterLocal;


public class Logger {

    //path to the logfile
    static String logFile = "./log/logfile.txt";

    // takes a string to write, and a start and end time. Writes time, string and time to run to the log and returnes the input string
    public static String writeToLog(String stringToWrite, long startTime, long endTime) {

        long executionTime = (endTime - startTime) / 1000000;

        LocalDateTime time = LocalDateTime.now();

        String stringToWritewithTime = (time + " " + stringToWrite + " Took: " + executionTime + "ms to execute \n");

        FileWriterLocal.writeStringToFile(logFile, stringToWritewithTime);

        return stringToWrite;
    }
    
}
