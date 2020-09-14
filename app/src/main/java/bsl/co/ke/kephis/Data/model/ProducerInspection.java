package bsl.co.ke.kephis.Data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProducerInspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int producer_inspection_id;
    private String document_number;
    private String document_date;
    private String licence_number;
    private String applicant_name;
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

    public ProducerInspection(int producer_inspection_id, String document_number, String document_date, String licence_number, String applicant_name, String localID, String sinspector, String firmName, String streetName, String postalAddres, String postalCode, String town, String country, String telephoneNo, String pin, String sectionUnit, String description, String latitude, String longitude) {
        this.producer_inspection_id = producer_inspection_id;
        this.document_number = document_number;
        this.document_date = document_date;
        this.licence_number = licence_number;
        this.applicant_name = applicant_name;
        this.localID = localID;
        this.sinspector = sinspector;
        this.firmName = firmName;
        this.streetName = streetName;
        this.postalAddres = postalAddres;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
        this.telephoneNo = telephoneNo;
        this.pin = pin;
        this.sectionUnit = sectionUnit;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getProducer_inspection_id() {
        return producer_inspection_id;
    }

    public void setProducer_inspection_id(int producer_inspection_id) {
        this.producer_inspection_id = producer_inspection_id;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getDocument_date() {
        return document_date;
    }

    public void setDocument_date(String document_date) {
        this.document_date = document_date;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
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
