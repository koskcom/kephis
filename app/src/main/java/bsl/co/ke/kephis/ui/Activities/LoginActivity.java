package bsl.co.ke.kephis.ui.Activities;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.Snackbar;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.response.WindowTabDataResponse;

import java.util.ArrayList;

import bsl.co.ke.kephis.Dashboard;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.Pojo.ADUser;
import bsl.co.ke.kephis.Pojo.User;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import bsl.co.ke.kephis.ui.Common.DashboardActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import static bsl.co.ke.kephis.settings.Settings.hasPermissions;

public class LoginActivity extends AppCompatActivity {
    /*    @BindView(R.id.appname)
        TextView textViewAppName;*/
    @BindView(R.id.editTextEmail)
    EditText editTextEmail;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;
    @BindView(R.id.rememberme)
    CheckBox rememberme;
    @BindView(R.id.loginButton)
    Button loginButton;

    int PERMISSION_ALL = 1;
    public ProgressDialog mprogress;
    private static int SPLASH_TIME_OUT = 3000;

    private KEPHIS kephis;
    String[] PERMISSIONS = {
            Manifest.permission.INTERNET,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private KEPHIS app;

    //static LoginRequest login;

    static String userName;
    static String password;
    private ADUser adUser;
    User user;
    User savedUser;
    private DataBaseAdapter db;
    static LoginRequest login;
    protected LoginRequest loginRequest;
    private Intent serviceIntent;
    Snackbar snackbar;
    private ScrollView scrollView;


    static String uri ;

    private static final int DATA_SETUP_SERVICE_ID = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        checkPermissions();
        loginButton = findViewById(R.id.loginButton);


        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());

        uri = "http://172.105.90.155:8080";


        user = db.getLogin();
        adUser = db.getADUser();
        savedUser = app.getSavedUser();

        System.out.println("logging in  " + userName);

        if (null != savedUser) {
            editTextEmail.setText(savedUser.getEmailAddress());
            editTextPassword.setText(savedUser.getPassword());
            rememberme.setChecked(true);
        }

        if (null != adUser) {

            app.setAdUser(adUser);

            loginRequest = new LoginRequest();
            loginRequest.setUser(getString(R.string.baseUsername));
            loginRequest.setPass(getString(R.string.basePassword));
            loginRequest.setClientID(1000000);
            loginRequest.setRoleID(1000000);
            loginRequest.setOrgID(1000000);
            loginRequest.setWarehouseID(1000000);
            app.setLoginRequest(loginRequest);
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);

        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User savedUser = null;

                userName = editTextEmail.getText().toString().trim();
                password = editTextPassword.getText().toString().trim();
                if (validateUsername(editTextEmail.getText().toString()) && validatePassword(editTextPassword.getText().toString())) { //Username and Password Validation


                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(intent);
                    finish();

                  /*  if(rememberme.isChecked()){
                        savedUser = new User();
                        savedUser.setEmailAddress(userName);
                        savedUser.setPassword(password);
                        app.setSavedUser(savedUser);
                    }

                    new FetchLogin().execute();*/
                }
            }
        });
    }

    private boolean validatePassword(String pass) {
        if (pass.length() < 3 || pass.length() > 20) {
            editTextPassword.setError("Password Must consist of 3 to 20 characters");
            return false;
        }
        return true;
    }

    private boolean validateUsername(String email) {

        if (email.length() < 4 /*|| email.length() > 30*/) {
            editTextEmail.setError("Email Must consist of at least characters");
            return false;
        } else if (!email.matches("^[A-za-z0-9.@]+")) {
            editTextEmail.setError("Only . and @ characters allowed");
            return false;
        } else if (!email.contains("@") || !email.contains(".")) {
            editTextEmail.setError("Email must contain @ and .");
            return false;
        }
        return true;
    }

    private void checkPermissions() {
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (app.settings.IsloggedIn() && db.getLogin() != null) {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private class FetchLogin extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mprogress = new ProgressDialog(LoginActivity.this);
        boolean islogin = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogress.show();
            mprogress.setTitle("Authenticating...");
            mprogress.setMessage("Authenticating...");
            mprogress.setCancelable(true);
            mprogress.setIndeterminate(false);

        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            islogin = login();
            if (islogin) {
                String directorate = app.getAdUser().getC_activity_id();
                /*serviceIntent = new Intent(getApplicationContext(), DataSetupService.class);
                serviceIntent.putExtra("UserDirectorate", directorate);
                startService(serviceIntent);*/
            }

            return null;
        }

        protected void onPostExecute(Void result) {

            if (mprogress.isShowing()) {
                mprogress.dismiss();
            }
            runOnUiThread(new Runnable() {
                public void run() {


                    // Start your app main activity
                    if (islogin) {
                        app.settings.SetIsloggedIn(true);

                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);

                        finish();
                    } else {
                       // showSnackBar("Invalid user", scrollView);
                        Toast.makeText(getApplicationContext(), "Invalid Username Or Password!!!", Toast.LENGTH_SHORT).show();

                    }


                    // close this activity
//                    finish();

                }
            });
        }
    }

    public void showSnackBar(String string, ScrollView scrollView) {
        snackbar = Snackbar.make(scrollView, string, Snackbar.LENGTH_INDEFINITE).
                setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
        snackbar.show();
    }


