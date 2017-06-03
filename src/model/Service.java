package model;
import java.util.*;

/**
 * Created by Administrator on 2017/6/2.
 */
public class Service {

    public enum ServiceType {
        BREAKIN(1),
        FIRE(2),
        BREAKIN_N_FIRE(3);

        private int number;

        private ServiceType(int number) {
            this.number = number;
        }

    }

    private Long id;
    private String serviceCode;
    private String customerName;
    private String buildingName;
    private String address;
    private String telephone;
    private ServiceType serviceType;
    private String emergencyTelephonePrimary;
    private String emergencyTelephoneSecondary;


    private Date fromDate;
    private Date toDate;

    public Service() {}

    public Service(final String serviceCode, final String customerName, final String buildingName,
                   final String address, final String telephone, final ServiceType serviceType,
                   final String emergencyTelephonePrimary, final String emergencyTelephoneSecondary,
                   final Date fromDate, final Date toDate){
        this.serviceCode = serviceCode;
        this.customerName = customerName;
        this.buildingName = buildingName;
        this.address = address;
        this.telephone = telephone;
        this.serviceType = serviceType;
        this.emergencyTelephonePrimary = emergencyTelephonePrimary;
        this.emergencyTelephoneSecondary = emergencyTelephoneSecondary;
        this.fromDate = fromDate;
        this.toDate = toDate;

    }
    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }
    public String getServiceCode() {
        return serviceCode;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }
    public String getBuildingName() {
        return buildingName;
    }
    public void setBuildingName(final String buildingName) {
        this.buildingName = buildingName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(final String address) {
        this.address = address;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }
    public void setServiceType(final ServiceType serviceType) {
        this.serviceType = serviceType;
    }
    public String getEmergencyTelephonePrimary() {
        return emergencyTelephonePrimary;
    }
    public void setEmergencyTelephonePrimary(final String emergencyTelephonePrimary) {
        this.emergencyTelephonePrimary = emergencyTelephonePrimary;
    }
    public String getEmergencyTelephoneSecondary() {
        return emergencyTelephoneSecondary;
    }
    public void setEmergencyTelephoneSecondary(final String emergencyTelephoneSecondary) {
        this.emergencyTelephoneSecondary = emergencyTelephoneSecondary;
    }

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(final Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    public void setToDate(final Date toDate) {
        this.toDate = toDate;
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id = " + id);
        sb.append("serviceCode = " + serviceCode);
        sb.append("customerName = " + customerName);
        sb.append("buildingName = " + buildingName);
        sb.append("address = " + address);
        sb.append("telephone = " + telephone);
        sb.append("serviceType = " + serviceType);
        sb.append("emergencyTelephonePrimary = " + emergencyTelephonePrimary);
        sb.append("emergencyTelephoneSecondary = " + emergencyTelephoneSecondary);
        return sb.toString();
    }
}

