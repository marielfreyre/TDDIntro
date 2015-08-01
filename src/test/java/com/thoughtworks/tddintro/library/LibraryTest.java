package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import static org.joda.time.DateTime.now;
import org.junit.Test;
import org.junit.Before;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    private List<String> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {


        String title = "Book Title";
        books.add(title);
        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        verify(printStream).println("Book Title");


    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(books, printStream, null);

        library.listBooks();
        verifyZeroInteractions(printStream);



    }

    @Test

    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {


        String title1 = "First Book Title";
        books.add(title1);
        String title2 = "Second Book Title";
        books.add(title2);
        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(books, printStream, null);

        library.listBooks();



        verify(printStream).println(contains("First Book Title"));
        verify(printStream).println(contains("Second Book Title"));
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

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
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);
        verify(printStream).println(contains(""));


    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {


        PrintStream printStream = mock(PrintStream.class);
        DateTime time = now();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("The time is Now!");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);
        verify(printStream).println(contains("The time is Now!"));
    }
}