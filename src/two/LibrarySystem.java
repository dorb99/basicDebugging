package two;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Book {
	
    private String title;
    private boolean isBorrowed;
    private int borrowedCount = 0;
    
    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (isBorrowed) {
            System.out.println("Error: Book is already borrowed."); 
        } else {
        	System.out.println("Borrowing book "+this.title); 
        	isBorrowed = true;
        }
    }

    public void returnBook() {
    	 if (isBorrowed) {
    		 System.out.println("Retruning the book "+this.title);
    		 isBorrowed = false;
    		 borrowedCount++;
         } else {
        	 System.out.println("Error: Book isn't borrowed."); 
         }
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Book name "+this.title +" was borroed "+this.borrowedCount+" times";
    }
}

class Library {
    private List<Book> books;
    
    public Library() {
        books = new ArrayList<>();
        books.add(new Book("The Hobbit"));
        books.add(new Book("1984"));
        books.add(new Book("Harry Potter"));
    }

    public void listAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.getIsBorrowed()) {
                System.out.println("- " + book.getTitle());
            } else {
            	System.out.println("Borrowed- " + book.getTitle());
            }
        }
    }

    public Book findBook(String title) {
    	if(title.isBlank()) {
    		System.err.println("Empty title");
    		return null;
    	}
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n1. List Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
	            try {
	                choice = scanner.nextInt();
	                scanner.nextLine(); // Consume newline
	            } catch (InputMismatchException e) {
	                System.out.println("Error: Invalid input. Please enter a number.");
	                scanner.nextLine();
	                continue;
	            }

            switch (choice) {
                case 1:
                    library.listAvailableBooks();
                    break;

                case 2:
                    System.out.print("Enter the book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book bookToBorrow = library.findBook(borrowTitle);
                    
                    if (bookToBorrow == null) {
                        System.out.println("Error: Book not found!");
                    } else {
                    	// prints whats going on
                    	bookToBorrow.borrowBook();
                    }
                    break;
                case 3:
                    System.out.print("Enter the book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book bookToReturn = library.findBook(returnTitle);

                    if (bookToReturn == null) {
                        System.out.println("Error: Book not found!");
                        break;
                    } 
                    bookToReturn.returnBook(); 
                    break;

                case 4:
                    System.out.println("Exiting Library System...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
