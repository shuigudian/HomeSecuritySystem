package view;

import model.Sensor;

import javax.swing.*;

public class TabbedPane extends JTabbedPane {

    public void createAfterLoginPanel() {
        remove(0);
        addTab("Installation Configure", new InstallationConfigurePanel());
        addTab("Motion Sensor Configure", new ActivationConfigurePanel(Sensor.SensorType.MOTION));
        addTab("Temperature Sensor Configure", new ActivationConfigurePanel(Sensor.SensorType.TEMPERATURE));
        addTab("Simulate", new SimulatePanel());
        addTab("Bill", new BillPanel());
    }

    public TabbedPane() {
        addTab("Welcome", new WelcomePanel());

    }
}
