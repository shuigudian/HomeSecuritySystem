package view;

import controller.SecurityService;
import model.Event;
import model.Section;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class SimulatePanel extends JPanel {
    private AlarmSimulateButton fireSimulateButton;
    private AlarmSimulateButton breakInSimulateButton;
    private List<JButton> sectionButtonList;
    private JComboBox<String> sectionComboBox;
    private JTextField responseTextField;

    private final SecurityService securityService;
    private final List<Section> buildingSectionList;

    private Event.EventType eventType;

    SimulatePanel() {
        setLayout(new GridLayout(2,1));

        securityService = SecurityService.getInstance();
        buildingSectionList = securityService.getBuildingSections();

        JPanel sectionsPanel = new JPanel();
        sectionsPanel.setLayout(new GridLayout(0,3));
        sectionButtonList = new ArrayList<>();
        for(Section section : buildingSectionList) {
            JButton button = new JButton(section.getName());
            sectionButtonList.add(button);
            sectionsPanel.add(button);
        }
        add(sectionsPanel);

        JPanel interactionPanel = new JPanel();
        JTextArea displayTextArea = new JTextArea();
        displayTextArea.setPreferredSize(new Dimension(400,600));

        JPanel panel = new JPanel();

        sectionComboBox = createSectionComboBox();
        panel.add(sectionComboBox);

        breakInSimulateButton = new AlarmSimulateButton(Event.EventType.BREAK_IN, displayTextArea);
        breakInSimulateButton.addActionListener(e -> eventType = Event.EventType.BREAK_IN);
        panel.add(breakInSimulateButton);

        fireSimulateButton = new AlarmSimulateButton(Event.EventType.FIRE, displayTextArea);
        fireSimulateButton.addActionListener(e -> eventType = Event.EventType.FIRE);
        panel.add(fireSimulateButton);
        attachSectionInfoToSimulateButton();

        panel.add(new JLabel("Please enter response code to disalarm the system"));
        responseTextField = new JTextField();
        responseTextField.setPreferredSize(new Dimension(100,20));
        panel.add(responseTextField);
        panel.add(createResponseButton());

        interactionPanel.add(panel);
        interactionPanel.add(displayTextArea);
        add(interactionPanel);
    }

    private JButton createResponseButton() {
        JButton button = new JButton("Confirm Code");
        button.addActionListener(e -> {
            if(SecurityService.getInstance().getCustomer().passwordMatched(responseTextField.getText())) {
                AlarmSimulateButton clickedButton = eventType.equals(Event.EventType.BREAK_IN)
                        ? breakInSimulateButton : fireSimulateButton;
                securityService.recordEvent(eventType, getSelectedSection().getId(), clickedButton.getTriggerTime(),
                        clickedButton.getTriggerTime(), clickedButton.getCallCount(), new Date());

                clickedButton.reset();
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(button),"Turn off alarming");
            } else {
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(button),"Response code is wrong, please enter again");
            }
            responseTextField.setText("");
        });
        return button;
    }

    private JComboBox<String> createSectionComboBox() {
        int size = buildingSectionList.size();
        String[] sectionNames = new String[size];
        for(int i = 0; i < size; i++) {
            sectionNames[i] = buildingSectionList.get(i).getName();
        }
        JComboBox<String> sectionComboBox  = new JComboBox<>(sectionNames);
        sectionComboBox.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                attachSectionInfoToSimulateButton();
            }
        });
        return sectionComboBox;
    }

    private void attachSectionInfoToSimulateButton() {
        int index = sectionComboBox.getSelectedIndex();
        Section section = buildingSectionList.get(index);
        JButton selectedSectionButton = sectionButtonList.get(index);
        breakInSimulateButton.setSectionInfo(section, selectedSectionButton);
        fireSimulateButton.setSectionInfo(section, selectedSectionButton);
    }

    private Section getSelectedSection() {
        int index = sectionComboBox.getSelectedIndex();
        return buildingSectionList.get(index);
    }
}
