package bsl.co.ke.kephis.Worker;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.CreateDataRequest;
import org.idempiere.webservice.client.request.UpdateDataRequest;
import org.idempiere.webservice.client.response.StandardResponse;

import java.net.InetAddress;
import java.util.List;

import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.ConsignmentIspectionDetails;
import bsl.co.ke.kephis.Pojo.FacilityInspectionDetails;
import bsl.co.ke.kephis.Pojo.FarmInspectionDetails;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.Pojo.User;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;

import static bsl.co.ke.kephis.KEPHIS.getApp;


public class DatapostWorker extends Worker {

    private static final String WORK_RESULT = "work_result";
    Context context = getApplicationContext();
    String uri = context.getString(R.string.url);
    DataBaseAdapter db;
    KEPHIS app;


    public DatapostWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    @NonNull
    @Override
    public Worker.Result doWork() {
        //read input argument

        if (isInternetAvailable()) {

            try {

                String workType = getInputData().getString("workType");
                Log.i("refresh cpn work", "type of work request: " + workType);

                System.out.println("-----------------------Updating Data-----------------------" + workType);


                //appState = (ApplicationState) getApplication();


                db = new DataBaseAdapter(getApplicationContext());
                app = (KEPHIS) getApp();

                postConsignmentInspectionVarities();
                System.out.println("----------------------FarmInspectionDetailsList Inspection-------------------");

                List<FarmInspectionDetails> farmInspectionDetailsList = db.getFarmInspectionDetailsDone();

                for (int k = 0; k < farmInspectionDetailsList.size(); k++) {

                    FarmInspectionDetails farmInspectionDetails = farmInspectionDetailsList.get(k);

                    System.out.println("farm local ID to push ==== " + farmInspectionDetails.getLocalID());
                    postFarmInspectionDetails(farmInspectionDetails);
                }

                System.out.println("----------------------facilityInspectionDetails Inspection-------------------");

                List<FacilityInspectionDetails> facilityInspectionDetailsList = db.getFacilityInspectionDetailsDone();

                for (int k = 0; k < facilityInspectionDetailsList.size(); k++) {

                    FacilityInspectionDetails facilityInspectionDetails = facilityInspectionDetailsList.get(k);

                    System.out.println("farm local ID to push ==== " + facilityInspectionDetails.getLocalID());
                    postFacilityInspectionDetails(facilityInspectionDetails);
                }

                System.out.println("----------------------ProducerInspectionDetails Inspection-------------------");

                List<ProducerInspectionDetails> producerInspectionDetailsList = db.getProducerInspectionDetailsDone();

                for (int k = 0; k < producerInspectionDetailsList.size(); k++) {

                    ProducerInspectionDetails producerInspectionDetails = producerInspectionDetailsList.get(k);

                    System.out.println("farm local ID to push ==== " + producerInspectionDetails.getLocalID());
                    postproducerInspectionDetails(producerInspectionDetails);
                }

                System.out.println("----------------------consignment Inspection-------------------");

                List<ConsignmentIspectionDetails> consignmentIspectionDetailsList = db.getConsignmentIspectionDetailsDone();

                for (int k = 0; k < consignmentIspectionDetailsList.size(); k++) {

                    ConsignmentIspectionDetails consignmentIspectionDetails = consignmentIspectionDetailsList.get(k);

                    System.out.println("farm local ID to push ==== " + consignmentIspectionDetails.getLocalID());
                    postconsignmentInspectionDetails(consignmentIspectionDetails);
                }


                System.out.println("------------------------------DOne-------------------");
            } finally {
                db.closeDB();
                System.out.println("---------------------- job- ended and closed the db ----------------------");

            }


            /* doWork(); */
            return Result.RETRY;
        }
        return Result.FAILURE;

    }


    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    public void postConsignmentInspectionVarities() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<ConsignmentIspectionDetails> consignmentIspectionDetailsList = db.getAllUnSentConsignmentIspectionDetails();

