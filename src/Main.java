package src;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;


    public class Main {
    public static void main(String[] args) {
        String filePathToBook = args[0];
        String fileContent = readTheContentsOfTheFile(filePathToBook);
        int numberOfWordsInTheBook = numberOfWordsInTheString(fileContent);
        Map characterMap = numberOfTimesAnyLetterIsUsedInAString(fileContent);
        
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
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAString = sw.toString();
            System.out.println(exceptionAString);

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

    public static Map<Character, Integer> numberOfTimesAnyLetterIsUsedInAString(String stringToAnalyse) {
        var stringToAnalyseLower = stringToAnalyse.toLowerCase();
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        // Converting given string to char array
        char[] strArray = stringToAnalyseLower.toCharArray();

         // checking each char of strArray
         for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
 
                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
 
                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }

        return charCountMap;

    }
    }


    
    
    
