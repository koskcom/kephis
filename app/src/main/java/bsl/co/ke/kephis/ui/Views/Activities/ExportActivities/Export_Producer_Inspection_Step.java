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

import bsl.co.ke.kephis.Data.Bus.ProducerInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Producer_Inspection_Step  extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.ssInspector)
    Spinner ssInspector;

    private String ssinspector;

    KEPHIS app;
    DataBaseAdapter db;
    String[] users = {"Select Inspector", "KEPHIS USER", "SYSTEM", "KEPHIS APPROVER", "KEPHIS INSPECTOR", "KEPHIS ADMIN"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection1_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        ssInspector.setOnItemSelectedListener(this);
        //Setting the ArrayAdapter data on the Spinner
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, users);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        ssInspector.setAdapter(arrayAdapter);
        return view;


    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        ssinspector = Objects.requireNonNull(ssInspector.getSelectedItem()).toString().trim();
        ProducerInspectionBus producerInspectionBus = ProducerInspectionBus.getInstance();
        producerInspectionBus.setSinspector(ssinspector);
        boolean valid = validateSpinner(ssInspector, ssinspector);
        if (valid) {
            callback.goToNextStep();
        }


    }

    boolean validateSpinner(Spinner spinner, String error) {

        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            if (selectedTextView.getText().equals("Select Inspector")) {
                selectedTextView.setError(error);
                Toast.makeText(getActivity(), "Inspector Required", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
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
