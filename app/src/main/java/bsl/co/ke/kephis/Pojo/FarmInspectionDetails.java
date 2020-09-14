package bsl.co.ke.kephis.Pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class FarmInspectionDetails implements Serializable {
    private String serverRecordID;
    private String sentStatus;
    private LoginRequest loginRequest;
    private String serviceType="QueryFarmInspection";
    private String FARM_Inspection_ID;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String licenceNumber;
    private String localID;
    private String sinspector;
    private String farmName;
    private String traceability_code;
    private String county;
    private String subCounty;
    private String ward;
    private String streetName;
    private String contactPerson;
    private String town;
    private String areaUnderProduction;
    private String marketDestination;
    private String isAwareOfmktRequirements;
    private String acreage;
    private String sourcesOfPlantingmateriial;
    private String presenceOfQualityAssurance;
    private String documentedPestManagement;
    private String noOfScouts;
    private String trainingExperienceOfscouts;
    private String areaAllocatedToEachScout;
    private String pestMonitoringMethodsUsed;
    private String scoutingmethodsused;
    private String frequencyOfScouting;
    private String scoutingrecordsavailable;
    private String pestreportingchannels;
    private String pestcontrolmethodsused;
    private String sprayprogramsinplace;
    private String qualitymanagementproceduresinplace;
    private String qualitycontrolchecksinplace;
    private String awarenessonpestsofconcern;
    private String abilityOfQualityContro;
    private String detectedpestrecordsinplace;
    private String trainingandexperience;
    private String abilityToIdentifyPest;
    private String areascoutedperday;
    private String frequencyOfscouting;
    private String scoutinghasscoutingsheetsbook;
    private String scoutingtoolsused;
    private String pestsconcerncapturedrecords;
    private String scoutingreportingchannels;
    private String anypestsorpestsignsdetected;
    private String pesttrapsinplace;
    private String anypestsofconcerntrapped;
    private String greenhousefarmsanitarystatus;
    private String awarenesspestsofconcern;
    private String trainingonpestsofconcern;
    private String abilitytodetectpestsandpestsigns;
    private String roleinpestreportingsystem;
    private String packhousesanitationstatus;
    private String qualitymanagementproceduresinplace2;
    private String howmanyqualitycontrolpoints;
    private String qualitycontrolpersonnelonawareness;
    private String abilitytodetectpestsandpestsigns2;
    private String reportingchannelforpestdetection;
    private String gradersawareofpestsandpestsigns;
    private String appropriatehygieneprotocolsinplace;
    private String qualityassurancepersonnelPostHarvest;
    private String qualityassurancepersonnelmarketrequirement;
    private String traceabilitysystemused;
    private String traceabilitysystemusedtowhatlevel;
    private String transportofproducefromfarm;
    private String farmmanagementinvolvementpestcontrol;
    private String latitude;
    private String longitude;
    private String pestmanagementsystem;
    private String packhousequalitymanagementsystem;
    private String traceabilitysystem;
    private String recommendation;

    public FarmInspectionDetails(String documentNumber, String documentDate, String nameOfApplicant, String licenceNumber, String farmName, String traceability_code, String county, String subCounty, String ward, String streetName, String contactPerson, String town, String areaUnderProduction, String marketDestination, String isAwareOfmktRequirements) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.licenceNumber = licenceNumber;
        this.farmName = farmName;
        this.traceability_code = traceability_code;
        this.county = county;
        this.subCounty = subCounty;
        this.ward = ward;
        this.streetName = streetName;
        this.contactPerson = contactPerson;
        this.town = town;
        this.areaUnderProduction = areaUnderProduction;
        this.marketDestination = marketDestination;
        this.isAwareOfmktRequirements = isAwareOfmktRequirements;
    }

    public FarmInspectionDetails() {
    }

    public String getLatitude() {
        return latitude;
    }

    public String getNoOfScouts() {
        return noOfScouts;
    }

    public void setNoOfScouts(String noOfScouts) {
        this.noOfScouts = noOfScouts;
    }

    public String getTrainingExperienceOfscouts() {
        return trainingExperienceOfscouts;
    }

    public void setTrainingExperienceOfscouts(String trainingExperienceOfscouts) {
        this.trainingExperienceOfscouts = trainingExperienceOfscouts;
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

    public String getFARM_Inspection_ID() {
        return FARM_Inspection_ID;
    }

    public void setFARM_Inspection_ID(String FARM_Inspection_ID) {
        this.FARM_Inspection_ID = FARM_Inspection_ID;
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

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getTraceability_code() {
        return traceability_code;
    }

    public void setTraceability_code(String traceability_code) {
        this.traceability_code = traceability_code;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSubCounty() {
        return subCounty;
    }

    public void setSubCounty(String subCounty) {
        this.subCounty = subCounty;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAreaUnderProduction() {
        return areaUnderProduction;
    }

    public void setAreaUnderProduction(String areaUnderProduction) {
        this.areaUnderProduction = areaUnderProduction;
    }

    public String getMarketDestination() {
        return marketDestination;
    }

    public void setMarketDestination(String marketDestination) {
        this.marketDestination = marketDestination;
    }

    public String getIsAwareOfmktRequirements() {
        return isAwareOfmktRequirements;
    }

    public void setIsAwareOfmktRequirements(String isAwareOfmktRequirements) {
        this.isAwareOfmktRequirements = isAwareOfmktRequirements;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getSourcesOfPlantingmateriial() {
        return sourcesOfPlantingmateriial;
    }

    public void setSourcesOfPlantingmateriial(String sourcesOfPlantingmateriial) {
        this.sourcesOfPlantingmateriial = sourcesOfPlantingmateriial;
    }

    public String getPresenceOfQualityAssurance() {
        return presenceOfQualityAssurance;
    }

    public void setPresenceOfQualityAssurance(String presenceOfQualityAssurance) {
        this.presenceOfQualityAssurance = presenceOfQualityAssurance;
    }

    public String getDocumentedPestManagement() {
        return documentedPestManagement;
    }

    public void setDocumentedPestManagement(String documentedPestManagement) {
        this.documentedPestManagement = documentedPestManagement;
    }

    public String getAreaAllocatedToEachScout() {
        return areaAllocatedToEachScout;
    }

    public void setAreaAllocatedToEachScout(String areaAllocatedToEachScout) {
        this.areaAllocatedToEachScout = areaAllocatedToEachScout;
    }

    public String getPestMonitoringMethodsUsed() {
        return pestMonitoringMethodsUsed;
    }

    public void setPestMonitoringMethodsUsed(String pestMonitoringMethodsUsed) {
        this.pestMonitoringMethodsUsed = pestMonitoringMethodsUsed;
    }

    public String getScoutingmethodsused() {
        return scoutingmethodsused;
    }

    public void setScoutingmethodsused(String scoutingmethodsused) {
        this.scoutingmethodsused = scoutingmethodsused;
    }

    public String getFrequencyOfScouting() {
        return frequencyOfScouting;
    }

    public void setFrequencyOfScouting(String frequencyOfScouting) {
        this.frequencyOfScouting = frequencyOfScouting;
    }

    public String getScoutingrecordsavailable() {
        return scoutingrecordsavailable;
    }

    public void setScoutingrecordsavailable(String scoutingrecordsavailable) {
        this.scoutingrecordsavailable = scoutingrecordsavailable;
    }

    public String getPestreportingchannels() {
        return pestreportingchannels;
    }

    public void setPestreportingchannels(String pestreportingchannels) {
        this.pestreportingchannels = pestreportingchannels;
    }

    public String getPestcontrolmethodsused() {
        return pestcontrolmethodsused;
    }

    public void setPestcontrolmethodsused(String pestcontrolmethodsused) {
        this.pestcontrolmethodsused = pestcontrolmethodsused;
    }

    public String getSprayprogramsinplace() {
        return sprayprogramsinplace;
    }

    public void setSprayprogramsinplace(String sprayprogramsinplace) {
        this.sprayprogramsinplace = sprayprogramsinplace;
    }

    public String getQualitymanagementproceduresinplace() {
        return qualitymanagementproceduresinplace;
    }

    public void setQualitymanagementproceduresinplace(String qualitymanagementproceduresinplace) {
        this.qualitymanagementproceduresinplace = qualitymanagementproceduresinplace;
    }

    public String getQualitycontrolchecksinplace() {
        return qualitycontrolchecksinplace;
    }

    public void setQualitycontrolchecksinplace(String qualitycontrolchecksinplace) {
        this.qualitycontrolchecksinplace = qualitycontrolchecksinplace;
    }

    public String getAwarenessonpestsofconcern() {
        return awarenessonpestsofconcern;
    }

    public void setAwarenessonpestsofconcern(String awarenessonpestsofconcern) {
        this.awarenessonpestsofconcern = awarenessonpestsofconcern;
    }

    public String getAbilityOfQualityContro() {
        return abilityOfQualityContro;
    }

    public void setAbilityOfQualityContro(String abilityOfQualityContro) {
        this.abilityOfQualityContro = abilityOfQualityContro;
    }

    public String getDetectedpestrecordsinplace() {
        return detectedpestrecordsinplace;
    }

    public void setDetectedpestrecordsinplace(String detectedpestrecordsinplace) {
        this.detectedpestrecordsinplace = detectedpestrecordsinplace;
    }

    public String getTrainingandexperience() {
        return trainingandexperience;
    }

    public void setTrainingandexperience(String trainingandexperience) {
        this.trainingandexperience = trainingandexperience;
    }

    public String getAbilityToIdentifyPest() {
        return abilityToIdentifyPest;
    }

    public void setAbilityToIdentifyPest(String abilityToIdentifyPest) {
        this.abilityToIdentifyPest = abilityToIdentifyPest;
    }

    public String getAreascoutedperday() {
        return areascoutedperday;
    }

    public void setAreascoutedperday(String areascoutedperday) {
        this.areascoutedperday = areascoutedperday;
    }

    public String getFrequencyOfscouting() {
        return frequencyOfscouting;
    }

    public void setFrequencyOfscouting(String frequencyOfscouting) {
        this.frequencyOfscouting = frequencyOfscouting;
    }

    public String getScoutinghasscoutingsheetsbook() {
        return scoutinghasscoutingsheetsbook;
    }

    public void setScoutinghasscoutingsheetsbook(String scoutinghasscoutingsheetsbook) {
        this.scoutinghasscoutingsheetsbook = scoutinghasscoutingsheetsbook;
    }

    public String getScoutingtoolsused() {
        return scoutingtoolsused;
    }

    public void setScoutingtoolsused(String scoutingtoolsused) {
        this.scoutingtoolsused = scoutingtoolsused;
    }

    public String getPestsconcerncapturedrecords() {
        return pestsconcerncapturedrecords;
    }

    public void setPestsconcerncapturedrecords(String pestsconcerncapturedrecords) {
        this.pestsconcerncapturedrecords = pestsconcerncapturedrecords;
    }

    public String getScoutingreportingchannels() {
        return scoutingreportingchannels;
    }

    public void setScoutingreportingchannels(String scoutingreportingchannels) {
        this.scoutingreportingchannels = scoutingreportingchannels;
    }

    public String getAnypestsorpestsignsdetected() {
        return anypestsorpestsignsdetected;
    }

    public void setAnypestsorpestsignsdetected(String anypestsorpestsignsdetected) {
        this.anypestsorpestsignsdetected = anypestsorpestsignsdetected;
    }

    public String getPesttrapsinplace() {
        return pesttrapsinplace;
    }

    public void setPesttrapsinplace(String pesttrapsinplace) {
        this.pesttrapsinplace = pesttrapsinplace;
    }

    public String getAnypestsofconcerntrapped() {
        return anypestsofconcerntrapped;
    }

    public void setAnypestsofconcerntrapped(String anypestsofconcerntrapped) {
        this.anypestsofconcerntrapped = anypestsofconcerntrapped;
    }

    public String getGreenhousefarmsanitarystatus() {
        return greenhousefarmsanitarystatus;
    }

    public void setGreenhousefarmsanitarystatus(String greenhousefarmsanitarystatus) {
        this.greenhousefarmsanitarystatus = greenhousefarmsanitarystatus;
    }

    public String getAwarenesspestsofconcern() {
        return awarenesspestsofconcern;
    }

    public void setAwarenesspestsofconcern(String awarenesspestsofconcern) {
        this.awarenesspestsofconcern = awarenesspestsofconcern;
    }

    public String getTrainingonpestsofconcern() {
        return trainingonpestsofconcern;
    }

    public void setTrainingonpestsofconcern(String trainingonpestsofconcern) {
        this.trainingonpestsofconcern = trainingonpestsofconcern;
    }

    public String getAbilitytodetectpestsandpestsigns() {
        return abilitytodetectpestsandpestsigns;
    }

    public void setAbilitytodetectpestsandpestsigns(String abilitytodetectpestsandpestsigns) {
        this.abilitytodetectpestsandpestsigns = abilitytodetectpestsandpestsigns;
    }

    public String getRoleinpestreportingsystem() {
        return roleinpestreportingsystem;
    }

    public void setRoleinpestreportingsystem(String roleinpestreportingsystem) {
        this.roleinpestreportingsystem = roleinpestreportingsystem;
    }

    public String getPackhousesanitationstatus() {
        return packhousesanitationstatus;
    }

    public void setPackhousesanitationstatus(String packhousesanitationstatus) {
        this.packhousesanitationstatus = packhousesanitationstatus;
    }

    public String getQualitymanagementproceduresinplace2() {
        return qualitymanagementproceduresinplace2;
    }

    public void setQualitymanagementproceduresinplace2(String qualitymanagementproceduresinplace2) {
        this.qualitymanagementproceduresinplace2 = qualitymanagementproceduresinplace2;
    }

    public String getHowmanyqualitycontrolpoints() {
        return howmanyqualitycontrolpoints;
    }

    public void setHowmanyqualitycontrolpoints(String howmanyqualitycontrolpoints) {
        this.howmanyqualitycontrolpoints = howmanyqualitycontrolpoints;
    }

    public String getQualitycontrolpersonnelonawareness() {
        return qualitycontrolpersonnelonawareness;
    }

    public void setQualitycontrolpersonnelonawareness(String qualitycontrolpersonnelonawareness) {
        this.qualitycontrolpersonnelonawareness = qualitycontrolpersonnelonawareness;
    }

    public String getAbilitytodetectpestsandpestsigns2() {
        return abilitytodetectpestsandpestsigns2;
    }

    public void setAbilitytodetectpestsandpestsigns2(String abilitytodetectpestsandpestsigns2) {
        this.abilitytodetectpestsandpestsigns2 = abilitytodetectpestsandpestsigns2;
    }

    public String getReportingchannelforpestdetection() {
        return reportingchannelforpestdetection;
    }

    public void setReportingchannelforpestdetection(String reportingchannelforpestdetection) {
        this.reportingchannelforpestdetection = reportingchannelforpestdetection;
    }

    public String getGradersawareofpestsandpestsigns() {
        return gradersawareofpestsandpestsigns;
    }

    public void setGradersawareofpestsandpestsigns(String gradersawareofpestsandpestsigns) {
        this.gradersawareofpestsandpestsigns = gradersawareofpestsandpestsigns;
    }

    public String getAppropriatehygieneprotocolsinplace() {
        return appropriatehygieneprotocolsinplace;
    }

    public void setAppropriatehygieneprotocolsinplace(String appropriatehygieneprotocolsinplace) {
        this.appropriatehygieneprotocolsinplace = appropriatehygieneprotocolsinplace;
    }

    public String getQualityassurancepersonnelPostHarvest() {
        return qualityassurancepersonnelPostHarvest;
    }

    public void setQualityassurancepersonnelPostHarvest(String qualityassurancepersonnelPostHarvest) {
        this.qualityassurancepersonnelPostHarvest = qualityassurancepersonnelPostHarvest;
    }

    public String getQualityassurancepersonnelmarketrequirement() {
        return qualityassurancepersonnelmarketrequirement;
    }

    public void setQualityassurancepersonnelmarketrequirement(String qualityassurancepersonnelmarketrequirement) {
        this.qualityassurancepersonnelmarketrequirement = qualityassurancepersonnelmarketrequirement;
    }

    public String getTraceabilitysystemused() {
        return traceabilitysystemused;
    }

    public void setTraceabilitysystemused(String traceabilitysystemused) {
        this.traceabilitysystemused = traceabilitysystemused;
    }

    public String getTraceabilitysystemusedtowhatlevel() {
        return traceabilitysystemusedtowhatlevel;
    }

    public void setTraceabilitysystemusedtowhatlevel(String traceabilitysystemusedtowhatlevel) {
        this.traceabilitysystemusedtowhatlevel = traceabilitysystemusedtowhatlevel;
    }

    public String getTransportofproducefromfarm() {
        return transportofproducefromfarm;
    }

    public void setTransportofproducefromfarm(String transportofproducefromfarm) {
        this.transportofproducefromfarm = transportofproducefromfarm;
    }

    public String getFarmmanagementinvolvementpestcontrol() {
        return farmmanagementinvolvementpestcontrol;
    }

    public void setFarmmanagementinvolvementpestcontrol(String farmmanagementinvolvementpestcontrol) {
        this.farmmanagementinvolvementpestcontrol = farmmanagementinvolvementpestcontrol;
    }

    public String getPestmanagementsystem() {
        return pestmanagementsystem;
    }

    public void setPestmanagementsystem(String pestmanagementsystem) {
        this.pestmanagementsystem = pestmanagementsystem;
    }

    public String getPackhousequalitymanagementsystem() {
        return packhousequalitymanagementsystem;
    }

    public void setPackhousequalitymanagementsystem(String packhousequalitymanagementsystem) {
        this.packhousequalitymanagementsystem = packhousequalitymanagementsystem;
    }

    public String getTraceabilitysystem() {
        return traceabilitysystem;
    }

    public void setTraceabilitysystem(String traceabilitysystem) {
        this.traceabilitysystem = traceabilitysystem;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
