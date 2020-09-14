package bsl.co.ke.kephis.ui.Common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.google.android.material.navigation.NavigationView;
import com.mikepenz.crossfadedrawerlayout.view.CrossfadeDrawerLayout;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
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

import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.ADUser;
import bsl.co.ke.kephis.Pojo.ConsignmentIspectionDetails;
import bsl.co.ke.kephis.Pojo.FacilityInspectionDetails;
import bsl.co.ke.kephis.Pojo.FarmInspectionDetails;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.Worker.DatapostWorker;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.ui.Activities.LoginActivity;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityConsignmentListView;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityFacilityListView;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityFarmListView;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportListActivities.ActivityProducerListView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static bsl.co.ke.kephis.R.drawable.ic_logout_new_black_24dp;

public class DashboardActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private Drawer result;

    private KEPHIS app;
    static LoginRequest login;
    private DataBaseAdapter db;
    static String uri;

    private SnackProgressBarManager snackProgressBarManager;
    private CrossfadeDrawerLayout crossfadeDrawerLayout = null;
    private String name, email, photo, mobile;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    @BindView(R.id.cardViewAddFarmInspection)
    CardView cardViewAddFarmInspection;
    @BindView(R.id.cardViewAddProducerFarmInspection)
    CardView cardViewAddProducerFarmInspection;
    @BindView(R.id.cardViewAddConsignmentnspection)
    CardView cardViewAddConsignmentnspection;
    @BindView(R.id.cardViewAddFacilityInspection)
    CardView cardViewAddFacilityInspection;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    //  ProfileDialog profileDialog;

    Intent serviceIntent;

    private ADUser adUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());

        uri = getResources().getString(R.string.url);
       /* FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Notifications", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });*/

        //Initialize Snackbar Manager -> Attach/pin to the bottom of the layout :)
        snackProgressBarManager = new SnackProgressBarManager(coordinatorLayout)
                .setProgressBarColor(R.color.md_green_800)
                .setOverlayLayoutAlpha(0.9f);

        cardViewAddFarmInspection.setOnClickListener(v -> {
            new FetchStats().execute("cardViewAddFarmInspection");
            //   Toast.makeText(this, "Farm Inspection Selected", Toast.LENGTH_SHORT).show();
        });

        cardViewAddProducerFarmInspection.setOnClickListener(v -> {
            new FetchStats().execute("cardViewAddProducerFarmInspection");
            // Toast.makeText(this, "Producer Inspection Selected", Toast.LENGTH_SHORT).show();
        });

        cardViewAddConsignmentnspection.setOnClickListener(v -> {
            new FetchStats().execute("cardViewAddConsignmentnspection");
            // Toast.makeText(this, "Consignment Inspection Selected", Toast.LENGTH_SHORT).show();


        });
        cardViewAddFacilityInspection.setOnClickListener(v -> {
            new FetchStats().execute("cardViewAddFacilityInspection");
            // Toast.makeText(this, "Facility Inspection Selected", Toast.LENGTH_SHORT).show();
        });

        inflateNavDrawer();

    }

    //get data
    private class FetchStats extends AsyncTask<String, String, String> {

        private ProgressDialog mprogress = new ProgressDialog(DashboardActivity.this);

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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inflateNavDrawer() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.sans_regular);

        //Profile Making
        IProfile profile = new ProfileDrawerItem()
                .withName(name)
                .withEmail(email)
                .withTypeface(typeface);
        // .withIcon(R.drawable.kephislogo);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.md_green_900)
                .addProfiles(profile)
                .withCompactStyle(true)
                .withTypeface(typeface)
                .withOnlyMainProfileImageVisible(true)
                .build();

        //Adding nav drawer items ------------------------------------------------------------------
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.our_Services).withIcon(R.drawable.ic_our_services_24dp).withSelectable(false);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Phyto-Sanitary Services").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Seed Certification Services").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Analytical Chemistry and Food Services").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Service Charter").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);

        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName("About Us").withIcon(R.drawable.ic_our_services_24dp).withSelectable(false);
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName("Board Of Directors").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(8).withName("Organization Structure").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);
        PrimaryDrawerItem item9 = new PrimaryDrawerItem().withIdentifier(9).withName("Corporate Social Responsibility").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);
        PrimaryDrawerItem item10 = new PrimaryDrawerItem().withIdentifier(10).withName("Milestones").withIcon(R.drawable.ic_check_black_24dp).withSelectable(false);

        SecondaryDrawerItem item11 = new SecondaryDrawerItem().withIdentifier(11).withName("Logout").withIcon(ic_logout_new_black_24dp);
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withDrawerLayout(R.layout.crossfade_drawer)
                .withAccountHeader(headerResult)
                .withDrawerWidthDp(72)
                .withGenerateMiniDrawer(true)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withDelayDrawerClickEvent(-1)
                .addDrawerItems(
                        new DividerDrawerItem(), item1, new DividerDrawerItem(), item2, item3, item4, item5, new DividerDrawerItem(), item6, new DividerDrawerItem(), item7, item8, item9, item10, item11
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch (position) {

                            case 1:
                                // startActivity(new Intent(DashboardActivity.this, Export_Farm_inspection_Step1.class));
                                break;

                            case 2:
                                //  startActivity(new Intent(DashboardActivity.this, Export_Farm_inspection_Step2.class));
                                break;


                            case 15:
                                // logout();
                                new Logout().execute();
                                break;
                            default:
                                //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();
                        }

                        return true;
                    }
                })
                .build();

        crossfadeDrawerLayout = (CrossfadeDrawerLayout) result.getDrawerLayout();

        //define maxDrawerWidth
        crossfadeDrawerLayout.setMaxWidthPx(DrawerUIUtils.getOptimalDrawerWidth(this));

        //add second view (which is the miniDrawer)
        final MiniDrawer miniResult = result.getMiniDrawer()
                .withIncludeSecondaryDrawerItems(true);

        //build the view for the MiniDrawer
        View view = miniResult.build(this);

        //set the background of the MiniDrawer as this would be transparent
        view.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(this, com.mikepenz.materialdrawer.R.attr.material_drawer_background, com.mikepenz.materialdrawer.R.color.material_drawer_background));

        //we do not have the MiniDrawer view during CrossfadeDrawerLayout creation so we will add it here
        crossfadeDrawerLayout.getSmallView().addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //define the crossfader to be used with the miniDrawer. This is required to be able to automatically toggle open / close
        miniResult.withCrossFader(new ICrossfader() {
            @Override
            public void crossfade() {
                boolean isFaded = isCrossfaded();
                crossfadeDrawerLayout.crossfade(400);

                //only close the drawer if we were already faded and want to close it now
                if (isFaded) {
                    result.getDrawerLayout().closeDrawer(GravityCompat.START);
                }
            }

            @Override
            public boolean isCrossfaded() {
                return crossfadeDrawerLayout.isCrossfaded();
            }
        });
    }

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

        ProgressDialog mprogress = new ProgressDialog(DashboardActivity.this);


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

                    Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
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
