import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.String;


    public class Main {
    public static void main(String[] args) {
    
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";
        Path filePath = Path.of(filePathToBook);
        String fileContent = "";
        int numberOfWordsInTheBook = 0;
        try {
            // constructor of file class having file as argument
            fileContent = Files.readString(filePath);
            numberOfWordsInTheBook = numberOfWordsInTheString(fileContent);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        
        System.out.printf("There are %s words in the Frankenstein book", numberOfWordsInTheBook);        
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


    
    
    
