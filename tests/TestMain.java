package tests;
import src.Main;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;


public class TestMain {
    
    @Test
    public void TestTheReadContentsOfTheFileMethodReturnsAStringTypeObject() {
        // Arrange
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";

        // Act
        var fileContents = Main.readTheContentsOfTheFile(filePathToBook);  

        // Assert
        assertThat(fileContents , instanceOf(String.class));
    }

    @Test
    public void TestTheReadContentsOfTheFileMethodReturnsTheSameFirstLineAsInTheSourceTextFile() {
        // Arrange
        String filePathToBook = "/home/shiva/workspace/github.com/karts001/bookbot/books/frankenstein.txt";

        // Act
        var fileContents = Main.readTheContentsOfTheFile(filePathToBook);  

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
        var fileContents = Main.readTheContentsOfTheFile(invalidFilePath);
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
        var fileContents = Main.readTheContentsOfTheFile(invalidFilePath);
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
        var numberOfWordsInTheString = Main.numberOfWordsInTheString(testString);

        // Assert
        Assert.assertEquals(8, numberOfWordsInTheString);
    }

    @Test()
    public void TestTheCountNumberOfTimesALetterIsUsedInAStringMethod() {
        // Arrange
        String testString = "This is a test string containing some words";

        // Act
        var characterMap = Main.numberOfTimesAnyLetterIsUsedInAString(testString);
        Integer expectedNumberOfLetterAs = 2;

        // Assert
        Assert.assertEquals(expectedNumberOfLetterAs, characterMap.get('a'));
    }
}
