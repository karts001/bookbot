import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;


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
        
        // Act
        var fileContents = Main.readTheContentsOfTheFile(invalidFilePath);

        // Assert
        Assert.assertEquals("", fileContents);
        
    }
}

    