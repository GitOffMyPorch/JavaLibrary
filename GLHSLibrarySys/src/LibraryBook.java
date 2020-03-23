public class LibraryBook implements java.io.Serializable {

    private String bookName;
    private int bookNumber;
    private boolean ableToBeCheckedOut;
    private String authorName;

    //constructor that gives a LibraryBook object its attributes
    LibraryBook(String bookName, int bookNumber, boolean ableToBeCheckedOut, String authorName) {
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.ableToBeCheckedOut = ableToBeCheckedOut;
        this.authorName = authorName;
    }

    //static display info method
    static void display_book_info(LibraryBook book) {
        System.out.println("The current book's name is: " + book.bookName);
        System.out.println("The current book's library number is: " + book.bookNumber);
        if (book.ableToBeCheckedOut == true) {
            System.out.println("The current book is able to be checked out");
        } else {
            System.out.println("The current book is unable to be checked out");
        }
    }

    //getter for bookName
    String returnBookName() { return(bookName);}

    //getter for bookNumber
    int returnBookNumber() { return(bookNumber);}

    //getter for ableToBeCheckedOut
    boolean returnAbleToBeCheckedOut() { return(ableToBeCheckedOut);}

    //getter for authorName
    String returnAuthorName() { return(authorName);}

    //setter for ableToBeCheckedOut
    void changeCheckedOut(boolean ableToBeCheckedOut) {
        this.ableToBeCheckedOut = ableToBeCheckedOut;
    }

    //setter for bookName
    void changeBookName(String bookName) { this.bookName = bookName; }

    //setter for authorName
    void changeAuthorName(String authorName) { this.authorName = authorName; }

}
