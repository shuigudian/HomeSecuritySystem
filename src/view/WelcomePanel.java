package view;

import com.github.lgooddatepicker.components.DatePicker;
import controller.SecurityService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import net.miginfocom.layout.Grid;
import net.miginfocom.swing.MigLayout;

class WelcomePanel extends Panel {

    private JTextField customerNameTextFiled;
    private JTextField customerAddressTextFiled;
    private JTextField primaryContactTextFiled;
    private JTextField secondaryContactTextFiled;
    private JTextField customerContactTextFiled;
    private JTextField setPasswordTextFiled;
    private JTextField passwordTextField;


    WelcomePanel() {
        if (SecurityService.getInstance().customerExists()) {
            createPanelForExistingCustomer();
        } else {
            createPanelForNewCustomer();
        }
    }

    private void createPanelForExistingCustomer() {
        JPanel login = new JPanel();

        login.setLayout(null);
        setLayout(new GridLayout(0,1));

        JLabel nameLabel = new JLabel("User Name:");
        customerNameTextFiled = new JTextField(20);
        nameLabel.setBounds(400,200,80,25);
        customerNameTextFiled.setBounds(500,200,160,25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(400,250,80,25);
        passwordTextField = new JTextField(20);
        passwordTextField.setBounds(500,250,160,25);

        JButton confirmPasswordButton = new JButton("Login");
        confirmPasswordButton.setBounds(580,300,80,25);

        confirmPasswordButton.addActionListener(e -> {
            if (SecurityService.getInstance().getCustomer().passwordMatched(passwordTextField.getText())
                    &&(SecurityService.getInstance().getCustomer().getName().equals(customerNameTextFiled.getText()))) {
                HomeTabbedPane pane = (HomeTabbedPane) getParent();
                pane.switchToContentPanel();
            }
            else {
                JOptionPane.showMessageDialog(this,"Password or Username is not correct, try again");
            }
        });
       JButton cancelButton = new JButton("Cancel");
       cancelButton.setBounds(490,300,80,25);

        cancelButton.addActionListener(e -> {
            passwordTextField.setText("");
            customerNameTextFiled.setText("");
        });

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(495,380,80,25);
        closeButton.addActionListener(e -> {
            System.exit(0);
       });

        add(login);
        login.add(nameLabel);
        login.add(customerNameTextFiled);
        login.add(passwordLabel);
        login.add(passwordTextField);
        login.add(confirmPasswordButton);
        login.add(cancelButton,"wrap");
        login.add(closeButton);
    }

    private void createPanelForNewCustomer() {
        setLayout(new MigLayout("","grow"));

        JLabel customerNameLabel = new JLabel("Your Name");
        customerNameTextFiled = new JTextField();
        customerNameTextFiled.setPreferredSize(new Dimension(100, 20));
//       JPanel p1 = new JPanel(flowLayout);
        add(customerNameLabel);
        add(customerNameTextFiled,"wrap");
        JLabel customerAddressLabel = new JLabel("Your Address");
        customerAddressTextFiled = new JTextField();
        customerAddressTextFiled.setPreferredSize(new Dimension(100, 20));

        add(customerAddressLabel);
        add(customerAddressTextFiled,"wrap");
        JLabel primaryContactLabel = new JLabel("Primary Contact Number");
        primaryContactTextFiled = new JTextField();
        primaryContactTextFiled.setPreferredSize(new Dimension(100, 20));
        add(primaryContactLabel);
        add(primaryContactTextFiled,"wrap");

        JLabel secondaryContactLabel = new JLabel("Secondary Contact Number");
        secondaryContactTextFiled = new JTextField();
        secondaryContactTextFiled.setPreferredSize(new Dimension(100, 20));

        add(secondaryContactLabel);
        add(secondaryContactTextFiled,"wrap");

        JLabel customerContactLabel = new JLabel("Your contact number");
        customerContactTextFiled = new JTextField();
        customerContactTextFiled.setPreferredSize(new Dimension(100, 20));

       add(customerContactLabel);
        add(customerContactTextFiled,"wrap");

        JLabel startDateLabel = new JLabel("Coverage From");
        DatePicker startDatePicker = new DatePicker();
        JLabel endDateLabel = new JLabel("Coverage To");
        DatePicker endDatePicker = new DatePicker();
        add(startDateLabel);
        add(startDatePicker,"wrap");
        add(endDateLabel);
        add(endDatePicker,"wrap");

        JLabel setPasswordLabel = new JLabel("Set your password");
        setPasswordTextFiled = new JTextField();
        setPasswordTextFiled.setPreferredSize(new Dimension(100, 20));
        add(setPasswordLabel);
        add(setPasswordTextFiled,"wrap");

        JButton cancelInfoButton = new JButton("Reset");
        add(cancelInfoButton,"grow");
        JButton saveInfoButton = new JButton("Register");
        add(saveInfoButton,"grow");

        saveInfoButton.addActionListener(e -> {
            String name = customerNameTextFiled.getText();
            String address = customerAddressTextFiled.getText();
            String primary = primaryContactTextFiled.getText();
            String secondary = secondaryContactTextFiled.getText();
            String contact = customerContactTextFiled.getText();
            String password = setPasswordTextFiled.getText();
            String contractServiceId = generateContractServiceId();


            if((startDatePicker.toString().length()!= 0)&& (endDatePicker.toString().length()!=0)){
                String startDate = startDatePicker.getDate().toString();
                String endDate = endDatePicker.getDate().toString();
                if((startDatePicker.getDate().isAfter(endDatePicker.getDate()))){
                    JOptionPane.showMessageDialog(null, "Please fill the Date again!");
                }

                else if (SecurityService.getInstance().createCustomer(
                        name, address, primary, secondary, contact, password,contractServiceId,startDate, endDate)) {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    HomeTabbedPane pane = (HomeTabbedPane) getParent();
                    pane.switchToContentPanel();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please fill all information and then save");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill all information and then save");
            }
        });
        cancelInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 customerNameTextFiled.setText("");
                 customerAddressTextFiled.setText("");
                 primaryContactTextFiled.setText("");
                 secondaryContactTextFiled.setText("");
                 customerContactTextFiled.setText("");
                 setPasswordTextFiled.setText("");
            }
        });
    }

    private String generateContractServiceId() {
        String contractId =  "SEV";
        Random random = new Random();
        contractId += random.nextInt(100000);
        return contractId;
    }
}


