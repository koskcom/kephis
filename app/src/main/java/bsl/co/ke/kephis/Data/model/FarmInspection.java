package bsl.co.ke.kephis.Data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FarmInspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int farm_inspection_id;
    private String document_number;
    private String document_date;
    private String licence_number;
    private String applicant_name;
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
    private String frequencyOfscouting2;
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
    private String pestmanagementsystem;
    private String packhousequalitymanagementsystem;
    private String traceabilitysystem;
    private String recommendation;

    public FarmInspection(int farm_inspection_id, String document_number, String document_date, String licence_number, String applicant_name, String localID, String sinspector, String farmName, String traceability_code, String county, String subCounty, String ward, String streetName, String contactPerson, String town, String areaUnderProduction, String marketDestination, String isAwareOfmktRequirements, String acreage, String sourcesOfPlantingmateriial, String presenceOfQualityAssurance, String documentedPestManagement, String noOfScouts, String trainingExperienceOfscouts, String areaAllocatedToEachScout, String pestMonitoringMethodsUsed, String scoutingmethodsused, String frequencyOfScouting, String scoutingrecordsavailable, String pestreportingchannels, String pestcontrolmethodsused, String sprayprogramsinplace, String qualitymanagementproceduresinplace, String qualitycontrolchecksinplace, String awarenessonpestsofconcern, String abilityOfQualityContro, String detectedpestrecordsinplace, String trainingandexperience, String abilityToIdentifyPest, String areascoutedperday, String frequencyOfscouting2, String scoutinghasscoutingsheetsbook, String scoutingtoolsused, String pestsconcerncapturedrecords, String scoutingreportingchannels, String anypestsorpestsignsdetected, String pesttrapsinplace, String anypestsofconcerntrapped, String greenhousefarmsanitarystatus, String awarenesspestsofconcern, String trainingonpestsofconcern, String abilitytodetectpestsandpestsigns, String roleinpestreportingsystem, String packhousesanitationstatus, String qualitymanagementproceduresinplace2, String howmanyqualitycontrolpoints, String qualitycontrolpersonnelonawareness, String abilitytodetectpestsandpestsigns2, String reportingchannelforpestdetection, String gradersawareofpestsandpestsigns, String appropriatehygieneprotocolsinplace, String qualityassurancepersonnelPostHarvest, String qualityassurancepersonnelmarketrequirement, String traceabilitysystemused, String traceabilitysystemusedtowhatlevel, String transportofproducefromfarm, String farmmanagementinvolvementpestcontrol, String pestmanagementsystem, String packhousequalitymanagementsystem, String traceabilitysystem, String recommendation) {
        this.farm_inspection_id = farm_inspection_id;
        this.document_number = document_number;
        this.document_date = document_date;
        this.licence_number = licence_number;
        this.applicant_name = applicant_name;
        this.localID = localID;
        this.sinspector = sinspector;
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
        this.acreage = acreage;
        this.sourcesOfPlantingmateriial = sourcesOfPlantingmateriial;
        this.presenceOfQualityAssurance = presenceOfQualityAssurance;
        this.documentedPestManagement = documentedPestManagement;
        this.noOfScouts = noOfScouts;
        this.trainingExperienceOfscouts = trainingExperienceOfscouts;
        this.areaAllocatedToEachScout = areaAllocatedToEachScout;
        this.pestMonitoringMethodsUsed = pestMonitoringMethodsUsed;
        this.scoutingmethodsused = scoutingmethodsused;
        this.frequencyOfScouting = frequencyOfScouting;
        this.scoutingrecordsavailable = scoutingrecordsavailable;
        this.pestreportingchannels = pestreportingchannels;
        this.pestcontrolmethodsused = pestcontrolmethodsused;
        this.sprayprogramsinplace = sprayprogramsinplace;
        this.qualitymanagementproceduresinplace = qualitymanagementproceduresinplace;
        this.qualitycontrolchecksinplace = qualitycontrolchecksinplace;
        this.awarenessonpestsofconcern = awarenessonpestsofconcern;
        this.abilityOfQualityContro = abilityOfQualityContro;
        this.detectedpestrecordsinplace = detectedpestrecordsinplace;
        this.trainingandexperience = trainingandexperience;
        this.abilityToIdentifyPest = abilityToIdentifyPest;
        this.areascoutedperday = areascoutedperday;
        this.frequencyOfscouting2 = frequencyOfscouting2;
        this.scoutinghasscoutingsheetsbook = scoutinghasscoutingsheetsbook;
        this.scoutingtoolsused = scoutingtoolsused;
        this.pestsconcerncapturedrecords = pestsconcerncapturedrecords;
        this.scoutingreportingchannels = scoutingreportingchannels;
        this.anypestsorpestsignsdetected = anypestsorpestsignsdetected;
        this.pesttrapsinplace = pesttrapsinplace;
        this.anypestsofconcerntrapped = anypestsofconcerntrapped;
        this.greenhousefarmsanitarystatus = greenhousefarmsanitarystatus;
        this.awarenesspestsofconcern = awarenesspestsofconcern;
        this.trainingonpestsofconcern = trainingonpestsofconcern;
        this.abilitytodetectpestsandpestsigns = abilitytodetectpestsandpestsigns;
        this.roleinpestreportingsystem = roleinpestreportingsystem;
        this.packhousesanitationstatus = packhousesanitationstatus;
        this.qualitymanagementproceduresinplace2 = qualitymanagementproceduresinplace2;
        this.howmanyqualitycontrolpoints = howmanyqualitycontrolpoints;
        this.qualitycontrolpersonnelonawareness = qualitycontrolpersonnelonawareness;
        this.abilitytodetectpestsandpestsigns2 = abilitytodetectpestsandpestsigns2;
        this.reportingchannelforpestdetection = reportingchannelforpestdetection;
        this.gradersawareofpestsandpestsigns = gradersawareofpestsandpestsigns;
        this.appropriatehygieneprotocolsinplace = appropriatehygieneprotocolsinplace;
        this.qualityassurancepersonnelPostHarvest = qualityassurancepersonnelPostHarvest;
        this.qualityassurancepersonnelmarketrequirement = qualityassurancepersonnelmarketrequirement;
        this.traceabilitysystemused = traceabilitysystemused;
        this.traceabilitysystemusedtowhatlevel = traceabilitysystemusedtowhatlevel;
        this.transportofproducefromfarm = transportofproducefromfarm;
        this.farmmanagementinvolvementpestcontrol = farmmanagementinvolvementpestcontrol;
        this.pestmanagementsystem = pestmanagementsystem;
        this.packhousequalitymanagementsystem = packhousequalitymanagementsystem;
        this.traceabilitysystem = traceabilitysystem;
        this.recommendation = recommendation;
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

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public int getFarm_inspection_id() {
        return farm_inspection_id;
    }

    public void setFarm_inspection_id(int farm_inspection_id) {
        this.farm_inspection_id = farm_inspection_id;
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

    public String getsinspector() {
        return sinspector;
    }

    public void setsinspector(String sinspector) {
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

    public String getSinspector() {
        return sinspector;
    }

    public void setSinspector(String sinspector) {
        this.sinspector = sinspector;
    }

    public String getFrequencyOfscouting2() {
        return frequencyOfscouting2;
    }

    public void setFrequencyOfscouting2(String frequencyOfscouting2) {
        this.frequencyOfscouting2 = frequencyOfscouting2;
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
