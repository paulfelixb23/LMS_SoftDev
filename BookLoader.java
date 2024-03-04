/**
 * Paul Felix
 * CEN-3024 - Software Development
 * 01/26/2024
 * BookLoader.java
 * This class is responsible for loading books into the library from a file. It provides functionality to prompt the user
 * for a file name and to read book information from the specified file. Each book's title and author are extracted from
 * the file and added to the library, facilitating the initial population of the library's book collection.
 */

package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BookLoader {

    /**
     * loadBooksFromUserInput
     * Prompts the user for a filename and loads books from it into the library.
     * Receive the library instance to which the books will be added.
     */
    public static void loadBooksFromUserInput(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the filename to load books from:");
        String fileName = scanner.nextLine();

        loadBooksFromFile(fileName, library);
    }

    /**
     * loadBooksFromFile
     * Loads books from a specified file into the library.
     * This private method reads the file line by line, parsing each book's title and author,
     * and then adds the book to the library.
     * The name of the file from which to load books.
     * The library instance to which the books will be added.
     */
    private static void loadBooksFromFile(String fileName, Library library) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    // Clean each part to include only letters and spaces
                    String title = parts[0].replaceAll("[^a-zA-Z\\s]", "");
                    String author = parts[1].replaceAll("[^a-zA-Z\\s]", "");
                    library.addBook(new Book(title, author));
                }
            }
            System.out.println("\n* Books loaded successfully from " + fileName + " *");
        } catch (IOException e) {
            System.out.println("\nError reading file: " + e.getMessage());
        }
    }
}
