package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.ProducerInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;

import static bsl.co.ke.kephis.settings.Settings.hasPermissions;

public class Export_Producer_Inspection_Step3 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;

    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {
            Manifest.permission.INTERNET,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    @BindView(R.id.etsection_unit)
    EditText etsection_unit;
    @BindView(R.id.etDescription)
    EditText etDescription;


    private Button btnsave;
    private GPSTracker mGPS;
    KEPHIS app;
    DataBaseAdapter db;

    private String sectionUnit, description, latitude, longitude;


    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_producer_inspection3_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();

        mGPS = new GPSTracker(getActivity());


        return view;


    }


    public void postDataToSQLite() {


    }

    private void checkPermissions() {
        if (!hasPermissions(getActivity(), PERMISSIONS)) {
            ActivityCompat.requestPermissions(getActivity(), PERMISSIONS, PERMISSION_ALL);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        sectionUnit = Objects.requireNonNull(etsection_unit.getText()).toString().trim();
        description = Objects.requireNonNull(etDescription.getText()).toString().trim();


        if (TextUtils.isEmpty(sectionUnit)) {
            etsection_unit.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(description)) {
            etDescription.setError("Field Required");
            return;
        } else {

            ProducerInspectionBus producerInspectionBus = ProducerInspectionBus.getInstance();
            producerInspectionBus.setSectionUnit(sectionUnit);
            producerInspectionBus.setDescription(description);

            long isupdated = db.updateProducerInspectionn(producerInspectionBus.getLocalID(),
                    producerInspectionBus.getSinspector(),
                    producerInspectionBus.getSectionUnit(),
                    producerInspectionBus.getDescription(),
                    producerInspectionBus.getLatitude(),
                    producerInspectionBus.getLongitude());

            if (isupdated == 1) {
                Toast.makeText(getActivity(), "Updated", Toast.LENGTH_SHORT);
            } else {
                Toast.makeText(getActivity(), "Not updated", Toast.LENGTH_SHORT);
            }
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

}
