package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

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

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.ConsignmentIspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Consignment_Inspection_Step4 extends Fragment implements AdapterView.OnItemSelectedListener, BlockingStep {

    @BindView(R.id.etproducts)
    EditText etproducts;
    @BindView(R.id.etnetweight)
    EditText etnetweight;
    @BindView(R.id.etgrossweight)
    EditText etgrossweight;
    @BindView(R.id.etproductcategory)
    EditText etproductcategory;
    @BindView(R.id.etcommodityform)
    EditText etcommodityform;
    @BindView(R.id.etvariety)
    EditText etvariety;
    @BindView(R.id.etQuatity)
    EditText etQuatity;
    @BindView(R.id.etQuantityUnit)
    EditText etQuantityUnit;
    @BindView(R.id.etQuantityPassed)
    EditText etQuantityPassed;
    @BindView(R.id.etQuantityRejected)
    EditText etQuantityRejected;
    @BindView(R.id.etNumberofpackages)
    EditText etNumberofpackages;
    @BindView(R.id.etRejectedPackages)
    EditText etRejectedPackages;

    KEPHIS app;
    DataBaseAdapter db;
    private String products, netWeight, grossWeiight, productCategory, commodityForm, variety, quantity, quantityUnit, quantityPassed, quantityRejected;
    private String numberofpackages, rejectedPackages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_consignment_inspection4_records, container, false);
        ButterKnife.bind(this, view);


        app = (KEPHIS) Objects.requireNonNull(getActivity()).getApplication();

        db = new DataBaseAdapter(getContext()).open();


        return view;


    }


    public void postDataToSQLite() {


    }

    boolean validateSpinner(Spinner spinner, String error) {

        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            if (selectedTextView.getText().equals("Select")) {
                selectedTextView.setError(error);
                Toast.makeText(getActivity(), "Field Required", Toast.LENGTH_SHORT).show();

                return false;
            }
        }
        return true;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        products = Objects.requireNonNull(etproducts.getText()).toString().trim();
        netWeight = Objects.requireNonNull(etnetweight.getText()).toString().trim();
        grossWeiight = Objects.requireNonNull(etgrossweight.getText()).toString().trim();
        productCategory = Objects.requireNonNull(etproductcategory.getText()).toString().trim();
        commodityForm = Objects.requireNonNull(etcommodityform.getText()).toString().trim();
        variety = Objects.requireNonNull(etvariety.getText()).toString().trim();
        quantity = Objects.requireNonNull(etQuatity.getText()).toString().trim();
        quantityUnit = Objects.requireNonNull(etQuantityUnit.getText()).toString().trim();
        quantityPassed = Objects.requireNonNull(etQuantityPassed.getText()).toString().trim();
        quantityRejected = Objects.requireNonNull(etQuantityRejected.getText()).toString().trim();
        numberofpackages = Objects.requireNonNull(etNumberofpackages.getText()).toString().trim();
        rejectedPackages = Objects.requireNonNull(etRejectedPackages.getText()).toString().trim();

        if (TextUtils.isEmpty(products)) {
            etproducts.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(netWeight)) {
            etnetweight.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(grossWeiight)) {
            etgrossweight.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(productCategory)) {
            etproductcategory.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(commodityForm)) {
            etcommodityform.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(variety)) {
            etvariety.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(quantity)) {
            etQuatity.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(quantityUnit)) {
            etQuantityUnit.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(quantityPassed)) {
            etQuantityPassed.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(quantityRejected)) {
            etQuantityRejected.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(numberofpackages)) {
            etNumberofpackages.setError("Field Required");
            return;
        } else if (TextUtils.isEmpty(rejectedPackages)) {
            etRejectedPackages.setError("Field Required");
            return;
        } else {

            ConsignmentIspectionBus consignmentIspectionBus = ConsignmentIspectionBus.getInstance();
            consignmentIspectionBus.setProducts(products);
            consignmentIspectionBus.setNetWeight(netWeight);
            consignmentIspectionBus.setGrossWeiight(grossWeiight);
            consignmentIspectionBus.setProductCategory(productCategory);
            consignmentIspectionBus.setCommodityForm(commodityForm);
            consignmentIspectionBus.setVariety(variety);
            consignmentIspectionBus.setQuantity(quantity);
            consignmentIspectionBus.setQuantityUnit(quantityUnit);
            consignmentIspectionBus.setQuantityPassed(quantityPassed);
            consignmentIspectionBus.setQuantityRejected(quantityRejected);
            consignmentIspectionBus.setNumberofpackages(numberofpackages);
            consignmentIspectionBus.setRejectedPackages(rejectedPackages);


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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

