import java.awt.BorderLayout;
import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.ScrollPaneConstants;
import java.io.InputStream;
import java.io.InputStreamReader;


public class QuestionsPage extends javax.swing.JFrame {
    private ArrayList<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private Object question;
    private String userName;
    private String userMSSV;

    /**
     * Creates new form QuestionsPage
     */
    public QuestionsPage(String userName, String userMSSV) {
       this.userName = userName;
       this.userMSSV = userMSSV;
       setTitle("Cau hoi trac nghiem - " + userMSSV);
        initComponents();
        setLocationRelativeTo(null);
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        loadQuestionsFromFile();
        displayQuestion(currentQuestionIndex);
        
        jPanelQuestion.setLayout(new BorderLayout());
        jPanelQuestion.add(jLabelQuestion,BorderLayout.CENTER);
//       JScrollPane jScrollPaneQuestion = new JScrollPane(jLabelQuestion);
//        jScrollPaneQuestion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        jScrollPaneQuestion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//        jPanelQuestion.add(jScrollPaneQuestion, BorderLayout.CENTER);

    }

     
    private void loadQuestionsFromFile() {
    String path = "/database.txt";
    try (InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            String question = parts[0].trim();
            String[] options = {parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim()};
//            char correctAnswer = parts[5].charAt(0);
//            questions.add(new Question(question, options, correctAnswer));
            String correctAnswer = parts[5].trim(); // Directly take the correct answer string
            questions.add(new Question(question, options, correctAnswer));

        }
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
//    private void displayQuestion(int index) {
//    if (index >= 0 && index < questions.size()) {
//        Question currentQuestion = questions.get(index);
//        jLabelQuestion.setText(currentQuestion.getQuestionText());
//        jRadioButton1.setText(currentQuestion.getOptions()[0]);
//        jRadioButton2.setText(currentQuestion.getOptions()[1]);
//        jRadioButton3.setText(currentQuestion.getOptions()[2]);
//        jRadioButton4.setText(currentQuestion.getOptions()[3]);
//        }
//    }
      private void displayQuestion(int index) {
    if (index >= 0 && index < questions.size()) {
        Question currentQuestion = questions.get(index);
        // Use HTML tags to enable line wrapping in JLabel
        jLabelQuestion.setText("<html><body style='width: 350px'; text-align: center>" + currentQuestion.getQuestionText() + "</body></html>");
        jRadioButton1.setText("<html>" + currentQuestion.getOptions()[0] + "</html>");
        jRadioButton2.setText("<html>" + currentQuestion.getOptions()[1] + "</html>");
        jRadioButton3.setText("<html>" + currentQuestion.getOptions()[2] + "</html>");
        jRadioButton4.setText("<html>" + currentQuestion.getOptions()[3] + "</html>");
        
        // Clear sectiọn
        buttonGroup1.clearSelection();
        
        // check user answer and select the corresponding radio
        String userAnswer = currentQuestion.getUserAnswer();
        if (userAnswer.isEmpty()) {
            buttonGroup1.clearSelection();  // Ensures no selection if no answer has been previously recorded
        } else {
            if (userAnswer.equals(currentQuestion.getOptions()[0])) {
                jRadioButton1.setSelected(true);
            } else if (userAnswer.equals(currentQuestion.getOptions()[1])) {
                jRadioButton2.setSelected(true);
            } else if (userAnswer.equals(currentQuestion.getOptions()[2])) {
                jRadioButton3.setSelected(true);
            } else if (userAnswer.equals(currentQuestion.getOptions()[3])) {
                jRadioButton4.setSelected(true);
            }
        }

        // Repack the frame to adjust to content size changes
        this.pack();
    }
}
      private void updateAnswer() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (jRadioButton1.isSelected()) {
            currentQuestion.setUserAnswer(jRadioButton1.getText().replaceAll("<html>|</html>", ""));
        } else if (jRadioButton2.isSelected()) {
            currentQuestion.setUserAnswer(jRadioButton2.getText().replaceAll("<html>|</html>", ""));
        } else if (jRadioButton3.isSelected()) {
            currentQuestion.setUserAnswer(jRadioButton3.getText().replaceAll("<html>|</html>", ""));
        } else if (jRadioButton4.isSelected()) {
            currentQuestion.setUserAnswer(jRadioButton4.getText().replaceAll("<html>|</html>", ""));
        }
}
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelContent = new javax.swing.JPanel();
        jPanelQuestion = new javax.swing.JPanel();
        jLabelQuestion = new javax.swing.JLabel();
        jPanelAnswser1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanelAnswer2 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanelAnswer3 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanelAnswer4 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButtonFirst = new javax.swing.JButton();
        jButtonPrev = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonLast = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cau hoi trac nghiem - MSSV: " + userMSSV );
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContent.setLayout(new java.awt.BorderLayout());

