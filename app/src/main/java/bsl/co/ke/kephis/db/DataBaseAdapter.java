package bsl.co.ke.kephis.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import bsl.co.ke.kephis.Data.model.ConsignmentIspection;
import bsl.co.ke.kephis.Data.model.FarmInspection;
import bsl.co.ke.kephis.Data.model.ProducerInspection;
import bsl.co.ke.kephis.Pojo.ADUser;
import bsl.co.ke.kephis.Pojo.CBPartner;
import bsl.co.ke.kephis.Pojo.ConsignmentIspectionDetails;
import bsl.co.ke.kephis.Pojo.Country;
import bsl.co.ke.kephis.Pojo.County;
import bsl.co.ke.kephis.Pojo.FacilityInspectionDetails;
import bsl.co.ke.kephis.Pojo.FarmInspectionDetails;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.Pojo.SubCounty;
import bsl.co.ke.kephis.Pojo.User;

public class DataBaseAdapter {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    //the user table
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    // Variable to hold the database instance
    public static SQLiteDatabase db;
    // Database open/upgrade helper
    private static DatabaseHelper dbHelper;
    String ok = "OK";
    // Context of the application using the database.
    private Context context = null;

    public DataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //local brand Stocked

    // Method to openthe Database
    public DataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;

    }

    // Method to close the Database
    public void close() {

        db.close();
    }

    // method returns an Instance of the Database
    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }


    // Database Name
    private static final String DATABASE_NAME = "kephis.db";

    // User table name
    private static final String TABLE_USER = "user";
    public static final String TABLE_login = "login";
    public static final String TABLE_AD_USER = "ad_user";
    public static final String TABLE_FARM_INSPECTION = "Farm_Inspection";

    // User Table Columns names
    private static final String KEY_ID = "Record_id";
    private static final String KEY_SERVER_ID = "serverId";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_AD_USER_ID = "ad_user_id";
    private static final String KEY_STATUS = "status";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_C_BPARTNER_ID = "c_bpartner_id";
    private static final String KEY_C_ACTIVITY_ID = "c_activity_id";


    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_FARM_INSPECTION_ID = "farm_inspection_id";

    public static final String TABLE_C_BPARTNER = "c_bpartner";


    private static final String KEY_DOCUMMENT_NUMBER = "document_number";
    private static final String KEY_DOCUMMENT_DATE = "document_date";
    private static final String KEY_LICENCE_NUMBER = "licence_number";
    private static final String KEY_APPLICANT_NAME = "applicant_name";
    private static final String KEY_LOCALID = "local_id";
    private static final String KEY_SINSPECTOR = "inspector";
    private static final String KEY_INSPECTION_DONE = "inspection_done";
    private static final String KEY_FARMNAME = "farmname";
    private static final String KEY_TRACEABILITYCODE = "traceability_code";
    private static final String KEY_SELECTED = "selected";
    private static final String KEY_COUNTY = "county";
    private static final String KEY_SUBCOUNTY = "subcounty";
    private static final String KEY_WARD = "ward";
    private static final String KEY_STREETNAME = "streetname";
    private static final String KEY_CONTACTPERSON = "contactperson";
    private static final String KEY_TOWN = "town";
    private static final String KEY_AREAUNDERPRODUCTION = "areaunderproduction";
    private static final String KEY_MARKETDESTINATION = "mkt_destination";
    private static final String KEY_ISAWAREOFMKTREQUIREMENTS = "isaware";
    private static final String KEY_ACREAGE = "acreage";
    private static final String KEY_SOURCESOFPLANTINGMATERIIAL = "sources_of_plntng_mtrials";
    private static final String KEY_PRESENCEOFQUALITYASSURANCE = "presence_of_q_assu";
    private static final String KEY_DOCUMENTEDPESTMANAGEMENT = "documented_pest";
    private static final String KEY_NO_OF_SCOUTS = "no_of_scouts";
    private static final String KEY_TRAINING_EXPERIENCE_OF_SCOUTS = "training_experience_scouts";
    private static final String KEY_AREAALLOCATEDTOEACHSCOUT = "area_allocated";
    private static final String KEY_PESTMONITORINGMETHODSUSED = "pest_monitoring";
    private static final String KEY_SCOUTINGMETHODSUSED = "scouting_methods";
    private static final String KEY_FREQUENCYOFSCOUTING = "frequency_of_scouting";
    private static final String KEY_SCOUTINGRECORDSAVAILABLE = "scoutingrecordsavailable";
    private static final String KEY_PESTREPORTINGCHANNELS = "pestreportingchannels";
    private static final String KEY_PESTCONTROLMETHODSUSED = "pestcontrolmethodsused";
    private static final String KEY_SPRAYPROGRAMSINPLACE = "sprayprogramsinplace";
    private static final String KEY_QUALITYMANAGEMENTPROCEDURESINPLACE = "qualitymanagementproceduresinplace";
    private static final String KEY_QUALITYCONTROLCHECKSINPLACE = "qualitycontrolchecksinplace";
    private static final String KEY_AWARENESSONPESTSOFCONCERN = "awarenessonpestsofconcern";
    private static final String KEY_ABILITYOFQUALITYCONTRO = "abilityofqualitycontro";
    private static final String KEY_DETECTEDPESTRECORDSINPLACE = "detectedpestrecordsinplace";
    private static final String KEY_TRAININGANDEXPERIENCE = "trainingandexperience";
    private static final String KEY_ABILITYTOIDENTIFYPEST = "abilitytoidentifypest";
    private static final String KEY_AREASCOUTEDPERDAY = "areascoutedperday";
    private static final String KEY_FREQUENCYOFSCOUTING2 = "frequencyofscouting2";
    private static final String KEY_SCOUTINGHASSCOUTINGSHEETSBOOK = "scoutinghasscoutingsheetsbook";
    private static final String KEY_SCOUTINGTOOLSUSED = "scoutingtoolsused";
    private static final String KEY_PESTSCONCERNCAPTUREDRECORDS = "pestsconcerncapturedrecords";
    private static final String KEY_SCOUTINGREPORTINGCHANNELS = "scoutingreportingchannels";
    private static final String KEY_ANYPESTSORPESTSIGNSDETECTED = "anypestsorpestsignsdetected";
    private static final String KEY_PESTTRAPSINPLACE = "pesttrapsinplace";
    private static final String KEY_ANYPESTSOFCONCERNTRAPPED = "anypestsofconcerntrapped";
    private static final String KEY_GREENHOUSEFARMSANITARYSTATUS = "greenhousefarmsanitarystatus";
    private static final String KEY_AWARENESSPESTSOFCONCERN = "awarenesspestsofconcern";
    private static final String KEY_TRAININGONPESTSOFCONCERN = "trainingonpestsofconcern";
    private static final String KEY_ABILITYTODETECTPESTSANDPESTSIGNS = "abilitytodetectpestsandpestsigns";
    private static final String KEY_ROLEINPESTREPORTINGSYSTEM = "roleinpestreportingsystem";
    private static final String KEY_PACKHOUSESANITATIONSTATUS = "packhousesanitationstatus";
    private static final String KEY_QUALITYMANAGEMENTPROCEDURESINPLACE2 = "qualitymanagementproceduresinplace2";
    private static final String KEY_HOWMANYQUALITYCONTROLPOINTS = "howmanyqualitycontrolpoints";
    private static final String KEY_QUALITYCONTROLPERSONNELONAWARENESS = "qualitycontrolpersonnelonawareness";
    private static final String KEY_ABILITYTODETECTPESTSANDPESTSIGNS2 = "abilitytodetectpestsandpestsigns2";
    private static final String KEY_REPORTINGCHANNELFORPESTDETECTION = "reportingchannelforpestdetection";
    private static final String KEY_GRADERSAWAREOFPESTSANDPESTSIGNS = "gradersawareofpestsandpestsigns";
    private static final String KEY_APPROPRIATEHYGIENEPROTOCOLSINPLACE = "appropriatehygieneprotocolsinplace";
    private static final String KEY_QUALITYASSURANCEPERSONNELPOSTHARVEST = "qualityassurancepersonnelpostharvest";
    private static final String KEY_QUALITYASSURANCEPERSONNELMARKETREQUIREMENT = "qualityassurancepersonnelmarketrequirement";
    private static final String KEY_TRACEABILITYSYSTEMUSED = "traceabilitysystemused";
    private static final String KEY_TRACEABILITYSYSTEMUSEDTOWHATLEVEL = "traceabilitysystemusedtowhatlevel";
    private static final String KEY_TRANSPORTOFPRODUCEFROMFARM = "transportofproducefromfarm";
    private static final String KEY_FARMMANAGEMENTINVOLVEMENTPESTCONTROL = "farmmanagementinvolvementpestcontrol";
    private static final String KEY_PESTMANAGEMENTSYSTEM = "key_pestmanagementsystem";
    private static final String KEY_PACKHOUSEQUALITYMANAGEMENTSYSTEM = "key_packhousequalitymanagementsystem";
    private static final String KEY_TRACEABILITYSYSTEM = "key_traceabilitysystem";
    private static final String KEY_RECOMMENDATION = "key_recommendation";
    private static final String KEY_UPLOADED = "uploaded";


    public static final String CREATE_TABLE_USER = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_login + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT," + KEY_PASSWORD + " TEXT,"
            + KEY_CREATED_AT
            + " DATETIME" + ")";

    public static final String CREATE_TABLE_ADUSER = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_AD_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT,"
            + KEY_EMAIL + " TEXT,"
            + KEY_AD_USER_ID + " TEXT,"
            + KEY_C_BPARTNER_ID + " TEXT,"
            + KEY_C_ACTIVITY_ID + " TEXT,"
            + KEY_CREATED_AT
            + " DATETIME" + ")";

    public static final String CREATE_TABLE_FARM_INSPECTION = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_FARM_INSPECTION + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_FARM_INSPECTION_ID + " TEXT UNIQUE,"
            + KEY_DOCUMMENT_NUMBER + " TEXT,"
            + KEY_DOCUMMENT_DATE + " TEXT,"
            + KEY_LICENCE_NUMBER + " TEXT,"
            + KEY_APPLICANT_NAME + " TEXT,"
            + KEY_LOCALID + " TEXT,"
            + KEY_SINSPECTOR + " TEXT,"
            + KEY_INSPECTION_DONE + " TEXT,"
            + KEY_SELECTED + " TEXT,"
            + KEY_FARMNAME + " TEXT,"
            + KEY_TRACEABILITYCODE + " TEXT,"
            + KEY_COUNTY + " TEXT,"
            + KEY_SUBCOUNTY + " TEXT,"
            + KEY_WARD + " TEXT,"
            + KEY_STREETNAME + " TEXT,"
            + KEY_CONTACTPERSON + " TEXT,"
            + KEY_TOWN + " TEXT,"
            + KEY_AREAUNDERPRODUCTION + " TEXT,"
            + KEY_MARKETDESTINATION + " TEXT,"
            + KEY_ISAWAREOFMKTREQUIREMENTS + " TEXT,"
            + KEY_ACREAGE + " TEXT,"
            + KEY_SOURCESOFPLANTINGMATERIIAL + " TEXT,"
            + KEY_PRESENCEOFQUALITYASSURANCE + " TEXT,"
            + KEY_DOCUMENTEDPESTMANAGEMENT + " TEXT,"
            + KEY_NO_OF_SCOUTS + " TEXT,"
            + KEY_TRAINING_EXPERIENCE_OF_SCOUTS + " TEXT,"
            + KEY_AREAALLOCATEDTOEACHSCOUT + " TEXT,"
            + KEY_PESTMONITORINGMETHODSUSED + " TEXT,"
            + KEY_SCOUTINGMETHODSUSED + " TEXT,"
            + KEY_FREQUENCYOFSCOUTING + " TEXT,"
            + KEY_SCOUTINGRECORDSAVAILABLE + " TEXT,"
            + KEY_PESTREPORTINGCHANNELS + " TEXT,"
            + KEY_PESTCONTROLMETHODSUSED + " TEXT,"
            + KEY_SPRAYPROGRAMSINPLACE + " TEXT,"
            + KEY_QUALITYMANAGEMENTPROCEDURESINPLACE + " TEXT,"
            + KEY_QUALITYCONTROLCHECKSINPLACE + " TEXT,"
            + KEY_AWARENESSONPESTSOFCONCERN + " TEXT,"
            + KEY_ABILITYOFQUALITYCONTRO + " TEXT,"
            + KEY_DETECTEDPESTRECORDSINPLACE + " TEXT,"
            + KEY_TRAININGANDEXPERIENCE + " TEXT,"
            + KEY_ABILITYTOIDENTIFYPEST + " TEXT,"
            + KEY_AREASCOUTEDPERDAY + " TEXT,"
            + KEY_FREQUENCYOFSCOUTING2 + " TEXT,"
            + KEY_SCOUTINGHASSCOUTINGSHEETSBOOK + " TEXT,"
            + KEY_SCOUTINGTOOLSUSED + " TEXT,"
            + KEY_PESTSCONCERNCAPTUREDRECORDS + " TEXT,"
            + KEY_SCOUTINGREPORTINGCHANNELS + " TEXT,"
            + KEY_ANYPESTSORPESTSIGNSDETECTED + " TEXT,"
            + KEY_PESTTRAPSINPLACE + " TEXT,"
            + KEY_ANYPESTSOFCONCERNTRAPPED + " TEXT,"
            + KEY_GREENHOUSEFARMSANITARYSTATUS + " TEXT,"
            + KEY_AWARENESSPESTSOFCONCERN + " TEXT,"
            + KEY_TRAININGONPESTSOFCONCERN + " TEXT,"
            + KEY_ABILITYTODETECTPESTSANDPESTSIGNS + " TEXT,"
            + KEY_ROLEINPESTREPORTINGSYSTEM + " TEXT,"
            + KEY_PACKHOUSESANITATIONSTATUS + " TEXT,"
            + KEY_QUALITYMANAGEMENTPROCEDURESINPLACE2 + " TEXT,"
            + KEY_HOWMANYQUALITYCONTROLPOINTS + " TEXT,"
            + KEY_QUALITYCONTROLPERSONNELONAWARENESS + " TEXT,"
            + KEY_ABILITYTODETECTPESTSANDPESTSIGNS2 + " TEXT,"
            + KEY_REPORTINGCHANNELFORPESTDETECTION + " TEXT,"
            + KEY_GRADERSAWAREOFPESTSANDPESTSIGNS + " TEXT,"
            + KEY_APPROPRIATEHYGIENEPROTOCOLSINPLACE + " TEXT,"
            + KEY_QUALITYASSURANCEPERSONNELPOSTHARVEST + " TEXT,"
            + KEY_QUALITYASSURANCEPERSONNELMARKETREQUIREMENT + " TEXT,"
            + KEY_TRACEABILITYSYSTEMUSED + " TEXT,"
            + KEY_TRACEABILITYSYSTEMUSEDTOWHATLEVEL + " TEXT,"
            + KEY_TRANSPORTOFPRODUCEFROMFARM + " TEXT,"
            + KEY_FARMMANAGEMENTINVOLVEMENTPESTCONTROL + " TEXT,"
            + KEY_PESTMANAGEMENTSYSTEM + " TEXT,"
            + KEY_PACKHOUSEQUALITYMANAGEMENTSYSTEM + " TEXT,"
            + KEY_TRACEABILITYSYSTEM + " TEXT,"
            + KEY_RECOMMENDATION + " TEXT,"
            + KEY_LATITUDE + " TEXT,"
            + KEY_LONGITUDE + " TEXT,"
            + KEY_SERVER_ID + " TEXT ,"
            + KEY_CREATED_AT + " DATETIME,"
            + KEY_UPLOADED + " TEXT" + ")";

    //C_BPartner Details
    public static final String CREATE_TABLE_C_BPARTNER = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_C_BPARTNER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT UNIQUE," + KEY_CREATED_AT
            + " DATETIME," + KEY_SERVER_ID + " TEXT UNIQUE" + ")";
    /*////////////////////////////////////////////////////////////////////////////////////////////////*/
    /*INSERTING DATA AND UPDATING*/

    public long insertFarmInspection(FarmInspectionDetails farmInspectionDetails) {

        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, farmInspectionDetails.getLocalID());
        values.put(KEY_FARM_INSPECTION_ID, farmInspectionDetails.getFARM_Inspection_ID());
        values.put(KEY_DOCUMMENT_NUMBER, farmInspectionDetails.getDocumentNumber());
        values.put(KEY_DOCUMMENT_DATE, farmInspectionDetails.getDocumentDate());
        values.put(KEY_APPLICANT_NAME, farmInspectionDetails.getNameOfApplicant());
        values.put(KEY_LICENCE_NUMBER, farmInspectionDetails.getLicenceNumber());
        values.put(KEY_FARMNAME, farmInspectionDetails.getFarmName());
        values.put(KEY_TRACEABILITYCODE, farmInspectionDetails.getTraceability_code());
        values.put(KEY_COUNTY, farmInspectionDetails.getCounty());
        values.put(KEY_SUBCOUNTY, farmInspectionDetails.getSubCounty());
        values.put(KEY_WARD, farmInspectionDetails.getWard());
        values.put(KEY_STREETNAME, farmInspectionDetails.getStreetName());
        values.put(KEY_CONTACTPERSON, farmInspectionDetails.getContactPerson());
        values.put(KEY_TOWN, farmInspectionDetails.getTown());
        values.put(KEY_AREAUNDERPRODUCTION, farmInspectionDetails.getAreaUnderProduction());
        values.put(KEY_MARKETDESTINATION, farmInspectionDetails.getMarketDestination());
        values.put(KEY_ISAWAREOFMKTREQUIREMENTS, farmInspectionDetails.getIsAwareOfmktRequirements());
        values.put(KEY_INSPECTION_DONE, "N");
        values.put(KEY_SELECTED, "N");
        values.put(KEY_UPLOADED, "PENDING");

        long farmInspectionDetailsID = db.insertWithOnConflict(TABLE_FARM_INSPECTION, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        System.out.println("farmInspectionDetails: " + farmInspectionDetailsID);

        closeDB();
        return farmInspectionDetailsID;
        // insert row

    }

    public long updateFarmInspection(String localID,
                                     String acreage,
                                     String sourcesOfPlantingmateriial,
                                     String presenceOfQualityAssurance,
                                     String documentedPestManagement,
                                     String noOfScouts,
                                     String trainingExperienceOfscouts,
                                     String areaAllocatedToEachScout,
                                     String pestMonitoringMethodsUsed,
                                     String scoutingmethodsused,
                                     String frequencyOfScouting,
                                     String scoutingrecordsavailable,
                                     String pestreportingchannels,
                                     String pestcontrolmethodsused,
                                     String sprayprogramsinplace,
                                     String qualitymanagementproceduresinplace,
                                     String qualitycontrolchecksinplace,
                                     String awarenessonpestsofconcern,
                                     String abilityOfQualityContro,
                                     String detectedpestrecordsinplace,
                                     String trainingandexperience,
                                     String abilityToIdentifyPest,
                                     String areascoutedperday,
                                     String frequencyOfscouting2,
                                     String scoutinghasscoutingsheetsbook,
                                     String scoutingtoolsused,
                                     String pestsconcerncapturedrecords,
                                     String scoutingreportingchannels,
                                     String anypestsorpestsignsdetected,
                                     String pesttrapsinplace,
                                     String anypestsofconcerntrapped,
                                     String greenhousefarmsanitarystatus,
                                     String awarenesspestsofconcern,
                                     String trainingonpestsofconcern,
                                     String abilitytodetectpestsandpestsigns,
                                     String roleinpestreportingsystem,
                                     String packhousesanitationstatus,
                                     String qualitymanagementproceduresinplace2,
                                     String howmanyqualitycontrolpoints,
                                     String qualitycontrolpersonnelonawareness,
                                     String abilitytodetectpestsandpestsigns2,
                                     String reportingchannelforpestdetection,
                                     String gradersawareofpestsandpestsigns,
                                     String appropriatehygieneprotocolsinplace,
                                     String qualityassurancepersonnelPostHarvest,
                                     String qualityassurancepersonnelmarketrequirement,
                                     String traceabilitysystemused,
                                     String traceabilitysystemusedtowhatlevel,
                                     String transportofproducefromfarm,
                                     String farmmanagementinvolvementpestcontrol,
                                     String pestmanagementsystem,
                                     String packhousequalitymanagementsystem,
                                     String traceabilitysystem,
                                     String recommendation,
                                     String latitude, String longitude) {
        db = dbHelper.getWritableDatabase();

        FarmInspection farmInspection = null;

        ContentValues values = new ContentValues();

        int result = 0;
        try {
            values.put(KEY_INSPECTION_DONE, "Y");
            values.put(KEY_SELECTED, "N");
           //+-- values.put(KEY_SINSPECTOR, String.valueOf(sinspector));

            values.put(KEY_ACREAGE, String.valueOf(acreage));
            values.put(KEY_SOURCESOFPLANTINGMATERIIAL, String.valueOf(sourcesOfPlantingmateriial));
            values.put(KEY_PRESENCEOFQUALITYASSURANCE, String.valueOf(presenceOfQualityAssurance));
            values.put(KEY_DOCUMENTEDPESTMANAGEMENT, String.valueOf(documentedPestManagement));
            values.put(KEY_NO_OF_SCOUTS, String.valueOf(noOfScouts));
            values.put(KEY_TRAINING_EXPERIENCE_OF_SCOUTS, String.valueOf(trainingExperienceOfscouts));
            values.put(KEY_AREAALLOCATEDTOEACHSCOUT, String.valueOf(areaAllocatedToEachScout));
            values.put(KEY_PESTMONITORINGMETHODSUSED, String.valueOf(pestMonitoringMethodsUsed));
            values.put(KEY_SCOUTINGMETHODSUSED, String.valueOf(scoutingmethodsused));
            values.put(KEY_FREQUENCYOFSCOUTING, String.valueOf(frequencyOfScouting));
            values.put(KEY_SCOUTINGRECORDSAVAILABLE, String.valueOf(scoutingrecordsavailable));
            values.put(KEY_PESTREPORTINGCHANNELS, String.valueOf(pestreportingchannels));
            values.put(KEY_PESTCONTROLMETHODSUSED, String.valueOf(pestcontrolmethodsused));
            values.put(KEY_SPRAYPROGRAMSINPLACE, String.valueOf(sprayprogramsinplace));
            values.put(KEY_QUALITYMANAGEMENTPROCEDURESINPLACE, String.valueOf(qualitymanagementproceduresinplace));
            values.put(KEY_QUALITYCONTROLCHECKSINPLACE, String.valueOf(qualitycontrolchecksinplace));
            values.put(KEY_AWARENESSONPESTSOFCONCERN, String.valueOf(awarenessonpestsofconcern));
            values.put(KEY_ABILITYOFQUALITYCONTRO, String.valueOf(abilityOfQualityContro));
            values.put(KEY_DETECTEDPESTRECORDSINPLACE, String.valueOf(detectedpestrecordsinplace));
            values.put(KEY_TRAININGANDEXPERIENCE, String.valueOf(trainingandexperience));
            values.put(KEY_ABILITYTOIDENTIFYPEST, String.valueOf(abilityToIdentifyPest));
            values.put(KEY_AREASCOUTEDPERDAY, String.valueOf(areascoutedperday));
            values.put(KEY_FREQUENCYOFSCOUTING2, String.valueOf(frequencyOfscouting2));
            values.put(KEY_SCOUTINGHASSCOUTINGSHEETSBOOK, String.valueOf(scoutinghasscoutingsheetsbook));
            values.put(KEY_SCOUTINGTOOLSUSED, String.valueOf(scoutingtoolsused));
            values.put(KEY_PESTSCONCERNCAPTUREDRECORDS, String.valueOf(pestsconcerncapturedrecords));
            values.put(KEY_SCOUTINGREPORTINGCHANNELS, String.valueOf(scoutingreportingchannels));
            values.put(KEY_ANYPESTSORPESTSIGNSDETECTED, String.valueOf(anypestsorpestsignsdetected));
            values.put(KEY_PESTTRAPSINPLACE, String.valueOf(pesttrapsinplace));
            values.put(KEY_ANYPESTSOFCONCERNTRAPPED, String.valueOf(anypestsofconcerntrapped));
            values.put(KEY_GREENHOUSEFARMSANITARYSTATUS, String.valueOf(greenhousefarmsanitarystatus));
            values.put(KEY_AWARENESSPESTSOFCONCERN, String.valueOf(awarenesspestsofconcern));
            values.put(KEY_TRAININGONPESTSOFCONCERN, String.valueOf(trainingonpestsofconcern));
            values.put(KEY_ABILITYTODETECTPESTSANDPESTSIGNS, String.valueOf(abilitytodetectpestsandpestsigns));
            values.put(KEY_ROLEINPESTREPORTINGSYSTEM, String.valueOf(roleinpestreportingsystem));
            values.put(KEY_PACKHOUSESANITATIONSTATUS, String.valueOf(packhousesanitationstatus));
            values.put(KEY_QUALITYMANAGEMENTPROCEDURESINPLACE2, String.valueOf(qualitymanagementproceduresinplace2));
            values.put(KEY_HOWMANYQUALITYCONTROLPOINTS, String.valueOf(howmanyqualitycontrolpoints));
            values.put(KEY_QUALITYCONTROLPERSONNELONAWARENESS, String.valueOf(qualitycontrolpersonnelonawareness));
            values.put(KEY_ABILITYTODETECTPESTSANDPESTSIGNS2, String.valueOf(abilitytodetectpestsandpestsigns2));
            values.put(KEY_REPORTINGCHANNELFORPESTDETECTION, String.valueOf(reportingchannelforpestdetection));
            values.put(KEY_GRADERSAWAREOFPESTSANDPESTSIGNS, String.valueOf(gradersawareofpestsandpestsigns));
            values.put(KEY_APPROPRIATEHYGIENEPROTOCOLSINPLACE, String.valueOf(appropriatehygieneprotocolsinplace));
            values.put(KEY_QUALITYASSURANCEPERSONNELPOSTHARVEST, String.valueOf(qualityassurancepersonnelPostHarvest));
            values.put(KEY_QUALITYASSURANCEPERSONNELMARKETREQUIREMENT, String.valueOf(qualityassurancepersonnelmarketrequirement));
            values.put(KEY_TRACEABILITYSYSTEMUSED, String.valueOf(traceabilitysystemused));
            values.put(KEY_TRACEABILITYSYSTEMUSEDTOWHATLEVEL, String.valueOf(traceabilitysystemusedtowhatlevel));
            values.put(KEY_TRANSPORTOFPRODUCEFROMFARM, String.valueOf(transportofproducefromfarm));
            values.put(KEY_FARMMANAGEMENTINVOLVEMENTPESTCONTROL, String.valueOf(farmmanagementinvolvementpestcontrol));
            values.put(KEY_PESTMANAGEMENTSYSTEM, String.valueOf(pestmanagementsystem));
            values.put(KEY_PACKHOUSEQUALITYMANAGEMENTSYSTEM, String.valueOf(packhousequalitymanagementsystem));
            values.put(KEY_TRACEABILITYSYSTEM, String.valueOf(traceabilitysystem));
            values.put(KEY_RECOMMENDATION, String.valueOf(recommendation));
            values.put(KEY_LATITUDE, String.valueOf(latitude));
            values.put(KEY_LONGITUDE, String.valueOf(longitude));
            // updating row
            //
            result = db.update(TABLE_FARM_INSPECTION, values, KEY_ID + " = " + localID, null);


            System.out.println("results is " + result);
        } finally {
            if (result == 0) {
                // db.setTransactionSuccessful();
            }
//        db.endTransaction();
            db.close();
        }
        return result;
    }

    public boolean updatefarmInspectionSent(String localID, String serverRecordID) {
        db = dbHelper.getWritableDatabase();

        // db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(KEY_UPLOADED, "SENT");

            int result = db.update(TABLE_FARM_INSPECTION, values, KEY_ID + " =" + localID, null);

            System.out.println("Total records to be sent " + result);
            if (result == 1) {
                return true;
            } else {
                return false;
            }
        } finally {
            closeDB();
            //db.endTransaction();
            //  db.close();
        }
    }

    public List<FarmInspectionDetails> getFarmInspectionDetailsList() {

        List<FarmInspectionDetails> farmInspectionDetailslist = new ArrayList<FarmInspectionDetails>();
        FarmInspectionDetails td = new FarmInspectionDetails();
        // td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_FARM_INSPECTION + " where " + KEY_INSPECTION_DONE + " =" + "'N'";

        //System.out.println(selectQuery.toString());
        System.out.println("Picking farmInspectionDetailslist data from the db");

        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new FarmInspectionDetails();

                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setFARM_Inspection_ID(c.getString((c.getColumnIndex(KEY_FARM_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setFarmName(c.getString((c.getColumnIndex(KEY_FARMNAME))));
                    td.setTraceability_code(c.getString((c.getColumnIndex(KEY_TRACEABILITYCODE))));
                    td.setCounty(c.getString((c.getColumnIndex(KEY_COUNTY))));
                    td.setSubCounty(c.getString((c.getColumnIndex(KEY_SUBCOUNTY))));
                    td.setWard(c.getString((c.getColumnIndex(KEY_WARD))));
                    td.setStreetName(c.getString((c.getColumnIndex(KEY_STREETNAME))));
                    td.setContactPerson(c.getString((c.getColumnIndex(KEY_CONTACTPERSON))));
                    td.setTown(c.getString((c.getColumnIndex(KEY_TOWN))));
                    td.setAreaUnderProduction(c.getString((c.getColumnIndex(KEY_AREAUNDERPRODUCTION))));
                    td.setMarketDestination(c.getString((c.getColumnIndex(KEY_MARKETDESTINATION))));
                    td.setIsAwareOfmktRequirements(c.getString((c.getColumnIndex(KEY_ISAWAREOFMKTREQUIREMENTS))));

                    // adding to itinerary list
                    farmInspectionDetailslist.add(td);
                } while (c.moveToNext());
            }
        } finally {
            //   closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("picking data from the db" + farmInspectionDetailslist.size());
        return farmInspectionDetailslist;
    }

    public List<FarmInspectionDetails> getFarmInspectionDetailsDone() {

        List<FarmInspectionDetails> FarmInspectionDetailsList = new ArrayList<FarmInspectionDetails>();
        FarmInspectionDetails td = new FarmInspectionDetails();
        // td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_FARM_INSPECTION + " where " + KEY_INSPECTION_DONE + " =" + "'Y'"
                + " AND " + KEY_UPLOADED + " = 'PENDING'";

        db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new FarmInspectionDetails();
                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setFARM_Inspection_ID(c.getString((c.getColumnIndex(KEY_FARM_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setFarmName(c.getString((c.getColumnIndex(KEY_FARMNAME))));
                    td.setTraceability_code(c.getString((c.getColumnIndex(KEY_TRACEABILITYCODE))));
                    td.setCounty(c.getString((c.getColumnIndex(KEY_COUNTY))));
                    td.setSubCounty(c.getString((c.getColumnIndex(KEY_SUBCOUNTY))));
                    td.setWard(c.getString((c.getColumnIndex(KEY_WARD))));
                    td.setStreetName(c.getString((c.getColumnIndex(KEY_STREETNAME))));
                    td.setContactPerson(c.getString((c.getColumnIndex(KEY_CONTACTPERSON))));
                    td.setTown(c.getString((c.getColumnIndex(KEY_TOWN))));
                    td.setAreaUnderProduction(c.getString((c.getColumnIndex(KEY_AREAUNDERPRODUCTION))));
                    td.setMarketDestination(c.getString((c.getColumnIndex(KEY_MARKETDESTINATION))));
                    td.setIsAwareOfmktRequirements(c.getString((c.getColumnIndex(KEY_ISAWAREOFMKTREQUIREMENTS))));
                    td.setAcreage(c.getString((c.getColumnIndex(KEY_ACREAGE))));
                    td.setSourcesOfPlantingmateriial(c.getString((c.getColumnIndex(KEY_SOURCESOFPLANTINGMATERIIAL))));
                    td.setPresenceOfQualityAssurance(c.getString((c.getColumnIndex(KEY_PRESENCEOFQUALITYASSURANCE))));
                    td.setDocumentedPestManagement(c.getString((c.getColumnIndex(KEY_DOCUMENTEDPESTMANAGEMENT))));
                    td.setNoOfScouts(c.getString((c.getColumnIndex(KEY_NO_OF_SCOUTS))));
                    td.setTrainingExperienceOfscouts(c.getString((c.getColumnIndex(KEY_TRAINING_EXPERIENCE_OF_SCOUTS))));
                    td.setAreaAllocatedToEachScout(c.getString((c.getColumnIndex(KEY_AREAALLOCATEDTOEACHSCOUT))));
                    td.setPestMonitoringMethodsUsed(c.getString((c.getColumnIndex(KEY_PESTMONITORINGMETHODSUSED))));
                    td.setScoutingmethodsused(c.getString((c.getColumnIndex(KEY_SCOUTINGMETHODSUSED))));
                    td.setFrequencyOfScouting(c.getString((c.getColumnIndex(KEY_FREQUENCYOFSCOUTING))));
                    td.setScoutingrecordsavailable(c.getString((c.getColumnIndex(KEY_SCOUTINGRECORDSAVAILABLE))));
                    td.setPestreportingchannels(c.getString((c.getColumnIndex(KEY_PESTREPORTINGCHANNELS))));
                    td.setPestcontrolmethodsused(c.getString((c.getColumnIndex(KEY_PESTCONTROLMETHODSUSED))));
                    td.setSprayprogramsinplace(c.getString((c.getColumnIndex(KEY_SPRAYPROGRAMSINPLACE))));
                    td.setQualitymanagementproceduresinplace(c.getString((c.getColumnIndex(KEY_QUALITYMANAGEMENTPROCEDURESINPLACE))));
                    td.setQualitycontrolchecksinplace(c.getString((c.getColumnIndex(KEY_QUALITYCONTROLCHECKSINPLACE))));
                    td.setAwarenessonpestsofconcern(c.getString((c.getColumnIndex(KEY_AWARENESSONPESTSOFCONCERN))));
                    td.setAbilityOfQualityContro(c.getString((c.getColumnIndex(KEY_ABILITYOFQUALITYCONTRO))));
                    td.setDetectedpestrecordsinplace(c.getString((c.getColumnIndex(KEY_DETECTEDPESTRECORDSINPLACE))));
                    td.setTrainingandexperience(c.getString((c.getColumnIndex(KEY_TRAININGANDEXPERIENCE))));
                    td.setAbilityToIdentifyPest(c.getString((c.getColumnIndex(KEY_ABILITYTOIDENTIFYPEST))));
                    td.setAreascoutedperday(c.getString((c.getColumnIndex(KEY_AREASCOUTEDPERDAY))));
                    td.setFrequencyOfscouting(c.getString((c.getColumnIndex(KEY_FREQUENCYOFSCOUTING2))));
                    td.setScoutinghasscoutingsheetsbook(c.getString((c.getColumnIndex(KEY_SCOUTINGHASSCOUTINGSHEETSBOOK))));
                    td.setScoutingtoolsused(c.getString((c.getColumnIndex(KEY_SCOUTINGTOOLSUSED))));
                    td.setPestsconcerncapturedrecords(c.getString((c.getColumnIndex(KEY_PESTSCONCERNCAPTUREDRECORDS))));
                    td.setScoutingreportingchannels(c.getString((c.getColumnIndex(KEY_SCOUTINGREPORTINGCHANNELS))));
                    td.setAnypestsorpestsignsdetected(c.getString((c.getColumnIndex(KEY_ANYPESTSORPESTSIGNSDETECTED))));
                    td.setPesttrapsinplace(c.getString((c.getColumnIndex(KEY_PESTTRAPSINPLACE))));
                    td.setAnypestsofconcerntrapped(c.getString((c.getColumnIndex(KEY_ANYPESTSOFCONCERNTRAPPED))));
                    td.setGreenhousefarmsanitarystatus(c.getString((c.getColumnIndex(KEY_GREENHOUSEFARMSANITARYSTATUS))));
                    td.setAwarenesspestsofconcern(c.getString((c.getColumnIndex(KEY_AWARENESSPESTSOFCONCERN))));
                    td.setTrainingonpestsofconcern(c.getString((c.getColumnIndex(KEY_TRAININGONPESTSOFCONCERN))));
                    td.setAbilitytodetectpestsandpestsigns(c.getString((c.getColumnIndex(KEY_ABILITYTODETECTPESTSANDPESTSIGNS))));
                    td.setRoleinpestreportingsystem(c.getString((c.getColumnIndex(KEY_ROLEINPESTREPORTINGSYSTEM))));
                    td.setPackhousesanitationstatus(c.getString((c.getColumnIndex(KEY_PACKHOUSESANITATIONSTATUS))));
                    td.setQualitymanagementproceduresinplace2(c.getString((c.getColumnIndex(KEY_QUALITYMANAGEMENTPROCEDURESINPLACE2))));
                    td.setHowmanyqualitycontrolpoints(c.getString((c.getColumnIndex(KEY_HOWMANYQUALITYCONTROLPOINTS))));
                    td.setQualitycontrolpersonnelonawareness(c.getString((c.getColumnIndex(KEY_QUALITYCONTROLPERSONNELONAWARENESS))));
                    td.setAbilitytodetectpestsandpestsigns2(c.getString((c.getColumnIndex(KEY_ABILITYTODETECTPESTSANDPESTSIGNS2))));
                    td.setReportingchannelforpestdetection(c.getString((c.getColumnIndex(KEY_REPORTINGCHANNELFORPESTDETECTION))));
                    td.setGradersawareofpestsandpestsigns(c.getString((c.getColumnIndex(KEY_GRADERSAWAREOFPESTSANDPESTSIGNS))));
                    td.setAppropriatehygieneprotocolsinplace(c.getString((c.getColumnIndex(KEY_APPROPRIATEHYGIENEPROTOCOLSINPLACE))));
                    td.setQualityassurancepersonnelPostHarvest(c.getString((c.getColumnIndex(KEY_QUALITYASSURANCEPERSONNELPOSTHARVEST))));
                    td.setQualityassurancepersonnelmarketrequirement(c.getString((c.getColumnIndex(KEY_QUALITYASSURANCEPERSONNELMARKETREQUIREMENT))));
                    td.setTraceabilitysystemused(c.getString((c.getColumnIndex(KEY_TRACEABILITYSYSTEMUSED))));
                    td.setTraceabilitysystemusedtowhatlevel(c.getString((c.getColumnIndex(KEY_TRACEABILITYSYSTEMUSEDTOWHATLEVEL))));
                    td.setTransportofproducefromfarm(c.getString((c.getColumnIndex(KEY_TRANSPORTOFPRODUCEFROMFARM))));
                    td.setFarmmanagementinvolvementpestcontrol(c.getString((c.getColumnIndex(KEY_FARMMANAGEMENTINVOLVEMENTPESTCONTROL))));
                    td.setPestmanagementsystem(c.getString((c.getColumnIndex(KEY_PESTMANAGEMENTSYSTEM))));
                    td.setPackhousequalitymanagementsystem(c.getString((c.getColumnIndex(KEY_PACKHOUSEQUALITYMANAGEMENTSYSTEM))));
                    td.setTraceabilitysystem(c.getString((c.getColumnIndex(KEY_TRACEABILITYSYSTEM))));
                    td.setRecommendation(c.getString((c.getColumnIndex(KEY_RECOMMENDATION))));

                    FarmInspectionDetailsList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("Total number of records FarmInspectionDetailsList to be saved=============" + FarmInspectionDetailsList.size());
        return FarmInspectionDetailsList;
    }

    public void deleteFarmInspectionDetailsList() {

        String deleteQuery = "DELETE FROM " + TABLE_FARM_INSPECTION;

        db = dbHelper.getWritableDatabase();

        db.execSQL(deleteQuery);

        closeDB();


    }


    public void unselectFarmInspectionDetails() {
        String updateQuery = "UPDATE " + TABLE_FARM_INSPECTION + " SET " + KEY_SELECTED + " = " + "'N'";
        db = dbHelper.getReadableDatabase();
        db.execSQL(updateQuery);
        System.out.println(updateQuery);
    }

    public void selectFarmInspectionDetails(String localID) {
        String updateQuery = "UPDATE " + TABLE_FARM_INSPECTION + " SET " + KEY_SELECTED + " = " + "'Y'" + " where " + KEY_ID + " = " + localID;
        db = dbHelper.getReadableDatabase();
        db.execSQL(updateQuery);
        System.out.println(updateQuery);
    }


    /**
     * This method is to create user record
     *
     * @param
     */

    public long insertUserRecords(String name, String password
    ) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(KEY_NAME, name);
        values.put(KEY_PASSWORD, String.valueOf(password));

        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long login_id = db.insertWithOnConflict(TABLE_login, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        closeDB();

        return login_id;
    }

    public User getLogin() {
        String selectQuery = "SELECT  * FROM " + TABLE_login + "";

        User td = new User();

        db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {


                td.setUsername((c.getString((c.getColumnIndex(KEY_NAME)))));
                td.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));


            } else {
                td = null;
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            //  closeDB();
            // RIGHT: ensure resource is always recovered
        }

        return td;
    }

    public long insertUser(String name, String password) {
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PASSWORD, String.valueOf(password));
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long login_id = db.insertWithOnConflict(TABLE_login, null, values, SQLiteDatabase.CONFLICT_REPLACE);


        db.close();

        return login_id;
        // Inserting Row

    }

    public long insertADUser(ADUser adUser) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, adUser.getAd_user_name());
        values.put(KEY_EMAIL, adUser.getAd_user_email());
        values.put(KEY_AD_USER_ID, adUser.getAd_user_id());
        values.put(KEY_C_BPARTNER_ID, adUser.getC_bpartner_id());
        values.put(KEY_C_ACTIVITY_ID, adUser.getC_activity_id());

        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long login_id = db.insertWithOnConflict(TABLE_AD_USER, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        close();

        return login_id;
    }

    public void deleteADUser(ADUser adUser) {
        db = dbHelper.getWritableDatabase();
        //db.delete(TABLE_LOCAL_IMPORT_STOCKED ,null, null);
        db.delete(TABLE_AD_USER, null, null);
        // delete user record by id
        db.delete(TABLE_USER, KEY_ID + " = ?", new String[]{String.valueOf(adUser.getAd_user_id())});
        db.close();

        close();
    }

    public void deleteaduser() {
        db = dbHelper.getReadableDatabase();
        //db.delete(TABLE_LOCAL_IMPORT_STOCKED ,null, null);
        db.delete(TABLE_USER, null, null);

        closeDB();
    }    public void deleteLogin() {
        db = dbHelper.getReadableDatabase();
        //db.delete(TABLE_LOCAL_IMPORT_STOCKED ,null, null);
        db.delete(TABLE_login, null, null);

        closeDB();
    }


    public ADUser getADUser() {
        List<ADUser> aduserList = new ArrayList<ADUser>();
        String selectQuery = "SELECT  * FROM " + TABLE_AD_USER + "";

        ADUser td = new ADUser();

        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {

                td.setAd_user_name((c.getString((c.getColumnIndex(KEY_NAME)))));
                td.setAd_user_email((c.getString((c.getColumnIndex(KEY_EMAIL)))));
                td.setAd_user_id(c.getString(c.getColumnIndex(KEY_AD_USER_ID)));
                td.setC_bpartner_id(c.getString(c.getColumnIndex(KEY_C_BPARTNER_ID)));
                td.setC_activity_id(c.getString(c.getColumnIndex(KEY_C_ACTIVITY_ID)));


            } else {
                td = null;
            }
        } finally {
            close();
            if (c != null)
                c.close();
            //  closeDB();
            // RIGHT: ensure resource is always recovered
        }

        return td;
    }


    public String getADUserID(String email) {
        String selectQuery = "SELECT  * FROM " + TABLE_AD_USER + " WHERE " + KEY_EMAIL + " =" + email;

        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                return c.getString((c.getColumnIndex(KEY_AD_USER_ID)));


            }
        } finally {
            close();
            if (c != null)
                c.close();  // RIGHT: ensure resource is always recovered
        }

        return null;
    }

    /**
     * get datetime
     */
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    //Tables
    public void addFarmDetails(FarmInspection farmInspection, String longitude,
                               String latitude) {
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_SS_FARM_NAME, farmInspection.getFarmName());

        values.put(KEY_LATITUDE, String.valueOf(latitude));
        values.put(KEY_LONGITUDE, String.valueOf(longitude));
        values.put(KEY_CREATED_AT, getDateTime());

        // Inserting Row
        db.insert(TABLE_FARM_INSPECTION, null, values);
        db.close();
    }


    /**
     * This method to update user record
     *
     * @param
     */


    //cbPartner
    public long insertCBPartner(String name, String serverID) {
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(KEY_NAME, name);

        values.put(KEY_SERVER_ID, serverID);

        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long patnerid = db.insertWithOnConflict(TABLE_C_BPARTNER, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        //closeDB();
        closeDB();
        return patnerid;
    }

    public List<CBPartner> getAllCPartners() {
        List<CBPartner> cbPartnerList = new ArrayList<CBPartner>();
        String selectQuery = "SELECT  * FROM " + TABLE_C_BPARTNER;


        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    CBPartner td = new CBPartner();
                    td.setC_bpartner_id(c.getString((c.getColumnIndex(KEY_SERVER_ID))));
                    td.setName(c.getString(c.getColumnIndex(KEY_NAME)));

                    // td.setServerRecordID(c.getString(c.getColumnIndex(KEY_SERVER_ID)));
                    // adding to itinerary list
                    cbPartnerList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            // closeDB();
            // RIGHT: ensure resource is always recovered

            // RIGHT: ensure resource is always recovered
        }
        return cbPartnerList;
    }

    public void closeDB() {
       /* db = dbHelper.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();*/
    }


    /*TABLE FACILITY INSPECTION*/
    public static final String TABLE_FACILITY_INSPECTION = "facility_inspection";
    private static final String KEY_FACILITY_INSPECTION_ID = "facility_inspection_id";

    private static final String KEY_NAMEOFAPPLICANT = "nameofapplicant";
    private static final String KEY_PERSONINCHARGE = "personinchargeu";
    private static final String KEY_POSTALADRRESS = "postaladrress";
    //    private static final String KEY_STREETNAME = "streetname";
    private static final String KEY_TELEPHONENUMBER = "telephonenumber";
    private static final String KEY_POSTALCODE = "postalcode";
    //    private static final String KEY_TOWN = "town";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_COMMODITY = "commodity";
    private static final String KEY_CAPACITYDIMENSIONSINFEET = "capacitydimensions";
    private static final String KEY_SSPRODUCEEXAMINED = "ssproduceexamined";
    private static final String KEY_SSEVIDENCEOFSTORAGE = "ssevidenceofstorage";
    private static final String KEY_SSRODENTANDPESTCONTROL = "ssrodentandpestcontrol";
    private static final String KEY_SSEQUIPMMENTFORTRAPPING = "ssequipmmentfortrapping";
    private static final String KEY_SSMANAGEMENTEMPLOYESSHAVEKNOWLEDGE = "ssmanagementemployesshaveknowledge";
    private static final String KEY_SSPROCESSINGADSTORAGEAREA = "ssprocessingadstoragearea";
    private static final String KEY_SSFINISHEDGOODSINBAGS = "ssfinishedgoodsinbags";
    private static final String KEY_SSCRATESPALLETS = "sscratespallets";
    private static final String KEY_SSREJECTEDGOODSAREKEPT = "ssrejectedgoodsarekept";
    private static final String KEY_SSPROCESSINGFACILITY = "ssprocessingfacility";
    private static final String KEY_SSDIFFERENTCOMMODITIES = "ssdifferentcommodities";
    private static final String KEY_SSCURRENTLYSTORED = "sscurrentlystored";
    private static final String KEY_SSFIRMHASSCHEDULED = "ssfirmhasscheduled";
    private static final String KEY_SSPROVISIONOFWIRE = "ssprovisionofwire";
    private static final String KEY_SSBUILDINGDURABLE = "ssbuildingdurable";
    private static final String KEY_SSINTERIORLIGHTING = "ssinteriorlighting";
    private static final String KEY_SSVENTILATIONSAREADEQUATE = "ssventilationsareadequate";
    private static final String KEY_SSTOILETSANDDREESING = "sstoiletsanddreesing";
    private static final String KEY_SSPRESENCEOFPERSONALPROTECTIVEGEAR = "sspresenceofpersonalprotectivegear";
    private static final String KEY_NAMEOFINPECTOR = "nameofinpector";
    private static final String KEY_DATE = "date";

    public static final String CREATE_TABLE_FACILITY_INSPECTION = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_FACILITY_INSPECTION + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_FACILITY_INSPECTION_ID + " TEXT UNIQUE,"
            + KEY_DOCUMMENT_NUMBER + " TEXT,"
            + KEY_DOCUMMENT_DATE + " TEXT,"
            + KEY_LICENCE_NUMBER + " TEXT,"
            + KEY_APPLICANT_NAME + " TEXT,"
            + KEY_LOCALID + " TEXT,"
            + KEY_INSPECTION_DONE + " TEXT,"
            + KEY_SELECTED + " TEXT,"
            + KEY_NAMEOFINPECTOR + " TEXT,"
            + KEY_PERSONINCHARGE + " TEXT,"
            + KEY_POSTALADRRESS + " TEXT,"
            + KEY_STREETNAME + " TEXT,"
            + KEY_TELEPHONENUMBER + " TEXT,"
            + KEY_POSTALCODE + " TEXT,"
            + KEY_TOWN + " TEXT,"
            + KEY_COUNTRY + " TEXT,"
            + KEY_COMMODITY + " TEXT,"
            + KEY_CAPACITYDIMENSIONSINFEET + " TEXT,"
            + KEY_SSPRODUCEEXAMINED + " TEXT,"
            + KEY_SSEVIDENCEOFSTORAGE + " TEXT,"
            + KEY_SSRODENTANDPESTCONTROL + " TEXT,"
            + KEY_SSEQUIPMMENTFORTRAPPING + " TEXT,"
            + KEY_SSMANAGEMENTEMPLOYESSHAVEKNOWLEDGE + " TEXT,"
            + KEY_SSPROCESSINGADSTORAGEAREA + " TEXT,"
            + KEY_SSFINISHEDGOODSINBAGS + " TEXT,"
            + KEY_SSCRATESPALLETS + " TEXT,"
            + KEY_SSREJECTEDGOODSAREKEPT + " TEXT,"
            + KEY_SSPROCESSINGFACILITY + " TEXT,"
            + KEY_SSDIFFERENTCOMMODITIES + " TEXT,"
            + KEY_SSCURRENTLYSTORED + " TEXT,"
            + KEY_SSFIRMHASSCHEDULED + " TEXT,"
            + KEY_SSPROVISIONOFWIRE + " TEXT,"
            + KEY_SSBUILDINGDURABLE + " TEXT,"
            + KEY_SSINTERIORLIGHTING + " TEXT,"
            + KEY_SSVENTILATIONSAREADEQUATE + " TEXT,"
            + KEY_SSTOILETSANDDREESING + " TEXT,"
            + KEY_SSPRESENCEOFPERSONALPROTECTIVEGEAR + " TEXT,"
            + KEY_DATE + " TEXT,"
            + KEY_LATITUDE + " TEXT,"
            + KEY_LONGITUDE + " TEXT,"
            + KEY_SERVER_ID + " TEXT ,"
            + KEY_CREATED_AT + " DATETIME,"
            + KEY_UPLOADED + " TEXT" + ")";

    public long insertFacilityInspectionn(FacilityInspectionDetails facilityInspectionDetails) {

        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, facilityInspectionDetails.getLocalID());
        values.put(KEY_FACILITY_INSPECTION_ID, facilityInspectionDetails.getKEPH_Facility_Inspection_ID());
        values.put(KEY_DOCUMMENT_NUMBER, facilityInspectionDetails.getDocumentNumber());
        values.put(KEY_DOCUMMENT_DATE, facilityInspectionDetails.getDocumentDate());
        values.put(KEY_APPLICANT_NAME, facilityInspectionDetails.getNameOfApplicant());
        values.put(KEY_LICENCE_NUMBER, facilityInspectionDetails.getLicenceNumber());
        values.put(KEY_PERSONINCHARGE, facilityInspectionDetails.getPersonInCharge());
        values.put(KEY_POSTALADRRESS, facilityInspectionDetails.getPostalAdrress());
        values.put(KEY_STREETNAME, facilityInspectionDetails.getStreetName());
        values.put(KEY_TELEPHONENUMBER, facilityInspectionDetails.getTelephoneNumber());
        values.put(KEY_POSTALCODE, facilityInspectionDetails.getPostalCode());
        values.put(KEY_TOWN, facilityInspectionDetails.getTown());
        values.put(KEY_COUNTRY, facilityInspectionDetails.getCountry());
        values.put(KEY_COMMODITY, facilityInspectionDetails.getCommodity());
        values.put(KEY_CAPACITYDIMENSIONSINFEET, facilityInspectionDetails.getCapacityDimensionsinfeet());
        values.put(KEY_INSPECTION_DONE, "N");
        values.put(KEY_SELECTED, "N");
        values.put(KEY_UPLOADED, "PENDING");

        long facilityInspectionDetailsID = db.insertWithOnConflict(TABLE_FACILITY_INSPECTION, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        System.out.println("facilityInspectionDetails:::::::>>>>" + facilityInspectionDetailsID);

        closeDB();
        return facilityInspectionDetailsID;
        // insert row

    }

    public void unselectFacilityInspectionDetails() {
        String updateQuery = "UPDATE " + TABLE_FACILITY_INSPECTION + " SET " + KEY_SELECTED + " = " + "'N'";
        db = dbHelper.getReadableDatabase();
        db.execSQL(updateQuery);
        System.out.println(updateQuery);
    }

    public void selectFacilityInspectionDetails(String localID) {
        String updateQuery = "UPDATE " + TABLE_FACILITY_INSPECTION + " SET " + KEY_SELECTED + " = " + "'Y'" + " where " + KEY_ID + " = " + localID;
        db = dbHelper.getReadableDatabase();
        db.execSQL(updateQuery);
        System.out.println(updateQuery);
    }

    public long updateFacilityInspection(String localID,
                                         String nameOfapplicant,
                                         String ssproduceExamined,
                                         String ssevidenceofstorage,
                                         String ssrodentandpestcontrol,
                                         String ssequipmmentFortrapping,
                                         String ssmanagementEmployessHaveKnowledge,
                                         String ssprocessingAdStorageArea,
                                         String ssfinishedGoodsInBags,
                                         String sscratesPallets,
                                         String ssrejectedGoodsAreKept,
                                         String ssprocessingFacility,
                                         String ssdifferentCommodities,
                                         String sscurrentlyStored,
                                         String ssfirmHasScheduled,
                                         String ssprovisionofWire,
                                         String ssbuildingDurable,
                                         String ssinteriorLighting,
                                         String ssventilationsareadequate,
                                         String sstoiletsanddreesing,
                                         String sspresenceOfpersonalProtectiveGear,
                                         String date,
                                         String latitude, String longitude) {
        db = dbHelper.getWritableDatabase();

        FarmInspection farmInspection = null;

        ContentValues values = new ContentValues();

        int result = 0;
        try {
            values.put(KEY_INSPECTION_DONE, "Y");
            values.put(KEY_SELECTED, "N");

            values.put(KEY_NAMEOFINPECTOR, String.valueOf(nameOfapplicant));
            values.put(KEY_SSPRODUCEEXAMINED, String.valueOf(ssproduceExamined));
            values.put(KEY_SSEVIDENCEOFSTORAGE, String.valueOf(ssevidenceofstorage));
            values.put(KEY_SSRODENTANDPESTCONTROL, String.valueOf(ssrodentandpestcontrol));
            values.put(KEY_SSEQUIPMMENTFORTRAPPING, String.valueOf(ssequipmmentFortrapping));
            values.put(KEY_SSMANAGEMENTEMPLOYESSHAVEKNOWLEDGE, String.valueOf(ssmanagementEmployessHaveKnowledge));
            values.put(KEY_SSPROCESSINGADSTORAGEAREA, String.valueOf(ssprocessingAdStorageArea));
            values.put(KEY_SSFINISHEDGOODSINBAGS, String.valueOf(ssfinishedGoodsInBags));
            values.put(KEY_SSCRATESPALLETS, String.valueOf(sscratesPallets));
            values.put(KEY_SSREJECTEDGOODSAREKEPT, String.valueOf(ssrejectedGoodsAreKept));
            values.put(KEY_SSPROCESSINGFACILITY, String.valueOf(ssprocessingFacility));
            values.put(KEY_SSDIFFERENTCOMMODITIES, String.valueOf(ssdifferentCommodities));
            values.put(KEY_SSCURRENTLYSTORED, String.valueOf(sscurrentlyStored));
            values.put(KEY_SSFIRMHASSCHEDULED, String.valueOf(ssfirmHasScheduled));
            values.put(KEY_SSPROVISIONOFWIRE, String.valueOf(ssprovisionofWire));
            values.put(KEY_SSBUILDINGDURABLE, String.valueOf(ssbuildingDurable));
            values.put(KEY_SSINTERIORLIGHTING, String.valueOf(ssinteriorLighting));
            values.put(KEY_SSVENTILATIONSAREADEQUATE, String.valueOf(ssventilationsareadequate));
            values.put(KEY_SSTOILETSANDDREESING, String.valueOf(sstoiletsanddreesing));
            values.put(KEY_SSPRESENCEOFPERSONALPROTECTIVEGEAR, String.valueOf(sspresenceOfpersonalProtectiveGear));
            values.put(KEY_DATE, String.valueOf(date));
            values.put(KEY_LATITUDE, String.valueOf(latitude));
            values.put(KEY_LONGITUDE, String.valueOf(longitude));
            // updating row
            //
            result = db.update(TABLE_FACILITY_INSPECTION, values, KEY_ID + " = " + localID, null);


            System.out.println("results is " + result);
        } finally {
            if (result == 0) {
                // db.setTransactionSuccessful();
            }
//        db.endTransaction();
            db.close();
        }
        return result;
    }

    public boolean updateFacilityInspectionSent(String localID, String serverRecordID) {
        db = dbHelper.getWritableDatabase();

        // db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(KEY_UPLOADED, "SENT");

            int result = db.update(TABLE_FACILITY_INSPECTION, values, KEY_ID + " =" + localID, null);

            System.out.println("Total records to be sent " + result);
            if (result == 1) {
                return true;
            } else {
                return false;
            }
        } finally {
            closeDB();
            //db.endTransaction();
            //  db.close();
        }
    }

    public List<FacilityInspectionDetails> getFacilityInspectionDetailsList() {

        List<FacilityInspectionDetails> facilityInspectionDetailslist = new ArrayList<FacilityInspectionDetails>();
        FacilityInspectionDetails td = new FacilityInspectionDetails();
        // td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_FACILITY_INSPECTION + " where " + KEY_INSPECTION_DONE + " =" + "'N'";

        //System.out.println(selectQuery.toString());
        System.out.println("Picking farmInspectionDetailslist data from the db");

        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new FacilityInspectionDetails();
                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setKEPH_Facility_Inspection_ID(c.getString((c.getColumnIndex(KEY_FACILITY_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setPersonInCharge(c.getString((c.getColumnIndex(KEY_PERSONINCHARGE))));
                    td.setPostalAdrress(c.getString((c.getColumnIndex(KEY_POSTALADRRESS))));
                    td.setStreetName(c.getString((c.getColumnIndex(KEY_STREETNAME))));
                    td.setTelephoneNumber(c.getString((c.getColumnIndex(KEY_TELEPHONENUMBER))));
                    td.setPostalCode(c.getString((c.getColumnIndex(KEY_POSTALCODE))));
                    td.setTown(c.getString((c.getColumnIndex(KEY_TOWN))));
                    td.setCountry(c.getString((c.getColumnIndex(KEY_COUNTRY))));
                    td.setCommodity(c.getString((c.getColumnIndex(KEY_COMMODITY))));
                    td.setCapacityDimensionsinfeet(c.getString((c.getColumnIndex(KEY_CAPACITYDIMENSIONSINFEET))));
                    // adding to itinerary list
                    facilityInspectionDetailslist.add(td);
                } while (c.moveToNext());
            }
        } finally {
            //   closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("picking data from the db" + facilityInspectionDetailslist.size());
        return facilityInspectionDetailslist;
    }

    public List<FacilityInspectionDetails> getFacilityInspectionDetailsDone() {

        List<FacilityInspectionDetails> FacilityInspectionDetailsList = new ArrayList<FacilityInspectionDetails>();
        FacilityInspectionDetails td = new FacilityInspectionDetails();
        // td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_FACILITY_INSPECTION + " where " + KEY_INSPECTION_DONE + " =" + "'Y'"
                + " AND " + KEY_UPLOADED + " = 'PENDING'";

        db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new FacilityInspectionDetails();
                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setKEPH_Facility_Inspection_ID(c.getString((c.getColumnIndex(KEY_FACILITY_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setNameOfapplicant(c.getString((c.getColumnIndex(KEY_NAMEOFINPECTOR))));
                    td.setSsproduceExamined(c.getString((c.getColumnIndex(KEY_SSPRODUCEEXAMINED))));
                    td.setSsevidenceofstorage(c.getString((c.getColumnIndex(KEY_SSEVIDENCEOFSTORAGE))));
                    td.setSsrodentandpestcontrol(c.getString((c.getColumnIndex(KEY_SSRODENTANDPESTCONTROL))));
                    td.setSsequipmmentFortrapping(c.getString((c.getColumnIndex(KEY_SSEQUIPMMENTFORTRAPPING))));
                    td.setSsmanagementEmployessHaveKnowledge(c.getString((c.getColumnIndex(KEY_SSMANAGEMENTEMPLOYESSHAVEKNOWLEDGE))));
                    td.setSsprocessingAdStorageArea(c.getString((c.getColumnIndex(KEY_SSPROCESSINGADSTORAGEAREA))));
                    td.setSsfinishedGoodsInBags(c.getString((c.getColumnIndex(KEY_SSFINISHEDGOODSINBAGS))));
                    td.setSscratesPallets(c.getString((c.getColumnIndex(KEY_SSCRATESPALLETS))));
                    td.setSsrejectedGoodsAreKept(c.getString((c.getColumnIndex(KEY_SSREJECTEDGOODSAREKEPT))));
                    td.setSsprocessingFacility(c.getString((c.getColumnIndex(KEY_SSPROCESSINGFACILITY))));
                    td.setSsdifferentCommodities(c.getString((c.getColumnIndex(KEY_SSDIFFERENTCOMMODITIES))));
                    td.setSscurrentlyStored(c.getString((c.getColumnIndex(KEY_SSCURRENTLYSTORED))));
                    td.setSsfirmHasScheduled(c.getString((c.getColumnIndex(KEY_SSFIRMHASSCHEDULED))));
                    td.setSsprovisionofWire(c.getString((c.getColumnIndex(KEY_SSPROVISIONOFWIRE))));
                    td.setSsbuildingDurable(c.getString((c.getColumnIndex(KEY_SSBUILDINGDURABLE))));
                    td.setSsinteriorLighting(c.getString((c.getColumnIndex(KEY_SSINTERIORLIGHTING))));
                    td.setSsVentillationAdequate(c.getString((c.getColumnIndex(KEY_SSVENTILATIONSAREADEQUATE))));
                    td.setSstoiletsanddreesing(c.getString((c.getColumnIndex(KEY_SSTOILETSANDDREESING))));
                    td.setSspresenceOfpersonalProtectiveGear(c.getString((c.getColumnIndex(KEY_SSPRESENCEOFPERSONALPROTECTIVEGEAR))));
                    td.setDate(c.getString((c.getColumnIndex(KEY_DATE))));
                    FacilityInspectionDetailsList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("Total number of records FacilityInspectionDetailsList to be saved=============" + FacilityInspectionDetailsList.size());
        return FacilityInspectionDetailsList;
    }

    public void deleteFacilityInspectionDetailsList() {

        String deleteQuery = "DELETE FROM " + TABLE_FACILITY_INSPECTION;

        db = dbHelper.getWritableDatabase();

        db.execSQL(deleteQuery);

        closeDB();


    }


    /*TABLE PRODUCER INSPECTION*/
    public static final String TABLE_PRODUCER_INSPECTION = "producer_inspection";
    private static final String KEY_PRODUCER_INSPECTION_ID = "producer_inspection_id";

    private static final String KEY_FIRMNAME = "firmname";
    private static final String KEY_IS_SELECTED = "isselected";
    private static final String KEY_POSTALADDRES = "postaladdress";
    private static final String KEY_TELEPHONENO = "telephone";
    private static final String KEY_PIN = "pin";
    private static final String KEY_SECTIONUNIT = "section";
    private static final String KEY_DESCRIPTION = "desption";

    public static final String CREATE_TABLE_PRODUCER_INSPECTION = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_PRODUCER_INSPECTION + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_PRODUCER_INSPECTION_ID + " TEXT UNIQUE,"
            + KEY_DOCUMMENT_NUMBER + " TEXT,"
            + KEY_DOCUMMENT_DATE + " TEXT,"
            + KEY_LICENCE_NUMBER + " TEXT,"
            + KEY_APPLICANT_NAME + " TEXT,"
            + KEY_LOCALID + " TEXT,"
            + KEY_INSPECTION_DONE + " TEXT,"
            + KEY_IS_SELECTED + " TEXT,"
            + KEY_NAMEOFINPECTOR + " TEXT,"
            + KEY_FIRMNAME + " TEXT,"
            + KEY_STREETNAME + " TEXT,"
            + KEY_POSTALADDRES + " TEXT,"
            + KEY_POSTALCODE + " TEXT,"
            + KEY_TOWN + " TEXT,"
            + KEY_COUNTRY + " TEXT,"
            + KEY_TELEPHONENO + " TEXT,"
            + KEY_PIN + " TEXT,"
            + KEY_SECTIONUNIT + " TEXT,"
            + KEY_DESCRIPTION + " TEXT,"
            + KEY_LATITUDE + " TEXT,"
            + KEY_LONGITUDE + " TEXT,"
            + KEY_SERVER_ID + " TEXT ,"
            + KEY_CREATED_AT + " DATETIME,"
            + KEY_UPLOADED + " TEXT" + ")";

    public long insertProducerInspection(ProducerInspectionDetails producerInspectionDetails) {

        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, producerInspectionDetails.getLocalID());
        values.put(KEY_PRODUCER_INSPECTION_ID, producerInspectionDetails.getKEPH_Producer_Inspection_ID());
        values.put(KEY_DOCUMMENT_NUMBER, producerInspectionDetails.getDocumentNumber());
        values.put(KEY_DOCUMMENT_DATE, producerInspectionDetails.getDocumentDate());
        values.put(KEY_APPLICANT_NAME, producerInspectionDetails.getNameOfApplicant());
        values.put(KEY_LICENCE_NUMBER, producerInspectionDetails.getLicenceNumber());
        values.put(KEY_FIRMNAME, producerInspectionDetails.getFirmName());
        values.put(KEY_STREETNAME, producerInspectionDetails.getStreetName());
        values.put(KEY_POSTALADDRES, producerInspectionDetails.getPostalAddres());
        values.put(KEY_POSTALCODE, producerInspectionDetails.getPostalCode());
        values.put(KEY_TOWN, producerInspectionDetails.getTown());
        values.put(KEY_COUNTRY, producerInspectionDetails.getCountry());
        values.put(KEY_TELEPHONENO, producerInspectionDetails.getTelephoneNo());
        values.put(KEY_PIN, producerInspectionDetails.getPin());
        values.put(KEY_INSPECTION_DONE, "N");
        values.put(KEY_IS_SELECTED, "N");
        values.put(KEY_UPLOADED, "PENDING");

        long producerInspectionDetailsID = db.insertWithOnConflict(TABLE_PRODUCER_INSPECTION, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        System.out.println("producerInspectionDetails: " + producerInspectionDetailsID);

        closeDB();
        return producerInspectionDetailsID;
        // insert row

    }


    public long updateProducerInspectionn(String localID,
                                          String sinspector,
                                          String sectionUnit,
                                          String description,
                                          String latitude,
                                          String longitude) {
        db = dbHelper.getWritableDatabase();

        ProducerInspection producerInspection = null;

        ContentValues values = new ContentValues();

        int result = 0;
        try {
            values.put(KEY_INSPECTION_DONE, "Y");
            values.put(KEY_IS_SELECTED, "N");

            values.put(KEY_NAMEOFINPECTOR, String.valueOf(sinspector));
            values.put(KEY_SECTIONUNIT, String.valueOf(sectionUnit));
            values.put(KEY_SECTIONUNIT, String.valueOf(description));
            values.put(KEY_LATITUDE, String.valueOf(latitude));
            values.put(KEY_LONGITUDE, String.valueOf(longitude));
            // updating row
            //
            result = db.update(TABLE_PRODUCER_INSPECTION, values, KEY_ID + " = " + localID, null);


            System.out.println("results is " + result);
        } finally {
            if (result == 0) {
                // db.setTransactionSuccessful();
            }
//        db.endTransaction();
            db.close();
        }
        return result;
    }

    public boolean updateProducerInspectionSent(String localID, String serverRecordID) {
        db = dbHelper.getWritableDatabase();

        // db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(KEY_UPLOADED, "SENT");

            int result = db.update(TABLE_PRODUCER_INSPECTION, values, KEY_ID + " =" + localID, null);

            System.out.println("Total records to be sent " + result);
            if (result == 1) {
                return true;
            } else {
                return false;
            }
        } finally {
            closeDB();
            //db.endTransaction();
            //  db.close();
        }
    }

    public List<ProducerInspectionDetails> getProducerInspectionDetailsList() {

        List<ProducerInspectionDetails> producerInspectionDetailslist = new ArrayList<ProducerInspectionDetails>();
        ProducerInspectionDetails td = new ProducerInspectionDetails();

        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCER_INSPECTION + " where " + KEY_IS_SELECTED + " = " + "'Y'";

        //System.out.println(selectQuery.toString());
        System.out.println("Picking ProducerInspectionDetailslist data from the db");

        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new ProducerInspectionDetails();

                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setKEPH_Producer_Inspection_ID(c.getString((c.getColumnIndex(KEY_PRODUCER_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setFirmName(c.getString((c.getColumnIndex(KEY_FIRMNAME))));
                    td.setStreetName(c.getString((c.getColumnIndex(KEY_STREETNAME))));
                    td.setPostalAddres(c.getString((c.getColumnIndex(KEY_POSTALADDRES))));
                    td.setPostalCode(c.getString((c.getColumnIndex(KEY_POSTALCODE))));
                    td.setTown(c.getString((c.getColumnIndex(KEY_TOWN))));
                    td.setCountry(c.getString((c.getColumnIndex(KEY_COUNTRY))));
                    td.setTelephoneNo(c.getString((c.getColumnIndex(KEY_TELEPHONENO))));
                    td.setPin(c.getString((c.getColumnIndex(KEY_PIN))));
                    // adding to itinerary list
                    producerInspectionDetailslist.add(td);
                } while (c.moveToNext());
            }
        } finally {
            //   closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("picking data from the db" + producerInspectionDetailslist.size());
        return producerInspectionDetailslist;
    }

    public List<ProducerInspectionDetails> getProducerInspectionDetailsDone() {

        List<ProducerInspectionDetails> ProducerInspectionDetailsList = new ArrayList<ProducerInspectionDetails>();
        ProducerInspectionDetails td = new ProducerInspectionDetails();
        // td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCER_INSPECTION + " where " + KEY_INSPECTION_DONE + " =" + "'Y'"
                + " AND " + KEY_UPLOADED + " = 'PENDING'";

        db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new ProducerInspectionDetails();
                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setKEPH_Producer_Inspection_ID(c.getString((c.getColumnIndex(KEY_PRODUCER_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setSinspector(c.getString((c.getColumnIndex(KEY_NAMEOFINPECTOR))));
                    td.setFirmName(c.getString((c.getColumnIndex(KEY_FIRMNAME))));
                    td.setStreetName(c.getString((c.getColumnIndex(KEY_STREETNAME))));
                    td.setPostalAddres(c.getString((c.getColumnIndex(KEY_POSTALADDRES))));
                    td.setPostalCode(c.getString((c.getColumnIndex(KEY_POSTALCODE))));
                    td.setTown(c.getString((c.getColumnIndex(KEY_TOWN))));
                    td.setCountry(c.getString((c.getColumnIndex(KEY_COUNTRY))));
                    td.setTelephoneNo(c.getString((c.getColumnIndex(KEY_TELEPHONENO))));
                    td.setPin(c.getString((c.getColumnIndex(KEY_PIN))));
                    td.setSectionUnit(c.getString((c.getColumnIndex(KEY_SECTIONUNIT))));

                    ProducerInspectionDetailsList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("Total number of records ProducerInspectionDetailsList to be saved=============" + ProducerInspectionDetailsList.size());
        return ProducerInspectionDetailsList;
    }

    public void deleteProducerInspectionDetailsList() {

        String deleteQuery = "DELETE FROM " + TABLE_PRODUCER_INSPECTION;

        db = dbHelper.getWritableDatabase();

        db.execSQL(deleteQuery);

        closeDB();


    }

    public void unselectproducerInspection() {
        String updateQuery = "UPDATE " + TABLE_PRODUCER_INSPECTION + " SET " + KEY_IS_SELECTED + " = " + "'N'";
        db = dbHelper.getReadableDatabase();
        db.execSQL(updateQuery);
        System.out.println(updateQuery);
    }

    public void selectproducerInspection(String localID) {
        String updateQuery = "UPDATE " + TABLE_PRODUCER_INSPECTION + " SET " + KEY_IS_SELECTED + " = " + "'Y'" + " where " + KEY_ID + " = " + localID;
        db = dbHelper.getReadableDatabase();
        db.execSQL(updateQuery);
        System.out.println(updateQuery);
    }


    /*TABLE CONSIGNMENT INSPECTION*/
    public static final String TABLE_CONSIGNMENT_INSPECTION = "Consignment_inspection";
    public static final String TABLE_LOCAL_VARITIES = "consignment_varieties";
    private static final String KEY_CONSIGNMENT_INSPECTION_ID = "producer_inspection_id";

    private static final String KEY_SECTION_UNIT = "section";
    private static final String KEY_CONSIGNMENT_REPORT = "consignment_report";
    private static final String KEY_ISADDITIONALINSPECTIONS = "isadditinal_inspections";
    private static final String KEY_ADDITIONALINSPECTIONREMARKS = "additionalinspectionremarks";
    private static final String KEY_FIRNUMBER = "firnumber";
    private static final String KEY_DESCRIPTION_PRO = "description_pro";
    private static final String KEY_VALIDUNTIL = "validuntil";
    private static final String KEY_FIELDINSPECTION = "fieldinspection";

    private static final String KEY_PRODUCTS = "products";
    private static final String KEY_NETWEIGHT = "netweight";
    private static final String KEY_GROSSWEIIGHT = "grossweiight";
    private static final String KEY_PRODUCTCATEGORY = "productcategory";
    private static final String KEY_COMMODITYFORM = "commodityform";
    private static final String KEY_VARIETY = "variety";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_QUANTITYUNIT = "quantityunit";
    private static final String KEY_QUANTITYPASSED = "quantitypassed";
    private static final String KEY_QUANTITYREJECTED = "quantityrejected";
    private static final String KEY_NUMBEROFPACKAGES = "numberofpackages";
    private static final String KEY_REJECTEDPACKAGES = "rejectedpackages";
    private static final String KEY_DAMAGEDCAUESD = "damagedcauesd";
    private static final String KEY_PLANTPART = "plantpart";
    private static final String KEY_SAMPLESIZEINSPECTED = "samplesizeinspected";
    private static final String KEY_TYPEOFDISEASE = "typeofdisease";
    private static final String KEY_PATHOGENIDENTIFIED = "pathogenidentified";
    private static final String KEY_HEALTHCLEAN = "healthclean";
    private static final String KEY_TREATMENT = "treatment";
    private static final String KEY_RELEASED = "released";
    private static final String KEY_METHODOFDESTRUCTION = "methodofdestruction";
    private static final String KEY_SERIALLNUMBER = "seriallnumber";
    private static final String KEY_RELEVANTINFORMATION = "relevantinformation";

    public static final String CREATE_TABLE_CONSIGNMENT_INSPECTION = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_CONSIGNMENT_INSPECTION + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_CONSIGNMENT_INSPECTION_ID + " TEXT UNIQUE,"
            + KEY_DOCUMMENT_NUMBER + " TEXT,"
            + KEY_DOCUMMENT_DATE + " TEXT,"
            + KEY_LICENCE_NUMBER + " TEXT,"
            + KEY_APPLICANT_NAME + " TEXT,"
            + KEY_LOCALID + " TEXT,"
            + KEY_INSPECTION_DONE + " TEXT,"
            + KEY_NAMEOFINPECTOR + " TEXT,"
            + KEY_SECTION_UNIT + " TEXT,"
            + KEY_CONSIGNMENT_REPORT + " TEXT,"
            + KEY_ISADDITIONALINSPECTIONS + " TEXT,"
            + KEY_ADDITIONALINSPECTIONREMARKS + " TEXT,"
            + KEY_FIRNUMBER + " TEXT,"
            + KEY_DESCRIPTION_PRO + " TEXT,"
            + KEY_VALIDUNTIL + " TEXT,"
            + KEY_FIELDINSPECTION + " TEXT,"
            + KEY_SERVER_ID + " TEXT ,"
            + KEY_CREATED_AT + " DATETIME,"
            + KEY_UPLOADED + " TEXT" + ")";


    public static final String CREATE_TABLE_LOCAL_VARITIES = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_LOCAL_VARITIES + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_CONSIGNMENT_INSPECTION_ID + " TEXT UNIQUE,"
            + KEY_PRODUCTS + " TEXT,"
            + KEY_NETWEIGHT + " TEXT,"
            + KEY_GROSSWEIIGHT + " TEXT,"
            + KEY_PRODUCTCATEGORY + " TEXT,"
            + KEY_COMMODITYFORM + " TEXT,"
            + KEY_VARIETY + " TEXT,"
            + KEY_QUANTITY + " TEXT,"
            + KEY_QUANTITYUNIT + " TEXT,"
            + KEY_QUANTITYPASSED + " TEXT,"
            + KEY_QUANTITYREJECTED + " TEXT,"
            + KEY_NUMBEROFPACKAGES + " TEXT,"
            + KEY_REJECTEDPACKAGES + " TEXT,"
            + KEY_DAMAGEDCAUESD + " TEXT,"
            + KEY_PLANTPART + " TEXT,"
            + KEY_SAMPLESIZEINSPECTED + " TEXT,"
            + KEY_TYPEOFDISEASE + " TEXT,"
            + KEY_PATHOGENIDENTIFIED + " TEXT,"
            + KEY_HEALTHCLEAN + " TEXT,"
            + KEY_TREATMENT + " TEXT,"
            + KEY_RELEASED + " TEXT,"
            + KEY_METHODOFDESTRUCTION + " TEXT,"
            + KEY_SERIALLNUMBER + " TEXT,"
            + KEY_RELEVANTINFORMATION + " TEXT,"
            + KEY_SERVER_ID + " TEXT ,"
            + KEY_CREATED_AT + " DATETIME,"
            + KEY_UPLOADED + " TEXT" + ")";

    public long insertConsignmentIspection(ConsignmentIspectionDetails consignmentIspectionDetails) {

        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, consignmentIspectionDetails.getLocalID());
        values.put(KEY_CONSIGNMENT_INSPECTION_ID, consignmentIspectionDetails.getKEPH_Consignment_Inspection_ID());
        values.put(KEY_DOCUMMENT_NUMBER, consignmentIspectionDetails.getDocumentNumber());
        values.put(KEY_DOCUMMENT_DATE, consignmentIspectionDetails.getDocumentDate());
        values.put(KEY_APPLICANT_NAME, consignmentIspectionDetails.getNameOfApplicant());
        values.put(KEY_LICENCE_NUMBER, consignmentIspectionDetails.getLicenceNumber());
        values.put(KEY_INSPECTION_DONE, "N");
        values.put(KEY_UPLOADED, "PENDING");

        long consignmentIspectionDetailsID = db.insertWithOnConflict(TABLE_CONSIGNMENT_INSPECTION, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        System.out.println("consignmentIspectionDetails: " + consignmentIspectionDetailsID);

        closeDB();
        return consignmentIspectionDetailsID;
        // insert row

    }


    public long updateConsignmentIspection(String localID,
                                           String ssInspector,
                                           String sectionunit,
                                           String consignmentReport,
                                           String isadditionalInspections,
                                           String additionalInspectionRemarks,
                                           String firNumber,
                                           String description,
                                           String validUntil,
                                           String fieldInspection) {
        db = dbHelper.getWritableDatabase();

        ConsignmentIspection consignmentIspection = null;

        ContentValues values = new ContentValues();

        int result = 0;
        try {
            values.put(KEY_INSPECTION_DONE, "Y");

            values.put(KEY_NAMEOFINPECTOR, String.valueOf(ssInspector));
            values.put(KEY_SECTION_UNIT, String.valueOf(sectionunit));
            values.put(KEY_CONSIGNMENT_REPORT, String.valueOf(consignmentReport));
            values.put(KEY_ISADDITIONALINSPECTIONS, String.valueOf(isadditionalInspections));
            values.put(KEY_ADDITIONALINSPECTIONREMARKS, String.valueOf(additionalInspectionRemarks));
            values.put(KEY_FIRNUMBER, String.valueOf(firNumber));
            values.put(KEY_DESCRIPTION_PRO, String.valueOf(description));
            values.put(KEY_VALIDUNTIL, String.valueOf(validUntil));
            values.put(KEY_FIELDINSPECTION, String.valueOf(fieldInspection));

            // updating row
            //
            result = db.update(TABLE_CONSIGNMENT_INSPECTION, values, KEY_ID + " = " + localID, null);


            System.out.println("results is " + result);
        } finally {
            if (result == 0) {
                // db.setTransactionSuccessful();
            }
//        db.endTransaction();
            db.close();
        }
        return result;
    }

    public boolean updateConsignmentInspectionSent(String localID, String serverRecordID) {
        db = dbHelper.getWritableDatabase();

        // db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(KEY_UPLOADED, "SENT");

            int result = db.update(TABLE_CONSIGNMENT_INSPECTION, values, KEY_ID + " =" + localID, null);

            System.out.println("Total records to be sent " + result);
            if (result == 1) {
                return true;
            } else {
                return false;
            }
        } finally {
            closeDB();
            //db.endTransaction();
            //  db.close();
        }
    }

    public boolean updateVaritiesSent(String tableName, String localID, String serverRecordID) {
        db = dbHelper.getReadableDatabase();
        // db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(KEY_UPLOADED, "SENT");
            values.put(KEY_SERVER_ID, serverRecordID);

            // updating row
            int result = db.update(tableName, values, KEY_ID + " = ?",
                    new String[]{String.valueOf(localID)});
            if (result == 0) {
                return false;
            } else {
//                db.setTransactionSuccessful();
                return true;
            }
        } finally {
            closeDB();

        }
    }


    public List<ConsignmentIspectionDetails> getConsignmentIspectionDetailsList() {

        List<ConsignmentIspectionDetails> consignmentIspectionDetailslist = new ArrayList<ConsignmentIspectionDetails>();
        ConsignmentIspectionDetails td = new ConsignmentIspectionDetails();
        // td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_CONSIGNMENT_INSPECTION + " where " + KEY_INSPECTION_DONE + " =" + "'N'";

        //System.out.println(selectQuery.toString());
        System.out.println("Picking ConsignmentIspectionDetails data from the db");

        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new ConsignmentIspectionDetails();

                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setKEPH_Consignment_Inspection_ID(c.getString((c.getColumnIndex(KEY_CONSIGNMENT_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setSsInspector(c.getString((c.getColumnIndex(KEY_NAMEOFINPECTOR))));


                    // adding to itinerary list
                    consignmentIspectionDetailslist.add(td);
                } while (c.moveToNext());
            }
        } finally {
            //   closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("picking data from the db" + consignmentIspectionDetailslist.size());
        return consignmentIspectionDetailslist;
    }

    public List<ConsignmentIspectionDetails> getConsignmentIspectionDetailsDone() {

        List<ConsignmentIspectionDetails> ConsignmentIspectionDetailsList = new ArrayList<ConsignmentIspectionDetails>();
        ConsignmentIspectionDetails td = new ConsignmentIspectionDetails();
        // td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_CONSIGNMENT_INSPECTION + " where " + KEY_INSPECTION_DONE + " =" + "'Y'"
                + " AND " + KEY_UPLOADED + " = 'PENDING'";

        db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new ConsignmentIspectionDetails();
                    td.setLocalID(c.getString((c.getColumnIndex(KEY_ID))));
                    td.setKEPH_Consignment_Inspection_ID(c.getString((c.getColumnIndex(KEY_CONSIGNMENT_INSPECTION_ID))));
                    td.setDocumentNumber(c.getString((c.getColumnIndex(KEY_DOCUMMENT_NUMBER))));
                    td.setDocumentDate(c.getString((c.getColumnIndex(KEY_DOCUMMENT_DATE))));
                    td.setNameOfApplicant(c.getString((c.getColumnIndex(KEY_APPLICANT_NAME))));
                    td.setLicenceNumber(c.getString((c.getColumnIndex(KEY_LICENCE_NUMBER))));
                    td.setSsInspector(c.getString((c.getColumnIndex(KEY_NAMEOFINPECTOR))));
                    td.setSectionunit(c.getString((c.getColumnIndex(KEY_SECTION_UNIT))));
                    td.setConsignmentReport(c.getString((c.getColumnIndex(KEY_CONSIGNMENT_REPORT))));
                    td.setIsadditionalInspections(c.getString((c.getColumnIndex(KEY_ISADDITIONALINSPECTIONS))));
                    td.setAdditionalInspectionRemarks(c.getString((c.getColumnIndex(KEY_ADDITIONALINSPECTIONREMARKS))));
                    td.setFirNumber(c.getString((c.getColumnIndex(KEY_FIRNUMBER))));
                    td.setDescription(c.getString((c.getColumnIndex(KEY_DESCRIPTION_PRO))));
                    td.setValidUntil(c.getString((c.getColumnIndex(KEY_VALIDUNTIL))));
                    td.setFieldInspection(c.getString((c.getColumnIndex(KEY_FIELDINSPECTION))));
                    ConsignmentIspectionDetailsList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("Total number of records ConsignmentIspectionDetailsList to be saved=============" + ConsignmentIspectionDetailsList.size());
        return ConsignmentIspectionDetailsList;
    }

    public void deleteConsignmentIspectionDetailsList() {

        String deleteQuery = "DELETE FROM " + TABLE_CONSIGNMENT_INSPECTION;

        db = dbHelper.getWritableDatabase();

        db.execSQL(deleteQuery);

        closeDB();

    }


    //VarietyDetails
    public long insertVarietyDetails(int consid,
                                     String products,
                                     String netWeight,
                                     String grossWeiight,
                                     String productCategory,
                                     String commodityForm,
                                     String variety,
                                     String quantity,
                                     String quantityUnit,
                                     String quantityPassed,
                                     String quantityRejected,
                                     String numberofpackages,
                                     String rejectedPackages,
                                     String damagedCauesd,
                                     String plantPart,
                                     String sampleSizeInspected,
                                     String typeOfDisease,
                                     String pathogenIdentified,
                                     String healthClean,
                                     String treatment,
                                     String released,
                                     String methodofDestruction,
                                     String seriallNumber,
                                     String relevantInformation,
                                     String serverRecordID) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(KEY_CONSIGNMENT_INSPECTION_ID, consid);
        values.put(KEY_PRODUCTS, String.valueOf(products));
        values.put(KEY_NETWEIGHT, String.valueOf(netWeight));
        values.put(KEY_GROSSWEIIGHT, String.valueOf(grossWeiight));
        values.put(KEY_PRODUCTCATEGORY, String.valueOf(productCategory));
        values.put(KEY_COMMODITYFORM, String.valueOf(commodityForm));
        values.put(KEY_VARIETY, String.valueOf(variety));
        values.put(KEY_QUANTITY, String.valueOf(quantity));
        values.put(KEY_QUANTITYUNIT, String.valueOf(quantityUnit));
        values.put(KEY_QUANTITYPASSED, String.valueOf(quantityPassed));
        values.put(KEY_QUANTITYREJECTED, String.valueOf(quantityRejected));
        values.put(KEY_NUMBEROFPACKAGES, String.valueOf(numberofpackages));
        values.put(KEY_REJECTEDPACKAGES, String.valueOf(rejectedPackages));
        values.put(KEY_DAMAGEDCAUESD, String.valueOf(damagedCauesd));
        values.put(KEY_PLANTPART, String.valueOf(plantPart));
        values.put(KEY_SAMPLESIZEINSPECTED, String.valueOf(sampleSizeInspected));
        values.put(KEY_TYPEOFDISEASE, String.valueOf(typeOfDisease));
        values.put(KEY_PATHOGENIDENTIFIED, String.valueOf(pathogenIdentified));
        values.put(KEY_HEALTHCLEAN, String.valueOf(healthClean));
        values.put(KEY_TREATMENT, String.valueOf(treatment));
        values.put(KEY_RELEASED, String.valueOf(released));
        values.put(KEY_METHODOFDESTRUCTION, String.valueOf(methodofDestruction));
        values.put(KEY_SERIALLNUMBER, String.valueOf(seriallNumber));
        values.put(KEY_RELEVANTINFORMATION, String.valueOf(relevantInformation));
        values.put(KEY_UPLOADED, "PENDING");
        values.put(KEY_SERVER_ID, serverRecordID);
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long varityID = db.insertWithOnConflict(TABLE_LOCAL_VARITIES, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        closeDB();
        return varityID;
    }

    public List<ConsignmentIspectionDetails> getAllUnSentConsignmentIspectionDetails() {
        List<ConsignmentIspectionDetails> consignmentIspectionDetailsList = new ArrayList<ConsignmentIspectionDetails>();
        String selectQuery = "SELECT  * FROM " + TABLE_LOCAL_VARITIES + " WHERE " + KEY_UPLOADED + " = 'PENDING'";


        db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    ConsignmentIspectionDetails td = new ConsignmentIspectionDetails();
                    td.setKEPH_Consignment_Inspection_ID(c.getString((c.getColumnIndex(KEY_CONSIGNMENT_INSPECTION_ID))));

                    td.setProducts((c.getString((c.getColumnIndex(KEY_PRODUCTS)))));
                    td.setNetWeight((c.getString((c.getColumnIndex(KEY_NETWEIGHT)))));
                    td.setGrossWeiight((c.getString((c.getColumnIndex(KEY_GROSSWEIIGHT)))));
                    td.setProductCategory((c.getString((c.getColumnIndex(KEY_PRODUCTCATEGORY)))));
                    td.setCommodityForm((c.getString((c.getColumnIndex(KEY_COMMODITYFORM)))));
                    td.setVariety((c.getString((c.getColumnIndex(KEY_VARIETY)))));
                    td.setQuantity((c.getString((c.getColumnIndex(KEY_QUANTITY)))));
                    td.setQuantityUnit((c.getString((c.getColumnIndex(KEY_QUANTITYUNIT)))));
                    td.setQuantityPassed((c.getString((c.getColumnIndex(KEY_QUANTITYPASSED)))));
                    td.setQuantityRejected((c.getString((c.getColumnIndex(KEY_QUANTITYREJECTED)))));
                    td.setNumberofpackages((c.getString((c.getColumnIndex(KEY_NUMBEROFPACKAGES)))));
                    td.setRejectedPackages((c.getString((c.getColumnIndex(KEY_REJECTEDPACKAGES)))));
                    td.setDamagedCauesd((c.getString((c.getColumnIndex(KEY_DAMAGEDCAUESD)))));
                    td.setPlantPart((c.getString((c.getColumnIndex(KEY_PLANTPART)))));
                    td.setSampleSizeInspected((c.getString((c.getColumnIndex(KEY_SAMPLESIZEINSPECTED)))));
                    td.setTypeOfDisease((c.getString((c.getColumnIndex(KEY_TYPEOFDISEASE)))));
                    td.setPathogenIdentified((c.getString((c.getColumnIndex(KEY_PATHOGENIDENTIFIED)))));
                    td.setHealthClean((c.getString((c.getColumnIndex(KEY_HEALTHCLEAN)))));
                    td.setTreatment((c.getString((c.getColumnIndex(KEY_TREATMENT)))));
                    td.setReleased((c.getString((c.getColumnIndex(KEY_RELEASED)))));
                    td.setMethodofDestruction((c.getString((c.getColumnIndex(KEY_METHODOFDESTRUCTION)))));
                    td.setSeriallNumber((c.getString((c.getColumnIndex(KEY_SERIALLNUMBER)))));
                    td.setRelevantInformation((c.getString((c.getColumnIndex(KEY_RELEVANTINFORMATION)))));

                    // adding to itinerary list
                    consignmentIspectionDetailsList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            //closeDB();
            // RIGHT: ensure resource is always recovered
        }
        return consignmentIspectionDetailsList;
    }


    //
    public static final String TABLE_COUNTY = "county";

    public static final String CREATE_TABLE_COUNTY = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_COUNTY + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT UNIQUE,"
            + KEY_CREATED_AT
            + " DATETIME," + KEY_SERVER_ID + " TEXT  UNIQUE " + ")";

    public long insertCounty(String name, String serverID) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(KEY_NAME, name);

        values.put(KEY_SERVER_ID, serverID);

        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long companyID = db.insertWithOnConflict(TABLE_COUNTY, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        closeDB();
        return companyID;
    }


    public List<County> getAllCounty() {
        List<County> countyList = new ArrayList<County>();
        String selectQuery = "SELECT  * FROM " + TABLE_COUNTY;


        db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        County td = new County();
        td.setCountyName("- Required -");
        try {
            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    td = new County();
                    td.setCountyId(c.getString((c.getColumnIndex(KEY_SERVER_ID))));
                    td.setCountyName(c.getString(c.getColumnIndex(KEY_NAME)));

                    // td.setServerRecordID(c.getString(c.getColumnIndex(KEY_SERVER_ID)));
                    // adding to itinerary list
                    countyList.add(td);
                } while (c.moveToNext());
            }


        } finally {
            closeDB();
            if (c != null)
                c.close();
            //closeDB();// RIGHT: ensure resource is always recovered
        }

        return countyList;
    }


    //subcounty
    public static final String TABLE_SUB_COUNTY = "sub_county";

    public static final String KEY_SUB_COUNTY_ID = "subCountyID";
    public static final String KEY_COUNTY_ID = "countyID";

    public static final String CREATE_TABLE_SUB_COUNTY = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_SUB_COUNTY + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT  UNIQUE ,"
            + KEY_SUB_COUNTY_ID + " TEXT  UNIQUE ,"
            + KEY_COUNTY_ID + " TEXT,"
            + KEY_CREATED_AT
            + " DATETIME," + KEY_SERVER_ID + " TEXT  UNIQUE" + ")";

    public long insertSubCounty(String name, String serverID, String countyID
    ) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(KEY_NAME, name);

        values.put(KEY_SUB_COUNTY_ID, serverID);

        values.put(KEY_SERVER_ID, serverID);


        values.put(KEY_COUNTY_ID, countyID);

        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long companyID = db.insertWithOnConflict(TABLE_SUB_COUNTY, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        closeDB();

        return companyID;
    }

    public List<SubCounty> getAllSubCounty(String countyID) {
        List<SubCounty> subCountyList = new ArrayList<SubCounty>();
        String selectQuery = "SELECT  * FROM " + TABLE_SUB_COUNTY + " where " + KEY_COUNTY_ID + " = " + countyID;


        db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        subCountyList.add(new SubCounty());
        // looping through all rows and adding to list

        try {
            if (c.moveToFirst()) {
                do {
                    SubCounty td = new SubCounty();
                    td.setCountyId(c.getString((c.getColumnIndex(KEY_COUNTY_ID))));
                    td.setSubCountyName(c.getString(c.getColumnIndex(KEY_NAME)));

                    td.setSubCountyId(c.getString(c.getColumnIndex(KEY_SUB_COUNTY_ID)));
                    // adding to itinerary list
                    subCountyList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            // closeDB();// RIGHT: ensure resource is always recovered
        }

        return subCountyList;
    }


    public List<SubCounty> getAllLocalSubCounty() {
        List<SubCounty> subCountyList = new ArrayList<SubCounty>();
        String selectQuery = "SELECT  * FROM " + TABLE_SUB_COUNTY;


        db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        try { // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    SubCounty td = new SubCounty();
                    td.setCountyId(c.getString((c.getColumnIndex(KEY_COUNTY_ID))));
                    td.setSubCountyName(c.getString(c.getColumnIndex(KEY_NAME)));

                    td.setSubCountyId(c.getString(c.getColumnIndex(KEY_SUB_COUNTY_ID)));
                    // adding to itinerary list
                    subCountyList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            //closeDB();// RIGHT: ensure resource is always recovered
        }

        return subCountyList;
    }

    /**
     * Creating a country
     */
    public static final String TABLE_country = "country";
    private static final String KEY_COUNTRY_ID = "country_id";
    // Table Create Statements
    // Itinerary table create statement
    public static final String CREATE_TABLE_COUNTRY = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_country + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT,"
            + KEY_COUNTRY_ID + " TEXT UNIQUE,"
            + KEY_CREATED_AT
            + " DATETIME" + ")";

    public long createCountry(String name, String countryID) {
        db = dbHelper.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_COUNTRY_ID, countryID);
        values.put(KEY_NAME, name);

        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long itinerary_id = db.insertWithOnConflict(TABLE_country, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        // [{"itineraryMeterId":1,"readingStatus":null,"meterNumber":"12345","accountNumber":
        // "12345","minLimit":0.0,"maxLimit":1000.0,"itinerary":null,"itineraryId":1}

        /*
         * // insert tag_ids for (long tag_id : tag_ids) {
         * createTodoTag(todo_id, tag_id); }
         */
        closeDB();

        return itinerary_id;
    }

    public List<Country> getCountryList() {


        List<Country> countryList = new ArrayList<Country>();
        Country td = new Country();
        td.setName("- Required -");

        String selectQuery = "SELECT  * FROM " + TABLE_country + "";

        System.out.println("picking data from the db");
        db = dbHelper.getReadableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        try {
            if (c.moveToFirst()) {
                do {
                    td = new Country();
                    td.setC_country_id(c.getString((c.getColumnIndex(KEY_COUNTRY_ID))));
                    td.setName((c.getString((c.getColumnIndex(KEY_NAME)))));


                    // adding to itinerary list
                    countryList.add(td);
                } while (c.moveToNext());
            }
        } finally {
            closeDB();
            if (c != null)
                c.close();
            // closeDB();

            // RIGHT: ensure resource is always recovered
        }
        System.out.println("picking data from the db" + countryList.size());
        return countryList;
    }

}
