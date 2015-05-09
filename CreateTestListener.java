import java.awt.event.*;
import javax.swing.*;

public class CreateTestListener implements ActionListener {
  private JFrame mainFrame;

  public CreateTestListener(JFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  public void actionPerformed(ActionEvent event) {
    String name = JOptionPane.showInputDialog("Enter the test name: ");

    Test test = new Test(name);
    JFrame frame = new JFrame(name);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new CreateTest(test, mainFrame, frame));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    mainFrame.setVisible(false);
  }
}
