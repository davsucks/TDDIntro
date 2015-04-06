package com.thoughtworks.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private List<String> books;
    private PrintStream printStream;
    private String title_one;
    private String title_two;
    private DateTimeFormatter dateTimeFormatter;
    private DateTime time;


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void setUp() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        title_one = "Book Title One";
        title_two = "Book Title Two";
        dateTimeFormatter = mock(DateTimeFormatter.class);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        time = new DateTime();
    }

    private void createLibraryAndListBooks() {
        Library library = new Library(books, printStream, null);
        library.listBooks();
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        books.add(title_one);
        createLibraryAndListBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(title_one);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        createLibraryAndListBooks();
        verify(printStream, never()).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        books.add(title_one);
        books.add(title_two);
        createLibraryAndListBooks();

        verify(printStream).println(title_one);
        verify(printStream).println(title_two);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        createLibraryAndCallWelcomeWithTime();
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        String formattedTimeString = "FormattedTimeString";
        when(dateTimeFormatter.print(time)).thenReturn(formattedTimeString);

        createLibraryAndCallWelcomeWithTime();

        // add a verify here
        verify(printStream).println(contains(formattedTimeString));
    }

    private void createLibraryAndCallWelcomeWithTime() {
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);
    }

    @Test
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {

        createLibraryAndCallWelcomeWithTime();
        verify(dateTimeFormatter).print(time);
    }
}