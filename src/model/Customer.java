package model;
// this class is designed to set and get Customer information
public class Customer {
    private final String name;
    private final String address;
    private final String primaryNumber;
    private final String secondaryNumber;
    private final String contactNumber;
    private final String password;
    private final String serviceContractId;
    private final String startDate;
    private final String endDate;

    public Customer(String name, String address, String primaryNumber, String secondaryNumber,
                    String contactNumber, String password, String serviceContractId, String startDate, String endDate) {
        this.name = name;
        this.address = address;
        this.primaryNumber = primaryNumber;
        this.secondaryNumber = secondaryNumber;
        this.contactNumber = contactNumber;
        this.password = password;
        this.serviceContractId = serviceContractId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean passwordMatched(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public String getSecondaryNumber() {
        return secondaryNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getServiceContractId() {
        return serviceContractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}