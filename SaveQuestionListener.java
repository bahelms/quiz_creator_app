import java.awt.event.*;
import javax.swing.*;

public class SaveQuestionListener implements ActionListener {
  private Test test;
  private String question;
  private String answer;

  public SaveQuestionListener(Test test, String question, String answer) { 
    this.test = test; 
    this.question = question;
    this.answer = answer;
  }

  public void actionPerformed(ActionEvent event) {
    System.out.println("Question: " + question);
  }
}

