package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

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

import bsl.co.ke.kephis.Data.Bus.FacilityInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Facility_Inspection_step3 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.ssProcessingAdStorageArea)
    Spinner ssProcessingAdStorageArea;
    @BindView(R.id.ssFinishedGoodsInBags)
    Spinner ssFinishedGoodsInBags;
    @BindView(R.id.ssCratesPallets)
    Spinner ssCratesPallets;
    @BindView(R.id.ssRejectedGoodsAreKept)
    Spinner ssRejectedGoodsAreKept;
    @BindView(R.id.ssProcessingFacility)
    Spinner ssProcessingFacility;
    @BindView(R.id.ssDifferentCommodities)
    Spinner ssDifferentCommodities;
    @BindView(R.id.ssCurrentlyStored)
    Spinner ssCurrentlyStored;
    @BindView(R.id.ssFirmHasScheduled)
    Spinner ssFirmHasScheduled;

    KEPHIS app;
    DataBaseAdapter db;
    String[] yesnoselection = {"Select", "YES", "NO"};

    private String ssprocessingAdStorageArea, ssfinishedGoodsInBags, sscratesPallets, ssrejectedGoodsAreKept, ssprocessingFacility, ssdifferentCommodities;
    private String sscurrentlyStored, ssfirmHasScheduled;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_facility_inspection3_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        ssProcessingAdStorageArea.setOnItemSelectedListener(this);
        ssFinishedGoodsInBags.setOnItemSelectedListener(this);
        ssCratesPallets.setOnItemSelectedListener(this);
        ssRejectedGoodsAreKept.setOnItemSelectedListener(this);
        ssProcessingFacility.setOnItemSelectedListener(this);
        ssDifferentCommodities.setOnItemSelectedListener(this);
        ssCurrentlyStored.setOnItemSelectedListener(this);
        ssFirmHasScheduled.setOnItemSelectedListener(this);

        //Setting the ArrayAdapter data on the Spinner
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, yesnoselection);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner

        ssProcessingAdStorageArea.setAdapter(arrayAdapter);
        ssFinishedGoodsInBags.setAdapter(arrayAdapter);
        ssCratesPallets.setAdapter(arrayAdapter);
        ssRejectedGoodsAreKept.setAdapter(arrayAdapter);
        ssProcessingFacility.setAdapter(arrayAdapter);
        ssDifferentCommodities.setAdapter(arrayAdapter);
        ssCurrentlyStored.setAdapter(arrayAdapter);
        ssFirmHasScheduled.setAdapter(arrayAdapter);


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
        ssprocessingAdStorageArea = Objects.requireNonNull(ssProcessingAdStorageArea.getSelectedItem()).toString().trim();
        ssfinishedGoodsInBags = Objects.requireNonNull(ssFinishedGoodsInBags.getSelectedItem()).toString().trim();
        sscratesPallets = Objects.requireNonNull(ssCratesPallets.getSelectedItem()).toString().trim();
        ssrejectedGoodsAreKept = Objects.requireNonNull(ssRejectedGoodsAreKept.getSelectedItem()).toString().trim();
        ssprocessingFacility = Objects.requireNonNull(ssProcessingFacility.getSelectedItem()).toString().trim();
        ssdifferentCommodities = Objects.requireNonNull(ssDifferentCommodities.getSelectedItem()).toString().trim();
        sscurrentlyStored = Objects.requireNonNull(ssCurrentlyStored.getSelectedItem()).toString().trim();
        ssfirmHasScheduled = Objects.requireNonNull(ssFirmHasScheduled.getSelectedItem()).toString().trim();


/*
        boolean valid = validateSpinner(ssProcessingAdStorageArea, ssprocessingAdStorageArea) &
                validateSpinner(ssFinishedGoodsInBags, ssfinishedGoodsInBags) &
                validateSpinner(ssCratesPallets, sscratesPallets) &
                validateSpinner(ssRejectedGoodsAreKept, ssrejectedGoodsAreKept) &
                validateSpinner(ssProcessingFacility, ssprocessingFacility) &
                validateSpinner(ssDifferentCommodities, ssdifferentCommodities) &
                validateSpinner(ssCurrentlyStored, sscurrentlyStored) &
                validateSpinner(ssFirmHasScheduled, ssfirmHasScheduled);
        if (valid) {*/
        FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();
        facilityInspectionBus.setSsprocessingAdStorageArea(ssprocessingAdStorageArea);
        facilityInspectionBus.setSsfinishedGoodsInBags(ssfinishedGoodsInBags);
        facilityInspectionBus.setSscratesPallets(sscratesPallets);
        facilityInspectionBus.setSsrejectedGoodsAreKept(ssrejectedGoodsAreKept);
        facilityInspectionBus.setSsprocessingFacility(ssprocessingFacility);
        facilityInspectionBus.setSsdifferentCommodities(ssdifferentCommodities);
        facilityInspectionBus.setSscurrentlyStored(sscurrentlyStored);
        facilityInspectionBus.setSsfirmHasScheduled(ssfirmHasScheduled);
        callback.goToNextStep();
        // }

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

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


