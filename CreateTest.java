import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CreateTest extends JPanel {
  private Test test;
  private JFrame mainFrame;
  private JFrame createTestFrame;
  private JTextArea question;
  private JTextArea answer;
  private JButton saveQuestionButton;
  private JButton newQuestionButton;
  private JButton doneButton;

  public CreateTest(Test test, JFrame mainFrame, JFrame createTestFrame) {
    this.test = test;
    this.mainFrame = mainFrame;
    this.createTestFrame = createTestFrame;

    setPreferredSize(new Dimension(400, 200));
    setLayout(new BorderLayout(30, 30));

    add(setupLabels(), BorderLayout.WEST);
    add(setupFields(), BorderLayout.CENTER);
    add(setupButtons(), BorderLayout.SOUTH);
  }

  public JPanel setupLabels() {
    JPanel labels = new JPanel(new GridLayout(2, 1));
    labels.add(new JLabel("\t\tEnter Question: "));
    labels.add(new JLabel("\t\tEnter Answer: "));
    return labels;
  }

  public JPanel setupFields() {
    question = new JTextArea(10, 10);
    question.setLineWrap(true);
    question.setWrapStyleWord(true);

    answer = new JTextArea(10, 10);
    answer.setLineWrap(true);
    answer.setWrapStyleWord(true);

    JPanel fields = new JPanel(new GridLayout(2, 1));
    fields.add(new JScrollPane(question));
    fields.add(new JScrollPane(answer));
    return fields;
  }

  public JPanel setupButtons() {
    saveQuestionButton = new JButton("Save Question");
    doneButton = new JButton("Done");

    saveQuestionButton.addActionListener(
      new SaveQuestionListener(test, question, answer));

    doneButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        test.saveTestToFile();
        createTestFrame.dispose();
        JOptionPane.showMessageDialog(null, test.name() + " created!");
        mainFrame.setVisible(true);
      }
    });

    JPanel buttons = new JPanel(new GridLayout(1, 3));
    buttons.add(saveQuestionButton);
    buttons.add(doneButton);
    return buttons;
  }
}
