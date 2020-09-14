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

public class Export_Farm_inspection_Step9 extends Fragment implements BlockingStep {

    @BindView(R.id.etAppropriatehygieneprotocolsinplace)
    EditText etAppropriatehygieneprotocolsinplace;
    @BindView(R.id.etQualityassurancepersonnelPostHarvest)
    EditText etQualityassurancepersonnelPostHarvest;
    @BindView(R.id.etQualityassurancepersonnelmarketrequirement)
    EditText etQualityassurancepersonnelmarketrequirement;
    @BindView(R.id.etTraceabilitysystemused)
    EditText etTraceabilitysystemused;
    @BindView(R.id.etTraceabilitysystemusedtowhatlevel)
    EditText etTraceabilitysystemusedtowhatlevel;
    @BindView(R.id.etTransportofproducefromfarm)
    EditText etTransportofproducefromfarm;

    private String appropriatehygieneprotocolsinplace, qualityassurancepersonnelPostHarvest, qualityassurancepersonnelmarketrequirement, traceabilitysystemused, traceabilitysystemusedtowhatlevel, transportofproducefromfarm;

    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;

    private Button btnnext;
    private FarmInspection farmInspection;


    KEPHIS app;
    DataBaseAdapter db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection9_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        appropriatehygieneprotocolsinplace = Objects.requireNonNull(etAppropriatehygieneprotocolsinplace.getText()).toString().trim();
        qualityassurancepersonnelPostHarvest = Objects.requireNonNull(etQualityassurancepersonnelPostHarvest.getText()).toString().trim();
        qualityassurancepersonnelmarketrequirement = Objects.requireNonNull(etQualityassurancepersonnelmarketrequirement.getText()).toString().trim();
        traceabilitysystemused = Objects.requireNonNull(etTraceabilitysystemused.getText()).toString().trim();
        traceabilitysystemusedtowhatlevel = Objects.requireNonNull(etTraceabilitysystemusedtowhatlevel.getText()).toString().trim();
        transportofproducefromfarm = Objects.requireNonNull(etTransportofproducefromfarm.getText()).toString().trim();

        if (TextUtils.isEmpty(appropriatehygieneprotocolsinplace)) {
            etAppropriatehygieneprotocolsinplace.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(qualityassurancepersonnelPostHarvest)) {
            etQualityassurancepersonnelPostHarvest.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(qualityassurancepersonnelmarketrequirement)) {
            etQualityassurancepersonnelmarketrequirement.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(traceabilitysystemused)) {
            etTraceabilitysystemused.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(traceabilitysystemusedtowhatlevel)) {
            etTraceabilitysystemusedtowhatlevel.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(transportofproducefromfarm)) {
            etTransportofproducefromfarm.setError("Field Required");
            return;
        } else {
            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setAppropriatehygieneprotocolsinplace(appropriatehygieneprotocolsinplace);
            farmInspectionBus.setQualityassurancepersonnelPostHarvest(qualityassurancepersonnelPostHarvest);
            farmInspectionBus.setQualityassurancepersonnelmarketrequirement(qualityassurancepersonnelmarketrequirement);
            farmInspectionBus.setTraceabilitysystemused(traceabilitysystemused);
            farmInspectionBus.setTraceabilitysystemusedtowhatlevel(traceabilitysystemusedtowhatlevel);
            farmInspectionBus.setTransportofproducefromfarm(transportofproducefromfarm);

            callback.goToNextStep();

        }

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {

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
