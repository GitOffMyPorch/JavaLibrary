import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {

    public static void usingBufferedWriter(ArrayList<LibraryBook> book) throws java.io.IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data"));
        for(int i = 0; i < book.size(); i++) {
            String s1 = Integer.toString(book.get(i).returnBookNumber());
            String s2 = s1.concat("_" + book.get(i).returnBookName());
            String s3 = s2.concat("_" + book.get(i).returnAuthorName());
            String s4 = s3.concat("_" + book.get(i).returnAbleToBeCheckedOut());
            writer.write(s4 + "\n");
        }
        writer.close();
    }

    public static void usingReader() throws java.io.IOException {
        Scanner scan = new Scanner(new File("data"));
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] arrayOfStr = str.split("_");
            int number = Integer.valueOf(arrayOfStr[0]);
            String name = arrayOfStr[1];
            String author = arrayOfStr[2];
            Boolean checked = Boolean.valueOf(arrayOfStr[3]);
            LibraryFrontEnd.book.add(new LibraryBook(name, number, checked, author));
        }
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
                areaToAppendText.append(oldText);
                areaToAppendText.setLineWrap(true);
            }
        }
    }

}
