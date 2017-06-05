package view;

import controller.SecurityService;
import model.Customer;
import model.Section;
import model.Sensor;

import javax.swing.*;
import java.awt.*;

import static model.Event.EventType;

class BillingPanel extends JPanel {
    private static final double motionSensorPrice = 50.00;
    private static final double tempSensorPrice = 100.00;
    private static final double motionSensorInitFee = 200.00;
    private static final double tempSensorInitFee = 300;
    private static final double extraPerMotionServiceFee = 20.00;
    private static final double extraPerTempServiceFee = 50.00;

    private int motionSensorCount;
    private int tempSensorCount;
    private int extraMotionCallCount;
    private int extraTempCallCount;
    private Customer customer;
    private java.util.List<Section> sectionList;
    private JLabel serviceContractIdLabel;
    private JTextField serviceContractIdTextFiled;

    private JLabel customerNameLabel;
    private JTextField customerNameTextFiled;

    private JLabel customerAddressLabel;
    private JTextField customerAddressTextFiled;


    private JLabel primaryContactLabel;
    private JLabel secondaryContactLabel;

    private JTextField primaryContactTextFiled;
    private JTextField secondaryContactTextFiled;

    private JLabel customerContactLabel;
    private JTextField customerContactTextFiled;

    private JLabel effectiveDatesLable;
    private JLabel fromLabel;
    private JLabel toLabel;
    private JTextField effectiveFromTextField;
    private JTextField effectiveToTextField;

    private JLabel numberTempSensorsLabel;
    private JTextField numberTempSensorsTextField;

    private JLabel perFeeTempSensorLabel;
    private JTextField perFeeTempSensorTextField;

    private JLabel numberMotionSensorLabel;
    private JTextField numberMotionSensorTextField;

    private JLabel perFeeMotionSensorLabel;
    private JTextField perFeeMotionSensorTextField;

    private JLabel initTempServiceFeeLabel;
    private JTextField initTempServiceFeeTextField;

    private JLabel initMotionServiceFeeLabel;
    private JTextField initMotionServiceFeeTextField;

    private JLabel extraPerFeeTempLabel;
    private JTextField extraPerFeeTempTextField;
    private JLabel extraTempServiceCountLabel;
    private JTextField extraTempServiceCountTextField;

    private JLabel extraPerFeeMotionLabel;
    private JTextField extraPerFeeMotionTextField;
    private JLabel extraMotionServiceCountLabel;
    private JTextField extraMotionServiceCountTextField;

    private JLabel motionSensorTotalCostLabel;
    private JLabel tempSensorTotalCostLabel;
    private JTextField motionSensorTotalCostTextField;
    private JTextField tempSensorTotalCostTextField;

    private JLabel totalCostLabel;
    private JTextField totalCostTextField;

    private JButton generateBillButton;

    private SecurityService securityService;

