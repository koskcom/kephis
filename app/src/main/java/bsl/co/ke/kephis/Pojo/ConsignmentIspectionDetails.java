package bsl.co.ke.kephis.Pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class ConsignmentIspectionDetails implements Serializable {
    private String serverRecordID;
    private String sentStatus;
    private LoginRequest loginRequest;
    private String serviceType="QueryConsignmentInspection";
    private String KEPH_Consignment_Inspection_ID;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String licenceNumber;
    private String localID;
    private String ssInspector;
    private String sectionunit;
    private String consignmentReport;
    private String isadditionalInspections;
    private String additionalInspectionRemarks;
    private String firNumber;
    private String description;
    private String validUntil;
    private String fieldInspection;
    private String products;
    private String netWeight;
    private String grossWeiight;
    private String productCategory;
    private String commodityForm;
    private String variety;
    private String quantity;
    private String quantityUnit;
    private String quantityPassed;
    private String quantityRejected;
    private String numberofpackages;
    private String rejectedPackages;
    private String damagedCauesd;
    private String plantPart;
    private String sampleSizeInspected;
    private String typeOfDisease;
    private String pathogenIdentified;
    private String healthClean;
    private String treatment;
    private String released;
    private String methodofDestruction;
    private String seriallNumber;
    private String relevantInformation;

    public ConsignmentIspectionDetails() {
    }

    public ConsignmentIspectionDetails(String documentNumber, String documentDate, String nameOfApplicant, String licenceNumber) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.licenceNumber = licenceNumber;
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

    public String getKEPH_Consignment_Inspection_ID() {
        return KEPH_Consignment_Inspection_ID;
    }

    public void setKEPH_Consignment_Inspection_ID(String KEPH_Consignment_Inspection_ID) {
        this.KEPH_Consignment_Inspection_ID = KEPH_Consignment_Inspection_ID;
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

    public String getSsInspector() {
        return ssInspector;
    }

    public void setSsInspector(String ssInspector) {
        this.ssInspector = ssInspector;
    }

    public String getSectionunit() {
        return sectionunit;
    }

    public void setSectionunit(String sectionunit) {
        this.sectionunit = sectionunit;
    }

    public String getConsignmentReport() {
        return consignmentReport;
    }

    public void setConsignmentReport(String consignmentReport) {
        this.consignmentReport = consignmentReport;
    }

    public String getIsadditionalInspections() {
        return isadditionalInspections;
    }

    public void setIsadditionalInspections(String isadditionalInspections) {
        this.isadditionalInspections = isadditionalInspections;
    }

    public String getAdditionalInspectionRemarks() {
        return additionalInspectionRemarks;
    }

    public void setAdditionalInspectionRemarks(String additionalInspectionRemarks) {
        this.additionalInspectionRemarks = additionalInspectionRemarks;
    }

    public String getFirNumber() {
        return firNumber;
    }

    public void setFirNumber(String firNumber) {
        this.firNumber = firNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getFieldInspection() {
        return fieldInspection;
    }

    public void setFieldInspection(String fieldInspection) {
        this.fieldInspection = fieldInspection;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getGrossWeiight() {
        return grossWeiight;
    }

    public void setGrossWeiight(String grossWeiight) {
        this.grossWeiight = grossWeiight;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getCommodityForm() {
        return commodityForm;
    }

    public void setCommodityForm(String commodityForm) {
        this.commodityForm = commodityForm;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public String getQuantityPassed() {
        return quantityPassed;
    }

    public void setQuantityPassed(String quantityPassed) {
        this.quantityPassed = quantityPassed;
    }

    public String getQuantityRejected() {
        return quantityRejected;
    }

    public void setQuantityRejected(String quantityRejected) {
        this.quantityRejected = quantityRejected;
    }

    public String getNumberofpackages() {
        return numberofpackages;
    }

    public void setNumberofpackages(String numberofpackages) {
        this.numberofpackages = numberofpackages;
    }

    public String getRejectedPackages() {
        return rejectedPackages;
    }

    public void setRejectedPackages(String rejectedPackages) {
        this.rejectedPackages = rejectedPackages;
    }

    public String getDamagedCauesd() {
        return damagedCauesd;
    }

    public void setDamagedCauesd(String damagedCauesd) {
        this.damagedCauesd = damagedCauesd;
    }

    public String getPlantPart() {
        return plantPart;
    }

    public void setPlantPart(String plantPart) {
        this.plantPart = plantPart;
    }

    public String getSampleSizeInspected() {
        return sampleSizeInspected;
    }

    public void setSampleSizeInspected(String sampleSizeInspected) {
        this.sampleSizeInspected = sampleSizeInspected;
    }

    public String getTypeOfDisease() {
        return typeOfDisease;
    }

    public void setTypeOfDisease(String typeOfDisease) {
        this.typeOfDisease = typeOfDisease;
    }

    public String getPathogenIdentified() {
        return pathogenIdentified;
    }

    public void setPathogenIdentified(String pathogenIdentified) {
        this.pathogenIdentified = pathogenIdentified;
    }

    public String getHealthClean() {
        return healthClean;
    }

    public void setHealthClean(String healthClean) {
        this.healthClean = healthClean;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getMethodofDestruction() {
        return methodofDestruction;
    }

    public void setMethodofDestruction(String methodofDestruction) {
        this.methodofDestruction = methodofDestruction;
    }

    public String getSeriallNumber() {
        return seriallNumber;
    }

    public void setSeriallNumber(String seriallNumber) {
        this.seriallNumber = seriallNumber;
    }

    public String getRelevantInformation() {
        return relevantInformation;
    }

    public void setRelevantInformation(String relevantInformation) {
        this.relevantInformation = relevantInformation;
    }
}
