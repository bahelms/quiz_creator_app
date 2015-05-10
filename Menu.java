import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Menu extends JPanel {
  private JLabel titleLabel;
  private JButton createTest;
  private JButton takeTest;
  private JButton scoreTest;

  public Menu(JFrame mainFrame) {
    createTest = new JButton("Create Test");
    createTest.addActionListener(new CreateTestListener(mainFrame));

    takeTest = new JButton("Take Test");
    takeTest.addActionListener(new TakeTestListener());

    scoreTest = new JButton("Score Test");
    scoreTest.addActionListener(new ScoreTestListener());

    JPanel buttons = new JPanel(new GridLayout(1, 3));
    buttons.add(createTest);
    buttons.add(takeTest);
    buttons.add(scoreTest);

    TitledBorder title = BorderFactory.createTitledBorder(
      BorderFactory.createEmptyBorder(), "Welcome to Testing!");
    title.setTitleJustification(TitledBorder.CENTER);

    setPreferredSize(new Dimension(300, 100));
    setLayout(new BorderLayout());
    setBorder(title);

    add(buttons, BorderLayout.CENTER);
  }
}