    public BillingPanel() {
        securityService = SecurityService.getInstance();

        customer = securityService.getCustomer();
        sectionList = securityService.getBuildingSections();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        setLayout(boxLayout);

        serviceContractIdLabel = new JLabel("Service Contract Id");
        serviceContractIdTextFiled = new JTextField();
        serviceContractIdTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p1 = new JPanel(flowLayout);
        p1.add(serviceContractIdLabel);
        p1.add(serviceContractIdTextFiled);

        customerNameLabel = new JLabel("Customer Name");
        customerNameTextFiled = new JTextField();
        customerNameTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p2 = new JPanel(flowLayout);
        p2.add(customerNameLabel);
        p2.add(customerNameTextFiled);

        customerAddressLabel = new JLabel("Property Address");
        customerAddressTextFiled = new JTextField();
        customerAddressTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p3 = new JPanel(flowLayout);
        p3.add(customerAddressLabel);
        p3.add(customerAddressTextFiled);

        primaryContactLabel = new JLabel("Primary Contact Number");
        primaryContactTextFiled = new JTextField();
        primaryContactTextFiled.setPreferredSize(new Dimension(100, 20));
        secondaryContactLabel = new JLabel("Secondary Contact Number");
        secondaryContactTextFiled = new JTextField();
        secondaryContactTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p4 = new JPanel(flowLayout);
        p4.add(primaryContactLabel);
        p4.add(primaryContactTextFiled);
        p4.add(secondaryContactLabel);
        p4.add(secondaryContactTextFiled);


        customerContactLabel = new JLabel("Contact Phone");
        customerContactTextFiled = new JTextField();
        customerContactTextFiled.setPreferredSize(new Dimension(100, 20));
        JPanel p5 = new JPanel(flowLayout);
        p5.add(customerContactLabel);
        p5.add(customerContactTextFiled);

        effectiveDatesLable = new JLabel("Date Coverage");
        fromLabel = new JLabel("From");
        toLabel = new JLabel("To");
        effectiveFromTextField = new JTextField();
        effectiveFromTextField.setPreferredSize(new Dimension(100, 20));
        effectiveToTextField = new JTextField();
        effectiveToTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p10 = new JPanel(flowLayout);
        p10.add(effectiveDatesLable);
        p10.add(fromLabel);
        p10.add(effectiveFromTextField);
        p10.add(toLabel);
        p10.add(effectiveToTextField);


        numberTempSensorsLabel = new JLabel("No. Of Temperature Sensors");
        numberTempSensorsTextField = new JTextField();
        numberTempSensorsTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p6 = new JPanel(flowLayout);
        p6.add(numberTempSensorsLabel);
        p6.add(numberTempSensorsTextField);

        perFeeTempSensorLabel = new JLabel("Fee Per Temperature Sensor");
        perFeeTempSensorTextField = new JTextField();
        perFeeTempSensorTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p11 = new JPanel(flowLayout);
        p11.add(perFeeTempSensorLabel);
        p11.add(perFeeTempSensorTextField);

        numberMotionSensorLabel = new JLabel("No. Of Motion Sensors");
        numberMotionSensorTextField = new JTextField();
        numberMotionSensorTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p7 = new JPanel(flowLayout);
        p7.add(numberMotionSensorLabel);
        p7.add(numberMotionSensorTextField);

        perFeeMotionSensorLabel = new JLabel("Fee Per Motion Sensor");
        perFeeMotionSensorTextField = new JTextField();
        perFeeMotionSensorTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p12 = new JPanel(flowLayout);
        p12.add(perFeeMotionSensorLabel);
        p12.add(perFeeMotionSensorTextField);


        initTempServiceFeeLabel = new JLabel("Initial Temperature Sensor Installation Charge");
        initTempServiceFeeTextField = new JTextField();
        initTempServiceFeeTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p8 = new JPanel(flowLayout);
        p8.add(initTempServiceFeeLabel);
        p8.add(initTempServiceFeeTextField);

        initMotionServiceFeeLabel = new JLabel("Initial Motion Sensor Installation Charge");
        initMotionServiceFeeTextField = new JTextField();
        initMotionServiceFeeTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p9 = new JPanel(flowLayout);
        p9.add(initMotionServiceFeeLabel);
        p9.add(initMotionServiceFeeTextField);

        extraPerFeeTempLabel = new JLabel("Extra Temperature Service Fee Per Time");
        extraPerFeeTempTextField = new JTextField();
        extraPerFeeTempTextField.setPreferredSize(new Dimension(100, 20));

        extraTempServiceCountLabel = new JLabel("Extra Temperature Service Number");
        extraTempServiceCountTextField = new JTextField();
        extraTempServiceCountTextField.setPreferredSize(new Dimension(100, 20));

        JPanel p13 = new JPanel(flowLayout);
        p13.add(extraPerFeeTempLabel);
        p13.add(extraPerFeeTempTextField);
        p13.add(extraTempServiceCountLabel);
        p13.add(extraTempServiceCountTextField);

        extraPerFeeMotionLabel = new JLabel("Extra Motion Service Fee Per Time");
        extraPerFeeMotionTextField = new JTextField();
        extraPerFeeMotionTextField.setPreferredSize(new Dimension(100, 20));

        extraMotionServiceCountLabel = new JLabel("Extra Motion Service Number");
        extraMotionServiceCountTextField = new JTextField();
        extraMotionServiceCountTextField.setPreferredSize(new Dimension(100, 20));

        JPanel p14 = new JPanel(flowLayout);
        p14.add(extraPerFeeMotionLabel);
        p14.add(extraPerFeeMotionTextField);
        p14.add(extraMotionServiceCountLabel);
        p14.add(extraMotionServiceCountTextField);

        motionSensorTotalCostLabel = new JLabel("Total cost for motion sensor");
        motionSensorTotalCostTextField = new JTextField();
        motionSensorTotalCostTextField.setPreferredSize(new Dimension(100, 20));

        tempSensorTotalCostLabel = new JLabel("Total cost for temperature sensor");
        tempSensorTotalCostTextField = new JTextField();
        tempSensorTotalCostTextField.setPreferredSize(new Dimension(100, 20));

        totalCostLabel = new JLabel("Total Cost");
        totalCostTextField = new JTextField();
        totalCostTextField.setPreferredSize(new Dimension(100, 20));

        JPanel p15 = new JPanel(flowLayout);
        p15.add(motionSensorTotalCostLabel);
        p15.add(motionSensorTotalCostTextField);
        p15.add(tempSensorTotalCostLabel);
        p15.add(tempSensorTotalCostTextField);
        p15.add(totalCostLabel);
        p15.add(totalCostTextField);
        generateBillButton = new JButton("GenerateBill");


        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p10);
        add(p6);
        add(p11);
        add(p7);
        add(p12);
        add(p8);
        add(p9);
        add(p13);
        add(p14);
        add(p15);
        add(generateBillButton);

