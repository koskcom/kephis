package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.List;
import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.FacilityInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.FacilityInspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Facility_Inspection_step1 extends Fragment implements BlockingStep {

    @BindView(R.id.etPersonIncharge)
    EditText etPersonIncharge;
    @BindView(R.id.etPostalAddress)
    EditText etPostalAddress;
    @BindView(R.id.etStreetName)
    EditText etStreetName;
    @BindView(R.id.etTelephoneNumber)
    EditText etTelephoneNumber;
    @BindView(R.id.etpostalCode)
    EditText etpostalCode;
    @BindView(R.id.ettown)
    EditText ettown;
    @BindView(R.id.etcountry)
    EditText etcountry;
    @BindView(R.id.etCommodity)
    EditText etCommodity;
    @BindView(R.id.etcapacity_dimensions)
    EditText etcapacity_dimensions;

    KEPHIS app;
    DataBaseAdapter db;
    private String personInCharge, postalAdrress, streetName, telephoneNumber, postalCode, town, country, commodity, capacityDimensionsinfeet;

    protected List<FacilityInspectionDetails> facilityInspectionDetailsList;
    FacilityInspectionDetails facilityInspectionDetails = new FacilityInspectionDetails();


    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_facility_inspection1_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        final Observer<FacilityInspectionDetails> observer = new Observer<FacilityInspectionDetails>() {
            @Override
            public void onChanged(FacilityInspectionDetails facilityInspectionDetailsinspection) {
                facilityInspectionDetails = facilityInspectionDetailsinspection;

                System.out.println("person in charge passed >>>>>> " + facilityInspectionDetails.getPersonInCharge());


                personInCharge = facilityInspectionDetails.getPersonInCharge();
                postalAdrress = facilityInspectionDetails.getPostalAdrress();
                streetName = facilityInspectionDetails.getStreetName();
                telephoneNumber = facilityInspectionDetails.getTelephoneNumber();
                postalCode = facilityInspectionDetails.getPostalCode();
                streetName = facilityInspectionDetails.getStreetName();
                town = facilityInspectionDetails.getTown();
                country = facilityInspectionDetails.getCountry();
                commodity = facilityInspectionDetails.getCommodity();
                capacityDimensionsinfeet = facilityInspectionDetails.getCapacityDimensionsinfeet();

                etPersonIncharge.setText(personInCharge);
                etPostalAddress.setText(postalAdrress);
                etStreetName.setText(streetName);
                etTelephoneNumber.setText(telephoneNumber);
                etpostalCode.setText(postalCode);
                etStreetName.setText(streetName);
                ettown.setText(town);
                etcountry.setText(country);
                etCommodity.setText(commodity);
                etcapacity_dimensions.setText(capacityDimensionsinfeet);

              /*  etPersonIncharge.setEnabled(false);
                etPostalAddress.setEnabled(false);
                etStreetName.setEnabled(false);
                etTelephoneNumber.setEnabled(false);
                etpostalCode.setEnabled(false);
                etStreetName.setEnabled(false);
                ettown.setEnabled(false);
                etcountry.setEnabled(false);
                etCommodity.setEnabled(false);
                etcapacity_dimensions.setEnabled(false);*/

             /*   etPersonIncharge.setFocusable(false);
                etPostalAddress.setFocusable(false);
                etStreetName.setFocusable(false);
                etTelephoneNumber.setFocusable(false);
                etpostalCode.setFocusable(false);
                etStreetName.setFocusable(false);
                ettown.setFocusable(false);
                etcountry.setFocusable(false);
                etCommodity.setFocusable(false);
                etcapacity_dimensions.setFocusable(false);*/


            }
        };

        app.getFacilityInspectionDetails().observe(this, observer);
        return view;


    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
       /* personInCharge = Objects.requireNonNull(etPersonIncharge.getText()).toString().trim();
        postalAdrress = Objects.requireNonNull(etPostalAddress.getText()).toString().trim();
        streetName = Objects.requireNonNull(etStreetName.getText()).toString().trim();
        telephoneNumber = Objects.requireNonNull(etTelephoneNumber.getText()).toString().trim();
        postalCode = Objects.requireNonNull(etpostalCode.getText()).toString().trim();
        town = Objects.requireNonNull(ettown.getText()).toString().trim();
        country = Objects.requireNonNull(etcountry.getText()).toString().trim();
        commodity = Objects.requireNonNull(etCommodity.getText()).toString().trim();
        capacityDimensionsinfeet = Objects.requireNonNull(etcapacity_dimensions.getText()).toString().trim();*/


       /* if (TextUtils.isEmpty(personInCharge)) {
            etPersonIncharge.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(postalAdrress)) {
            etPostalAddress.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(streetName)) {
            etStreetName.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(telephoneNumber)) {
            etTelephoneNumber.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(postalCode)) {
            etpostalCode.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(town)) {
            ettown.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(country)) {
            etcountry.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(commodity)) {
            etCommodity.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(capacityDimensionsinfeet)) {
            etcapacity_dimensions.setError("Field Required");
            return;
        } else {

*/
        FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();

        facilityInspectionBus.setPersonInCharge(personInCharge);
        facilityInspectionBus.setPostalAdrress(postalAdrress);
        facilityInspectionBus.setStreetName(streetName);
        facilityInspectionBus.setTelephoneNumber(telephoneNumber);
        facilityInspectionBus.setPostalCode(postalCode);
        facilityInspectionBus.setTown(town);
        facilityInspectionBus.setCountry(country);
        facilityInspectionBus.setCommodity(commodity);
        facilityInspectionBus.setCapacityDimensionsinfeet(capacityDimensionsinfeet);

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


}


















