import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryFrontEnd {
    private JPanel rootPanel;
    static int x = 0;
    static boolean state;


    public static void main(String args[]) {
        JFrame f = new JFrame("Library Database");
        ArrayList<LibraryBook> book = new ArrayList<LibraryBook>();
        JTextArea showbooks = new JTextArea();
        JButton addBook = new JButton("Add a Book");
        JButton changeBook = new JButton("Change a Book");
        JTextField whichBook = new JTextField("book number update");
        JTextField changeName = new JTextField("book name change");
        JCheckBox AbleToCheck = new JCheckBox("book check out feature");
        JLabel bookNumberLabel = new JLabel("Which Book are you changing? ");
        JLabel changeNameLabel = new JLabel("Change Book Name: ");
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JTabbedPane pane = new JTabbedPane();

        showbooks.setBounds(50, 50, 300, 100);
        addBook.setBounds(50, 200, 300, 50);
        changeBook.setBounds(50, 250, 300,50);
        whichBook.setBounds(50, 350, 300, 30);
        changeName.setBounds(50, 450, 300, 30);
        AbleToCheck.setBounds(200, 160, 300, 30);
        bookNumberLabel.setBounds(50, 320, 300, 30);
        changeNameLabel.setBounds(50, 420, 300, 30);
        pane.setBounds(0,0, 1000, 1000);



        addBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.add(new LibraryBook("null", x, false));
                x++;
                String old = "";
                for(int i = 0; i < book.size(); i++) {
                    old = old + i + ": " + book.get(i).bookName + ", ";
                    showbooks.setText(old);
                    showbooks.setLineWrap(true);
                }
            }
        });

        changeBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i = whichBook.getText();
                int a = Integer.parseInt(i);
                book.get(a).change_book_name(changeName.getText());

                String old = "";
                for(int j = 0; j < book.size(); j++) {
                    old = old + j + ": " + book.get(j).bookName + ", ";
                    showbooks.setText(old);
                    showbooks.setLineWrap(true);
                }


                book.get(a).change_checked_out(state);
            }
        });

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

        pane.add("Main", panel);
        pane.add("Side", panel2);


        panel.add(changeNameLabel);
        panel.add(bookNumberLabel);
        panel.add(showbooks);
        panel.add(addBook);
        panel.add(changeBook);
        panel.add(whichBook);
        panel.add(changeName);
        panel.add(AbleToCheck);
        f.add(pane);
        f.setSize(1000,1000);
        f.setLayout(null);
        panel.setLayout(null);
        f.setVisible(true);


    }

}

