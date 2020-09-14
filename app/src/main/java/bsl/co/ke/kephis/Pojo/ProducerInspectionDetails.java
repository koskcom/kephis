package bsl.co.ke.kephis.Pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class ProducerInspectionDetails implements Serializable {
    private String serverRecordID;
    private String sentStatus;
    private LoginRequest loginRequest;
    private String serviceType="QueryProducerInspection";
    private String KEPH_Producer_Inspection_ID;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String licenceNumber;
    private String localID;
    private String sinspector;
    private String firmName;
    private String streetName;
    private String postalAddres;
    private String postalCode;
    private String town;
    private String country;
    private String telephoneNo;
    private String pin;
    private String sectionUnit;
    private String description;
    private String latitude;
    private String longitude;

    public ProducerInspectionDetails(String documentNumber, String documentDate, String nameOfApplicant, String licenceNumber, String firmName, String streetName, String postalAddres, String postalCode, String town, String country, String telephoneNo, String pin) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.licenceNumber = licenceNumber;
        this.firmName = firmName;
        this.streetName = streetName;
        this.postalAddres = postalAddres;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
        this.telephoneNo = telephoneNo;
        this.pin = pin;
    }

    public ProducerInspectionDetails() {
    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
    }

    public String getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(String sentStatus) {
        this.sentStatus = sentStatus;
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getKEPH_Producer_Inspection_ID() {
        return KEPH_Producer_Inspection_ID;
    }

    public void setKEPH_Producer_Inspection_ID(String KEPH_Producer_Inspection_ID) {
        this.KEPH_Producer_Inspection_ID = KEPH_Producer_Inspection_ID;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getSinspector() {
        return sinspector;
    }

    public void setSinspector(String sinspector) {
        this.sinspector = sinspector;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalAddres() {
        return postalAddres;
    }

    public void setPostalAddres(String postalAddres) {
        this.postalAddres = postalAddres;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getSectionUnit() {
        return sectionUnit;
    }

    public void setSectionUnit(String sectionUnit) {
        this.sectionUnit = sectionUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
