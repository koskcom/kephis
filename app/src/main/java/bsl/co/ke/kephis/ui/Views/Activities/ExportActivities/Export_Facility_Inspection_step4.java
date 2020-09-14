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

public class Export_Facility_Inspection_step4 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.ssProvisionofWire)
    Spinner ssProvisionofWire;
    @BindView(R.id.ssBuildingDurable)
    Spinner ssBuildingDurable;
    @BindView(R.id.ssInteriorLighting)
    Spinner ssInteriorLighting;
    @BindView(R.id.ssVentilationsareadequate)
    Spinner ssVentilationsareadequate;

    KEPHIS app;
    DataBaseAdapter db;

    private String ssprovisionofWire, ssbuildingDurable, ssinteriorLighting, ssventilationsareadequate;
    String[] yesnoselection = {"Select", "YES", "NO"};


    private String ssprocessingAdStorageArea, ssfinishedGoodsInBags, sscratesPallets, ssrejectedGoodsAreKept, ssprocessingFacility, ssdifferentCommodities;
    private String sscurrentlyStored, ssfirmHasScheduled;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_facility_inspection4_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        ssProvisionofWire.setOnItemSelectedListener(this);
        ssBuildingDurable.setOnItemSelectedListener(this);
        ssInteriorLighting.setOnItemSelectedListener(this);
        ssVentilationsareadequate.setOnItemSelectedListener(this);

        //Setting the ArrayAdapter data on the Spinner
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, yesnoselection);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner

        ssProvisionofWire.setAdapter(arrayAdapter);
        ssBuildingDurable.setAdapter(arrayAdapter);
        ssInteriorLighting.setAdapter(arrayAdapter);
        ssVentilationsareadequate.setAdapter(arrayAdapter);


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
        ssprovisionofWire = Objects.requireNonNull(ssProvisionofWire.getSelectedItem()).toString().trim();
        ssbuildingDurable = Objects.requireNonNull(ssBuildingDurable.getSelectedItem()).toString().trim();
        ssinteriorLighting = Objects.requireNonNull(ssInteriorLighting.getSelectedItem()).toString().trim();
        ssventilationsareadequate = Objects.requireNonNull(ssVentilationsareadequate.getSelectedItem()).toString().trim();


       /* boolean valid = validateSpinner(ssProvisionofWire, ssprovisionofWire) &
                validateSpinner(ssBuildingDurable, ssbuildingDurable) &
                validateSpinner(ssInteriorLighting, ssinteriorLighting) &
                validateSpinner(ssVentilationsareadequate, ssventilationsareadequate);


        if (valid) {*/
        FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();
        facilityInspectionBus.setSsprovisionofWire(ssprovisionofWire);
        facilityInspectionBus.setSsbuildingDurable(ssbuildingDurable);
        facilityInspectionBus.setSsinteriorLighting(ssinteriorLighting);
        facilityInspectionBus.setSsVentillationAdequate(ssventilationsareadequate);
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




















