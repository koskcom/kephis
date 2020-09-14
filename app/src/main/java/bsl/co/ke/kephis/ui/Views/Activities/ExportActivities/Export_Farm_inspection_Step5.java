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

public class Export_Farm_inspection_Step5 extends Fragment implements BlockingStep {

    @BindView(R.id.etTrainingandexperience)
    EditText etTrainingandexperience;
    @BindView(R.id.etAbilityToIdentifyPest)
    EditText etAbilityToIdentifyPest;
    @BindView(R.id.etAreascoutedperday)
    EditText etAreascoutedperday;
    @BindView(R.id.etFrequencyOfScouting)
    EditText etFrequencyOfScouting;
    @BindView(R.id.etScoutinghasscoutingsheetsbook)
    EditText etScoutinghasscoutingsheetsbook;
    @BindView(R.id.etScoutingtoolsused)
    EditText etScoutingtoolsused;
    @BindView(R.id.etPestsconcerncapturedrecords)
    EditText etPestsconcerncapturedrecords;
    @BindView(R.id.etScoutingreportingchannels)
    EditText etScoutingreportingchannels;

    private String trainingandexperience, abilityToIdentifyPest, areascoutedperday, frequencyOfScouting2, scoutinghasscoutingsheetsbook, scoutingtoolsused, pestsconcerncapturedrecords, scoutingreportingchannels;

    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;

    private Button btnnext;
    private FarmInspection farmInspection;

    KEPHIS app;
    DataBaseAdapter db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection5_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        trainingandexperience = Objects.requireNonNull(etTrainingandexperience.getText()).toString().trim();
        abilityToIdentifyPest = Objects.requireNonNull(etAbilityToIdentifyPest.getText()).toString().trim();
        areascoutedperday = Objects.requireNonNull(etAreascoutedperday.getText()).toString().trim();
        frequencyOfScouting2 = Objects.requireNonNull(etFrequencyOfScouting.getText()).toString().trim();
        scoutinghasscoutingsheetsbook = Objects.requireNonNull(etScoutinghasscoutingsheetsbook.getText()).toString().trim();
        scoutingtoolsused = Objects.requireNonNull(etScoutingtoolsused.getText()).toString().trim();
        pestsconcerncapturedrecords = Objects.requireNonNull(etPestsconcerncapturedrecords.getText()).toString().trim();
        scoutingreportingchannels = Objects.requireNonNull(etScoutingreportingchannels.getText()).toString().trim();

        if (TextUtils.isEmpty(trainingandexperience)) {
            etTrainingandexperience.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(abilityToIdentifyPest)) {
            etAbilityToIdentifyPest.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(areascoutedperday)) {
            etAreascoutedperday.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(frequencyOfScouting2)) {
            etFrequencyOfScouting.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(scoutinghasscoutingsheetsbook)) {
            etScoutinghasscoutingsheetsbook.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(scoutingtoolsused)) {
            etScoutingtoolsused.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(pestsconcerncapturedrecords)) {
            etPestsconcerncapturedrecords.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(scoutingreportingchannels)) {
            etScoutingreportingchannels.setError("Field Required");
            return;
        } else {
            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setTrainingandexperience(trainingandexperience);
            farmInspectionBus.setAbilityToIdentifyPest(abilityToIdentifyPest);
            farmInspectionBus.setAreascoutedperday(areascoutedperday);
            farmInspectionBus.setFrequencyOfscouting2(frequencyOfScouting2);
            farmInspectionBus.setScoutinghasscoutingsheetsbook(scoutinghasscoutingsheetsbook);
            farmInspectionBus.setScoutingtoolsused(scoutingtoolsused);
            farmInspectionBus.setPestsconcerncapturedrecords(pestsconcerncapturedrecords);
            farmInspectionBus.setScoutingreportingchannels(scoutingreportingchannels);

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
