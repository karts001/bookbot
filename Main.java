import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.String;


    public class Main {
    public static void main(String[] args) {
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";
        String fileContent = readTheContentsOfTheFile(filePathToBook);
        int numberOfWordsInTheBook = numberOfWordsInTheString(fileContent);
        
        System.out.printf("There are %s words in the Frankenstein book", numberOfWordsInTheBook);       
        }

    // public static Path returnPath(String filePath) {
        
    //     return path;
    // }

    public static String readTheContentsOfTheFile(String filePath) {
        Path path = Path.of(filePath);
        String fileContent = "";
        try {
            // constructor of file class having file as argument
            fileContent = Files.readString(path);
            
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.out.println("Please provide a valid file path");
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


    
    
    