        for (int k = 0; k < consignmentIspectionDetailsList.size(); k++) {
            ConsignmentIspectionDetails consignmentIspectionDetails = new ConsignmentIspectionDetails();

            consignmentIspectionDetails = consignmentIspectionDetailsList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType(consignmentIspectionDetails.getServiceType());

            System.out.println("products==" + consignmentIspectionDetails.getProducts());
            System.out.println("varities==" + consignmentIspectionDetails.getVariety());


            data.addField("M_Product_ID", consignmentIspectionDetails.getProducts());
            data.addField("net_weight", consignmentIspectionDetails.getNetWeight());
            data.addField("gross_weight", consignmentIspectionDetails.getGrossWeiight());
            data.addField("M_Product_Category_ID", consignmentIspectionDetails.getProductCategory());
            data.addField("commodity_form", consignmentIspectionDetails.getCommodityForm());
            data.addField("commodity_variety", consignmentIspectionDetails.getVariety());
            data.addField("Qty", consignmentIspectionDetails.getQuantity());
            data.addField("qty_unit", consignmentIspectionDetails.getQuantityUnit());
            data.addField("qty_pass", consignmentIspectionDetails.getQuantityPassed());
            data.addField("qty_reject", consignmentIspectionDetails.getQuantityRejected());
            data.addField("no_of_packs", consignmentIspectionDetails.getNumberofpackages());
            data.addField("packs_rejected", consignmentIspectionDetails.getRejectedPackages());
            data.addField("damage_caused", consignmentIspectionDetails.getDamagedCauesd());
            data.addField("plant_part", consignmentIspectionDetails.getPlantPart());
            data.addField("sample_size", consignmentIspectionDetails.getSampleSizeInspected());
            data.addField("disease", consignmentIspectionDetails.getTypeOfDisease());
            data.addField("pathogen_ident", consignmentIspectionDetails.getPathogenIdentified());
            data.addField("health_clean", consignmentIspectionDetails.getHealthClean());
            data.addField("treatment", consignmentIspectionDetails.getTreatment());
            data.addField("not_released", consignmentIspectionDetails.getReleased());
            data.addField("destrctn_mthd", consignmentIspectionDetails.getMethodofDestruction());
            data.addField("serial_no", consignmentIspectionDetails.getSeriallNumber());
            data.addField("relv_info", consignmentIspectionDetails.getRelevantInformation());

            //  data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(retailLooseSugarPricesRangeImported.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateVaritiesSent("product", consignmentIspectionDetails.getLocalID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void postFarmInspectionDetails(FarmInspectionDetails farmInspectionDetails) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFarmInspection");

        System.out.println("Local ID to be pushed = " + farmInspectionDetails.getLocalID());

        System.out.println("AFA_FCD_ManufacturerLic_ID" + farmInspectionDetails.getFARM_Inspection_ID());
        System.out.println("getLocalID" + farmInspectionDetails.getLocalID());
        System.out.println("Document Date =" + farmInspectionDetails.getDocumentDate());
        System.out.println("Document nUmber = " + farmInspectionDetails.getDocumentNumber());
        System.out.println("Applicant Name = " + farmInspectionDetails.getNameOfApplicant());
        System.out.println("Licence Number =" + farmInspectionDetails.getLicenceNumber());

        if (!TextUtils.isEmpty(farmInspectionDetails.getFARM_Inspection_ID()) && TextUtils.isDigitsOnly(farmInspectionDetails.getFARM_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(farmInspectionDetails.getFARM_Inspection_ID()));
        }

        data.addField("Latitude", farmInspectionDetails.getLatitude());
        data.addField("longtitude", farmInspectionDetails.getLongitude());
        data.addField("acreage", farmInspectionDetails.getAcreage());
        data.addField("plant_material", farmInspectionDetails.getSourcesOfPlantingmateriial());
        data.addField("qlty_assurance", farmInspectionDetails.getPresenceOfQualityAssurance());
        data.addField("pest_mgt", farmInspectionDetails.getPresenceOfQualityAssurance());
        data.addField("no_of_scouts_Number", farmInspectionDetails.getNoOfScouts());
        data.addField("scout_exp", farmInspectionDetails.getTrainingExperienceOfscouts());
        data.addField("scout_area", farmInspectionDetails.getAreaAllocatedToEachScout());
        data.addField("pest_monitor", farmInspectionDetails.getPestMonitoringMethodsUsed());
        data.addField("scout_method", farmInspectionDetails.getScoutingmethodsused());
        data.addField("scout_freq", farmInspectionDetails.getFrequencyOfScouting());
        data.addField("scout_record", farmInspectionDetails.getScoutingrecordsavailable());
        data.addField("pest_report", farmInspectionDetails.getPestreportingchannels());
        data.addField("control_method", farmInspectionDetails.getPestcontrolmethodsused());
        data.addField("spray_progrms", farmInspectionDetails.getSprayprogramsinplace());
        data.addField("qlty_mgmt", farmInspectionDetails.getQualitymanagementproceduresinplace());
        data.addField("qlty_checks", farmInspectionDetails.getQualitycontrolchecksinplace());
        data.addField("qlty_personnel", farmInspectionDetails.getAwarenessonpestsofconcern());
        data.addField("p_detectpest", farmInspectionDetails.getAbilityOfQualityContro());
        data.addField("detected_pestrecord", farmInspectionDetails.getDetectedpestrecordsinplace());
        data.addField("training_exp", farmInspectionDetails.getTrainingandexperience());
        data.addField("pest_of_concern", farmInspectionDetails.getAbilityToIdentifyPest());
        data.addField("area_scouted", farmInspectionDetails.getAreascoutedperday());
        data.addField("scout_freqncy", farmInspectionDetails.getFrequencyOfscouting());
        data.addField("scout_sheets", farmInspectionDetails.getScoutinghasscoutingsheetsbook());
        data.addField("scout_tools", farmInspectionDetails.getScoutingtoolsused());
        data.addField("pest_captured", farmInspectionDetails.getPestsconcerncapturedrecords());
        data.addField("scout_report", farmInspectionDetails.getScoutingreportingchannels());
        data.addField("any_pests", farmInspectionDetails.getAnypestsorpestsignsdetected());
        data.addField("pest_traps", farmInspectionDetails.getPesttrapsinplace());
        data.addField("pest_trapped", farmInspectionDetails.getAnypestsofconcerntrapped());
        data.addField("greenhouse_status", farmInspectionDetails.getGreenhousefarmsanitarystatus());
        data.addField("pest_awereness", farmInspectionDetails.getAwarenesspestsofconcern());
        data.addField("pest_training", farmInspectionDetails.getTrainingonpestsofconcern());
        data.addField("pest_signs", farmInspectionDetails.getAbilitytodetectpestsandpestsigns());
        data.addField("pes_reporting", farmInspectionDetails.getRoleinpestreportingsystem());
        data.addField("packhouse_status", farmInspectionDetails.getPackhousesanitationstatus());
        data.addField("mgt_procedures", farmInspectionDetails.getQualitymanagementproceduresinplace2());
        data.addField("qlty_control_pts", farmInspectionDetails.getHowmanyqualitycontrolpoints());
        data.addField("qlty_control_pple", farmInspectionDetails.getQualitycontrolpersonnelonawareness());
        data.addField("pest_detectablty", farmInspectionDetails.getAbilitytodetectpestsandpestsigns2());
        data.addField("report_channels", farmInspectionDetails.getReportingchannelforpestdetection());
        data.addField("graders_aware", farmInspectionDetails.getGradersawareofpestsandpestsigns());
        data.addField("hygiene_protocol", farmInspectionDetails.getAppropriatehygieneprotocolsinplace());
        data.addField("post_harvest", farmInspectionDetails.getQualityassurancepersonnelPostHarvest());
        data.addField("market_challange", farmInspectionDetails.getQualityassurancepersonnelmarketrequirement());
        data.addField("trace_systems", farmInspectionDetails.getTraceabilitysystemused());
        data.addField("trace_levels", farmInspectionDetails.getTraceabilitysystemusedtowhatlevel());
        data.addField("produce_trans", farmInspectionDetails.getTransportofproducefromfarm());
        data.addField("mgt_involve", farmInspectionDetails.getFarmmanagementinvolvementpestcontrol());
        data.addField("pest_mgt_syst", farmInspectionDetails.getPestmanagementsystem());
        data.addField("packhouse_qlty", farmInspectionDetails.getPackhousequalitymanagementsystem());
        data.addField("treaceblty_syst", farmInspectionDetails.getTraceabilitysystem());
        data.addField("recommendation", farmInspectionDetails.getRecommendation());

      /*  data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("IsApproved", "Y");
*/
        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updatefarmInspectionSent(farmInspectionDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void postproducerInspectionDetails(ProducerInspectionDetails producerInspectionDetails) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFarmInspection");

        System.out.println("Local ID to be pushed = " + producerInspectionDetails.getLocalID());

        System.out.println("KEPH_Producer_Inspection_ID" + producerInspectionDetails.getKEPH_Producer_Inspection_ID());
        System.out.println("getLocalID" + producerInspectionDetails.getLocalID());
        System.out.println("Document Date =" + producerInspectionDetails.getDocumentDate());
        System.out.println("Document nUmber = " + producerInspectionDetails.getDocumentNumber());
        System.out.println("Applicant Name = " + producerInspectionDetails.getNameOfApplicant());
        System.out.println("Licence Number =" + producerInspectionDetails.getLicenceNumber());

        if (!TextUtils.isEmpty(producerInspectionDetails.getKEPH_Producer_Inspection_ID()) && TextUtils.isDigitsOnly(producerInspectionDetails.getKEPH_Producer_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(producerInspectionDetails.getKEPH_Producer_Inspection_ID()));
        }


        data.addField("section_unit", producerInspectionDetails.getSectionUnit());
        data.addField("Description", producerInspectionDetails.getDescription());
        data.addField("Latitude", producerInspectionDetails.getLatitude());
        data.addField("Longitude", producerInspectionDetails.getLongitude());

        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateProducerInspectionSent(producerInspectionDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void postconsignmentInspectionDetails(ConsignmentIspectionDetails consignmentIspectionDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFarmInspection");

        System.out.println("Local ID to be pushed = " + consignmentIspectionDetails.getLocalID());

        System.out.println("KEPH_Producer_Inspection_ID" + consignmentIspectionDetails.getKEPH_Consignment_Inspection_ID());
        System.out.println("getLocalID" + consignmentIspectionDetails.getLocalID());
        System.out.println("Document Date =" + consignmentIspectionDetails.getDocumentDate());
        System.out.println("Document nUmber = " + consignmentIspectionDetails.getDocumentNumber());
        System.out.println("Applicant Name = " + consignmentIspectionDetails.getNameOfApplicant());
        System.out.println("Licence Number =" + consignmentIspectionDetails.getLicenceNumber());

        if (!TextUtils.isEmpty(consignmentIspectionDetails.getKEPH_Consignment_Inspection_ID()) && TextUtils.isDigitsOnly(consignmentIspectionDetails.getKEPH_Consignment_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(consignmentIspectionDetails.getKEPH_Consignment_Inspection_ID()));
        }

        data.addField("inspector", consignmentIspectionDetails.getSsInspector());
        data.addField("section_unit", consignmentIspectionDetails.getSectionunit());
        data.addField("consign_report", consignmentIspectionDetails.getConsignmentReport());
        data.addField("is_additional", consignmentIspectionDetails.getIsadditionalInspections());
        data.addField("additional_rmks", consignmentIspectionDetails.getAdditionalInspectionRemarks());
        data.addField("fir_no", consignmentIspectionDetails.getFirNumber());
        data.addField("Description", consignmentIspectionDetails.getDescription());
        data.addField("valid_to", consignmentIspectionDetails.getValidUntil());
        data.addField("inspctn_report", consignmentIspectionDetails.getFieldInspection());

        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateConsignmentInspectionSent(consignmentIspectionDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void postFacilityInspectionDetails(FacilityInspectionDetails facilityInspectionDetails) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFacilityInspection");

        System.out.println("Local ID to be pushed = " + facilityInspectionDetails.getLocalID());

        System.out.println("KEPH_facility_Inspection_ID" + facilityInspectionDetails.getKEPH_Facility_Inspection_ID());
        System.out.println("getLocalID" + facilityInspectionDetails.getLocalID());
        System.out.println("Document Date =" + facilityInspectionDetails.getDocumentDate());
        System.out.println("Document nUmber = " + facilityInspectionDetails.getDocumentNumber());
        System.out.println("Applicant Name = " + facilityInspectionDetails.getNameOfApplicant());
        System.out.println("Licence Number =" + facilityInspectionDetails.getLicenceNumber());

        if (!TextUtils.isEmpty(facilityInspectionDetails.getKEPH_Facility_Inspection_ID()) && TextUtils.isDigitsOnly(facilityInspectionDetails.getKEPH_Facility_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(facilityInspectionDetails.getKEPH_Facility_Inspection_ID()));
        }


        // data.addField("farm_name", facilityInspectionDetails.getNameOfapplicant());
       /* data.addField("visual_examinatn", facilityInspectionDetails.getSsproduceExamined());
        data.addField("storage_evidence", facilityInspectionDetails.getSsevidenceofstorage());
        data.addField("pestcontrol", facilityInspectionDetails.getSsrodentandpestcontrol());
        data.addField("trap_equipment", facilityInspectionDetails.getSsequipmmentFortrapping());
        data.addField("employee_knowldg", facilityInspectionDetails.getSsmanagementEmployessHaveKnowledge());
        data.addField("damp_proof", facilityInspectionDetails.getSsprocessingAdStorageArea());
        data.addField("wooden_placed", facilityInspectionDetails.getSsfinishedGoodsInBags());
        data.addField("crates_pallets", facilityInspectionDetails.getSscratesPallets());
        data.addField("reject_goods", facilityInspectionDetails.getSsrejectedGoodsAreKept());
        data.addField("spillage_free", facilityInspectionDetails.getSsprocessingFacility());
        data.addField("separate_storge", facilityInspectionDetails.getSsdifferentCommodities());
        data.addField("food_contamn", facilityInspectionDetails.getSscurrentlyStored());
        data.addField("cleaning_prog", facilityInspectionDetails.getSsfirmHasScheduled());
        data.addField("wire_mesh", facilityInspectionDetails.getSsprovisionofWire());
        data.addField("durable_build", facilityInspectionDetails.getSsbuildingDurable());
        data.addField("lighting", facilityInspectionDetails.getSsinteriorLighting());
        data.addField("adequate_vents", facilityInspectionDetails.getSsVentillationAdequate());
        data.addField("toilets", facilityInspectionDetails.getSstoiletsanddreesing());
        data.addField("protective_gears", facilityInspectionDetails.getSspresenceOfpersonalProtectiveGear());
        data.addField("farm_name", facilityInspectionDetails.getDate());
        data.addField("Latitude", facilityInspectionDetails.getLatitude());
        data.addField("longtitude", facilityInspectionDetails.getLongitude());*/
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateFacilityInspectionSent(facilityInspectionDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public WebServiceConnection getClient() {
        WebServiceConnection client = new WebServiceConnection();
        client.setAttempts(3);
        client.setTimeout(5000);
        client.setAttemptsTimeout(5000);
        client.setUrl(uri);
        client.setAppName("Java Test WS Client");
        return client;
    }

    public LoginRequest getLogin() {
        User user = db.getLogin();
        if ((user == null)) {
            user = new User();
            user.setUsername("inspector@briskbusiness.co.ke");
            user.setPassword("abc123");
        }


        LoginRequest login = new LoginRequest();

        if (user != null) {
            login.setUser(user.getUsername());
            login.setPass(user.getPassword());
            login.setClientID(1000000);
            login.setRoleID(1000000);
            login.setOrgID(1000000);
            login.setWarehouseID(1000000);
        }

        return login;
    }

}
