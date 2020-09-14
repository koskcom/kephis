package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.FarmInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.County;
import bsl.co.ke.kephis.Pojo.FarmInspectionDetails;
import bsl.co.ke.kephis.Pojo.SubCounty;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.db.DatabaseHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Farm_inspection_Step2 extends Fragment implements BlockingStep {

    @BindView(R.id.etfarmname)
    EditText etfarmname;
    @BindView(R.id.ettraceability_code)
    EditText ettraceability_code;
    @BindView(R.id.etCounty)
    EditText etCounty;
    @BindView(R.id.etSubCounty)
    EditText etSubCounty;
    @BindView(R.id.etWard)
    EditText etWard;
    @BindView(R.id.etStreetName)
    EditText etStreetName;
    @BindView(R.id.etContactPerson)
    EditText etContactPerson;
    @BindView(R.id.etTown)
    EditText etTown;
    @BindView(R.id.etAreaunderproduction)
    EditText etAreaunderproduction;
    @BindView(R.id.etMarketdestination)
    EditText etMarketdestination;
    @BindView(R.id.isAwareOfMktRequirements)
    CheckBox isAwareOfMktRequirements;
    @BindView(R.id.etAcreage)
    EditText etAcreage;
    @BindView(R.id.etSourceofplantingmaterial)
    EditText etSourceofplantingmaterial;
    @BindView(R.id.etPresenceOfQualityAssurance)
    EditText etPresenceOfQualityAssurance;
    private String farmName, traceability_code, county, subCounty, ward, streetName, contactPerson, town, areaUnderProduction, marketDestination;
    private String isAwareOfmktRequirements, acreage, sourcesOfPlantingmateriial, presenceOfQualityAssurance;

    private DatabaseHelper databaseHelper;

    private ScrollView scrollView;

    KEPHIS app;
    DataBaseAdapter db;
    private Button btnnext;

    private ArrayList<String> cityList = new ArrayList<>();

    protected Handler asyncTaskHandler;
    private List<County> countyList = new ArrayList<>();
    private List<SubCounty> subCountyList = new ArrayList<>();

    FarmInspectionDetails farmInspectionDetails = new FarmInspectionDetails();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_farm_inspection2_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        isAwareOfMktRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAwareOfMktRequirements.isChecked()) {
                    isAwareOfmktRequirements = "Y";
                } else {
                    isAwareOfmktRequirements = "N";
                }
            }
        });


        final Observer<FarmInspectionDetails> observer = new Observer<FarmInspectionDetails>() {
            @Override
            public void onChanged(FarmInspectionDetails farmInspectionDetails) {
                farmInspectionDetails = farmInspectionDetails;

                System.out.println("Street name passed " + farmInspectionDetails.getStreetName());

                county = farmInspectionDetails.getCounty();
                subCounty = farmInspectionDetails.getSubCounty();

                if (!countyList.isEmpty()) {
                    for (County cnty : countyList) {
                        if (null != cnty.getCountyId() && cnty.getCountyId().equals(county)) {

                            etCounty.setText(cnty.getCountyName());

                            System.out.println(app + "County CountyID is " + cnty.getCountyId());
                        } else {
                            System.out.println(app + "County CountyID is null");
                        }
                    }
                } else {
                    System.out.println(app + "County countyList is null");
                }

                if (county != null && !county.isEmpty()) {
                    subCountyList = db.getAllSubCounty(county);
                    if (!subCountyList.isEmpty()) {
                        for (SubCounty subCnty : subCountyList) {
                            if (null != subCnty.getSubCountyId() && subCnty.getSubCountyId().equals(subCounty)) {

                                etSubCounty.setText(subCnty.getSubCountyName());
                            }
                        }
                    } else {
                        System.out.println(app + "SubCounty SubCountyID is null");
                    }
                } else {
                    System.out.println(app + "SubCounty CountyID is null");
                }

                farmName = farmInspectionDetails.getFarmName();
                traceability_code = farmInspectionDetails.getTraceability_code();
                //county = farmInspectionDetails.getCounty();
                //subCounty = farmInspectionDetails.getSubCounty();
                ward = farmInspectionDetails.getWard();
                streetName = farmInspectionDetails.getStreetName();
                contactPerson = farmInspectionDetails.getContactPerson();
                town = farmInspectionDetails.getTown();
                areaUnderProduction = farmInspectionDetails.getAreaUnderProduction();
                marketDestination = farmInspectionDetails.getMarketDestination();
                isAwareOfmktRequirements = farmInspectionDetails.getIsAwareOfmktRequirements();

                etfarmname.setText(farmName);
                ettraceability_code.setText(traceability_code);
                etCounty.setText(county);
                etSubCounty.setText(subCounty);
                etWard.setText(ward);
                etStreetName.setText(streetName);
                etContactPerson.setText(contactPerson);
                etTown.setText(town);
                etAreaunderproduction.setText(areaUnderProduction);
                etMarketdestination.setText(marketDestination);
                isAwareOfMktRequirements.setText(isAwareOfmktRequirements);

                etfarmname.setEnabled(false);
                ettraceability_code.setEnabled(false);
                etCounty.setEnabled(false);
                etSubCounty.setEnabled(false);
                etWard.setEnabled(false);
                etStreetName.setEnabled(false);
                etContactPerson.setEnabled(false);
                etTown.setEnabled(false);
                etAreaunderproduction.setEnabled(false);
                etMarketdestination.setEnabled(false);
                isAwareOfMktRequirements.setEnabled(false);

                etfarmname.setFocusable(false);
                ettraceability_code.setFocusable(false);
                etCounty.setFocusable(false);
                etSubCounty.setFocusable(false);
                etWard.setFocusable(false);
                etStreetName.setFocusable(false);
                etContactPerson.setFocusable(false);
                etTown.setFocusable(false);
                etAreaunderproduction.setFocusable(false);
                etMarketdestination.setFocusable(false);
                isAwareOfMktRequirements.setFocusable(false);

            }
        };
        app.getFarmInspectionDetails().observe(getActivity(), observer);


        return view;


    }


    public void postDataToSQLite() {

        // }

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        farmName = Objects.requireNonNull(etfarmname.getText()).toString().trim();
        traceability_code = Objects.requireNonNull(ettraceability_code.getText()).toString().trim();
        county = Objects.requireNonNull(etCounty.getText()).toString().trim();
        subCounty = Objects.requireNonNull(etSubCounty.getText()).toString().trim();
        ward = Objects.requireNonNull(etWard.getText()).toString().trim();
        streetName = Objects.requireNonNull(etStreetName.getText()).toString().trim();
        contactPerson = Objects.requireNonNull(etContactPerson.getText()).toString().trim();
        town = Objects.requireNonNull(etTown.getText()).toString().trim();
        areaUnderProduction = Objects.requireNonNull(etAreaunderproduction.getText()).toString().trim();
        marketDestination = Objects.requireNonNull(etMarketdestination.getText()).toString().trim();
        acreage = Objects.requireNonNull(etAcreage.getText()).toString().trim();
        sourcesOfPlantingmateriial = Objects.requireNonNull(etSourceofplantingmaterial.getText()).toString().trim();
        presenceOfQualityAssurance = Objects.requireNonNull(etPresenceOfQualityAssurance.getText()).toString().trim();

     /*   if (TextUtils.isEmpty(farmName)) {
            etfarmname.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(traceability_code)) {
            ettraceability_code.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(county)) {
            etCounty.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(subCounty)) {
            etSubCounty.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(ward)) {
            etWard.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(streetName)) {
            etStreetName.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(contactPerson)) {
            etContactPerson.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(contactPerson)) {
            etContactPerson.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(town)) {
            etTown.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(areaUnderProduction)) {
            etAreaunderproduction.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(marketDestination)) {
            etMarketdestination.setError("Field Required");
            return;
        }*/
        if (TextUtils.isEmpty(acreage)) {
            etAcreage.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(sourcesOfPlantingmateriial)) {
            etSourceofplantingmaterial.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(presenceOfQualityAssurance)) {
            etPresenceOfQualityAssurance.setError("Field Required");
            return;
        } else {


            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();

            farmInspectionBus.setFarmName(farmName);
            farmInspectionBus.setTraceability_code(traceability_code);
            farmInspectionBus.setCounty(county);
            farmInspectionBus.setSubCounty(subCounty);
            farmInspectionBus.setWard(ward);
            farmInspectionBus.setStreetName(streetName);
            farmInspectionBus.setContactPerson(contactPerson);
            farmInspectionBus.setTown(town);
            farmInspectionBus.setAreaUnderProduction(areaUnderProduction);
            farmInspectionBus.setMarketDestination(marketDestination);
            farmInspectionBus.setAcreage(acreage);
            farmInspectionBus.setIsAwareOfmktRequirements(isAwareOfmktRequirements);
            farmInspectionBus.setSourcesOfPlantingmateriial(sourcesOfPlantingmateriial);
            farmInspectionBus.setPresenceOfQualityAssurance(presenceOfQualityAssurance);
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