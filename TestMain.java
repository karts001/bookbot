import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;


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
}

    