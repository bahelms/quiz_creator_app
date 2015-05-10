import java.io.*;
import javax.swing.*;

public class TakeTest {
  private String[] responses;
  private Test test;

  public TakeTest(Test test) {
    this.test = test;
  }

  public void start() {
    responses = new String[test.questions().length];
    int i = 0;

    for (String question : test.questions()) {
      responses[i] = JOptionPane.showInputDialog(question);
      i++;
    }
  }

  public void saveResponsesToFile() {
    try {
      PrintWriter writer = new PrintWriter("Responses.txt");
      for (int i = 0; i < responses.length; i++)
        writer.println("A" + (i+1) + ":" + responses[i]);
      writer.close();
    }
    catch (FileNotFoundException e) {}
  }
}

