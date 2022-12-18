import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.String;


    public class Main {
    public static void main(String[] args) {
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";
        Path filePath = openTheFile(filePathToBook);
        String fileContent = readTheContentsOfTheFile(filePath);
        int numberOfWordsInTheBook = numberOfWordsInTheString(fileContent);
        
        System.out.printf("There are %s words in the Frankenstein book", numberOfWordsInTheBook);       
        }

    public static Path openTheFile(String filePath) {
        Path path = Path.of(filePath);
        return path;
    }

    public static String readTheContentsOfTheFile(Path filePath) {
        String fileContent = "";
        try {
            // constructor of file class having file as argument
            fileContent = Files.readString(filePath);
            
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return fileContent;
    }

    public static int numberOfWordsInTheString(String stringToEvaluate) {
        if (stringToEvaluate == null || stringToEvaluate.isEmpty()) {
            return 0;
        }
        String [] words = stringToEvaluate.split(" ");
        int numberOfWords = words.length;

        return numberOfWords;
    }
    }


    
    
    
