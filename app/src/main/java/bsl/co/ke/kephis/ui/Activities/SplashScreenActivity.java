package bsl.co.ke.kephis.ui.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.snackbar.Snackbar;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.response.WindowTabDataResponse;

import java.util.ArrayList;

import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.CBPartner;
import bsl.co.ke.kephis.Pojo.Country;
import bsl.co.ke.kephis.Pojo.County;
import bsl.co.ke.kephis.Pojo.SubCounty;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;


public class SplashScreenActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    private static DataBaseAdapter db;

    protected static KEPHIS appState;

    private static Context mContext;
    static LoginRequest login;

    static String userName;
    static String password;

    static ArrayList<County> countyArrayList = new ArrayList<>();

    static ArrayList<Country> CountryList = new ArrayList<>();


    private static final String CHANNEL_ID = "1000000";

    static ArrayList<SubCounty> subCountyArrayList = new ArrayList<>();


    Snackbar snackbar;

    static String uri;
    private LinearLayout linearLayout;

    /**
     * Called when the activity is first created.
     */
    Thread splashTread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        userName = getResources().getString(R.string.baseUsername);
        password = getResources().getString(R.string.basePassword);

        appState = (KEPHIS) getApplication();

        uri = "http://172.105.90.155:8080";
        mContext = getApplicationContext();
        db = new DataBaseAdapter(getApplicationContext());

        appState = (KEPHIS) getApplication();

        uri = getResources().getString(R.string.url);
        mContext = getApplicationContext();
        db = new DataBaseAdapter(getApplicationContext());

       /* YoYo.with(Techniques.Bounce)
                .duration(3000)
                .playOn(findViewById(R.id.logo));*/

        YoYo.with(Techniques.FadeInUp)
                .duration(1500)
                .playOn(findViewById(R.id.appname));

        new FetchStats().execute();


    }


    private class FetchStats extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {
            refreshCouponPeriodicWork();
            return null;
        }

        protected void onPostExecute(String result) {
            runOnUiThread(new Runnable() {
                public void run() {

                    // Start your app main activity
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));

                    // close this activity
                    finish();

                }
            });
        }
    }

    public static void refreshCouponPeriodicWork() {


        System.out.println("the username passed is " + userName);
        System.out.println("the password passed is " + password);
        try {


            getCBPartner();

            countyArrayList = (ArrayList<County>) db.getAllCounty();
            System.out.println(countyArrayList.size() + "countyArrayList");
            subCountyArrayList = (ArrayList<SubCounty>) db.getAllLocalSubCounty();


            CountryList = (ArrayList<Country>) db.getCountryList();


            if (countyArrayList.isEmpty() || countyArrayList == null || countyArrayList.size() < 2) {
                getCountyList();
            }


            if (subCountyArrayList.isEmpty() || subCountyArrayList == null || subCountyArrayList.size() < 2) {
                getSubCounty();
            }


            if (CountryList.isEmpty() || CountryList == null || CountryList.size() < 2) {
                getCountry();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected static void getCountyList() {

        //LoginRequest loginRequest= params[0];

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCounty");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<County> cityArrayList = new ArrayList<>();

        County city = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    city = new County();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
                            city.setCountyId(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            city.setCountyName(field.getStringValue());


                    }
                    db.insertCounty(city.getCountyName(), city.getCountyId());
                    cityArrayList.add(city);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected static void getCountry() {


        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCountry");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<Country> countryArrayList = new ArrayList<>();
        Country country = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    country = new Country();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("C_Country_ID".equalsIgnoreCase(field.getColumn()))
                            country.setC_country_id(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            country.setName(field.getStringValue());


                    }
                    db.createCountry(country.getName(), country.getC_country_id());
                    // countryArrayList.add(country);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    protected static void getSubCounty() {


        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySubCounty");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();

        //  data.addField("SPD_County_ID",caneCensusFarmer.getCountyID() );
        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    SubCounty city = new SubCounty();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
                            city.setCountyId(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            city.setSubCountyName(field.getStringValue());
                        else if ("SPD_SubCounty_ID".equalsIgnoreCase(field.getColumn()))
                            city.setSubCountyId(field.getStringValue());

                        if (city.getSubCountyName() != null && city.getSubCountyId() != null) {


                        }

                    }
                    db.insertSubCounty(city.getSubCountyName(), city.getSubCountyId(), city.getCountyId());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // return cityArrayList;

    }


    protected static void getCBPartner() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCBPartner");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
//         db.deleteAllRecord("sugar_company");

        ArrayList<CBPartner> countryArrayList = new ArrayList<>();
        CBPartner cbPartner = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    cbPartner = new CBPartner();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            cbPartner.setC_bpartner_id(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            cbPartner.setName(field.getStringValue());

                        if (cbPartner.getName() != null && cbPartner.getC_bpartner_id() != null) {


                        }
                    }
                    db.insertCBPartner(cbPartner.getName(), cbPartner.getC_bpartner_id());
                    countryArrayList.add(cbPartner);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static LoginRequest getLogin() {
        // SET LOGIN
        login = new LoginRequest();

        login.setUser(userName);
        login.setPass(password);
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
