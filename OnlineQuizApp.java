import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

// Abstract class for questions
abstract class Question {
    private String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    // Abstract method to be implemented by subclasses
    public abstract boolean checkAnswer(String response);

    // Abstract method to get the score for a question
    public abstract int getScore();

    // Abstract method to create a panel for displaying the question
    public abstract JPanel createQuestionPanel();
}

// Subclass for multiple-choice questions
class MultipleChoiceQuestion extends Question {
    private String[] choices;
    private int correctChoiceIndex;

    public MultipleChoiceQuestion(String questionText, String[] choices, int correctChoiceIndex) {
        super(questionText);
        this.choices = choices;
        this.correctChoiceIndex = correctChoiceIndex;
    }

    public String[] getChoices() {
        return choices;
    }

    @Override
    public boolean checkAnswer(String response) {
        int selectedChoice = Integer.parseInt(response);
        return selectedChoice == correctChoiceIndex;
    }

    @Override
    public int getScore() {
        return 1; // Multiple-choice questions are scored with 1 point for correct answers
    }

    @Override
    public JPanel createQuestionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(getQuestionText(), SwingConstants.CENTER), BorderLayout.NORTH);

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));  // Use BoxLayout for vertical arrangement
    
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < choices.length; i++) {
            JRadioButton radioButton = new JRadioButton(choices[i]);
            radioButton.setActionCommand(Integer.toString(i));
            radioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Add hover effect
            buttonGroup.add(radioButton);
            answerPanel.add(radioButton);
        }

        panel.add(answerPanel, BorderLayout.CENTER);

        return panel;
    }
}

// Subclass for true/false questions
class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String questionText, boolean correctAnswer) {
        super(questionText);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String response) {
        boolean selectedAnswer = Boolean.parseBoolean(response);
        return selectedAnswer == correctAnswer;
    }

    @Override
    public int getScore() {
        return 1; // True/false questions are scored with 1 point for correct answers
    }

    @Override
    public JPanel createQuestionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(getQuestionText(), SwingConstants.CENTER), BorderLayout.NORTH);

        JButton trueButton = new JButton("True");
        JButton falseButton = new JButton("False");

        trueButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Add hover effect
        falseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Add hover effect

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(trueButton);
        buttonPanel.add(falseButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }
}

// Class for the quiz itself
class Quiz {
    private Question[] questions;
    private int currentQuestionIndex;
    private int score;
    private JPanel quizPanel;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void takeQuiz() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Online Quiz");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLayout(new BorderLayout());

            quizPanel = new JPanel(new CardLayout());
            JButton nextButton = new JButton("Next");

            for (Question question : questions) {
                JPanel questionPanel = question.createQuestionPanel();
                quizPanel.add(questionPanel);

                JPanel answerPanel = new JPanel(new GridLayout(0, 1));
                answerPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the answer panel

                if (question instanceof MultipleChoiceQuestion) {
                    String[] choices = ((MultipleChoiceQuestion) question).getChoices();
                    for (int i = 0; i < choices.length; i++) {
                        JButton choiceButton = new JButton(choices[i]);
                        choiceButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Add hover effect
                        choiceButton.addActionListener(e -> {
                            String response = Integer.toString(Arrays.asList(choices).indexOf(choiceButton.getText()));
                            handleResponse(frame, questionPanel, question, response);
                        });
                        answerPanel.add(choiceButton);
                    }
                } else if (question instanceof TrueFalseQuestion) {
                    JButton trueButton = new JButton("True");
                    JButton falseButton = new JButton("False");

                    trueButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Add hover effect
                    falseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Add hover effect

                    trueButton.addActionListener(e -> handleResponse(frame, questionPanel, question, "true"));
                    falseButton.addActionListener(e -> handleResponse(frame, questionPanel, question, "false"));

                    answerPanel.add(trueButton);
                    answerPanel.add(falseButton);
                }

                questionPanel.add(answerPanel, BorderLayout.CENTER);
            }

            nextButton.addActionListener(e -> {
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    CardLayout cardLayout = (CardLayout) quizPanel.getLayout();
                    cardLayout.next(quizPanel);
                    frame.revalidate();
                    frame.repaint();
                } else {
                    showResult(frame);
                }
            });

            frame.add(quizPanel, BorderLayout.CENTER);
            frame.add(nextButton, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private void handleResponse(JFrame frame, JPanel questionPanel, Question question, String response) {
        if (question.checkAnswer(response)) {
            score += question.getScore();
        }
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            CardLayout cardLayout = (CardLayout) quizPanel.getLayout();
            cardLayout.next(quizPanel);
            frame.revalidate();
            frame.repaint();
        } else {
            showResult(frame);
        }
    }

    private void showResult(JFrame frame) {
        JPanel resultPanel = new JPanel(new BorderLayout());
        JLabel scoreLabel = new JLabel("Your total score is: " + score + "/" + questions.length);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Set font size
        scoreLabel.setForeground(new Color(255, 215, 0)); // Golden yellow color

        resultPanel.add(scoreLabel, BorderLayout.CENTER);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> frame.dispose());
        resultPanel.add(exitButton, BorderLayout.SOUTH);

        frame.getContentPane().removeAll();
        frame.add(resultPanel);
        frame.revalidate();
        frame.repaint();
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        // Sample questions
        Question[] questions = {
                new MultipleChoiceQuestion("What is the capital of France?", new String[]{"Madird", "Paris", "Yaounde", "London"}, 1),
                new TrueFalseQuestion("Java is a programming language.", true),
                new MultipleChoiceQuestion("Which of the following is a Java keyword?", new String[]{"Python", "class", "function", "JavaScript"}, 1),
                new TrueFalseQuestion("Inheritance is a feature of Java.", true),
                new MultipleChoiceQuestion("What is the powerhouse of the cell?", new String[]{"Nucleus", "Mitochondria", "Ribosome", "Endoplasmic Reticulum"}, 1),
                new TrueFalseQuestion("The Earth is flat.", false),
                new MultipleChoiceQuestion("Which planet is known as the Red Planet?", new String[]{"Venus", "Jupiter", "Mars", "Mercury"}, 2),
                new TrueFalseQuestion("Water boils at 100 degrees Celsius.", true),
                new MultipleChoiceQuestion("Who wrote the play 'Romeo and Juliet'?", new String[]{"William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"}, 0),
                new TrueFalseQuestion("The sun is a planet.", false)
       
            };

        // Create and take the quiz
        Quiz quiz = new Quiz(questions);
        quiz.takeQuiz();
    }
}
