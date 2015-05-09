import java.awt.event.*;
import javax.swing.*;

public class SaveQuestionListener implements ActionListener {
  private Test test;
  private JTextArea question;
  private JTextArea answer;

  public SaveQuestionListener(Test test, JTextArea question, JTextArea answer) { 
    this.test = test; 
    this.question = question;
    this.answer = answer;
  }

  public void actionPerformed(ActionEvent event) {
    if (question.getText().equals("") || answer.getText().equals("")) {
      JOptionPane.showMessageDialog(null, 
        "Blank questions or answers are not allowed.");
    } else {
      question.setText("");
      answer.setText("");
    }
  }
}

