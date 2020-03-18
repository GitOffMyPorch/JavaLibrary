import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryFrontEnd {
    // not sure what this is, but don't remove it, it will break
    private JPanel rootPanel;

    /* makes sure that the bookNumber is
    incremented when the addBook button is pressed */
    static int x = 0;

    /* boolean used to transfer the value of
    AbleToCheck to the changeBook action listener */
    static boolean state;

    // make an ArrayList to store book objects
     static ArrayList<LibraryBook> book = new ArrayList<LibraryBook>();

    // main function start
    public static void main(String args[]) {
        // add a JFrame object containing all the components
        JFrame f = new JFrame("Library Database");
        // object for displaying a list of all the current books
        JTextArea showbooks = new JTextArea();
        // make the showbooks scrollable
        JScrollPane showScroll = new JScrollPane(showbooks);
        // make an addBook button
        JButton addBook = new JButton("Add a Book");
        // make a saveBooks button
        JButton saveBooks = new JButton("Save");
        // make a loadBooks button
        JButton loadBooks = new JButton("Load");
        // make a deleteBook button
        JButton deleteBook = new JButton("Delete a Book");
        // make a changeBook button
        JButton changeBook = new JButton("Change a Book");
        // make a field for bookNumber which can be used for changing/deleting book objects
        JTextField whichBook = new JTextField("book number update");
        // make a field for changing the book name
        JTextField changeName = new JTextField("book name change");
        // make a field for changing the author name
        JTextField changeAuthor = new JTextField("author name change");
        // make a checkbox for the AbleToBeCheckedOut functionality
        JCheckBox AbleToCheck = new JCheckBox("book check out feature");
        // make a label that says "Which Book are you changing/deleting? "
        JLabel bookNumberLabel = new JLabel("Which Book are you changing/deleting? ");
        // make a label that says "Change Book Name; "
        JLabel changeNameLabel = new JLabel("Change Book Name: ");
        // make a label that says "Change Author Name: "
        JLabel changeAuthorLabel = new JLabel("Change Author Name: ");
        // create a JPanel object that goes inside the TabbedPane
        JPanel panel = new JPanel();
        // create a second JPanel object that goes inside TabbedPane
        JPanel panel2 = new JPanel();
        // create a TabbedPane for better organization
        JTabbedPane pane = new JTabbedPane();
        // create an input field for the search button
        JTextArea searchArray =  new JTextArea("");
        // make the searchArray scrollable
        JScrollPane searchScroll = new JScrollPane(searchArray);
        // create a search button that searches the ArrayList
        JButton search = new JButton("Search");

        // sets the bounds of all the components
        loadBooks.setBounds(50, 680, 300, 50);
        saveBooks.setBounds(50, 630, 300, 50);
        showScroll.setBounds(50, 50, 300, 100);
        addBook.setBounds(50, 200, 300, 50);
        changeBook.setBounds(50, 250, 300,50);
        deleteBook.setBounds(50, 580, 300, 50);
        whichBook.setBounds(50, 350, 300, 30);
        changeName.setBounds(50, 450, 300, 30);
        AbleToCheck.setBounds(200, 160, 300, 30);
        bookNumberLabel.setBounds(50, 320, 300, 30);
        changeNameLabel.setBounds(50, 420, 300, 30);
        changeAuthorLabel.setBounds(50, 500, 300, 30);
        changeAuthor.setBounds(50, 530, 300, 30);
        searchScroll.setBounds(50,100, 300, 100);
        search.setBounds(50, 200, 300, 50);
        pane.setBounds(0,0, 1000, 1000);


        /* When the addBook button is clicked it adds an empty
        book object and displays the book name in the showbooks
        JTextArea
        */
        addBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.add(new LibraryBook("null", x, false, "null"));
                x++;
                String old = "";
                for(int i = 0; i < book.size(); i++) {
                    old = old + i + ": " + book.get(i).bookName + ", ";
                    showbooks.setText(old);
                    showbooks.setLineWrap(true);
                }
            }
        });

        /* When saveBooks button is pressed take the contents of
         book ArrayList and put it in a file called "data" */
        saveBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Utility.usingBufferedWriter(book);
                } catch (java.io.IOException a) {
                    System.out.println("it didn't work");
                }
            }
        });

        /* When loadBooks button is pressed take the contents
         "data" and load it into the book ArrayList */
        loadBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Utility.usingReader();
                    String old = "";
                    for(int i = 0; i < book.size(); i++) {
                        old = old + i + ": " + book.get(i).bookName + ", ";
                        showbooks.setText(old);
                        showbooks.setLineWrap(true);
                    }
                } catch (java.io.IOException a) {
                    System.out.println("2 it didn't work");
                }
            }
        });

        /* When the deleteBook button is pressed
        gets an integer from the whichBook JTextField
        and to delete a book object, then update the
         showbooks JTextArea
         */
        deleteBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i = whichBook.getText();
                int a = Integer.parseInt(i);
                book.remove(a);

                String old = "";
                for (int j = 0; j < book.size(); j++) {
                    old = old + j + ": " + book.get(j).bookName + ", ";
                    showbooks.setText(old);
                    showbooks.setLineWrap(true);
                }
            }
            });

        /* When the changeBook button is pressed get
        an integer from whichBook to update, then get
         the text from changeName, changeAuthor,
         and change_checked_out fields to change the
          selected book object, then refresh showbook JTextArea
          */
        changeBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i = whichBook.getText();
                int a = Integer.parseInt(i);
                book.get(a).change_book_name(changeName.getText());
                book.get(a).change_author_name(changeAuthor.getText());
                book.get(a).change_checked_out(state);

                String old = "";
                for(int j = 0; j < book.size(); j++) {
                    old = old + j + ": " + book.get(j).bookName + ", ";
                    showbooks.setText(old);
                    showbooks.setLineWrap(true);
                }
            }
        });

        /* When the search button is pressed check if
        the contents of searchArray matches anything in
        the book ArrayList, if it does, return all the
        information related to that book object
         */
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String i = searchArray.getText();
                searchArray.setText("");
                for (int j = 0; j < book.size(); j++) {
                    if (book.get(j).bookName.contains(i)) {
                        String oldText;
                        oldText = "Book Name: " + book.get(j).bookName + " \n";
                        oldText = oldText + "Author Name: " + book.get(j).authorName + " \n";
                        int i1 = book.get(j).bookNumber;
                        String s1 = Integer.toString(i1);
                        oldText = oldText + "Book Number: " + s1 + " \n";
                        Boolean b1 = book.get(j).ableToBeCheckedOut;
                        String s2 = Boolean.toString(b1);
                        oldText = oldText + "Able to be checked out: " + s2 + " \n";
                        searchArray.append(oldText);
                        searchArray.setLineWrap(true);
                    }
                }

            }
        });

        /* If this is checked, change the state of the
        static boolean "state" to the opposite value
        (the state boolean is then used in the changeBook
        action listener)
         */
        AbleToCheck.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String i = whichBook.getText();
                int a = Integer.parseInt(i);
                if (book.get(a).ableToBeCheckedOut == true) {
                    state = false;
                } else {
                    state = true;
                }
            }
        });

        // add panes to the TabbedPane
        pane.add("Add Books", panel);
        pane.add("Search Books", panel2);

        // add components under the "Add Books" tab
        panel.add(changeNameLabel);
        panel.add(bookNumberLabel);
        panel.add(showScroll);
        panel.add(addBook);
        panel.add(deleteBook);
        panel.add(changeBook);
        panel.add(whichBook);
        panel.add(changeName);
        panel.add(AbleToCheck);
        panel.add(changeAuthorLabel);
        panel.add(changeAuthor);
        panel.add(saveBooks);
        panel.add(loadBooks);

        // add compnents under the "Search Books" tab
        panel2.add(searchScroll);
        panel2.add(search);

        /* add the TabbedPane (which contains the panels that
        contain all the components) to the JFrame window */
        f.add(pane);

        // set the size of the JFrame window
        f.setSize(1000,1000);

        // set the layout of JFrame window to manual component placement
        f.setLayout(null);

        // set the layout of the JPanels to manual component placement
        panel.setLayout(null);
        panel2.setLayout(null);

        // make the JFrame window visible
        f.setVisible(true);

        // close the application when the window is closed
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

