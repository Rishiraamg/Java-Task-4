import java.io.*;
import java.util.Scanner;

public class Task4 {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeNote(scanner);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Notes App...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }

    private static void writeNote(Scanner scanner) {
        System.out.println("Enter your note (type 'END' on a new line to finish):");

        try (FileWriter fw = new FileWriter(FILE_NAME, true); BufferedWriter bw = new BufferedWriter(fw)) {
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readNotes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No notes found. Start writing one!");
            return;
        }

        System.out.println("\n--- Your Notes ---");
        try (FileReader fr = new FileReader(FILE_NAME); BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
