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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ListAdapters.ProducerInspectionAdapter;
import bsl.co.ke.kephis.Data.Bus.ProducerInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.CBPartner;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportStepperActivities.ProducerActivity;
import bsl.co.ke.kephis.util.GPSTracker;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ActivityProducerListView extends AppCompatActivity {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;

    private String documentNumber, documentDate, nameOfApplicant, Licenceno, localID;

    String firmName, streetName, postalAddres, postalCode, town, country, telephoneNo, pin;
    DataBaseAdapter db;
    KEPHIS app;
    private GPSTracker mGPS;
    protected Handler asyncTaskHandler;
    String cbPartnerID;
    ProducerInspectionAdapter adapter;
    Context ctx;
    SwipeRefreshLayout swipeLayout;

    private RelativeLayout relativeLayout;

    ListView itemsList;
    private ArrayList<ProducerInspectionDetails> producerInspectionDetailsArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_producer);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());

        getproducerInpectionList();
        Button btnnext = (Button) findViewById(R.id.btnnext);

       /* btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navgate();
                new onNextClicked().execute();
            }
        });*/




    }

    private void getproducerInpectionList() {
        //Creating a list view items
        ListView list = (ListView) findViewById(R.id.itemsList);
        producerInspectionDetailsArrayList.clear();
        producerInspectionDetailsArrayList.removeAll(producerInspectionDetailsArrayList);
        List<ProducerInspectionDetails> producerInspectionDetailslist = db.getProducerInspectionDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = producerInspectionDetailslist.size();
        System.out.println(listSize + "===============ProducerInspectionDetails==========");

        for (int i = 0; i < producerInspectionDetailslist.size(); i++) {
            System.out.println("Document Number=== " + producerInspectionDetailslist.get(i).getDocumentNumber());

            String retreivedDocumentDate = producerInspectionDetailslist.get(i).getDocumentDate();

            cbPartnerID = producerInspectionDetailslist.get(i).getNameOfApplicant();

            for (CBPartner partner : cbPartnerList) {
                if (null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())) {
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else {
                    //System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                producerInspectionDetailsArrayList.add(new ProducerInspectionDetails(
                        producerInspectionDetailslist.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        producerInspectionDetailslist.get(i).getLicenceNumber(),
                        producerInspectionDetailslist.get(i).getFirmName(),
                        producerInspectionDetailslist.get(i).getStreetName(),
                        producerInspectionDetailslist.get(i).getPostalAddres(),
                        producerInspectionDetailslist.get(i).getPostalCode(),
                        producerInspectionDetailslist.get(i).getTown(),
                        producerInspectionDetailslist.get(i).getCountry(),
                        producerInspectionDetailslist.get(i).getTelephoneNo(),
                        producerInspectionDetailslist.get(i).getPin()));
            }
            localhash.put(i, producerInspectionDetailslist.get(i).getLocalID());
            adapter = new ProducerInspectionAdapter(getApplicationContext(), producerInspectionDetailsArrayList);
            list.setAdapter(adapter);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocumentdate);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicenceNo);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewNameOfApplicant);

                documentNumber = producerInspectionDetailslist.get(position).getDocumentNumber();
                documentDate = producerInspectionDetailslist.get(position).getDocumentDate();
                Licenceno = producerInspectionDetailslist.get(position).getLicenceNumber();
                nameOfApplicant = producerInspectionDetailslist.get(position).getNameOfApplicant();
                localID = localhash.get(position);

                firmName = producerInspectionDetailslist.get(position).getFirmName();
                streetName = producerInspectionDetailslist.get(position).getStreetName();
                postalAddres = producerInspectionDetailslist.get(position).getPostalAddres();
                postalCode = producerInspectionDetailslist.get(position).getPostalCode();
                town = producerInspectionDetailslist.get(position).getTown();
                country = producerInspectionDetailslist.get(position).getCountry();
                telephoneNo = producerInspectionDetailslist.get(position).getTelephoneNo();
                pin = producerInspectionDetailslist.get(position).getPin();

                db.unselectproducerInspection();
                db.selectproducerInspection(localID);
                app.getProducerInspectionDetails().setValue(producerInspectionDetailslist.get(position));

                navgate();
            }
        });
    }

    public void navgate() {
        if (localID != null && !localID.isEmpty()) {
            ProducerInspectionBus producerInspectionBus = ProducerInspectionBus.getInstance();
            producerInspectionBus.setDocument_number(documentNumber);
            producerInspectionBus.setDocument_date(documentDate);
            producerInspectionBus.setLicence_number(Licenceno);
            producerInspectionBus.setApplicant_name(nameOfApplicant);
            producerInspectionBus.setFirmName(firmName);
            producerInspectionBus.setFirmName(streetName);
            producerInspectionBus.setFirmName(postalAddres);
            producerInspectionBus.setPostalCode(postalCode);
            producerInspectionBus.setTown(town);
            producerInspectionBus.setCountry(country);
            producerInspectionBus.setTelephoneNo(telephoneNo);
            producerInspectionBus.setPin(pin);
            producerInspectionBus.setLocalID(localID);
            new onNextClicked().execute();

        } else {

            Toast.makeText(app, "No Item Selected", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private class onNextClicked extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mprogress = new ProgressDialog(ActivityProducerListView.this);

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
                    Intent intent = new Intent(ActivityProducerListView.this, ProducerActivity.class);
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
