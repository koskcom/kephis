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
import bsl.co.ke.kephis.Pojo.ConsignmentIspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportStepperActivities.ConsignmentActivity;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ListAdapters.ConsignmentInspectionAdapter;
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityConsignmentListView extends AppCompatActivity {


    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;
    private String documentNumber, documentDate, nameOfApplicant, Licenceno, localID;

    DataBaseAdapter db;
    KEPHIS app;
    private GPSTracker mGPS;
    protected Handler asyncTaskHandler;
    String cbPartnerID;
    ConsignmentInspectionAdapter adapter;
    Context ctx;
    SwipeRefreshLayout swipeRefreshLayout;

    private RelativeLayout relativeLayout;

    ListView itemsList;
    private ArrayList<ConsignmentIspectionDetails> consignmentIspectionDetailsArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consignment);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());

       // Button btnnext = (Button) findViewById(R.id.btnnext);


        getConsignmentIspectionDetailsList();


       /* btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navgate();
                new onNextClicked().execute();
            }
        });*/

    }



    private void getConsignmentIspectionDetailsList() {
        //Creating a list view items
        ListView list = (ListView) findViewById(R.id.itemsList);
        consignmentIspectionDetailsArrayList.clear();
        consignmentIspectionDetailsArrayList.removeAll(consignmentIspectionDetailsArrayList);
        List<ConsignmentIspectionDetails> consignmentIspectionDetailslist = db.getConsignmentIspectionDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = consignmentIspectionDetailslist.size();
        System.out.println(listSize + "===============consignment inspection==========");

        for (int i = 0; i < consignmentIspectionDetailslist.size(); i++) {
            System.out.println("Document Number=== " + consignmentIspectionDetailslist.get(i).getDocumentNumber());

            String retreivedDocumentDate = consignmentIspectionDetailslist.get(i).getDocumentDate();

            cbPartnerID = consignmentIspectionDetailslist.get(i).getNameOfApplicant();

            for (CBPartner partner : cbPartnerList) {
                if (null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())) {
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else {
                    //System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                consignmentIspectionDetailsArrayList.add(new ConsignmentIspectionDetails(
                        consignmentIspectionDetailslist.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        consignmentIspectionDetailslist.get(i).getLicenceNumber()));
            }
            localhash.put(i, consignmentIspectionDetailslist.get(i).getLocalID());
            adapter = new ConsignmentInspectionAdapter(getApplicationContext(), consignmentIspectionDetailsArrayList);
            list.setAdapter(adapter);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocumentdate);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicenceNo);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewNameOfApplicant);

                documentNumber = consignmentIspectionDetailslist.get(position).getDocumentNumber();
                documentDate = consignmentIspectionDetailslist.get(position).getDocumentDate();
                Licenceno = consignmentIspectionDetailslist.get(position).getLicenceNumber();
                nameOfApplicant = consignmentIspectionDetailslist.get(position).getNameOfApplicant();
                localID = localhash.get(position);

                navgate();

            }
        });
    }

    public void navgate(){
        if (localID!= null && !localID.isEmpty())
        {
            FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();
            facilityInspectionBus.setDocument_number(documentNumber);
            facilityInspectionBus.setDocument_date(documentDate);
            facilityInspectionBus.setLicence_number(Licenceno);
            facilityInspectionBus.setApplicant_name(nameOfApplicant);
            facilityInspectionBus.setLocalID(localID);
            new onNextClicked().execute();

        }
        else
        {
            Toast.makeText(app, "No Item Selected", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private class onNextClicked extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mprogress = new ProgressDialog(ActivityConsignmentListView.this);

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
                    Intent intent = new Intent(ActivityConsignmentListView.this, ConsignmentActivity.class);
                    startActivity(intent);



                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp()
    {

        onBackPressed();

        finish();
        return true;
    }
}
