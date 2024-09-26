public class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer; // Store correct answer as String

    public Question(String question, String[] options, String correctAnswer) {
        this.questionText = question;
        this.options = options;
        this.correctAnswer = correctAnswer; // Ensure correctAnswer is a String
    }

    Question(String question, String[] options, char correctAnswer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer; // Return as String
    }
}
