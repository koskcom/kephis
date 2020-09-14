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

public class Export_Farm_inspection_Step6 extends Fragment implements BlockingStep {

    @BindView(R.id.etAnypestsorpestsignsdetected)
    EditText etAnypestsorpestsignsdetected;
    @BindView(R.id.etPesttrapsinplace)
    EditText etPesttrapsinplace;
    @BindView(R.id.etAnypestsofconcerntrapped)
    EditText etAnypestsofconcerntrapped;
    @BindView(R.id.etGreenhousefarmsanitarystatus)
    EditText etGreenhousefarmsanitarystatus;

    private String anypestsorpestsignsdetected, pesttrapsinplace, anypestsofconcerntrapped, greenhousefarmsanitarystatus;

    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;

    private Button btnnext;
    private FarmInspection farmInspection;

    KEPHIS app;
    DataBaseAdapter db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection6_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }

    public void postDataToSQLite() {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        anypestsorpestsignsdetected = Objects.requireNonNull(etAnypestsorpestsignsdetected.getText()).toString().trim();
        pesttrapsinplace = Objects.requireNonNull(etPesttrapsinplace.getText()).toString().trim();
        anypestsofconcerntrapped = Objects.requireNonNull(etAnypestsofconcerntrapped.getText()).toString().trim();
        greenhousefarmsanitarystatus = Objects.requireNonNull(etGreenhousefarmsanitarystatus.getText()).toString().trim();

        if (TextUtils.isEmpty(anypestsorpestsignsdetected)) {
            etAnypestsorpestsignsdetected.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(pesttrapsinplace)) {
            etPesttrapsinplace.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(anypestsofconcerntrapped)) {
            etAnypestsofconcerntrapped.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(greenhousefarmsanitarystatus)) {
            etGreenhousefarmsanitarystatus.setError("Field Required");
            return;
        }  else {
            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setAnypestsorpestsignsdetected(anypestsorpestsignsdetected);
            farmInspectionBus.setPesttrapsinplace(pesttrapsinplace);
            farmInspectionBus.setAnypestsofconcerntrapped(anypestsofconcerntrapped);
            farmInspectionBus.setGreenhousefarmsanitarystatus(greenhousefarmsanitarystatus);

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
