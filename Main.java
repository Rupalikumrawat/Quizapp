import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizApp quizApp = new QuizApp();
        AdminPanel adminPanel = new AdminPanel();
        String fileName = "questions.txt";

        while (true) {
            System.out.println("\n==== Online Quiz Application ====");
            System.out.println("1. Admin Panel (Add Questions)");
            System.out.println("2. Start Quiz");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        adminPanel.addQuestion(fileName);
                        break;
                    case 2:
                        quizApp.loadQuestions(fileName);
                        quizApp.startQuiz();
                        quizApp.displayResults();
                        break;
                    case 3:
                        System.out.println("Exiting application. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
