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

public class Export_Farm_inspection_Step7  extends Fragment implements BlockingStep {

    @BindView(R.id.etAwarenesspestsofconcern)
    EditText etAwarenesspestsofconcern;
    @BindView(R.id.etTrainingonpestsofconcern)
    EditText etTrainingonpestsofconcern;
    @BindView(R.id.etAbilitytodetectpestsandpestsigns)
    EditText etAbilitytodetectpestsandpestsigns;
    @BindView(R.id.etRoleinpestreportingsystem)
    EditText etRoleinpestreportingsystem;


    private String awarenesspestsofconcern, trainingonpestsofconcern, abilitytodetectpestsandpestsigns, roleinpestreportingsystem;

    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;

    private Button btnnext;
    private FarmInspection farmInspection;

    KEPHIS app;
    DataBaseAdapter db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection7_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        awarenesspestsofconcern = Objects.requireNonNull(etAwarenesspestsofconcern.getText()).toString().trim();
        trainingonpestsofconcern = Objects.requireNonNull(etTrainingonpestsofconcern.getText()).toString().trim();
        abilitytodetectpestsandpestsigns = Objects.requireNonNull(etAbilitytodetectpestsandpestsigns.getText()).toString().trim();
        roleinpestreportingsystem = Objects.requireNonNull(etRoleinpestreportingsystem.getText()).toString().trim();

        if (TextUtils.isEmpty(awarenesspestsofconcern)) {
            etAwarenesspestsofconcern.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(trainingonpestsofconcern)) {
            etTrainingonpestsofconcern.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(abilitytodetectpestsandpestsigns)) {
            etAbilitytodetectpestsandpestsigns.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(roleinpestreportingsystem)) {
            etRoleinpestreportingsystem.setError("Field Required");
            return;
        } else {
            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setAwarenesspestsofconcern(awarenesspestsofconcern);
            farmInspectionBus.setTrainingonpestsofconcern(trainingonpestsofconcern);
            farmInspectionBus.setAbilitytodetectpestsandpestsigns(abilitytodetectpestsandpestsigns);
            farmInspectionBus.setRoleinpestreportingsystem(roleinpestreportingsystem);

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
