import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Utility {


    public static void usingBufferedWriter(ArrayList<LibraryBook> book) throws java.io.IOException {
                ArrayList<LibraryBook> object = book;
                String filename = "data.ser";
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(object);
                out.flush();
                out.close();
    }

    public static void usingReader() throws java.io.IOException, java.lang.ClassNotFoundException {
                String filename = "data.ser";
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
                ArrayList<LibraryBook> object = (ArrayList<LibraryBook>) in.readObject();
                LibraryFrontEnd.book = object;
                in.close();
                file.close();
    }

    public static void updateShowBooksTextArea(JTextArea showbooks) {
        String old = "";
        for(int i = 0; i < LibraryFrontEnd.book.size(); i++) {
            old = old + i + ": " + LibraryFrontEnd.book.get(i).returnBookName() + ", ";
            showbooks.setText(old);
            showbooks.setLineWrap(true);
        }
    }

    public static void searchAnArrayForText(String input, ArrayList<LibraryBook> book, JTextArea areaToAppendText) {
        for (int j = 0; j < book.size(); j++) {
            if (book.get(j).returnBookName().contains(input)) {
                String oldText;
                oldText = "Book Name: " + book.get(j).returnBookName() + " \n";
                oldText = oldText + "Author Name: " + book.get(j).returnAuthorName() + " \n";
                int i1 = book.get(j).returnBookNumber();
                String s1 = Integer.toString(i1);
                oldText = oldText + "Book Number: " + s1 + " \n";
                Boolean b1 = book.get(j).returnAbleToBeCheckedOut();
                String s2 = Boolean.toString(b1);
                oldText = oldText + "Able to be checked out: " + s2 + " \n";
                oldText = oldText + "Book Section: " + book.get(j).returnBookSection() + " \n";
                areaToAppendText.append(oldText);
                areaToAppendText.setLineWrap(true);
            }
        }
    }

}
