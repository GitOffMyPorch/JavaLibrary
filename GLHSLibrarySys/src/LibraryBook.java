public class LibraryBook implements java.io.Serializable {

    private String bookName;
    private int bookNumber;
    private boolean ableToBeCheckedOut;
    private String authorName;
    private String bookSection;

    //constructor that gives a LibraryBook object its attributes
    LibraryBook(String bookName, int bookNumber, boolean ableToBeCheckedOut, String authorName, String bookSection) {
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.ableToBeCheckedOut = ableToBeCheckedOut;
        this.authorName = authorName;
        this.bookSection = bookSection;
    }

    //getter for bookName
    String returnBookName() { return(bookName);}

    //getter for bookNumber
    int returnBookNumber() { return(bookNumber);}

    //getter for ableToBeCheckedOut
    boolean returnAbleToBeCheckedOut() { return(ableToBeCheckedOut);}

    //getter for authorName
    String returnAuthorName() { return(authorName);}

    //getter for bookSection
    String returnBookSection() { return(bookSection);}

    //setter for bookSection
    void changeBookSection(String bookSection) { this.bookSection = bookSection; }

    //setter for ableToBeCheckedOut
    void changeCheckedOut(boolean ableToBeCheckedOut) { this.ableToBeCheckedOut = ableToBeCheckedOut; }

    //setter for bookName
    void changeBookName(String bookName) { this.bookName = bookName; }

    //setter for authorName
    void changeAuthorName(String authorName) { this.authorName = authorName; }

}
