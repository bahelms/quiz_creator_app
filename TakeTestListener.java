import java.io.*;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;

public class TakeTestListener implements ActionListener {
  public void actionPerformed(ActionEvent event) {
    try {
      Test test = Test.loadTest();
      for (String question : test.questions()) {
        String userAnswer = JOptionPane.showInputDialog(question);
      }
    }
    catch (FileNotFoundException e) {}
  }
}

