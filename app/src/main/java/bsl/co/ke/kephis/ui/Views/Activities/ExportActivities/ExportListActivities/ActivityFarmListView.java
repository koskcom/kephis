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
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.FarmInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.CBPartner;
import bsl.co.ke.kephis.Pojo.FarmInspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportStepperActivities.FarmActivity;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ListAdapters.FarmInspectionAdapter;
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityFarmListView extends AppCompatActivity {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;
    private String documentNumber, documentDate, nameOfApplicant, Licenceno, localID;

    private String farmName, traceability_code, county, subCounty, ward, streetName, contactPerson, town, areaUnderProduction, marketDestination;
    private String isAwareOfmktRequirements, acreage, sourcesOfPlantingmateriial, presenceOfQualityAssurance;

    DataBaseAdapter db;
    KEPHIS app;
    private GPSTracker mGPS;
    protected Handler asyncTaskHandler;
    String cbPartnerID;
    FarmInspectionAdapter adapter;
    Context ctx;

    private RelativeLayout relativeLayout;

    ListView itemsList;

    private ArrayList<FarmInspectionDetails> farmInspectionDetailsArrayList = new ArrayList<FarmInspectionDetails>();
    private HashMap<Integer, String> localhash = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());

        Button btnnext = (Button) findViewById(R.id.btnnext);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        getFamrInspectionList();
        /*btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new onNextClicked().execute();

            }
        });*/

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int arg2, long arg3) {
                 Intent intent = new Intent(ActivityFarmListView.this, Export_Farm_inspection_Step1.class);
                 startActivity(intent);
            }
        });*/

    }


    private void getFamrInspectionList() {
        //Creating a list view items
        ListView list = (ListView) findViewById(R.id.itemsList);
        farmInspectionDetailsArrayList.clear();

        List<FarmInspectionDetails> farmInspectionDetailslist = db.getFarmInspectionDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = farmInspectionDetailslist.size();
        System.out.println(listSize + "===============farm inspection==========");

        for (int i = 0; i < farmInspectionDetailslist.size(); i++) {
            System.out.println("Document Number=== " + farmInspectionDetailslist.get(i).getDocumentNumber());

            String retreivedDocumentDate = farmInspectionDetailslist.get(i).getDocumentDate();

            cbPartnerID = farmInspectionDetailslist.get(i).getNameOfApplicant();

            for (CBPartner partner : cbPartnerList) {
                if (null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())) {
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else {
                    //System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                farmInspectionDetailsArrayList.add(new FarmInspectionDetails(
                        farmInspectionDetailslist.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        farmInspectionDetailslist.get(i).getLicenceNumber(),
                        farmInspectionDetailslist.get(i).getFarmName(),
                        farmInspectionDetailslist.get(i).getTraceability_code(),
                        farmInspectionDetailslist.get(i).getCounty(),
                        farmInspectionDetailslist.get(i).getSubCounty(),
                        farmInspectionDetailslist.get(i).getWard(),
                        farmInspectionDetailslist.get(i).getStreetName(),
                        farmInspectionDetailslist.get(i).getContactPerson(),
                        farmInspectionDetailslist.get(i).getTown(),
                        farmInspectionDetailslist.get(i).getAreaUnderProduction(),
                        farmInspectionDetailslist.get(i).getMarketDestination(),
                        farmInspectionDetailslist.get(i).getIsAwareOfmktRequirements()
                ));
            }
            localhash.put(i, farmInspectionDetailslist.get(i).getLocalID());
            adapter = new FarmInspectionAdapter(this, farmInspectionDetailsArrayList);
            list.setAdapter(adapter);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocumentdate);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicenceNo);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewNameOfApplicant);

                documentNumber = farmInspectionDetailslist.get(position).getDocumentNumber();
                documentDate = farmInspectionDetailslist.get(position).getDocumentDate();
                Licenceno = farmInspectionDetailslist.get(position).getLicenceNumber();
                nameOfApplicant = farmInspectionDetailslist.get(position).getNameOfApplicant();
                localID = localhash.get(position);


                farmName = farmInspectionDetailslist.get(position).getFarmName();
                traceability_code = farmInspectionDetailslist.get(position).getTraceability_code();
                county = farmInspectionDetailslist.get(position).getCounty();
                subCounty = farmInspectionDetailslist.get(position).getSubCounty();
                ward = farmInspectionDetailslist.get(position).getWard();
                streetName = farmInspectionDetailslist.get(position).getStreetName();
                contactPerson = farmInspectionDetailslist.get(position).getContactPerson();
                town = farmInspectionDetailslist.get(position).getTown();
                areaUnderProduction = farmInspectionDetailslist.get(position).getAreaUnderProduction();
                marketDestination = farmInspectionDetailslist.get(position).getMarketDestination();
                isAwareOfmktRequirements = farmInspectionDetailslist.get(position).getIsAwareOfmktRequirements();

                db.unselectFarmInspectionDetails();
                db.selectFarmInspectionDetails(localID);
                app.getFarmInspectionDetails().setValue(farmInspectionDetailslist.get(position));


                navgate();
            }
        });

    }

    public void navgate() {
        if (localID != null && !localID.isEmpty()) {
            FarmInspectionBus farmInspectionBus = FarmInspectionBus.getInstance();
            farmInspectionBus.setDocument_number(documentNumber);
            farmInspectionBus.setDocument_date(documentDate);
            farmInspectionBus.setLicence_number(Licenceno);
            farmInspectionBus.setApplicant_name(nameOfApplicant);

            farmInspectionBus.setFarmName(farmName);
            farmInspectionBus.setTraceability_code(traceability_code);
            farmInspectionBus.setCounty(county);
            farmInspectionBus.setSubCounty(subCounty);
            farmInspectionBus.setWard(ward);
            farmInspectionBus.setStreetName(streetName);
            farmInspectionBus.setContactPerson(contactPerson);
            farmInspectionBus.setTown(town);
            farmInspectionBus.setMarketDestination(marketDestination);
            farmInspectionBus.setIsAwareOfmktRequirements(isAwareOfmktRequirements);


            farmInspectionBus.setLocalID(localID);
            new onNextClicked().execute();

        } else {
            new onNextClicked().execute();
            Toast.makeText(app, "No Item Selected", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private class onNextClicked extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mprogress = new ProgressDialog(ActivityFarmListView.this);

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
                    Intent intent = new Intent(ActivityFarmListView.this, FarmActivity.class);
                    startActivity(intent);


                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }
}
