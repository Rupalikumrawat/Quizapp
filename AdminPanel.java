import java.io.*;
import java.util.Scanner;

public class AdminPanel {
    public void addQuestion(String fileName) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the question:");
        String questionText = scanner.nextLine();

        String[] options = new String[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter option " + (i + 1) + ":");
            options[i] = scanner.nextLine();
        }

        System.out.println("Enter the correct option number (1-4):");
        int correctAnswer = scanner.nextInt() - 1;

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(questionText + "|" + String.join("|", options) + "|" + correctAnswer);
        writer.newLine();
        writer.close();

        System.out.println("Question added successfully!");
    }
}
