package view;

import model.Sensor;

import javax.swing.*;

// HomeTabbedPane class is collections of all panels
public class HomeTabbedPane extends JTabbedPane {

    public HomeTabbedPane() {
        addTab("Welcome", new WelcomePanel());
    }

    void switchToContentPanel() {
        removeAll();
        addTab("Installation Configure", new InstallationConfigurePanel());
        addTab("Motion Sensor Configure", new ActivationConfigurePanel(Sensor.SensorType.MOTION));
        addTab("Temperature Sensor Configure", new ActivationConfigurePanel(Sensor.SensorType.TEMPERATURE));
        addTab("Simulate", new SimulatePanel());
        addTab("Billing", new BillingPanel());
        addChangeListener(event -> {
            int index = ((JTabbedPane) event.getSource()).getSelectedIndex();
            switch (index) {
                case 0:
                    setComponentAt(index, new InstallationConfigurePanel());
                    break;
                case 1:
                    setComponentAt(index, new ActivationConfigurePanel(Sensor.SensorType.MOTION));
                    break;
                case 2:
                    setComponentAt(index, new ActivationConfigurePanel(Sensor.SensorType.TEMPERATURE));
                    break;
                case 3:
                    setComponentAt(index, new SimulatePanel());
                    break;
                case 4:
                    setComponentAt(index, new BillingPanel());
                    break;
                default:
                    break;
            }
        });
    }
}
