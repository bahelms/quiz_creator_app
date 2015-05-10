import java.io.*;

public class Test {
  private String name;
  private String[] questions;
  private String[] answers;
  private int index;

  public Test(String name) {
    this.name = name;
    questions = new String[500];
    answers = new String[500];
    index = 0;
  }

  public String name() { return name; }

  public void createQuestion(String question, String answer) {
    questions[index] = question;
    answers[index] = answer;
    index++;
  }

  public void saveTestToFile() {
    try {
      PrintWriter writer = new PrintWriter("Test.txt");
      for (int i = 0; i < index; i++) {
        writer.println("Q" + (i+1) + ":" + questions[i]);
        writer.println("A" + (i+1) + ":" + answers[i]);
      }
      writer.close();
    }
    catch (FileNotFoundException e) {}
  }
}

