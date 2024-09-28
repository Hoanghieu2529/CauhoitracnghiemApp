public class Question {

    private String questionText;
    private String[] options;
    private String correctAnswer; // Store correct answer as String
    private String userAnswer;

    public Question(String question, String[] options, String correctAnswer) {
        this.questionText = question;
        this.options = options;
        this.correctAnswer = correctAnswer; // Ensure correctAnswer is a String
        this.userAnswer = "";
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
    public String getUserAnswer() {
        return userAnswer; // Return user's answer
    }
  
     public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer; // Phương thức để cập nhật câu trả lời của người dùng
    }
}

