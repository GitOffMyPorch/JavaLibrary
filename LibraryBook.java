public class LibraryBook {

    String bookName;
    int bookNumber;
    boolean ableToBeCheckedOut;

    //constructor that gives a LibraryBook object its attributes
    LibraryBook(String bookName, int bookNumber, boolean ableToBeCheckedOut) {
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.ableToBeCheckedOut = ableToBeCheckedOut;
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

    //method that changes book number
    void change_book_number(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    //method that changes checked out functionality
    void change_checked_out(boolean ableToBeCheckedOut) {
        this.ableToBeCheckedOut = ableToBeCheckedOut;
    }

    //method that changes book name
    void change_book_name(String bookName) { this.bookName = bookName; }

}
