package controller;

import model.Customer;
import model.Event;
import model.Event.EventType;
import model.Section;
import model.Sensor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SecurityService {
    private static final String CUSTOMER_INFO_FILENAME = "customer_info";
    private static final String SECTION_CONFIG_FILENAME = "section_config";
    private static final String EVENT_RECORDS_FILENAME = "event_records.txt";

    private static SecurityService securityService = null;

    public synchronized static SecurityService getInstance() {
        if (securityService == null) {
            securityService = new SecurityService();
            securityService.init();
        }
        return securityService;
    }

    private final List<Section> buildingSectionList = new ArrayList<>();
    private Customer customer = null;
    private final List<Event> eventList = new ArrayList<>();

    private SecurityService() {
    }

    private void init() {
        try {
            Scanner scanner = new Scanner(new File(SECTION_CONFIG_FILENAME));
            while (scanner.hasNextLine()) {
                buildingSectionList.add(new Section(scanner.nextLine()));
            }
            scanner.close();

            File customerInfoFile = new File(CUSTOMER_INFO_FILENAME);
            if (customerInfoFile.exists()) {
                scanner = new Scanner(customerInfoFile);
                if (scanner.hasNextLine()) {
                    String[] infos = scanner.nextLine().split(",");
                    customer = new Customer(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5], infos[6], infos[7], infos[8]);
                }
                scanner.close();
            }

            File eventRecordsFile = new File(EVENT_RECORDS_FILENAME);
            if (eventRecordsFile.exists()) {
                scanner = new Scanner(new File(EVENT_RECORDS_FILENAME));
                while (scanner.hasNextLine()) {
                    eventList.add(new Event(scanner.nextLine()));
                }
                scanner.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveSensorConfig() {
        try {
            FileWriter fileWriter = new FileWriter(SECTION_CONFIG_FILENAME);
            for (Section section : buildingSectionList) {
                fileWriter.write(section.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Section> getBuildingSections() {
        return buildingSectionList;
    }

    public List<Section> getSectionsWithSensorInstalled(Sensor.SensorType sensorType) {
        List<Section> installedSections = new ArrayList<>();
        for (Section section : buildingSectionList) {
            if (section.isSensorInstalled(sensorType)) {
                installedSections.add(section);
            }
        }
        return installedSections;
    }

    public int getEventCount(EventType eventType) {
        int count = 0;
        for (Event event : eventList) {
            if (event.getEventType().equals(eventType)) {
                count++;
            }
        }
        return count;
    }

    public boolean customerExists() {
        return customer != null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean createCustomer(String name, String address, String primaryNumber, String secondaryNumber,
                                  String contactNumber, String password, String contractServiceId,String startDate, String endDate) {
        if (name.isEmpty() || address.isEmpty() || primaryNumber.isEmpty() || secondaryNumber.isEmpty()
                || contactNumber.isEmpty() || password.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
            return false;
        }

        try {
            FileWriter fileWriter = new FileWriter(CUSTOMER_INFO_FILENAME);
            fileWriter.write(
                    String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", name, address, primaryNumber, secondaryNumber, contactNumber, password,contractServiceId,startDate,endDate));
            fileWriter.close();
            customer = new Customer(name, address, primaryNumber, secondaryNumber, contactNumber, password,contractServiceId, startDate, endDate);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void recordEvent(EventType eventType, String sectionId, Date triggerTime,
                            Date firstCallTime, int callCount, Date responseTime) {
        Event event = new Event(eventType, sectionId, triggerTime, firstCallTime, callCount, responseTime);
        eventList.add(event);
        try {
            FileWriter fileWriter = new FileWriter(EVENT_RECORDS_FILENAME, true);
            fileWriter.append(event.toString()).append("\r\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
