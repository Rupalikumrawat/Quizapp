import java.io.*;
import java.util.*;

public class QuizApp {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    // Load questions from a file
    public void loadQuestions(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            String questionText = parts[0];
            String[] options = Arrays.copyOfRange(parts, 1, 5);
            int correctAnswer = Integer.parseInt(parts[5]);
            questions.add(new Question(questionText, options, correctAnswer));
        }
        reader.close();
    }

    // Start the quiz
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt() - 1;
            if (answer == question.getCorrectAnswer()) {
                score++;
            }
        }
    }

    // Display quiz results
    public void displayResults() {
        System.out.println("You scored: " + score + "/" + questions.size());
        System.out.println("Thanks for participating!");
    }
}
