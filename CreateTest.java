import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CreateTest extends JPanel {
  private JFrame mainFrame;
  private JFrame createTestFrame;
  private JTextArea question;
  private JTextArea answer;
  private JButton saveQuestionButton;
  private JButton newQuestionButton;
  private JButton doneButton;

  public CreateTest(Test test, JFrame mainFrame, JFrame createTestFrame) {
    this.mainFrame = mainFrame;
    this.createTestFrame = createTestFrame;

    setPreferredSize(new Dimension(400, 200));
    setLayout(new BorderLayout(50, 50));

    add(setupLabels(), BorderLayout.WEST);
    add(setupFields(), BorderLayout.CENTER);
    add(setupButtons(), BorderLayout.SOUTH);
  }

  public JPanel setupLabels() {
    JPanel labels = new JPanel(new GridLayout(2, 1));
    labels.add(new JLabel("Enter Question: "));
    labels.add(new JLabel("Enter Answer: "));
    return labels;
  }

  public JPanel setupFields() {
    question = new JTextArea();
    answer = new JTextArea();

    JPanel fields = new JPanel(new GridLayout(2, 1));
    fields.add(question);
    fields.add(answer);
    return fields;
  }

  public JPanel setupButtons() {
    saveQuestionButton = new JButton("Save Question");
    doneButton = new JButton("Done");

    SaveQuestionListener listener = new SaveQuestionListener(test, question, answer);
    saveQuestionButton.addActionListener(listener);

    doneButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        createTestFrame.dispose();
        mainFrame.setVisible(true);
      }
    });

    JPanel buttons = new JPanel(new GridLayout(1, 3));
    buttons.add(saveQuestionButton);
    buttons.add(doneButton);
    return buttons;
  }
}
