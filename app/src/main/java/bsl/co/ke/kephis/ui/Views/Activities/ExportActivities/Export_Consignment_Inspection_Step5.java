package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Consignment_Inspection_Step5 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.etDamageCaused)
    EditText etDamageCaused;
    @BindView(R.id.etPlantPart)
    EditText etPlantPart;
    @BindView(R.id.etSampleSizeInspected)
    EditText etSampleSizeInspected;
    @BindView(R.id.etTypeofDisease)
    EditText etTypeofDisease;
    @BindView(R.id.etPathogenIdentified)
    EditText etPathogenIdentified;
    @BindView(R.id.etHealthClean)
    EditText etHealthClean;
    @BindView(R.id.etTreatment)
    EditText etTreatment;
    @BindView(R.id.etreleased)
    EditText etreleased;
    @BindView(R.id.etMethodofDestruction)
    EditText etMethodofDestruction;
    @BindView(R.id.etSerialNumber)
    EditText etSerialNumber;
    @BindView(R.id.etRelevantInformation)
    EditText etRelevantInformation;

    private GPSTracker mGPS;
    KEPHIS app;
    DataBaseAdapter db;


    private String damagedCauesd, plantPart, sampleSizeInspected, typeOfDisease, pathogenIdentified, healthClean, treatment, released;
    private String methodofDestruction, seriallNumber, relevantInformation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_consignment_inspection5_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


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
        damagedCauesd = Objects.requireNonNull(etDamageCaused.getText()).toString().trim();
        plantPart = Objects.requireNonNull(etPlantPart.getText()).toString().trim();
        sampleSizeInspected = Objects.requireNonNull(etSampleSizeInspected.getText()).toString().trim();
        typeOfDisease = Objects.requireNonNull(etTypeofDisease.getText()).toString().trim();
        pathogenIdentified = Objects.requireNonNull(etPathogenIdentified.getText()).toString().trim();
        healthClean = Objects.requireNonNull(etHealthClean.getText()).toString().trim();
        treatment = Objects.requireNonNull(etTreatment.getText()).toString().trim();
        released = Objects.requireNonNull(etreleased.getText()).toString().trim();
        methodofDestruction = Objects.requireNonNull(etMethodofDestruction.getText()).toString().trim();
        seriallNumber = Objects.requireNonNull(etSerialNumber.getText()).toString().trim();
        relevantInformation = Objects.requireNonNull(etRelevantInformation.getText()).toString().trim();

        if (TextUtils.isEmpty(damagedCauesd)) {
            etDamageCaused.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(plantPart)) {
            etPlantPart.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(sampleSizeInspected)) {
            etSampleSizeInspected.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(typeOfDisease)) {
            etTypeofDisease.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(pathogenIdentified)) {
            etPathogenIdentified.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(healthClean)) {
            etHealthClean.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(treatment)) {
            etTreatment.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(released)) {
            etreleased.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(methodofDestruction)) {
            etMethodofDestruction.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(seriallNumber)) {
            etSerialNumber.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(relevantInformation)) {
            etRelevantInformation.setError("Field Required");
            return;
        } else {


            ConsignmentIspectionBus consignmentIspectionBus = ConsignmentIspectionBus.getInstance();
            consignmentIspectionBus.setDamagedCauesd(damagedCauesd);
            consignmentIspectionBus.setPlantPart(plantPart);
            consignmentIspectionBus.setSampleSizeInspected(sampleSizeInspected);
            consignmentIspectionBus.setTypeOfDisease(typeOfDisease);
            consignmentIspectionBus.setPathogenIdentified(pathogenIdentified);
            consignmentIspectionBus.setHealthClean(healthClean);
            consignmentIspectionBus.setTreatment(treatment);
            consignmentIspectionBus.setReleased(released);
            consignmentIspectionBus.setMethodofDestruction(methodofDestruction);
            consignmentIspectionBus.setSeriallNumber(seriallNumber);
            consignmentIspectionBus.setRelevantInformation(relevantInformation);


            long consi_inspection_id = db.updateConsignmentIspection(consignmentIspectionBus.getLocalID(),
                    consignmentIspectionBus.getSsInspector(),
                    consignmentIspectionBus.getSectionunit(),
                    consignmentIspectionBus.getConsignmentReport(),
                    consignmentIspectionBus.getIsadditionalInspections(),
                    consignmentIspectionBus.getAdditionalInspectionRemarks(),
                    consignmentIspectionBus.getFirNumber(),
                    consignmentIspectionBus.getDescription(),
                    consignmentIspectionBus.getValidUntil(),
                    consignmentIspectionBus.getFieldInspection());

            db.insertVarietyDetails(Integer.parseInt(String.valueOf(consi_inspection_id)),
                    consignmentIspectionBus.getProducts(),
                    consignmentIspectionBus.getNetWeight(),
                    consignmentIspectionBus.getGrossWeiight(),
                    consignmentIspectionBus.getProductCategory(),
                    consignmentIspectionBus.getCommodityForm(),
                    consignmentIspectionBus.getVariety(),
                    consignmentIspectionBus.getQuantity(),
                    consignmentIspectionBus.getQuantityUnit(),
                    consignmentIspectionBus.getQuantityPassed(),
                    consignmentIspectionBus.getQuantityRejected(),
                    consignmentIspectionBus.getNumberofpackages(),
                    consignmentIspectionBus.getRejectedPackages(),
                    consignmentIspectionBus.getDamagedCauesd(),
                    consignmentIspectionBus.getPlantPart(),
                    consignmentIspectionBus.getSampleSizeInspected(),
                    consignmentIspectionBus.getTypeOfDisease(),
                    consignmentIspectionBus.getPathogenIdentified(),
                    consignmentIspectionBus.getHealthClean(),
                    consignmentIspectionBus.getTreatment(),
                    consignmentIspectionBus.getReleased(),
                    consignmentIspectionBus.getMethodofDestruction(),
                    consignmentIspectionBus.getSeriallNumber(),
                    consignmentIspectionBus.getRelevantInformation(), "0");


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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}












