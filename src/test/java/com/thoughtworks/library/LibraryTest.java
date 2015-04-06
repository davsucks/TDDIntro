package com.thoughtworks.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private List<String> books;
    private PrintStream printStream;


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void setUp() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
    }

    private void createLibraryAndListBooks(List<String> books, PrintStream printStream) {
        Library library = new Library(books, printStream, null);
        library.listBooks();
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        createLibraryAndListBooks(books, printStream);

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        createLibraryAndListBooks(books, printStream);
        verify(printStream, never()).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        String title_one ="Book Title One";
        String title_two = "Book Title Two";

        books.add(title_one);
        books.add(title_two);
        createLibraryAndListBooks(books, printStream);
        
        verify(printStream).println(title_one);
        verify(printStream).println(title_two);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("FormattedTimeString");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
    }

    @Test
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {

        // implement me
    }
}