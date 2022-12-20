package tests;
import src.Main.AnalyseData;
import src.Main.Reporting;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class TestMain {
    
    @Test
    public void TestTheReadContentsOfTheFileMethodReturnsAStringTypeObject() {
        // Arrange
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";

        // Act
        var fileContents = AnalyseData.readTheContentsOfTheFile(filePathToBook);  

        // Assert
        assertThat(fileContents , instanceOf(String.class));
    }

    @Test
    public void TestTheReadContentsOfTheFileMethodReturnsTheSameFirstLineAsInTheSourceTextFile() {
        // Arrange
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";

        // Act
        var fileContents = AnalyseData.readTheContentsOfTheFile(filePathToBook);  

        // Assert
        assertThat(fileContents, CoreMatchers.containsString("Project Gutenberg's Frankenstein, by Mary Wollstonecraft (Godwin) Shelley"));
    }
 
    @Test()
    public void TestFileContentsReturnsEmptyStringWhenAnInvalidFIlePathIsSupplied() {
        // Arrange
        String invalidFilePath = "/invalid/filepath/to/book";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        
        // Act
        var fileContents = AnalyseData.readTheContentsOfTheFile(invalidFilePath);
        System.out.flush();
        System.setOut(old);
        var consoleOutput = baos.toString();

        // Assert
        Assert.assertEquals("", fileContents);
        Assert.assertTrue(consoleOutput.contains("NoSuchFileException"));
    }

    @Test()
    public void TestFileContentsReturnsEmptyStringWhenAnFilePathToADirectoryIsSupplied() {
        // Arrange
        String invalidFilePath = "/home/shiva/workspace/github.com/karts001/bookbot/books";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        
        // Act
        var fileContents = AnalyseData.readTheContentsOfTheFile(invalidFilePath);
        System.out.flush();
        System.setOut(old);
        var consoleOutput = baos.toString();

        // Assert
        Assert.assertEquals("", fileContents);
        Assert.assertTrue(consoleOutput.contains("Is a directory"));
    }

    @Test()
    public void TestNumberOfWordsMethodReturnsTheCorrectNumberOfWordsInAString() {
        // Arrange
        String testString = "This is a test string containing 8 words";

        // Act
        var numberOfWordsInTheString = AnalyseData.numberOfWordsInTheString(testString);

        // Assert
        Assert.assertEquals(8, numberOfWordsInTheString);
    }

    @Test()
    public void TestTheCountNumberOfTimesALetterIsUsedInAStringMethodReturnsTheCorrectNumberOfTheLetterAForAGivenString  () {
        // Arrange
        String testString = "This is a test string containing some words";

        // Act
        var characterMap = AnalyseData.numberOfTimesAnyLetterIsUsedInAString(testString);
        Integer expectedNumberOfLetterA = 2;
        Integer expectedNumberOfLetterT = 5;

        // Assert
        Assert.assertEquals(expectedNumberOfLetterA, characterMap.get('a'));
        Assert.assertEquals(expectedNumberOfLetterT, characterMap.get('t'));

    }

    @Test()
    public void TestTheWriteToFileMethodCreatesAFileWithExpectedTitleInTheExpectedLocation () {
        // Arrange
        int numberOfWords = 5;
        Map characterMap = null;
        String basePath = new File("").getAbsolutePath();
        Path reportPath = Path.of(basePath + "/" + "Book Report.txt");

        // Act
        Reporting.createFile(numberOfWords, characterMap);

        // Assert
        boolean fileExists = Files.exists(reportPath);
        Assert.assertTrue(fileExists);

    }
}
