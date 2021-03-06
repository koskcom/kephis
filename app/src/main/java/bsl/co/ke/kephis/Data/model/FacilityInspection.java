package bsl.co.ke.kephis.Data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FacilityInspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int facility_inspection_id;
    private String document_number;
    private String document_date;
    private String licence_number;
    private String applicant_name;
    private String localID;
    private String nameOfapplicant;
    private String personInCharge;
    private String postalAdrress;
    private String streetName;
    private String telephoneNumber;
    private String postalCode;
    private String town;
    private String country;
    private String commodity;
    private String capacityDimensionsinfeet;
    private String ssproduceExamined;
    private String ssevidenceofstorage;
    private String ssrodentandpestcontrol;
    private String ssequipmmentFortrapping;
    private String ssmanagementEmployessHaveKnowledge;
    private String ssprocessingAdStorageArea;
    private String ssfinishedGoodsInBags;
    private String sscratesPallets;
    private String ssrejectedGoodsAreKept;
    private String ssprocessingFacility;
    private String ssdifferentCommodities;
    private String sscurrentlyStored;
    private String ssfirmHasScheduled;
    private String ssprovisionofWire;
    private String ssbuildingDurable;
    private String ssinteriorLighting;
    private String ssVentillationAdequate;
    private String sstoiletsanddreesing;
    private String sspresenceOfpersonalProtectiveGear;
    private String date;
    private String latitude;
    private String longitude;


    public String getSsVentillationAdequate() {
        return ssVentillationAdequate;
    }

    public void setSsVentillationAdequate(String ssVentillationAdequate) {
        this.ssVentillationAdequate = ssVentillationAdequate;
    }

    public FacilityInspection(int facility_inspection_id, String document_number, String document_date, String licence_number, String applicant_name, String localID, String nameOfapplicant, String personInCharge, String postalAdrress, String streetName, String telephoneNumber, String postalCode, String town, String country, String commodity, String capacityDimensionsinfeet, String ssproduceExamined, String ssevidenceofstorage, String ssrodentandpestcontrol, String ssequipmmentFortrapping, String ssmanagementEmployessHaveKnowledge, String ssprocessingAdStorageArea, String ssfinishedGoodsInBags, String sscratesPallets, String ssrejectedGoodsAreKept, String ssprocessingFacility, String ssdifferentCommodities, String sscurrentlyStored, String ssfirmHasScheduled, String ssprovisionofWire, String ssbuildingDurable, String ssinteriorLighting, String ssVentillationAdequate, String sstoiletsanddreesing, String sspresenceOfpersonalProtectiveGear, String date, String latitude, String longitude) {
        this.facility_inspection_id = facility_inspection_id;
        this.document_number = document_number;
        this.document_date = document_date;
        this.licence_number = licence_number;
        this.applicant_name = applicant_name;
        this.localID = localID;
        this.nameOfapplicant = nameOfapplicant;
        this.personInCharge = personInCharge;
        this.postalAdrress = postalAdrress;
        this.streetName = streetName;
        this.telephoneNumber = telephoneNumber;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
        this.commodity = commodity;
        this.capacityDimensionsinfeet = capacityDimensionsinfeet;
        this.ssproduceExamined = ssproduceExamined;
        this.ssevidenceofstorage = ssevidenceofstorage;
        this.ssrodentandpestcontrol = ssrodentandpestcontrol;
        this.ssequipmmentFortrapping = ssequipmmentFortrapping;
        this.ssmanagementEmployessHaveKnowledge = ssmanagementEmployessHaveKnowledge;
        this.ssprocessingAdStorageArea = ssprocessingAdStorageArea;
        this.ssfinishedGoodsInBags = ssfinishedGoodsInBags;
        this.sscratesPallets = sscratesPallets;
        this.ssrejectedGoodsAreKept = ssrejectedGoodsAreKept;
        this.ssprocessingFacility = ssprocessingFacility;
        this.ssdifferentCommodities = ssdifferentCommodities;
        this.sscurrentlyStored = sscurrentlyStored;
        this.ssfirmHasScheduled = ssfirmHasScheduled;
        this.ssprovisionofWire = ssprovisionofWire;
        this.ssbuildingDurable = ssbuildingDurable;
        this.ssinteriorLighting = ssinteriorLighting;
        this.ssVentillationAdequate = ssVentillationAdequate;
        this.sstoiletsanddreesing = sstoiletsanddreesing;
        this.sspresenceOfpersonalProtectiveGear = sspresenceOfpersonalProtectiveGear;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNameOfapplicant() {
        return nameOfapplicant;
    }

    public void setNameOfapplicant(String nameOfapplicant) {
        this.nameOfapplicant = nameOfapplicant;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getPostalAdrress() {
        return postalAdrress;
    }

    public void setPostalAdrress(String postalAdrress) {
        this.postalAdrress = postalAdrress;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCapacityDimensionsinfeet() {
        return capacityDimensionsinfeet;
    }

    public void setCapacityDimensionsinfeet(String capacityDimensionsinfeet) {
        this.capacityDimensionsinfeet = capacityDimensionsinfeet;
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

    public int getFacility_inspection_id() {
        return facility_inspection_id;
    }

    public void setFacility_inspection_id(int facility_inspection_id) {
        this.facility_inspection_id = facility_inspection_id;
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

    public String getSsproduceExamined() {
        return ssproduceExamined;
    }

    public void setSsproduceExamined(String ssproduceExamined) {
        this.ssproduceExamined = ssproduceExamined;
    }

    public String getSsevidenceofstorage() {
        return ssevidenceofstorage;
    }

    public void setSsevidenceofstorage(String ssevidenceofstorage) {
        this.ssevidenceofstorage = ssevidenceofstorage;
    }

    public String getSsrodentandpestcontrol() {
        return ssrodentandpestcontrol;
    }

    public void setSsrodentandpestcontrol(String ssrodentandpestcontrol) {
        this.ssrodentandpestcontrol = ssrodentandpestcontrol;
    }

    public String getSsequipmmentFortrapping() {
        return ssequipmmentFortrapping;
    }

    public void setSsequipmmentFortrapping(String ssequipmmentFortrapping) {
        this.ssequipmmentFortrapping = ssequipmmentFortrapping;
    }

    public String getSsmanagementEmployessHaveKnowledge() {
        return ssmanagementEmployessHaveKnowledge;
    }

    public void setSsmanagementEmployessHaveKnowledge(String ssmanagementEmployessHaveKnowledge) {
        this.ssmanagementEmployessHaveKnowledge = ssmanagementEmployessHaveKnowledge;
    }

    public String getSsprocessingAdStorageArea() {
        return ssprocessingAdStorageArea;
    }

    public void setSsprocessingAdStorageArea(String ssprocessingAdStorageArea) {
        this.ssprocessingAdStorageArea = ssprocessingAdStorageArea;
    }

    public String getSsfinishedGoodsInBags() {
        return ssfinishedGoodsInBags;
    }

    public void setSsfinishedGoodsInBags(String ssfinishedGoodsInBags) {
        this.ssfinishedGoodsInBags = ssfinishedGoodsInBags;
    }

    public String getSscratesPallets() {
        return sscratesPallets;
    }

    public void setSscratesPallets(String sscratesPallets) {
        this.sscratesPallets = sscratesPallets;
    }

    public String getSsrejectedGoodsAreKept() {
        return ssrejectedGoodsAreKept;
    }

    public void setSsrejectedGoodsAreKept(String ssrejectedGoodsAreKept) {
        this.ssrejectedGoodsAreKept = ssrejectedGoodsAreKept;
    }

    public String getSsprocessingFacility() {
        return ssprocessingFacility;
    }

    public void setSsprocessingFacility(String ssprocessingFacility) {
        this.ssprocessingFacility = ssprocessingFacility;
    }

    public String getSsdifferentCommodities() {
        return ssdifferentCommodities;
    }

    public void setSsdifferentCommodities(String ssdifferentCommodities) {
        this.ssdifferentCommodities = ssdifferentCommodities;
    }

    public String getSscurrentlyStored() {
        return sscurrentlyStored;
    }

    public void setSscurrentlyStored(String sscurrentlyStored) {
        this.sscurrentlyStored = sscurrentlyStored;
    }

    public String getSsfirmHasScheduled() {
        return ssfirmHasScheduled;
    }

    public void setSsfirmHasScheduled(String ssfirmHasScheduled) {
        this.ssfirmHasScheduled = ssfirmHasScheduled;
    }

    public String getSsprovisionofWire() {
        return ssprovisionofWire;
    }

    public void setSsprovisionofWire(String ssprovisionofWire) {
        this.ssprovisionofWire = ssprovisionofWire;
    }

    public String getSsbuildingDurable() {
        return ssbuildingDurable;
    }

    public void setSsbuildingDurable(String ssbuildingDurable) {
        this.ssbuildingDurable = ssbuildingDurable;
    }

    public String getSsinteriorLighting() {
        return ssinteriorLighting;
    }

    public void setSsinteriorLighting(String ssinteriorLighting) {
        this.ssinteriorLighting = ssinteriorLighting;
    }

    public String getSstoiletsanddreesing() {
        return sstoiletsanddreesing;
    }

    public void setSstoiletsanddreesing(String sstoiletsanddreesing) {
        this.sstoiletsanddreesing = sstoiletsanddreesing;
    }

    public String getSspresenceOfpersonalProtectiveGear() {
        return sspresenceOfpersonalProtectiveGear;
    }

    public void setSspresenceOfpersonalProtectiveGear(String sspresenceOfpersonalProtectiveGear) {
        this.sspresenceOfpersonalProtectiveGear = sspresenceOfpersonalProtectiveGear;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
