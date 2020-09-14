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
import bsl.co.ke.kephis.Data.model.FarmInspection;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.db.DatabaseHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Farm_inspection_Step8 extends Fragment implements BlockingStep {

    @BindView(R.id.etPackhousesanitationstatus)
    EditText etPackhousesanitationstatus;
    @BindView(R.id.etQualitymanagementproceduresinplace)
    EditText etQualitymanagementproceduresinplace;
    @BindView(R.id.etHowmanyqualitycontrolpoints)
    EditText etHowmanyqualitycontrolpoints;
    @BindView(R.id.etQualitycontrolpersonnelonawareness)
    EditText etQualitycontrolpersonnelonawareness;
    @BindView(R.id.etAbilitytodetectpestsandpestsigns)
    EditText etAbilitytodetectpestsandpestsigns;
    @BindView(R.id.etReportingchannelforpestdetection)
    EditText etReportingchannelforpestdetection;
    @BindView(R.id.etGradersawareofpestsandpestsigns)
    EditText etGradersawareofpestsandpestsigns;

    private String packhousesanitationstatus, qualitymanagementproceduresinplace, howmanyqualitycontrolpoints, qualitycontrolpersonnelonawareness;
    private String abilitytodetectpestsandpestsigns2, reportingchannelforpestdetection, gradersawareofpestsandpestsigns;

    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;

    private Button btnnext;
    private FarmInspection farmInspection;


    KEPHIS app;
    DataBaseAdapter db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection8_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        packhousesanitationstatus = Objects.requireNonNull(etPackhousesanitationstatus.getText()).toString().trim();
        qualitymanagementproceduresinplace = Objects.requireNonNull(etQualitymanagementproceduresinplace.getText()).toString().trim();
        howmanyqualitycontrolpoints = Objects.requireNonNull(etHowmanyqualitycontrolpoints.getText()).toString().trim();
        qualitycontrolpersonnelonawareness = Objects.requireNonNull(etQualitycontrolpersonnelonawareness.getText()).toString().trim();
        abilitytodetectpestsandpestsigns2 = Objects.requireNonNull(etAbilitytodetectpestsandpestsigns.getText()).toString().trim();
        reportingchannelforpestdetection = Objects.requireNonNull(etReportingchannelforpestdetection.getText()).toString().trim();
        gradersawareofpestsandpestsigns = Objects.requireNonNull(etGradersawareofpestsandpestsigns.getText()).toString().trim();
        if (TextUtils.isEmpty(packhousesanitationstatus)) {
            etPackhousesanitationstatus.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(qualitymanagementproceduresinplace)) {
            etQualitymanagementproceduresinplace.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(howmanyqualitycontrolpoints)) {
            etHowmanyqualitycontrolpoints.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(qualitycontrolpersonnelonawareness)) {
            etQualitycontrolpersonnelonawareness.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(abilitytodetectpestsandpestsigns2)) {
            etAbilitytodetectpestsandpestsigns.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(reportingchannelforpestdetection)) {
            etReportingchannelforpestdetection.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(gradersawareofpestsandpestsigns)) {
            etGradersawareofpestsandpestsigns.setError("Field Required");
            return;
        } else {
            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setPackhousesanitationstatus(packhousesanitationstatus);
            farmInspectionBus.setQualitymanagementproceduresinplace2(qualitymanagementproceduresinplace);
            farmInspectionBus.setHowmanyqualitycontrolpoints(howmanyqualitycontrolpoints);
            farmInspectionBus.setQualitycontrolpersonnelonawareness(qualitycontrolpersonnelonawareness);
            farmInspectionBus.setAbilitytodetectpestsandpestsigns2(abilitytodetectpestsandpestsigns2);
            farmInspectionBus.setReportingchannelforpestdetection(reportingchannelforpestdetection);
            farmInspectionBus.setGradersawareofpestsandpestsigns(gradersawareofpestsandpestsigns);

            callback.goToNextStep();

        }

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


}
