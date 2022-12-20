package src;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;


    public class Main {
    public static void main(String[] args) {
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";
        String fileContent = AnalyseData.readTheContentsOfTheFile(filePathToBook);

        int numberOfWordsInTheBook = AnalyseData.numberOfWordsInTheString(fileContent);
        var characterMap = AnalyseData.numberOfTimesAnyLetterIsUsedInAString(fileContent);
        Reporting.createFile(numberOfWordsInTheBook, characterMap);  

        }

    public static class AnalyseData {
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

    public static class Reporting {
        public static void createFile (int numberOfWords, Map<Character, Integer> characterMap) {
            String basePath = new File("").getAbsolutePath();
            System.out.println(basePath);

            try {
                FileWriter reportFile = new FileWriter(basePath + "/Book Report.txt");
                reportFile.write("-- Begin report of Frankenstein --\n\n");
                reportFile.write(String.valueOf(numberOfWords) + " words found in the document\n\n");

                for (Map.Entry<Character, Integer> entry: characterMap.entrySet()) {
                    Character character = entry.getKey();
                    int frequency = entry.getValue();
                    if (Character.isLetter(character)) {
                    reportFile.write("The " + "'" + character + "' " + "was found " + frequency + " times\n");
                    }
                }
                reportFile.write("-- End of Report --");
                reportFile.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}


    
    
    
