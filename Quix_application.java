
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Quix_application {

    static class QuizQuestion {
        private String questionText;
        private String[] answerOptions;
        private int correctIndex;

        public QuizQuestion(String text, String[] options, int correctIdx) {
            this.questionText = text;
            this.answerOptions = options;
            this.correctIndex = correctIdx;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String[] getAnswerOptions() {
            return answerOptions;
        }

        public int getCorrectIndex() {
            return correctIndex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<QuizQuestion> quiz = new ArrayList<>();
        int score = 0;

        // Initialize quiz questions
        quiz.add(new QuizQuestion("Which company developed the TensorFlow framework?", 
            new String[]{"1. Microsoft", "2. Google", "3. Amazon", "4. IBM"}, 1));
        quiz.add(new QuizQuestion("What is the latest version of the Java programming language as of 2024?", 
            new String[]{"1. Java 14", "2. Java 17", "3. Java 19", "4. Java 21"}, 3));
        quiz.add(new QuizQuestion("Which technology is used for container orchestration?", 
            new String[]{"1. Docker", "2. Kubernetes", "3. Ansible", "4. Puppet"}, 1));
        quiz.add(new QuizQuestion("Which programming language is known for its use in data science?", 
            new String[]{"1. C++", "2. Java", "3. Python", "4. Ruby"}, 2));
        quiz.add(new QuizQuestion("What does the acronym 'AI' stand for?", 
            new String[]{"1. Automatic Intelligence", "2. Artificial Intelligence", "3. Augmented Intelligence", "4. Adaptive Intelligence"}, 1));
        quiz.add(new QuizQuestion("Which company is known for the development of the Linux operating system?", 
            new String[]{"1. Red Hat", "2. Canonical", "3. Microsoft", "4. Apple"}, 1));
        quiz.add(new QuizQuestion("What is the primary purpose of a Content Delivery Network (CDN)?", 
            new String[]{"1. Security", "2. Load Balancing", "3. Speed Up Content Delivery", "4. Database Management"}, 2));
        quiz.add(new QuizQuestion("Which cloud computing platform is developed by Amazon?", 
            new String[]{"1. Azure", "2. AWS", "3. Google Cloud", "4. IBM Cloud"}, 1));
        quiz.add(new QuizQuestion("What does 'VR' stand for in the context of technology?", 
            new String[]{"1. Virtual Reality", "2. Virtual Rendering", "3. Virtual Revolution", "4. Visual Reality"}, 1));
        quiz.add(new QuizQuestion("Which database technology is known for its use in blockchain applications?", 
            new String[]{"1. MySQL", "2. PostgreSQL", "3. MongoDB", "4. Distributed Ledger"}, 3));

        // Iterate through each question in the quiz
        for (int i = 0; i < quiz.size(); i++) {
            QuizQuestion currentQuestion = quiz.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.getQuestionText());
            String[] options = currentQuestion.getAnswerOptions();
            for (String option : options) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            boolean answered = false;

            // Allow time for the user to answer
            while (true) {
                if (System.currentTimeMillis() - startTime > 10000) { // 10 seconds limit
                    System.out.println("\nTime's up!");
                    break;
                }

                System.out.print("Your answer (1-4): ");
                if (scanner.hasNextInt()) {
                    int userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= 4) {
                        if (userAnswer - 1 == currentQuestion.getCorrectIndex()) {
                            System.out.println("Correct answer!");
                            score++;
                        } else {
                            System.out.println("Incorrect. The right answer was: " + (currentQuestion.getCorrectIndex() + 1));
                        }
                        answered = true;
                        break;
                    } else {
                        System.out.println("Please select a valid option (1-4).");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }

            if (!answered) {
                System.out.println("You did not respond in time.");
            }
        }

        // Display the final results
        System.out.println("\nQuiz Completed!");
        System.out.println("Your total score: " + score + " out of " + quiz.size());

        scanner.close();
    }
}
