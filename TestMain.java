import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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
        System.out.println(consoleOutput);

        // Assert
        Assert.assertEquals("", fileContents);
        Assert.assertTrue(consoleOutput.contains("Is a directory"));
    }
}
 