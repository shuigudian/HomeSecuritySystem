import controller.InstallPanel;
import controller.SchedulePanel;
import controller.SimulatePanel;
import controller.WelcomePanel;
import view.TabbedPane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yizhou on 6/3/17.
 */
public class Demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Home Security System");
        frame.setSize(1200, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WelcomePanel welcomePanel = new WelcomePanel();
        frame.add(welcomePanel);


        TabbedPane tabbedPane = new TabbedPane();

        Container container = frame.getContentPane();
        container.add(tabbedPane);
        frame.setVisible(true);

    }
}
