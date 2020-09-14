package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.FacilityInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.CBPartner;
import bsl.co.ke.kephis.Pojo.FacilityInspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportStepperActivities.FacilityActivity;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ListAdapters.FacilityInspectionAdapter;
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityFacilityListView extends AppCompatActivity {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;
    private String documentNumber, documentDate, nameOfApplicant, Licenceno, localID;

    private String personInCharge, postalAdrress, streetName, telephoneNumber, postalCode, town, country, commodity, capacityDimensionsinfeet;

    DataBaseAdapter db;
    KEPHIS app;
    private GPSTracker mGPS;
    protected Handler asyncTaskHandler;
    String cbPartnerID;
    FacilityInspectionAdapter adapter;
    Context ctx;
    SwipeRefreshLayout swipeLayout;

    private RelativeLayout relativeLayout;

    ListView itemsList;
    private ArrayList<FacilityInspectionDetails> facilityInspectionDetailsArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_facility);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());


        getFacilityInspectionDetailsList();

    }

    private void getFacilityInspectionDetailsList() {
        //Creating a list view items
        ListView list = (ListView) findViewById(R.id.itemsList);
        facilityInspectionDetailsArrayList.clear();
        facilityInspectionDetailsArrayList.removeAll(facilityInspectionDetailsArrayList);
        List<FacilityInspectionDetails> facilityInspectionDetailslist = db.getFacilityInspectionDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = facilityInspectionDetailslist.size();
        System.out.println(listSize + "===============facility inspection==========");

        for (int i = 0; i < facilityInspectionDetailslist.size(); i++) {
            System.out.println("Document Number=== " + facilityInspectionDetailslist.get(i).getDocumentNumber());
            System.out.println("telephone Number=== " + facilityInspectionDetailslist.get(i).getTelephoneNumber());
            System.out.println("town === " + facilityInspectionDetailslist.get(i).getTown());
            System.out.println("street name=== " + facilityInspectionDetailslist.get(i).getStreetName());
            System.out.println("commodity=== " + facilityInspectionDetailslist.get(i).getCommodity());
            System.out.println("country=== " + facilityInspectionDetailslist.get(i).getCountry());
            System.out.println("capacity=== " + facilityInspectionDetailslist.get(i).getCapacityDimensionsinfeet());
            System.out.println("potal address=== " + facilityInspectionDetailslist.get(i).getPostalAdrress());
            System.out.println("postal code=== " + facilityInspectionDetailslist.get(i).getPostalCode());

            String retreivedDocumentDate = facilityInspectionDetailslist.get(i).getDocumentDate();

            cbPartnerID = facilityInspectionDetailslist.get(i).getNameOfApplicant();

            for (CBPartner partner : cbPartnerList) {
                if (null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())) {
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else {
                    //System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                facilityInspectionDetailsArrayList.add(new FacilityInspectionDetails(
                        facilityInspectionDetailslist.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        facilityInspectionDetailslist.get(i).getLicenceNumber(),
                        facilityInspectionDetailslist.get(i).getNameOfapplicant(),
                        facilityInspectionDetailslist.get(i).getPersonInCharge(),
                        facilityInspectionDetailslist.get(i).getPostalAdrress(),
                        facilityInspectionDetailslist.get(i).getStreetName(),
                        facilityInspectionDetailslist.get(i).getTelephoneNumber(),
                        facilityInspectionDetailslist.get(i).getPostalCode(),
                        facilityInspectionDetailslist.get(i).getTown(),
                        facilityInspectionDetailslist.get(i).getCountry(),
                        facilityInspectionDetailslist.get(i).getCommodity(),
                        facilityInspectionDetailslist.get(i).getCapacityDimensionsinfeet()));
            }
            localhash.put(i, facilityInspectionDetailslist.get(i).getLocalID());
            adapter = new FacilityInspectionAdapter(getApplicationContext(), facilityInspectionDetailsArrayList);
            list.setAdapter(adapter);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocumentdate);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicenceNo);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewNameOfApplicant);

                documentNumber = facilityInspectionDetailsArrayList.get(position).getDocumentNumber();
                documentDate = facilityInspectionDetailsArrayList.get(position).getDocumentDate();
                Licenceno = facilityInspectionDetailsArrayList.get(position).getLicenceNumber();
                nameOfApplicant = facilityInspectionDetailsArrayList.get(position).getNameOfApplicant();
                localID = localhash.get(position);


                personInCharge = facilityInspectionDetailsArrayList.get(position).getPersonInCharge();
                postalAdrress = facilityInspectionDetailsArrayList.get(position).getPostalAdrress();
                streetName = facilityInspectionDetailsArrayList.get(position).getStreetName();
                postalCode = facilityInspectionDetailsArrayList.get(position).getPostalCode();
                telephoneNumber = facilityInspectionDetailsArrayList.get(position).getTelephoneNumber();
                postalCode = facilityInspectionDetailsArrayList.get(position).getPostalCode();
                town = facilityInspectionDetailsArrayList.get(position).getTown();
                country = facilityInspectionDetailsArrayList.get(position).getCountry();
                commodity = facilityInspectionDetailsArrayList.get(position).getCommodity();
                capacityDimensionsinfeet = facilityInspectionDetailsArrayList.get(position).getCapacityDimensionsinfeet();

                db.unselectFacilityInspectionDetails();
                db.selectFacilityInspectionDetails(localID);
                app.getFacilityInspectionDetails().setValue(facilityInspectionDetailsArrayList.get(position));

                navgate();
            }
        });
    }

    public void navgate() {

        if (localID != null && !localID.isEmpty()) {
            FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();
            facilityInspectionBus.setDocument_number(documentNumber);
            facilityInspectionBus.setDocument_date(documentDate);
            facilityInspectionBus.setLicence_number(Licenceno);
            facilityInspectionBus.setApplicant_name(nameOfApplicant);
            facilityInspectionBus.setPersonInCharge(personInCharge);
            facilityInspectionBus.setPostalAdrress(postalAdrress);
            facilityInspectionBus.setStreetName(streetName);
            facilityInspectionBus.setTelephoneNumber(telephoneNumber);
            facilityInspectionBus.setPostalCode(postalCode);
            facilityInspectionBus.setTown(town);
            facilityInspectionBus.setCountry(country);
            facilityInspectionBus.setCommodity(commodity);
            facilityInspectionBus.setCapacityDimensionsinfeet(capacityDimensionsinfeet);
            facilityInspectionBus.setLocalID(localID);
            new onNextClicked().execute();

        } else {
            Toast.makeText(app, "No Item Selected", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private class onNextClicked extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mprogress = new ProgressDialog(ActivityFacilityListView.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogress.show();
            mprogress.setMessage("Saving Data...Continue...");
            mprogress.setCancelable(true);
            mprogress.setIndeterminate(false);

        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(700);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {

            if (mprogress.isShowing()) {
                mprogress.dismiss();
            }
            runOnUiThread(new Runnable() {
                public void run() {
                    Intent intent = new Intent(ActivityFacilityListView.this, FacilityActivity.class);
                    startActivity(intent);


                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();

        finish();
        return true;
    }

}
