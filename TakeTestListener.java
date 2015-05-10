import java.io.*;
import java.awt.event.*;

public class TakeTestListener implements ActionListener {
  public void actionPerformed(ActionEvent event) {
    try {
      TakeTest takeTest = new TakeTest(Test.loadTest());
      takeTest.start();
      takeTest.saveResponsesToFile();
    }
    catch (FileNotFoundException e) {}
  }
}

