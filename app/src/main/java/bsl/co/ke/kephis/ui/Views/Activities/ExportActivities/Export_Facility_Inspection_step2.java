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

public class Export_Facility_Inspection_step2 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.ssProduceExamined)
    Spinner ssProduceExamined;
    @BindView(R.id.ssEvidenceofstorage)
    Spinner ssEvidenceofstorage;
    @BindView(R.id.ssRodentandpestcontrol)
    Spinner ssRodentandpestcontrol;
    @BindView(R.id.ssEquipmmentFortrapping)
    Spinner ssEquipmmentFortrapping;
    @BindView(R.id.ssManagementEmployessHaveKnowledge)
    Spinner ssManagementEmployessHaveKnowledge;

    KEPHIS app;
    DataBaseAdapter db;
    String[] yesnoselection = {"Select", "Yes", "No"};

    private String ssproduceExamined, ssevidenceofstorage, ssrodentandpestcontrol, ssequipmmentFortrapping, ssmanagementEmployessHaveKnowledge;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_facility_inspection2_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        ssProduceExamined.setOnItemSelectedListener(this);
        ssEvidenceofstorage.setOnItemSelectedListener(this);
        ssRodentandpestcontrol.setOnItemSelectedListener(this);
        ssEquipmmentFortrapping.setOnItemSelectedListener(this);
        ssManagementEmployessHaveKnowledge.setOnItemSelectedListener(this);
        //Setting the ArrayAdapter data on the Spinner
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, yesnoselection);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        ssProduceExamined.setAdapter(arrayAdapter);
        ssEvidenceofstorage.setAdapter(arrayAdapter);
        ssRodentandpestcontrol.setAdapter(arrayAdapter);
        ssEquipmmentFortrapping.setAdapter(arrayAdapter);
        ssManagementEmployessHaveKnowledge.setAdapter(arrayAdapter);

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
        ssproduceExamined = Objects.requireNonNull(ssProduceExamined.getSelectedItem()).toString().trim();
        ssevidenceofstorage = Objects.requireNonNull(ssEvidenceofstorage.getSelectedItem()).toString().trim();
        ssrodentandpestcontrol = Objects.requireNonNull(ssRodentandpestcontrol.getSelectedItem()).toString().trim();
        ssequipmmentFortrapping = Objects.requireNonNull(ssEquipmmentFortrapping.getSelectedItem()).toString().trim();
        ssmanagementEmployessHaveKnowledge = Objects.requireNonNull(ssManagementEmployessHaveKnowledge.getSelectedItem()).toString().trim();



    /*    boolean valid = validateSpinner(ssProduceExamined, ssproduceExamined) &
                validateSpinner(ssEvidenceofstorage, ssevidenceofstorage) &
                validateSpinner(ssRodentandpestcontrol, ssrodentandpestcontrol) &
                validateSpinner(ssEquipmmentFortrapping, ssequipmmentFortrapping) &
                validateSpinner(ssManagementEmployessHaveKnowledge, ssmanagementEmployessHaveKnowledge);
        if (valid) {*/
        FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();
        facilityInspectionBus.setSsproduceExamined(ssproduceExamined);
        facilityInspectionBus.setSsevidenceofstorage(ssevidenceofstorage);
        facilityInspectionBus.setSsrodentandpestcontrol(ssrodentandpestcontrol);
        facilityInspectionBus.setSsequipmmentFortrapping(ssequipmmentFortrapping);
        facilityInspectionBus.setSsmanagementEmployessHaveKnowledge(ssmanagementEmployessHaveKnowledge);
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
