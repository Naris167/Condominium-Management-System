package Week_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileSequence implements IntSequence, Closeable, Channel {
    //1.3.6 Implementing Multiple Interfaces
    @Override
    public boolean close() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public int next() {
        return 0;
    }

    public static void readNumber(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextLine()) {
            String text = input.nextLine();
            System.out.println(text);
        }
    }
}
