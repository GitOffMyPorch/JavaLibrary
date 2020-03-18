import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {

    public static void usingBufferedWriter(ArrayList<LibraryBook> book) throws java.io.IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data"));
        for(int i = 0; i < book.size(); i++) {
            String s1 = Integer.toString(book.get(i).bookNumber);
            String s2 = s1.concat("_" + book.get(i).bookName);
            String s3 = s2.concat("_" + book.get(i).authorName);
            String s4 = s3.concat("_" + book.get(i).ableToBeCheckedOut);
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
}
