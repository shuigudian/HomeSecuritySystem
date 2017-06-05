package view;

import model.Event.EventType;
import model.Section;
import model.Sensor.SensorType;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

class AlarmSimulateButton extends JButton {

    private final JTextArea messageArea;
    private final Color flashColor;
    private final Timer flashTimer;
    private final Timer messageTimer;

    private Section section;
    private JButton sectionButton;
    private Date triggerTime;
    private int callCount;

    AlarmSimulateButton(EventType eventType, JTextArea messageArea) {
        super(eventType.equals(EventType.BREAK_IN) ? "Simulate Break In" : "Simulate Fire");
        this.messageArea = messageArea;

        flashColor = eventType.equals(EventType.BREAK_IN) ? Color.ORANGE : Color.RED;
        flashTimer = new Timer(500, e -> {
            if(sectionButton.getBackground().equals(flashColor)) {
                sectionButton.setBackground(Color.WHITE);
                sectionButton.setBorderPainted(true);
            } else {
                sectionButton.setBackground(flashColor);
                sectionButton.setOpaque(true);
                sectionButton.setBorderPainted(false);
            }
        });

        messageTimer = new Timer(1000, e -> {
            callCount++;
            String message = "Event Ocurred :" + eventType + '\n' + "Emergency Number Calling Number : " + callCount + '\n';
            messageArea.setText(message);
        });

        addActionListener(e -> {
            if (section.isSensorActive(eventType.equals(EventType.BREAK_IN) ? SensorType.MOTION : SensorType.TEMPERATURE)) {
                triggerTime = new Date();
                flashTimer.start();
                messageTimer.start();
            } else {
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(AlarmSimulateButton.this),
                        String.format("%s sensor is not available for section %s",
                                eventType.equals(EventType.BREAK_IN) ? "Motion" : "Temperature", section.getName()));
            }
        });
    }

    void setSectionInfo(Section section, JButton sectionButton) {
        this.section = section;
        this.sectionButton = sectionButton;
    }

    Date getTriggerTime() {
        return triggerTime;
    }

    int getCallCount() {
        return callCount;
    }

    void reset() {
        callCount = 0;
        flashTimer.stop();
        messageTimer.stop();
        sectionButton.setBackground(Color.WHITE);
        sectionButton.setBorderPainted(true);
        messageArea.setText("");
    }
}
