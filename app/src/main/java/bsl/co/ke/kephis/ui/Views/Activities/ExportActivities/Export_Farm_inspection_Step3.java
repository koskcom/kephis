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

public class Export_Farm_inspection_Step3 extends Fragment implements BlockingStep {

    @BindView(R.id.etDocumentedPestManagement)
    EditText etDocumentedPestManagement;
    @BindView(R.id.etNoOfScouts)
    EditText etNoOfScouts;
    @BindView(R.id.etTrainingExperienceOfscouts)
    EditText etTrainingExperienceOfscouts;
    @BindView(R.id.etAreaAllocatedToEachScout)
    EditText etAreaAllocatedToEachScout;
    @BindView(R.id.etPestMonitoringMethodsUsed)
    EditText etPestMonitoringMethodsUsed;
    @BindView(R.id.etScoutingmethodsused)
    EditText etScoutingmethodsused;
    @BindView(R.id.etFrequencyOfScouting)
    EditText etFrequencyOfScouting;
    @BindView(R.id.etScoutingrecordsavailable)
    EditText etScoutingrecordsavailable;
    @BindView(R.id.etPestreportingchannels)
    EditText etPestreportingchannels;
    @BindView(R.id.etPestcontrolmethodsused)
    EditText etPestcontrolmethodsused;
    @BindView(R.id.etSprayprogramsinplace)
    EditText etSprayprogramsinplace;


    private String documentedPestManagement, noOfScouts, trainingExperienceOfscouts, areaAllocatedToEachScout, pestMonitoringMethodsUsed, scoutingmethodsused;
    private String frequencyOfScouting, scoutingrecordsavailable, pestreportingchannels, pestcontrolmethodsused, sprayprogramsinplace;

    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;

    private Button btnnext;
    private FarmInspection farmInspection;

    KEPHIS app;
    DataBaseAdapter db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection3_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        documentedPestManagement = Objects.requireNonNull(etDocumentedPestManagement.getText()).toString().trim();
        noOfScouts = Objects.requireNonNull(etNoOfScouts.getText()).toString().trim();
        trainingExperienceOfscouts = Objects.requireNonNull(etTrainingExperienceOfscouts.getText()).toString().trim();
        areaAllocatedToEachScout = Objects.requireNonNull(etAreaAllocatedToEachScout.getText()).toString().trim();
        pestMonitoringMethodsUsed = Objects.requireNonNull(etPestMonitoringMethodsUsed.getText()).toString().trim();
        scoutingmethodsused = Objects.requireNonNull(etScoutingmethodsused.getText()).toString().trim();
        frequencyOfScouting = Objects.requireNonNull(etFrequencyOfScouting.getText()).toString().trim();
        scoutingrecordsavailable = Objects.requireNonNull(etScoutingrecordsavailable.getText()).toString().trim();
        pestreportingchannels = Objects.requireNonNull(etPestreportingchannels.getText()).toString().trim();
        pestcontrolmethodsused = Objects.requireNonNull(etPestcontrolmethodsused.getText()).toString().trim();
        sprayprogramsinplace = Objects.requireNonNull(etSprayprogramsinplace.getText()).toString().trim();

        if (TextUtils.isEmpty(documentedPestManagement)) {
            etDocumentedPestManagement.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(noOfScouts)) {
            etNoOfScouts.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(trainingExperienceOfscouts)) {
            etTrainingExperienceOfscouts.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(areaAllocatedToEachScout)) {
            etAreaAllocatedToEachScout.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(pestMonitoringMethodsUsed)) {
            etPestcontrolmethodsused.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(scoutingmethodsused)) {
            etScoutingmethodsused.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(frequencyOfScouting)) {
            etFrequencyOfScouting.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(scoutingrecordsavailable)) {
            etScoutingrecordsavailable.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(pestreportingchannels)) {
            etPestreportingchannels.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(pestcontrolmethodsused)) {
            etPestcontrolmethodsused.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(sprayprogramsinplace)) {
            etSprayprogramsinplace.setError("Field Required");
            return;
        } else {
            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setDocumentedPestManagement(documentedPestManagement);
            farmInspectionBus.setNoOfScouts(noOfScouts);
            farmInspectionBus.setTrainingExperienceOfscouts(trainingExperienceOfscouts);
            farmInspectionBus.setAreaAllocatedToEachScout(areaAllocatedToEachScout);
            farmInspectionBus.setPestMonitoringMethodsUsed(pestMonitoringMethodsUsed);
            farmInspectionBus.setScoutingmethodsused(scoutingmethodsused);
            farmInspectionBus.setFrequencyOfScouting(frequencyOfScouting);
            farmInspectionBus.setScoutingrecordsavailable(scoutingrecordsavailable);
            farmInspectionBus.setPestreportingchannels(pestreportingchannels);
            farmInspectionBus.setPestcontrolmethodsused(pestcontrolmethodsused);
            farmInspectionBus.setSprayprogramsinplace(sprayprogramsinplace);

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
