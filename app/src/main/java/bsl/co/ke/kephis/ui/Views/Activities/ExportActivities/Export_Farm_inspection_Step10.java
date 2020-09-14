package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.FarmInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Farm_inspection_Step10 extends Fragment implements BlockingStep {

    @BindView(R.id.etFarmmanagementinvolvementpestcontrol)
    EditText etFarmmanagementinvolvementpestcontrol;
    @BindView(R.id.etPestmanagementsystem)
    EditText etPestmanagementsystem;
    @BindView(R.id.etPackhousequalitymanagementsystem)
    EditText etPackhousequalitymanagementsystem;
    @BindView(R.id.etTraceabilitysystem)
    EditText etTraceabilitysystem;
    @BindView(R.id.etRecommendation)
    EditText etRecommendation;


    private String farmmanagementinvolvementpestcontrol, pestmanagementsystem, packhousequalitymanagementsystem, traceabilitysystem, recommendation;

    private ScrollView scrollView;

    private Button btnsave;
    private GPSTracker mGPS;
    KEPHIS app;
    DataBaseAdapter db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection10_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        farmmanagementinvolvementpestcontrol = Objects.requireNonNull(etFarmmanagementinvolvementpestcontrol.getText()).toString().trim();
        pestmanagementsystem = Objects.requireNonNull(etPestmanagementsystem.getText()).toString().trim();
        packhousequalitymanagementsystem = Objects.requireNonNull(etPackhousequalitymanagementsystem.getText()).toString().trim();
        traceabilitysystem = Objects.requireNonNull(etTraceabilitysystem.getText()).toString().trim();
        recommendation = Objects.requireNonNull(etRecommendation.getText()).toString().trim();

        if (TextUtils.isEmpty(farmmanagementinvolvementpestcontrol)) {
            etFarmmanagementinvolvementpestcontrol.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(pestmanagementsystem)) {
            etPestmanagementsystem.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(packhousequalitymanagementsystem)) {
            etPackhousequalitymanagementsystem.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(traceabilitysystem)) {
            etTraceabilitysystem.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(recommendation)) {
            etRecommendation.setError("Field Required");
            return;
        } else {

            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setFarmmanagementinvolvementpestcontrol(farmmanagementinvolvementpestcontrol);
            farmInspectionBus.setPestmanagementsystem(pestmanagementsystem);
            farmInspectionBus.setPackhousequalitymanagementsystem(packhousequalitymanagementsystem);
            farmInspectionBus.setTraceabilitysystem(traceabilitysystem);
            farmInspectionBus.setRecommendation(recommendation);

            db.updateFarmInspection(farmInspectionBus.getLocalID(),
                    farmInspectionBus.getAcreage(),
                    farmInspectionBus.getSourcesOfPlantingmateriial(),
                    farmInspectionBus.getPresenceOfQualityAssurance(),
                    farmInspectionBus.getDocumentedPestManagement(),
                    farmInspectionBus.getNoOfScouts(),
                    farmInspectionBus.getTrainingExperienceOfscouts(),
                    farmInspectionBus.getAreaAllocatedToEachScout(),
                    farmInspectionBus.getPestMonitoringMethodsUsed(),
                    farmInspectionBus.getScoutingmethodsused(),
                    farmInspectionBus.getFrequencyOfScouting(),
                    farmInspectionBus.getScoutingrecordsavailable(),
                    farmInspectionBus.getPestreportingchannels(),
                    farmInspectionBus.getPestcontrolmethodsused(),
                    farmInspectionBus.getSprayprogramsinplace(),
                    farmInspectionBus.getQualitymanagementproceduresinplace(),
                    farmInspectionBus.getQualitycontrolchecksinplace(),
                    farmInspectionBus.getAwarenessonpestsofconcern(),
                    farmInspectionBus.getAbilityOfQualityContro(),
                    farmInspectionBus.getDetectedpestrecordsinplace(),
                    farmInspectionBus.getTrainingandexperience(),
                    farmInspectionBus.getAbilityToIdentifyPest(),
                    farmInspectionBus.getAreascoutedperday(),
                    farmInspectionBus.getFrequencyOfscouting2(),
                    farmInspectionBus.getScoutinghasscoutingsheetsbook(),
                    farmInspectionBus.getScoutingtoolsused(),
                    farmInspectionBus.getPestsconcerncapturedrecords(),
                    farmInspectionBus.getScoutingreportingchannels(),
                    farmInspectionBus.getAnypestsorpestsignsdetected(),
                    farmInspectionBus.getPesttrapsinplace(),
                    farmInspectionBus.getAnypestsofconcerntrapped(),
                    farmInspectionBus.getGreenhousefarmsanitarystatus(),
                    farmInspectionBus.getAwarenesspestsofconcern(),
                    farmInspectionBus.getTrainingonpestsofconcern(),
                    farmInspectionBus.getAbilitytodetectpestsandpestsigns(),
                    farmInspectionBus.getRoleinpestreportingsystem(),
                    farmInspectionBus.getPackhousesanitationstatus(),
                    farmInspectionBus.getQualitymanagementproceduresinplace2(),
                    farmInspectionBus.getHowmanyqualitycontrolpoints(),
                    farmInspectionBus.getQualitycontrolpersonnelonawareness(),
                    farmInspectionBus.getAbilitytodetectpestsandpestsigns2(),
                    farmInspectionBus.getReportingchannelforpestdetection(),
                    farmInspectionBus.getGradersawareofpestsandpestsigns(),
                    farmInspectionBus.getAppropriatehygieneprotocolsinplace(),
                    farmInspectionBus.getQualityassurancepersonnelPostHarvest(),
                    farmInspectionBus.getQualityassurancepersonnelmarketrequirement(),
                    farmInspectionBus.getTraceabilitysystemused(),
                    farmInspectionBus.getTraceabilitysystemusedtowhatlevel(),
                    farmInspectionBus.getTransportofproducefromfarm(),
                    farmInspectionBus.getFarmmanagementinvolvementpestcontrol(),
                    farmInspectionBus.getPestmanagementsystem(),
                    farmInspectionBus.getPackhousequalitymanagementsystem(),
                    farmInspectionBus.getTraceabilitysystem(),
                    farmInspectionBus.getRecommendation(),
                    String.valueOf(mGPS.getLatitude()),
                    String.valueOf(mGPS.getLongitude()));


           /* if (isupdated == 1) {

                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT);
            }
        else {
                Toast.makeText(this, "Not updated", Toast.LENGTH_SHORT);
            }*/

            //  databaseHelper.updateFarmInspection(farmInspection, String.valueOf(mGPS.getLatitude()), String.valueOf(mGPS.getLongitude()));


        }


    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();

    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }


}
