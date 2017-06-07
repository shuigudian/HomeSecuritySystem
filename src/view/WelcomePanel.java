package view;

import com.github.lgooddatepicker.components.DatePicker;
import controller.SecurityService;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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


       setLayout(new GridLayout(0, 1));
//       FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
//       JPanel pane0 = new JPanel(null);
//       JPanel panex = new JPanel(null);
//        JPanel paney = new JPanel(null);


    //    passwordTextField.setPreferredSize(new Dimension(100, 20));

        JLabel nameLabel = new JLabel("User Name:");
        customerNameTextFiled = new JTextField(20);
        nameLabel.setBounds(400,200,80,25);
        customerNameTextFiled.setBounds(500,200,160,25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(400,250,80,25);
        passwordTextField = new JTextField(20);
        passwordTextField.setBounds(500,250,160,25);


  //      customerNameTextFiled.setPreferredSize(new Dimension(100,20));


        JButton confirmPasswordButton = new JButton("Login");
        Font bigFont = new Font("serif",Font.BOLD,20);
        confirmPasswordButton.setFont(bigFont);
        confirmPasswordButton.setBounds(518,300,120,25);

        confirmPasswordButton.addActionListener(e -> {
            if (SecurityService.getInstance().getCustomer().passwordMatched(passwordTextField.getText())
                    &&(SecurityService.getInstance().getCustomer().getName().equals(customerNameTextFiled.getText()))) {
                HomeTabbedPane pane = (HomeTabbedPane) getParent();
                pane.switchToContentPanel();
            }
        });

        add(login);
//        add(panex);
//        add(paney);

        login.add(nameLabel);
        login.add(customerNameTextFiled);
        login.add(passwordLabel);
        login.add(passwordTextField);
        login.add(confirmPasswordButton);

    }

    private void createPanelForNewCustomer() {


      setLayout(new GridLayout(0, 1));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);

        JLabel customerNameLabel = new JLabel("Your Name");
        customerNameTextFiled = new JTextField();
        customerNameTextFiled.setPreferredSize(new Dimension(100, 20));
       JPanel p1 = new JPanel(flowLayout);
        p1.add(customerNameLabel);
        p1.add(customerNameTextFiled);
        add(p1);

        JLabel customerAddressLabel = new JLabel("Your Address");
        customerAddressTextFiled = new JTextField();
        customerAddressTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p2 = new JPanel(flowLayout);
        p2.add(customerAddressLabel);
        p2.add(customerAddressTextFiled);
        add(p2);

        JLabel primaryContactLabel = new JLabel("Primary Contact Number");
        primaryContactTextFiled = new JTextField();
        primaryContactTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p3 = new JPanel(flowLayout);
        p3.add(primaryContactLabel);
        p3.add(primaryContactTextFiled);
        add(p3);

        JLabel secondaryContactLabel = new JLabel("Secondary Contact Number");
        secondaryContactTextFiled = new JTextField();
        secondaryContactTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p4 = new JPanel(flowLayout);
        p4.add(secondaryContactLabel);
        p4.add(secondaryContactTextFiled);
        add(p4);

        JLabel customerContactLabel = new JLabel("Your contact number");
        customerContactTextFiled = new JTextField();
        customerContactTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p5 = new JPanel(flowLayout);
        p5.add(customerContactLabel);
        p5.add(customerContactTextFiled);
        add(p5);

        JLabel startDateLabel = new JLabel("Coverage From");
        DatePicker startDatePicker = new DatePicker();
        JLabel endDateLabel = new JLabel("To");
        DatePicker endDatePicker = new DatePicker();
        JPanel p7 = new JPanel(flowLayout);
        p7.add(startDateLabel);
        p7.add(startDatePicker);
        p7.add(endDateLabel);
        p7.add(endDatePicker);
        add(p7);


        JLabel setPasswordLabel = new JLabel("Set your password");
        setPasswordTextFiled = new JTextField();
        setPasswordTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p6 = new JPanel(flowLayout);
        p6.add(setPasswordLabel);
        p6.add(setPasswordTextFiled);
        add(p6);

        JPanel psave = new JPanel(flowLayout);
        JButton saveInfoButton = new JButton("Save Information");
        psave.add(saveInfoButton);
        add(psave);





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

                if (SecurityService.getInstance().createCustomer(
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
    }

    private String generateContractServiceId() {
        String contractId =  "SEV";
        Random random = new Random();
        contractId += random.nextInt(100000);
        return contractId;
    }
}