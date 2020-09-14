package bsl.co.ke.kephis.Data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ConsignmentIspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int consignment_inspection_id;
    private String document_number;
    private String document_date;
    private String licence_number;
    private String applicant_name;
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

    public ConsignmentIspection(int consignment_inspection_id, String document_number, String document_date, String licence_number, String applicant_name, String localID, String ssInspector, String sectionunit, String consignmentReport, String isadditionalInspections, String additionalInspectionRemarks, String firNumber, String description, String validUntil, String fieldInspection, String products, String netWeight, String grossWeiight, String productCategory, String commodityForm, String variety, String quantity, String quantityUnit, String quantityPassed, String quantityRejected, String numberofpackages, String rejectedPackages, String damagedCauesd, String plantPart, String sampleSizeInspected, String typeOfDisease, String pathogenIdentified, String healthClean, String treatment, String released, String methodofDestruction, String seriallNumber, String relevantInformation) {
        this.consignment_inspection_id = consignment_inspection_id;
        this.document_number = document_number;
        this.document_date = document_date;
        this.licence_number = licence_number;
        this.applicant_name = applicant_name;
        this.localID = localID;
        this.ssInspector = ssInspector;
        this.sectionunit = sectionunit;
        this.consignmentReport = consignmentReport;
        this.isadditionalInspections = isadditionalInspections;
        this.additionalInspectionRemarks = additionalInspectionRemarks;
        this.firNumber = firNumber;
        this.description = description;
        this.validUntil = validUntil;
        this.fieldInspection = fieldInspection;
        this.products = products;
        this.netWeight = netWeight;
        this.grossWeiight = grossWeiight;
        this.productCategory = productCategory;
        this.commodityForm = commodityForm;
        this.variety = variety;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.quantityPassed = quantityPassed;
        this.quantityRejected = quantityRejected;
        this.numberofpackages = numberofpackages;
        this.rejectedPackages = rejectedPackages;
        this.damagedCauesd = damagedCauesd;
        this.plantPart = plantPart;
        this.sampleSizeInspected = sampleSizeInspected;
        this.typeOfDisease = typeOfDisease;
        this.pathogenIdentified = pathogenIdentified;
        this.healthClean = healthClean;
        this.treatment = treatment;
        this.released = released;
        this.methodofDestruction = methodofDestruction;
        this.seriallNumber = seriallNumber;
        this.relevantInformation = relevantInformation;
    }

    public int getConsignment_inspection_id() {
        return consignment_inspection_id;
    }

    public void setConsignment_inspection_id(int consignment_inspection_id) {
        this.consignment_inspection_id = consignment_inspection_id;
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
