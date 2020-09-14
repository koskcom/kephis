package bsl.co.ke.kephis.Pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class FacilityInspectionDetails implements Serializable {
    private String serverRecordID;
    private String sentStatus;
    private LoginRequest loginRequest;
    private String serviceType="QueryFacilityInspection";
    private String KEPH_Facility_Inspection_ID;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String licenceNumber;
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


    public FacilityInspectionDetails(String documentNumber, String documentDate, String nameOfApplicant, String licenceNumber, String nameOfapplicant, String personInCharge, String postalAdrress, String streetName, String telephoneNumber, String postalCode, String town, String country, String commodity, String capacityDimensionsinfeet) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.licenceNumber = licenceNumber;
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
    }

    public String getSsVentillationAdequate() {
        return ssVentillationAdequate;
    }

    public void setSsVentillationAdequate(String ssVentillationAdequate) {
        this.ssVentillationAdequate = ssVentillationAdequate;
    }

    public FacilityInspectionDetails() {
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

    public String getKEPH_Facility_Inspection_ID() {
        return KEPH_Facility_Inspection_ID;
    }

    public void setKEPH_Facility_Inspection_ID(String KEPH_Facility_Inspection_ID) {
        this.KEPH_Facility_Inspection_ID = KEPH_Facility_Inspection_ID;
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
