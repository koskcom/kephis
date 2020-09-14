package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.ProducerInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Producer_Inspection_Step2 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.etstreetname)
    EditText etstreetname;
    @BindView(R.id.etpostalAddres)
    EditText etpostalAddres;

    @BindView(R.id.etpostalCode)
    EditText etpostalCode;
    @BindView(R.id.etTown)
    EditText etTown;

    @BindView(R.id.etCountry)
    EditText etCountry;
    @BindView(R.id.ettelephoneNo)
    EditText ettelephoneNo;

    @BindView(R.id.etPIN)
    EditText etPIN;

    KEPHIS app;
    DataBaseAdapter db;

    private String streetName, postalAddres, postalCode, town, country, telephoneNo, pin;


    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_producer_inspection2_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        final Observer<ProducerInspectionDetails> observer = new Observer<ProducerInspectionDetails>() {
            @Override
            public void onChanged(ProducerInspectionDetails producerInspectionDetails) {
                producerInspectionDetails = producerInspectionDetails;

                System.out.println("Street name passed " + producerInspectionDetails.getStreetName());


                streetName = producerInspectionDetails.getStreetName();
                postalAddres = producerInspectionDetails.getPostalAddres();
                postalCode = producerInspectionDetails.getPostalCode();
                town = producerInspectionDetails.getTown();
                country = producerInspectionDetails.getCountry();
                telephoneNo = producerInspectionDetails.getTelephoneNo();
                pin = producerInspectionDetails.getPin();

                etstreetname.setText(streetName);
                etpostalAddres.setText(postalAddres);
                etpostalAddres.setText(postalCode);
                etTown.setText(town);
                etCountry.setText(country);
                ettelephoneNo.setText(telephoneNo);
                etPIN.setText(pin);

                etstreetname.setEnabled(false);
                etpostalAddres.setEnabled(false);
                etpostalAddres.setEnabled(false);
                etTown.setEnabled(false);
                etCountry.setEnabled(false);
                ettelephoneNo.setEnabled(false);
                etPIN.setEnabled(false);

                etstreetname.setFocusable(false);
                etpostalAddres.setFocusable(false);
                etpostalAddres.setFocusable(false);
                etTown.setFocusable(false);
                etCountry.setFocusable(false);
                ettelephoneNo.setFocusable(false);
                etPIN.setFocusable(false);
            }
        };
        app.getProducerInspectionDetails().observe(this, observer);
        return view;


    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        streetName = Objects.requireNonNull(etstreetname.getText()).toString().trim();
        postalAddres = Objects.requireNonNull(etpostalAddres.getText()).toString().trim();
        postalCode = Objects.requireNonNull(etpostalCode.getText()).toString().trim();
        town = Objects.requireNonNull(etTown.getText()).toString().trim();
        country = Objects.requireNonNull(etCountry.getText()).toString().trim();
        telephoneNo = Objects.requireNonNull(ettelephoneNo.getText()).toString().trim();
        pin = Objects.requireNonNull(etPIN.getText()).toString().trim();


       /* if (TextUtils.isEmpty(streetName)) {
            etstreetname.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(postalAddres)) {
            etpostalAddres.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(postalCode)) {
            etpostalCode.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(town)) {
            etTown.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(country)) {
            etCountry.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(telephoneNo)) {
            ettelephoneNo.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(pin)) {
            etPIN.setError("Field Required");
            return;
        } else {
*/
        ProducerInspectionBus producerInspectionBus = ProducerInspectionBus.getInstance();
        producerInspectionBus.setStreetName(streetName);
        producerInspectionBus.setPostalAddres(postalAddres);
        producerInspectionBus.setPostalCode(postalCode);
        producerInspectionBus.setTown(town);
        producerInspectionBus.setCountry(country);
        producerInspectionBus.setTelephoneNo(telephoneNo);
        producerInspectionBus.setPin(pin);


        callback.goToNextStep();
        //  }



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
























