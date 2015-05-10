import java.io.*;
import java.util.*;

public class Test {
  public final static String FILENAME = "Test.txt";
  private String name;
  private String[] questions;
  private String[] answers;
  private int index;

  public static Test loadTest() throws FileNotFoundException {
    Scanner file = new Scanner(new File(Test.FILENAME));
    Test test = new Test(file.nextLine());

    while (file.hasNextLine()) {
      String question = file.nextLine().split(":")[1];
      String answer = file.nextLine().split(":")[1];
      test.createQuestion(question, answer);
    }
    file.close();
    return test;
  }

  public Test(String name) {
    this.name = name;
    questions = new String[500];
    answers = new String[500];
    index = 0;
  }

  public String name() { return name; }

  public String[] questions() { 
    return Arrays.copyOfRange(questions, 0, index);
  }

  public void createQuestion(String question, String answer) {
    questions[index] = question;
    answers[index] = answer;
    index++;
  }

  public void saveTestToFile() {
    try {
      PrintWriter writer = new PrintWriter(FILENAME);

      writer.println(name);
      for (int i = 0; i < index; i++) {
        writer.println("Q" + (i+1) + ":" + questions[i]);
        writer.println("A" + (i+1) + ":" + answers[i]);
      }
      writer.close();
    }
    catch (FileNotFoundException e) {}
  }

  public String displayResultsFor(String[] responses) {
    String results = "Test: " + name + "\n";
    int totalScore = 0;

    for (int i = 0; i < questions().length; i++) {
      int points = 0;

      if (answers[i].equals(responses[i])) {
        totalScore += 2;
        points = 2;
      }

      results = results.concat("\nQ# " + (i+1) + "\t" + "Points: " + points + "\n");
      results = results.concat("Question: " + questions[i] + "\n");
      results = results.concat("Your Answer: " + responses[i] + "\n");
      results = results.concat("Correct Answer: " + answers[i] + "\n");
    }

    results = results.concat("\nTotal Score: " + totalScore);
    return results;
  }
}