        jPanelQuestion.setLayout(new java.awt.CardLayout());

        jLabelQuestion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelQuestion.setText("<html>Loading\n\n</html>");
        jLabelQuestion.setToolTipText("");
        jPanelQuestion.add(jLabelQuestion, "card2");

        jPanelContent.add(jPanelQuestion, java.awt.BorderLayout.CENTER);

        jPanelAnswser1.setLayout(new java.awt.CardLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("<html> Lựa chọn </htm>");
        jPanelAnswser1.add(jRadioButton1, "card2");

        jPanelAnswer2.setLayout(new java.awt.CardLayout());

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("<html> Lựa chọn </htm>");
        jPanelAnswer2.add(jRadioButton2, "card2");

        jPanelAnswer3.setLayout(new java.awt.CardLayout());

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("<html> Lựa chọn </htm>");
        jPanelAnswer3.add(jRadioButton3, "card2");

        jPanelAnswer4.setLayout(new java.awt.CardLayout());

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("<html> Lựa chọn </htm>");
        jPanelAnswer4.add(jRadioButton4, "card2");

        jButtonFirst.setFont(new java.awt.Font("Segoe UI Light", 3, 16)); // NOI18N
        jButtonFirst.setText("First");
        jButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFirstActionPerformed(evt);
            }
        });

        jButtonPrev.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButtonPrev.setText("<");
        jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevActionPerformed(evt);
            }
        });

        jButtonNext.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonLast.setFont(new java.awt.Font("Segoe UI Light", 3, 16)); // NOI18N
        jButtonLast.setText("Last");
        jButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLastActionPerformed(evt);
            }
        });

        jButtonSubmit.setBackground(new java.awt.Color(204, 255, 204));
        jButtonSubmit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonSubmit.setForeground(new java.awt.Color(204, 0, 153));
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButtonFirst)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonLast))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelAnswer3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAnswer2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAnswser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAnswer4, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jButtonSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAnswser1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAnswer4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLast)
                    .addComponent(jButtonFirst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSubmit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        updateAnswer();
        currentQuestionIndex++;
        if (currentQuestionIndex >= questions.size()) {
        currentQuestionIndex = questions.size() - 1;
        }
        displayQuestion(currentQuestionIndex);
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevActionPerformed
        // TODO add your handling code here:
        updateAnswer();
        currentQuestionIndex--;
        if (currentQuestionIndex < 0) {
            currentQuestionIndex = 0; // Không lùi quá câu hỏi đầu tiên
        }
        displayQuestion(currentQuestionIndex);
    }//GEN-LAST:event_jButtonPrevActionPerformed

    private void jButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFirstActionPerformed
        // TODO add your handling code here:
        updateAnswer();
         currentQuestionIndex = 0;
        displayQuestion(currentQuestionIndex);
    }//GEN-LAST:event_jButtonFirstActionPerformed

    private void jButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLastActionPerformed
        // TODO add your handling code here:
        updateAnswer();
        currentQuestionIndex = questions.size() - 1;
        displayQuestion(currentQuestionIndex);
    }//GEN-LAST:event_jButtonLastActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
        updateAnswer(); 
        int score = 0;
    for (Question q : questions) {
       String userAnswer = q.getUserAnswer().replaceAll("<html>|</html>", "").trim(); 
        if (userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) { 
            score += 1;
        }
    }
    JOptionPane.showMessageDialog(this, "Điểm của bạn: " + score);
    // Confirm exit
    int response = JOptionPane.showConfirmDialog(this, "Bạn đã hoàn thành! Bạn có muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
        dispose();
    }
       
//      JOptionPane.showMessageDialog(this, "Bạn đã hoàn thành!");
//      dispose();
        //xác nhận thoát
        
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuestionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionsPage("Username", "UserMSSV").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JPanel jPanelAnswer2;
    private javax.swing.JPanel jPanelAnswer3;
    private javax.swing.JPanel jPanelAnswer4;
    private javax.swing.JPanel jPanelAnswser1;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelQuestion;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables

 
}
