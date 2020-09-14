package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
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

import bsl.co.ke.kephis.Data.Bus.ConsignmentIspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Consignment_Inspection_Step2 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.etsectionunit)
    EditText etsectionunit;
    @BindView(R.id.etConsignmentReport)
    EditText etConsignmentReport;
    @BindView(R.id.etAdditionalInspections)
    CheckBox etAdditionalInspections;
    @BindView(R.id.etAdditionalInspectionRemarks)
    EditText etAdditionalInspectionRemarks;

    DataBaseAdapter db;
    KEPHIS app;

    private String sectionunit, consignmentReport, isadditionalInspections, additionalInspectionRemarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_consignment_inspection2_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        etAdditionalInspections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etAdditionalInspections.isChecked()) {
                    isadditionalInspections = "Y";
                } else {
                    isadditionalInspections = "N";
                }
            }
        });

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
        sectionunit = Objects.requireNonNull(etsectionunit.getText()).toString().trim();
        consignmentReport = Objects.requireNonNull(etConsignmentReport.getText()).toString().trim();
        additionalInspectionRemarks = Objects.requireNonNull(etAdditionalInspectionRemarks.getText()).toString().trim();


        if (TextUtils.isEmpty(sectionunit)) {
            etsectionunit.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(consignmentReport)) {
            etConsignmentReport.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(additionalInspectionRemarks)) {
            etAdditionalInspectionRemarks.setError("Field Required");
            return;
        } else {

            ConsignmentIspectionBus consignmentIspectionBus = ConsignmentIspectionBus.getInstance();
            consignmentIspectionBus.setSectionunit(sectionunit);
            consignmentIspectionBus.setConsignmentReport(consignmentReport);
            consignmentIspectionBus.setAdditionalInspectionRemarks(additionalInspectionRemarks);
            callback.goToNextStep();

        }

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



