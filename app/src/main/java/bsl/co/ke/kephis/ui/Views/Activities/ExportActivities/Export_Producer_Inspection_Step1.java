package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.annotation.SuppressLint;
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
import androidx.lifecycle.Observer;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.List;
import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.ProducerInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Producer_Inspection_Step1 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {



    @BindView(R.id.etfirmName)
    EditText etfirmName;

    private String firmName;
    KEPHIS app;
    DataBaseAdapter db;

    protected List<ProducerInspectionDetails> producerInspectionDetailssList;
    ProducerInspectionDetails producerInspectionDetails = new ProducerInspectionDetails();


    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_producer_inspection1_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        final Observer<ProducerInspectionDetails> observer = new Observer<ProducerInspectionDetails>() {
            @Override
            public void onChanged(ProducerInspectionDetails producerInspectionDetails) {
                producerInspectionDetails = producerInspectionDetails;

                System.out.println("Firm name passed " + producerInspectionDetails.getFirmName());

                firmName = producerInspectionDetails.getFirmName();

                etfirmName.setText(firmName);

                etfirmName.setEnabled(false);
                etfirmName.setFocusable(false);

            }
        };

        app.getProducerInspectionDetails().observe(this, observer);
        return view;


    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        firmName = Objects.requireNonNull(etfirmName.getText()).toString().trim();


        if (TextUtils.isEmpty(firmName)) {
            etfirmName.setError("Firm Required");
            return;
        } else {


            ProducerInspectionBus producerInspectionBus = ProducerInspectionBus.getInstance();
            producerInspectionBus.setFirmName(firmName);

            callback.goToNextStep();
        }


    }

    boolean validateSpinner(Spinner spinner, String error) {

        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            if (selectedTextView.getText().equals("Select Inspector")) {
                selectedTextView.setError(error);
                Toast.makeText(getActivity(), "Inspector Required", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
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




























