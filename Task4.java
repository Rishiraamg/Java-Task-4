import java.io.*;
import java.util.*;
//NOTES APP CREATED BY RISHIRAAM GOPINATH USING FILE METHODS
//BY USING FILEWRITER, FILE, BUFFEREDREADER TO INTERACT WITH THE TEXT FILE
public class Task4 {
    public static final String FILE_NAME = "notes.txt";

    public static void sc(Scanner sc ) {
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(note + System.lineSeparator());
            System.out.println("Note saved!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewNotes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("\nDisplaying Your Notes ");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Notes App using JAVA");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 3) {
                System.out.println("Exiting Notes App\n\n");
                break;
            }
            if(option > 3 || option < 1 ){
                System.out.println("Invalid Option. Select again\n\n");
                continue;
            }

            switch (option) {
                case 1:
                    sc(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
            }
        }
    }
}

