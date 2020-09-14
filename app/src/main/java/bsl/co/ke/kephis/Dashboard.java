package bsl.co.ke.kephis;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.mikepenz.crossfadedrawerlayout.view.CrossfadeDrawerLayout;
import com.tingyik90.snackprogressbar.SnackProgressBar;
import com.tingyik90.snackprogressbar.SnackProgressBarManager;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.response.WindowTabDataResponse;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import bsl.co.ke.kephis.Pojo.ADUser;
import bsl.co.ke.kephis.Pojo.ConsignmentIspectionDetails;
import bsl.co.ke.kephis.Pojo.FacilityInspectionDetails;
import bsl.co.ke.kephis.Pojo.FarmInspectionDetails;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.Worker.DatapostWorker;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.ui.Activities.LoginActivity;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityConsignmentListView;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityFacilityListView;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityFarmListView;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityProducerListView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard extends AppCompatActivity {


    BottomAppBar bottomAppBar;

    ToggleButton toggleButton;

    BottomSheetBehavior<View> bottomSheetBehavior;

    CoordinatorLayout coordinatorLayout;

    FloatingActionButton fab;
    NavigationView navigationView;

    Context context;
    private KEPHIS app;
    static LoginRequest login;
    private DataBaseAdapter db;
    static String uri;

    private SnackProgressBarManager snackProgressBarManager;
    private CrossfadeDrawerLayout crossfadeDrawerLayout = null;
    private String name, email, photo, mobile;
    private DrawerLayout drawerLayout;
    @BindView(R.id.cardViewAddFarmInspection)
    CardView cardViewAddFarmInspection;
    @BindView(R.id.cardViewAddProducerFarmInspection)
    CardView cardViewAddProducerFarmInspection;
    @BindView(R.id.cardViewAddConsignmentnspection)
    CardView cardViewAddConsignmentnspection;
    @BindView(R.id.cardViewAddFacilityInspection)
    CardView cardViewAddFacilityInspection;

    //  ProfileDialog profileDialog;

    Intent serviceIntent;

    private FloatingNavigationView mFloatingNavigationView;

    private ADUser adUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btm_appbar_fab);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());

        uri = getResources().getString(R.string.url);


        mFloatingNavigationView = (FloatingNavigationView) findViewById(R.id.floating_navigation_view);
        mFloatingNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFloatingNavigationView.open();
            }
        });
        mFloatingNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //  Snackbar.make((View) mFloatingNavigationView.getParent(), item.getTitle() + " Selected!", Snackbar.LENGTH_SHORT).show();
                mFloatingNavigationView.close();
                return true;
            }
        });

     /*   snackProgressBarManager = new SnackProgressBarManager(coordinatorLayout)
                .setProgressBarColor(R.color.md_green_800)
                .setOverlayLayoutAlpha(0.9f);
*/
        cardViewAddFarmInspection.setOnClickListener(v -> {
            new Dashboard.FetchStats().execute("cardViewAddFarmInspection");
            //   Toast.makeText(this, "Farm Inspection Selected", Toast.LENGTH_SHORT).show();
        });

        cardViewAddProducerFarmInspection.setOnClickListener(v -> {
            new Dashboard.FetchStats().execute("cardViewAddProducerFarmInspection");
            // Toast.makeText(this, "Producer Inspection Selected", Toast.LENGTH_SHORT).show();
        });

        cardViewAddConsignmentnspection.setOnClickListener(v -> {
            new Dashboard.FetchStats().execute("cardViewAddConsignmentnspection");
            // Toast.makeText(this, "Consignment Inspection Selected", Toast.LENGTH_SHORT).show();


        });
        cardViewAddFacilityInspection.setOnClickListener(v -> {
            new Dashboard.FetchStats().execute("cardViewAddFacilityInspection");
            // Toast.makeText(this, "Facility Inspection Selected", Toast.LENGTH_SHORT).show();
        });

        init();

    }

    private void init() {
        if (getSupportActionBar() != null) {
            //  getSupportActionBar().setTitle("KEPHIS");
            //getSupportActionBar().setHomeButtonEnabled(true);
            // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        context = Dashboard.this;
        navigationView = findViewById(R.id.navigation_view);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        View bottomDrawer = coordinatorLayout.findViewById(R.id.bottom_drawer);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        toggleButton = findViewById(R.id.btn_toggle);
        //  toggleButton.setChecked(fab.getVisibility() == View.VISIBLE);
       /* toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) fab.show();
                else fab.hide();

            }

        });*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override


            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.btnlogout) {
                    logout();
                    return true;
                }
                //  TextUtils.showToast(context, "Search Clicked", Toast.LENGTH_SHORT);

             /*   else if (item.getItemId() == R.id.btm_contactus) {
                    return true;
                }*/
                // 66 AppUtils.showToast(context, "Accelerator Clicked", Toast.LENGTH_SHORT);
                return true;


            }

        });

        bottomSheetBehavior = BottomSheetBehavior.from(bottomDrawer);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        bottomAppBar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        bottomAppBar.replaceMenu(R.menu.menu_demo);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

            }

        });
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override


            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btnlogout:
                        logout();
                        break;

                    case R.id.btm_aboutus

                            :
                        // AppUtils.showToast(context, "3D Clicked!!", Toast.LENGTH_SHORT);
                        break;


                }
                return false;

            }

        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                Toast.makeText(context, "User Account Info Here!!!", Toast.LENGTH_SHORT).show();
            }

        });

    }


    @Override
    public void onBackPressed() {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            return;

        }
        super.onBackPressed();

    }


    public void showFabCenter(View view) {
        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);

    }


    public void showFabEnd(View view) {
        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);

    }

    //get data
    private class FetchStats extends AsyncTask<String, String, String> {
        private ProgressDialog mprogress = new ProgressDialog(Dashboard.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogress.show();
            mprogress.setTitle("Loading...");
            mprogress.setMessage("Loading Data...");
            mprogress.setCancelable(true);
            mprogress.setIndeterminate(false);


        }

        @Override
        protected String doInBackground(String... params) {
            String cardView = params[0];

            if (cardView.equals("cardViewAddFarmInspection")) {
                try {
                    getFFarmInspection();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewAddProducerFarmInspection")) {
                try {
                    getProducerInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewAddConsignmentnspection")) {
                try {
                    getConsignmentInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewAddFacilityInspection")) {
                try {
                    getFacilityInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return cardView;
        }

        @Override
        protected void onPostExecute(String result) {

            if (result.equals("cardViewAddFarmInspection")) {

                startActivity(new Intent(getApplicationContext(), ActivityFarmListView.class));

            } else if (result.equals("cardViewAddProducerFarmInspection")) {

                startActivity(new Intent(getApplicationContext(), ActivityProducerListView.class));

            } else if (result.equals("cardViewAddConsignmentnspection")) {

                startActivity(new Intent(getApplicationContext(), ActivityConsignmentListView.class));

            } else if (result.equals("cardViewAddFacilityInspection")) {

                startActivity(new Intent(getApplicationContext(), ActivityFacilityListView.class));

            }
            if (mprogress.isShowing()) {
                mprogress.dismiss();
            }


        }
    }


    protected void onResume() {

        //Work done by DataSetupWorker

        //Work done by DataPostWorker
        refreshCouponOneTimeWork();

//        inflateNavDrawer();
        super.onResume();
    }

    public static void refreshCouponOneTimeWork() {
        //define constraints
        Constraints myConstraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        //creating a data object
        //to pass the data with workrequest
        //we can put as many variables as we can
        Data source = new Data.Builder()
                .putString("workType", "DataPostWorker - OneTime")
                .build();

        final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(DatapostWorker.class)
                .setConstraints(myConstraints)
                .setInputData(source)
                .setInitialDelay(1, TimeUnit.MILLISECONDS)
                .setBackoffCriteria(BackoffPolicy.LINEAR, 0, TimeUnit.MILLISECONDS)
                .build();
        WorkManager.getInstance().enqueue(oneTimeWorkRequest);
        // WorkManager.getInstance().enqueueUniqueWork("DataPost",ExistingWorkPolicy.KEEP ,oneTimeWorkRequest);
        WorkManager.getInstance().beginUniqueWork("", ExistingWorkPolicy.APPEND, oneTimeWorkRequest).enqueue();

    }

/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/

    private void logout() {

        if (!app.settings.IsloggedIn()) {
            return;
        }
        SnackProgressBar snackProgressBar = new SnackProgressBar(
                SnackProgressBar.TYPE_CIRCULAR,
                "Logging Out...")
                .setSwipeToDismiss(false);

        // Show snack progress during logout
        snackProgressBarManager.dismissAll();
        snackProgressBarManager.show(snackProgressBar, SnackProgressBarManager.LENGTH_INDEFINITE);

        //Clear Shared Pref File
        app.settings.SetIsloggedIn(false);
        app.settings.SetIsFirstTime(true);
        app.settings.setFullName("");
        app.settings.setEmail("");
        app.settings.setBearerToken("");
        app.setAdUser(null);

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();

        //Unreachable anyway
        snackProgressBarManager.dismiss();
    }

    private class Logout extends AsyncTask<Void, Void, Void> {

        ProgressDialog mprogress = new ProgressDialog(Dashboard.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogress.show();
            mprogress.setMessage("Signing Out...");
            mprogress.setCancelable(true);
            mprogress.setIndeterminate(false);

        }

        @Override
        protected Void doInBackground(Void... params) {

            //Clear Shared Pref File
            app.settings.SetIsloggedIn(false);
            app.settings.SetIsFirstTime(true);
            app.settings.setFullName("");
            app.settings.setEmail("");
            app.settings.setBearerToken("");
            app.setAdUser(null);
            db.deleteLogin();
            //db.deleteaduser();

            try {
                Thread.sleep(3000);
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

                    Intent intent = new Intent(Dashboard.this, LoginActivity.class);
                    startActivity(intent);
                    finishAffinity();
                    finish();

                }
            });
        }
    }

    /*Webservices queries*/
    private void getFFarmInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFarmInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<FarmInspectionDetails> farmInspectionDetailsArrayList = new ArrayList<>();

        FarmInspectionDetails farmInspectionDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                db.deleteFarmInspectionDetailsList();

                System.out.println("Total food rows: " + response.getTotalRows());
                System.out.println("Num food rows: " + response.getNumRows());
                System.out.println("Start food row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    farmInspectionDetails = new FarmInspectionDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("KEPH_Farms_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setFARM_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setNameOfApplicant(field.getStringValue());

                        else if ("KEPH_Farms_Reg_ID".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setLicenceNumber(field.getStringValue());

                        else if ("farm_name".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setFarmName(field.getStringValue());

                        else if ("trace_code".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setTraceability_code(field.getStringValue());

                        else if ("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setCounty(field.getStringValue());

                        else if ("SPD_Subcounty_ID".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setSubCounty(field.getStringValue());

                        else if ("SPD_Ward_ID".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setWard(field.getStringValue());

                        else if ("street_name".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setStreetName(field.getStringValue());

                        else if ("contact_person".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setContactPerson(field.getStringValue());

                        else if ("town".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setTown(field.getStringValue());

                        else if ("producton_area".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setAreaUnderProduction(field.getStringValue());
                        else if ("market_dest".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setMarketDestination(field.getStringValue());

                        else if ("is_marketreq".equalsIgnoreCase(field.getColumn()))
                            farmInspectionDetails.setIsAwareOfmktRequirements(field.getStringValue());

                    }
                    db.insertFarmInspection(farmInspectionDetails);
                    farmInspectionDetailsArrayList.add(farmInspectionDetails);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    /*Webservices queries*/
    private void getFacilityInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFacilityInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        /*data.addField("IsApproved", "N");
        data.addField("Processing", "N");*/
        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<FacilityInspectionDetails> facilityInspectionDetailsArrayList = new ArrayList<>();

        FacilityInspectionDetails facilityInspectionDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                db.deleteFacilityInspectionDetailsList();
                System.out.println("Total food rows: " + response.getTotalRows());
                System.out.println("Num food rows: " + response.getNumRows());
                System.out.println("Start food row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    facilityInspectionDetails = new FacilityInspectionDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("KEPH_Lowrisk_Facltsinsp_ID".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setKEPH_Facility_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setNameOfApplicant(field.getStringValue());

                        else if ("KEPH_Lowrisk_Facltsreg_ID".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setLicenceNumber(field.getStringValue());

                        else if ("telephone".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setTelephoneNumber(field.getStringValue());

                        else if ("person_charge".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setPersonInCharge(field.getStringValue());

                        else if ("postal_address".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setPostalAdrress(field.getStringValue());

                        else if ("postal_code".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setPostalCode(field.getStringValue());

                        else if ("street_name".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setStreetName(field.getStringValue());

                        else if ("town".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setTown(field.getStringValue());

                        else if ("M_Product_ID".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setCommodity(field.getStringValue());
                        else if ("C_Country_ID".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setCountry(field.getStringValue());

                        else if ("dimensions".equalsIgnoreCase(field.getColumn()))
                            facilityInspectionDetails.setCapacityDimensionsinfeet(field.getStringValue());

                    }
                    db.insertFacilityInspectionn(facilityInspectionDetails);
                    facilityInspectionDetailsArrayList.add(facilityInspectionDetails);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    /*Webservices queries*/
    private void getProducerInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryProducerInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        /*data.addField("IsApproved", "N");
        data.addField("Processing", "N");
*/
        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<ProducerInspectionDetails> producerInspectionDetailsArrayList = new ArrayList<>();

        ProducerInspectionDetails producerInspectionDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {


                db.deleteProducerInspectionDetailsList();
                System.out.println("Total food rows: " + response.getTotalRows());
                System.out.println("Num food rows: " + response.getNumRows());
                System.out.println("Start food row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    producerInspectionDetails = new ProducerInspectionDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("KEPH_Producers_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setKEPH_Producer_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setNameOfApplicant(field.getStringValue());

                        else if ("KEPH_Producers_Reg_ID".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setLicenceNumber(field.getStringValue());

                        else if ("producer_name".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setFirmName(field.getStringValue());

                        else if ("street_name".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setStreetName(field.getStringValue());

                        else if ("postal_address".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setPostalAddres(field.getStringValue());

                        else if ("postal_code".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setPostalCode(field.getStringValue());

                        else if ("town".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setTown(field.getStringValue());

                        else if ("C_Country_ID".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setCountry(field.getStringValue());

                        else if ("telephone".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setTelephoneNo(field.getStringValue());
                        else if ("pinno".equalsIgnoreCase(field.getColumn()))
                            producerInspectionDetails.setPin(field.getStringValue());

                    }
                    db.insertProducerInspection(producerInspectionDetails);
                    producerInspectionDetailsArrayList.add(producerInspectionDetails);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getConsignmentInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryConsignmentInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<ConsignmentIspectionDetails> consignmentIspectionDetailsArrayList = new ArrayList<>();

        ConsignmentIspectionDetails consignmentIspectionDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {


                db.deleteConsignmentIspectionDetailsList();
                System.out.println("Total food rows: " + response.getTotalRows());
                System.out.println("Num food rows: " + response.getNumRows());
                System.out.println("Start food row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    consignmentIspectionDetails = new ConsignmentIspectionDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("KEPH_EXP_Consgn_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            consignmentIspectionDetails.setKEPH_Consignment_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            consignmentIspectionDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            consignmentIspectionDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            consignmentIspectionDetails.setNameOfApplicant(field.getStringValue());

                        else if ("KEPH_EXP_Phytocert_ID".equalsIgnoreCase(field.getColumn()))
                            consignmentIspectionDetails.setLicenceNumber(field.getStringValue());

                    }
                    db.insertConsignmentIspection(consignmentIspectionDetails);
                    consignmentIspectionDetailsArrayList.add(consignmentIspectionDetails);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public LoginRequest getLogin() {
        // SET LOGIN
        login = new LoginRequest();

        login.setUser(getString(R.string.baseUsername));
        login.setPass(getString(R.string.basePassword));
        login.setClientID(1000000);
        login.setRoleID(1000000);
        login.setOrgID(1000000);
        login.setWarehouseID(1000000);

        return login;
    }

    public static WebServiceConnection getClient() {

        WebServiceConnection client = new WebServiceConnection();
        client.setAttempts(3);
        client.setTimeout(10000);
        client.setAttemptsTimeout(10000);

        client.setUrl(uri);


        client.setAppName("Java Test WS Client");
        return client;
    }

}
