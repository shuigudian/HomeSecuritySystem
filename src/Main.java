import view.HomeTabbedPane;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
       frame.setSize(1100, 1100);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new HomeTabbedPane());
        frame.setVisible(true);
    }
}
