package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import bsl.co.ke.kephis.Dashboard;
import bsl.co.ke.kephis.Data.Bus.FacilityInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Facility_Inspection_step5 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {


    @BindView(R.id.ssToiletsanddressing)
    Spinner ssToiletsanddressing;
    @BindView(R.id.ssPresenceOfpersonalProtectiveGear)
    Spinner ssPresenceOfpersonalProtectiveGear;

    String[] yesnoselection = {"Select", "YES", "NO"};

    private GPSTracker mGPS;
    KEPHIS app;
    DataBaseAdapter db;


    private String sstoiletsanddreesing, sspresenceOfpersonalProtectiveGear, nameofinpector, date;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_facility_inspection5_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();
        mGPS = new GPSTracker(getContext());

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        ssToiletsanddressing.setOnItemSelectedListener(this);
        ssPresenceOfpersonalProtectiveGear.setOnItemSelectedListener(this);

        //Setting the ArrayAdapter data on the Spinner
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, yesnoselection);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner

        ssToiletsanddressing.setAdapter(arrayAdapter);
        ssPresenceOfpersonalProtectiveGear.setAdapter(arrayAdapter);


        return view;


    }


    public void postDataToSQLite() {


    }

    boolean validateSpinner(Spinner spinner, String error) {

        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            if (selectedTextView.getText().equals("Select")) {
                selectedTextView.setError(error);
                Toast.makeText(getActivity(), "Field Required", Toast.LENGTH_SHORT).show();

                return false;
            }
        }
        return true;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        sstoiletsanddreesing = Objects.requireNonNull(ssToiletsanddressing.getSelectedItem()).toString().trim();
        sspresenceOfpersonalProtectiveGear = Objects.requireNonNull(ssPresenceOfpersonalProtectiveGear.getSelectedItem()).toString().trim();


/*
        boolean valid = validateSpinner(ssToiletsanddressing, sstoiletsanddreesing) &
                validateSpinner(ssPresenceOfpersonalProtectiveGear, sspresenceOfpersonalProtectiveGear);

        if (valid) {*/
        FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();
        facilityInspectionBus.setSstoiletsanddreesing(sstoiletsanddreesing);
        facilityInspectionBus.setSspresenceOfpersonalProtectiveGear(sspresenceOfpersonalProtectiveGear);

        db.updateFacilityInspection(facilityInspectionBus.getLocalID(),
                facilityInspectionBus.getNameOfapplicant(),
                facilityInspectionBus.getSsproduceExamined(),
                facilityInspectionBus.getSsevidenceofstorage(),
                facilityInspectionBus.getSsrodentandpestcontrol(),
                facilityInspectionBus.getSsequipmmentFortrapping(),
                facilityInspectionBus.getSsmanagementEmployessHaveKnowledge(),
                facilityInspectionBus.getSsprocessingAdStorageArea(),
                facilityInspectionBus.getSsfinishedGoodsInBags(),
                facilityInspectionBus.getSscratesPallets(),
                facilityInspectionBus.getSsrejectedGoodsAreKept(),
                facilityInspectionBus.getSsprocessingFacility(),
                facilityInspectionBus.getSsdifferentCommodities(),
                facilityInspectionBus.getSscurrentlyStored(),
                facilityInspectionBus.getSsfirmHasScheduled(),
                facilityInspectionBus.getSsprovisionofWire(),
                facilityInspectionBus.getSsbuildingDurable(),
                facilityInspectionBus.getSsinteriorLighting(),
                facilityInspectionBus.getSsVentillationAdequate(),
                facilityInspectionBus.getSstoiletsanddreesing(),
                facilityInspectionBus.getSspresenceOfpersonalProtectiveGear(),
                facilityInspectionBus.getDate(),
                String.valueOf(mGPS.getLatitude()),
                String.valueOf(mGPS.getLongitude()));

        Intent intent = new Intent(getActivity(), Dashboard.class);
        startActivity(intent);

         /* long isupdated =
            if (isupdated == 1) {
                new onSubmitClicked().execute();

                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT);
            } else {
                Toast.makeText(this, "Not updated", Toast.LENGTH_SHORT);
            }*/

        //  databaseHelper.updateFarmInspection(farmInspection, String.valueOf(mGPS.getLatitude()), String.valueOf(mGPS.getLongitude()));


        // }

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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

















