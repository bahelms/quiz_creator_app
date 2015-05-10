import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ScoreTest extends JPanel {
  private JTextArea results;
  private Test test;
  private String[] responses;

  public ScoreTest() {
    try {
      test = Test.loadTest();
      responses = loadResponses();

      setPreferredSize(new Dimension(500, 600));
      setLayout(new BorderLayout());

      results = new JTextArea();
      results.setLineWrap(true);
      results.setWrapStyleWord(true);
      results.setEditable(false);

      results.setText(test.displayResultsFor(responses));

      add(new JScrollPane(results), BorderLayout.CENTER);
    }
    catch (FileNotFoundException e) {}
  }

  private String[] loadResponses() throws FileNotFoundException {
    String[] temp = new String[500];
    int i = 0;
    Scanner file = new Scanner(new File("Responses.txt"));

    while (file.hasNextLine()) {
      temp[i] = file.nextLine().split(":")[1];
      i++;
    }
    file.close();
    return Arrays.copyOfRange(temp, 0, i);
  }
}

