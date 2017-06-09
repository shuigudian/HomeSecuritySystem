package view;

import controller.SecurityService;
import model.Customer;
import model.Section;
import model.Sensor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static model.Event.EventType;
import net.miginfocom.layout.Grid;
import net.miginfocom.swing.MigLayout;


// BillingPanel class is designed to generate the bill information
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


    private JLabel effectiveDatesfromLabel;
    private JLabel effectiveDatestoLabel;
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
// constructor of BillingPanel
    public BillingPanel() {
        securityService = SecurityService.getInstance();

        customer = securityService.getCustomer();
        sectionList = securityService.getBuildingSections();

        setLayout(new MigLayout("","Right"));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);

        serviceContractIdLabel = new JLabel("Service Contract Id");
        serviceContractIdTextFiled = new JTextField(15);
        serviceContractIdTextFiled.setPreferredSize(new Dimension(100, 20));
        add(serviceContractIdLabel,"span 2 ");
        add(serviceContractIdTextFiled,"wrap");

        customerNameLabel = new JLabel("Customer Name");
        customerNameTextFiled = new JTextField(15);
        customerNameTextFiled.setPreferredSize(new Dimension(100, 20));
        add(customerNameLabel,"span 2");
        add(customerNameTextFiled,"wrap");

        customerAddressLabel = new JLabel("Property Address");
        customerAddressTextFiled = new JTextField(15);
        customerAddressTextFiled.setPreferredSize(new Dimension(100, 20));
        add(customerAddressLabel,"span 2 ");
        add(customerAddressTextFiled,"wrap");

        primaryContactLabel = new JLabel("Primary Contact Number");
        primaryContactTextFiled = new JTextField(15);
        primaryContactTextFiled.setPreferredSize(new Dimension(100, 20));
        secondaryContactLabel = new JLabel("Secondary Contact Number");
        secondaryContactTextFiled = new JTextField(15);
        secondaryContactTextFiled.setPreferredSize(new Dimension(100, 20));
        add(primaryContactLabel,"span 2");
        add(primaryContactTextFiled,"wrap");
        add(secondaryContactLabel,"span 2 ");
        add(secondaryContactTextFiled,"wrap");


        customerContactLabel = new JLabel("Contact Phone");
        customerContactTextFiled = new JTextField(15);
        customerContactTextFiled.setPreferredSize(new Dimension(100, 20));
        add(customerContactLabel,"span 2 ");
        add(customerContactTextFiled,"wrap");


        effectiveDatesfromLabel = new JLabel("Date Coverage From");
        effectiveDatestoLabel = new JLabel("Date Coverage To");
        effectiveFromTextField = new JTextField(15);
        effectiveFromTextField.setPreferredSize(new Dimension(100, 20));
        effectiveToTextField = new JTextField(15);
        effectiveToTextField.setPreferredSize(new Dimension(100, 20));

        add(effectiveDatesfromLabel,"span 2");
        add(effectiveFromTextField,"wrap");
        add(effectiveDatestoLabel,"span 2");
        add(effectiveToTextField,"wrap");


        numberTempSensorsLabel = new JLabel("No. Of Temperature Sensors");
        numberTempSensorsTextField = new JTextField(15);
        numberTempSensorsTextField.setPreferredSize(new Dimension(100, 20));
        add(numberTempSensorsLabel,"span 2");
        add(numberTempSensorsTextField,"wrap");

        perFeeTempSensorLabel = new JLabel("Fee Per Temperature Sensor");
        perFeeTempSensorTextField = new JTextField(15);
        perFeeTempSensorTextField.setPreferredSize(new Dimension(100, 20));
        JPanel p11 = new JPanel(flowLayout);
        p11.add(perFeeTempSensorLabel,"span,grow");
        p11.add(perFeeTempSensorTextField,"wrap");

        numberMotionSensorLabel = new JLabel("No. Of Motion Sensors");
        numberMotionSensorTextField = new JTextField(15);
        numberMotionSensorTextField.setPreferredSize(new Dimension(100, 20));
        add(numberMotionSensorLabel,"span 2");
        add(numberMotionSensorTextField,",wrap");

        perFeeMotionSensorLabel = new JLabel("Fee Per Motion Sensor");
        perFeeMotionSensorTextField = new JTextField(15);
        perFeeMotionSensorTextField.setPreferredSize(new Dimension(100, 20));
        add(perFeeMotionSensorLabel,"span 2");
        add(perFeeMotionSensorTextField,"wrap");


        initTempServiceFeeLabel = new JLabel("Initial Temperature Sensor Installation Charge");
        initTempServiceFeeTextField = new JTextField(15);
        initTempServiceFeeTextField.setPreferredSize(new Dimension(100, 20));
        add(initTempServiceFeeLabel,"span 2");
        add(initTempServiceFeeTextField,"span ,wrap");

        initMotionServiceFeeLabel = new JLabel("Initial Motion Sensor Installation Charge");
        initMotionServiceFeeTextField = new JTextField(15);
        initMotionServiceFeeTextField.setPreferredSize(new Dimension(100, 20));
        add(initMotionServiceFeeLabel,"span2 ");
        add(initMotionServiceFeeTextField,"wrap");

        extraPerFeeTempLabel = new JLabel("Extra Temperature Service Fee Per Time");
        extraPerFeeTempTextField = new JTextField(15);
        extraPerFeeTempTextField.setPreferredSize(new Dimension(100, 20));

        extraTempServiceCountLabel = new JLabel("Extra Temperature Service Number");
        extraTempServiceCountTextField = new JTextField(15);
        extraTempServiceCountTextField.setPreferredSize(new Dimension(100, 20));

        add(extraPerFeeTempLabel,"span2  ");
        add(extraPerFeeTempTextField,"wrap");
        add(extraTempServiceCountLabel,"span2 ");
        add(extraTempServiceCountTextField,"wrap");

        extraPerFeeMotionLabel = new JLabel("Extra Motion Service Fee Per Time");
        extraPerFeeMotionTextField = new JTextField(15);
        extraPerFeeMotionTextField.setPreferredSize(new Dimension(100, 20));

        extraMotionServiceCountLabel = new JLabel("Extra Motion Service Number");
        extraMotionServiceCountTextField = new JTextField(15);
        extraMotionServiceCountTextField.setPreferredSize(new Dimension(100, 20));

        add(extraPerFeeMotionLabel,"span2 ");
        add(extraPerFeeMotionTextField,"wrap");
        add(extraMotionServiceCountLabel,"span 2");
        add(extraMotionServiceCountTextField,"wrap");

        motionSensorTotalCostLabel = new JLabel("Total cost for motion sensor");
        motionSensorTotalCostTextField = new JTextField(15);
        motionSensorTotalCostTextField.setPreferredSize(new Dimension(100, 20));

        tempSensorTotalCostLabel = new JLabel("Total cost for temperature sensor");
        tempSensorTotalCostTextField = new JTextField(15);
        tempSensorTotalCostTextField.setPreferredSize(new Dimension(100, 20));

        totalCostLabel = new JLabel("Total Cost");
        totalCostTextField = new JTextField(15);
        totalCostTextField.setPreferredSize(new Dimension(100, 20));

        add(motionSensorTotalCostLabel,"span 2");
        add(motionSensorTotalCostTextField,"wrap");
        add(tempSensorTotalCostLabel,"span 2 ");
        add(tempSensorTotalCostTextField,"wrap");
        add(totalCostLabel,"span 2");
        add(totalCostTextField,"wrap");
        generateBillButton = new JButton("GenerateBill");

        add(generateBillButton,"span 2 2,wrap");

        generateBillButton.addActionListener(e -> {
            motionSensorCount = countInstalledSensor(true);
            tempSensorCount = countInstalledSensor(false);
            extraMotionCallCount = securityService.getEventCount(EventType.BREAK_IN);
            extraTempCallCount = securityService.getEventCount(EventType.FIRE);
            fillInBillInformation();

        });
        JButton eventReport = new JButton("Event Report");
        eventReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ex) {
                try{
                    Desktop.getDesktop().edit(new File("event_records.txt"));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        add(eventReport);

    }
// fill all bill information in the panel
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
//get Motion Sensor Total Cost
    private double getMotionSensorTotalCost() {
        double cost = 0;

        if (motionSensorCount > 0) {
            cost += motionSensorInitFee;
        }
        cost += motionSensorPrice * (double) motionSensorCount
                + extraPerMotionServiceFee * (double) extraMotionCallCount;
        return cost;
    }

    //get Temperature  Sensor Total Cost
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