        generateBillButton.addActionListener(e -> {
            motionSensorCount = countInstalledSensor(true);
            tempSensorCount = countInstalledSensor(false);
            extraMotionCallCount = securityService.getEventCount(EventType.BREAK_IN);
            extraTempCallCount = securityService.getEventCount(EventType.FIRE);
            fillInBillInformation();

        });

    }

    private void fillInBillInformation() {
        serviceContractIdTextFiled.setText(customer.getServiceContractId());
        customerNameTextFiled.setText(customer.getName());
        customerAddressTextFiled.setText(customer.getAddress());
        primaryContactTextFiled.setText(customer.getPrimaryNumber());
        secondaryContactTextFiled.setText(customer.getSecondaryNumber());
        customerContactTextFiled.setText(customer.getContactNumber());
        effectiveFromTextField.setText(customer.getStartDate());
        effectiveToTextField.setText(customer.getEndDate());
        numberTempSensorsTextField.setText(String.valueOf(tempSensorCount));
        numberMotionSensorTextField.setText(String.valueOf(motionSensorCount));
        perFeeMotionSensorTextField.setText(String.valueOf(motionSensorPrice));
        perFeeTempSensorTextField.setText(String.valueOf(tempSensorPrice));
        initMotionServiceFeeTextField.setText(String.valueOf(motionSensorInitFee));
        if (motionSensorCount > 0 && tempSensorCount > 0) {
            initTempServiceFeeTextField.setText(String.valueOf(tempSensorInitFee * 0.8));
        } else {
            initTempServiceFeeTextField.setText(String.valueOf(tempSensorInitFee));
        }
        extraPerFeeTempTextField.setText(String.valueOf(extraPerTempServiceFee));
        extraPerFeeMotionTextField.setText(String.valueOf(extraPerMotionServiceFee));
        extraTempServiceCountTextField.setText(String.valueOf(extraTempCallCount));
        extraMotionServiceCountTextField.setText(String.valueOf(extraMotionCallCount));
        motionSensorTotalCostTextField.setText(String.valueOf(getMotionSensorTotalCost()));
        tempSensorTotalCostTextField.setText(String.valueOf(getTempSensorTotalCost()));
        totalCostTextField.setText((String.valueOf(
                Double.valueOf(tempSensorTotalCostTextField.getText())
                        + Double.valueOf(motionSensorTotalCostTextField.getText()))));

    }

    private int countInstalledSensor(boolean motionSensor) {
        int count = 0;
        if (motionSensor) {
            for (Section section : sectionList) {
                if (section.isSensorInstalled(Sensor.SensorType.MOTION)) {
                    count++;
                }
            }
        } else {
            for (Section section : sectionList) {
                if (section.isSensorInstalled(Sensor.SensorType.TEMPERATURE)) {
                    count++;
                }

            }
        }
        return count;
    }

    private double getMotionSensorTotalCost() {
        double cost = 0;

        if (motionSensorCount > 0) {
            cost += motionSensorInitFee;
        }
        cost += motionSensorPrice * (double) motionSensorCount
                + extraPerMotionServiceFee * (double) extraMotionCallCount;
        return cost;
    }

    private double getTempSensorTotalCost() {
        double cost = 0;
        if (tempSensorCount > 0) {
            if (motionSensorCount > 0) {
                cost += tempSensorInitFee * 0.8;
            } else {
                cost += tempSensorInitFee;
            }
        }
        cost += tempSensorPrice * (double) tempSensorCount
                + extraPerTempServiceFee * (double) extraTempCallCount;
        return cost;
    }

}
