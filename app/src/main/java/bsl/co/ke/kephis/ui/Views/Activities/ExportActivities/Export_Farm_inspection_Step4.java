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

public class Export_Farm_inspection_Step4 extends Fragment implements BlockingStep {

    @BindView(R.id.etQualitymanagementproceduresinplace)
    EditText etQualitymanagementproceduresinplace;
    @BindView(R.id.etQualitycontrolchecksinplace)
    EditText etQualitycontrolchecksinplace;
    @BindView(R.id.etawarenessonpestsofconcern)
    EditText etawarenessonpestsofconcern;
    @BindView(R.id.etAbilityOfQualityControl)
    EditText etAbilityOfQualityControl;
    @BindView(R.id.etDetectedpestrecordsinplace)
    EditText etDetectedpestrecordsinplace;


    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;
    private Button btnnext;

    private FarmInspection farmInspection;

    KEPHIS app;
    DataBaseAdapter db;
    private String qualitymanagementproceduresinplace, qualitycontrolchecksinplace, awarenessonpestsofconcern, abilityOfQualityContro, detectedpestrecordsinplace;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection4_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        qualitymanagementproceduresinplace = Objects.requireNonNull(etQualitymanagementproceduresinplace.getText()).toString().trim();
        qualitycontrolchecksinplace = Objects.requireNonNull(etQualitycontrolchecksinplace.getText()).toString().trim();
        awarenessonpestsofconcern = Objects.requireNonNull(etawarenessonpestsofconcern.getText()).toString().trim();
        abilityOfQualityContro = Objects.requireNonNull(etAbilityOfQualityControl.getText()).toString().trim();
        detectedpestrecordsinplace = Objects.requireNonNull(etDetectedpestrecordsinplace.getText()).toString().trim();

        if (TextUtils.isEmpty(qualitymanagementproceduresinplace)) {
            etQualitymanagementproceduresinplace.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(qualitycontrolchecksinplace)) {
            etQualitycontrolchecksinplace.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(awarenessonpestsofconcern)) {
            etawarenessonpestsofconcern.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(abilityOfQualityContro)) {
            etAbilityOfQualityControl.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(detectedpestrecordsinplace)) {
            etDetectedpestrecordsinplace.setError("Field Required");
            return;
        } else {

            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setQualitymanagementproceduresinplace(qualitymanagementproceduresinplace);
            farmInspectionBus.setQualitycontrolchecksinplace(qualitycontrolchecksinplace);
            farmInspectionBus.setAwarenessonpestsofconcern(awarenessonpestsofconcern);
            farmInspectionBus.setAbilityOfQualityContro(abilityOfQualityContro);
            farmInspectionBus.setDetectedpestrecordsinplace(detectedpestrecordsinplace);


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
