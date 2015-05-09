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

  public void display() {
    System.out.println("\nChapter 7 & 8 General Assessment\n");

    for (int i = 0; i < index; i++) {
      System.out.println("GA Question #" + (i+1) + "\t" + "Points: ");
      System.out.println(questions[i]);
      System.out.println("CORRECT ANSWER: " + answers[i]);
      System.out.println();
    }
  }
}


