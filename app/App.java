
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);
            System.out.println("File to read: ");
            String fileName = in.nextLine();
            File file = new File(fileName);

            Scanner fileReader = new Scanner(file);
            UserInterface ui = new UserInterface(in, fileReader);

            ui.start();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

}