//    protected boolean login() {
//
//        CompositeOperationRequest compositeOperation = new CompositeOperationRequest();
//        compositeOperation.setWebServiceType("TestLogin");
//
//
//        System.out.println("the username passed is " + userName);
//        System.out.println("the password passed is " + password);
//        compositeOperation.setLogin(getLogin());
//
//        WebServiceConnection client = getClient();
//
//        boolean success;
//
//
//        try {
//            CompositeResponse response = client.sendRequest(compositeOperation);
//
//            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
//                System.out.println("Error: " + response.getErrorMessage());
//
//                toast(response.getErrorMessage());
//                success = false;
//
//            } else {
//                success = true;
//                app.setLoginRequest(loginRequest);
//                db.insertUserRecords(userName, password);
//
//                System.out.println("system logged in" + success);
//            }
//
//
//            System.out.println("--------------------------");
//            System.out.println("Web Service: TestLogin");
//            System.out.println("Attempts: " + client.getAttemptsRequest());
//            System.out.println("Time: " + client.getTimeRequest());
//            System.out.println("--------------------------");
//
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//            e.printStackTrace();
//            success = false;
//        }
//
//        return success;
//
//    }

    // Handle toast messages
    public void toast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG)
                .show();
    }

    public static LoginRequest getLogin() {

        // SET LOGIN
        System.out.println("logging in url=  " + uri);

        login = new LoginRequest();

//        login.setUser(userName);
//        login.setPass(password);

        login.setUser("qa.brisk@briskbusiness.co.ke");
        login.setPass("abc123");

        //pass for 172
//        login.setPass("abc123");

        login.setClientID(1000000);
        login.setRoleID(1000000);
        login.setOrgID(1000000);
        login.setWarehouseID(1000000);

        return login;
    }

    public WebServiceConnection getClient() {

        WebServiceConnection client = new WebServiceConnection();
        client.setAttempts(3);
        client.setTimeout(5000);
        client.setAttemptsTimeout(5000);
        client.setUrl(uri);


        client.setAppName("Java Test WS Client");
        return client;
    }

    protected boolean login() {

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryUser");
        ws.setLogin(getLogin());


        System.out.println(app + "username = " + userName + " password = " + password);


        DataRow data = new DataRow();
        data.addField("EMail", userName);
        data.addField("Password", password);
        ws.setDataRow(data);


        WebServiceConnection client = getClient();

        ArrayList<ADUser> adUserArrayList = new ArrayList<>();

        ADUser adUser = null;

        boolean success = false;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
                success = false;
            } else {
                // db.deleteADUser();
                adUser = new ADUser();
                adUser.setAd_user_email(userName);
                System.out.println("Total ad rows: " + response.getTotalRows());
                System.out.println("Num ad rows: " + response.getNumRows());
                System.out.println("Start ad row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AD_User_ID".equalsIgnoreCase(field.getColumn())) {
                            adUser.setAd_user_id(field.getStringValue());
                        } else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn())) {
                            adUser.setC_bpartner_id(field.getStringValue());
                        } else if ("Name".equalsIgnoreCase(field.getColumn())) {
                            adUser.setAd_user_name(field.getStringValue());
                        } else if ("EMail".equalsIgnoreCase(field.getColumn())) {
                            adUser.setAd_user_email(field.getStringValue());
                        }


                    }

                    System.out.println("Emails" + adUser.getAd_user_email());
                    System.out.println("Emails" + adUser.getAd_user_name());

                    db.insertADUser(adUser);
                    app.setAdUser(adUser);

                    app.setLoginRequest(loginRequest);
                    db.insertUserRecords(getString(R.string.baseUsername), getString(R.string.basePassword));

                    adUserArrayList.add(adUser);
                    System.out.println("users==" + adUserArrayList.size());
                    success = true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception user " + e.getMessage());
            success = false;
        } finally {
            db.close();
        }

        return success;

    }


}
