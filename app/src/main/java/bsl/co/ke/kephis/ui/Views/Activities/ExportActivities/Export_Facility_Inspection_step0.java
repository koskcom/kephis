package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

import java.util.Objects;

import bsl.co.ke.kephis.Data.Bus.FacilityInspectionBus;
import bsl.co.ke.kephis.KEPHIS;
import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.db.DataBaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Export_Facility_Inspection_step0 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;

    @BindView(R.id.ssInspector)
    Spinner ssInspector;

    private String ssinspector;

    KEPHIS app;
    DataBaseAdapter db;
    String[] users = {"Select Inspector", "KEPHIS USER", "SYSTEM", "KEPHIS APPROVER", "KEPHIS INSPECTOR", "KEPHIS ADMIN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_inspection1_records);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        app = (KEPHIS) getApplication();
        db = new DataBaseAdapter(getApplicationContext());

        Button btnnext = (Button) findViewById(R.id.btnnext);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.ssInspector);
        spin.setOnItemSelectedListener(this);
        //Setting the ArrayAdapter data on the Spinner
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, users);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(arrayAdapter);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDataToSQLite();


            }
        });


    }

    public void postDataToSQLite() {

        ssinspector = Objects.requireNonNull(ssInspector.getSelectedItem()).toString().trim();
        FacilityInspectionBus facilityInspectionBus = FacilityInspectionBus.getInstance();
        facilityInspectionBus.setNameOfapplicant(ssinspector);
        boolean valid = validateSpinner(ssInspector, ssinspector);
        if (valid) {
            new onNextClicked().execute();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      /*  if (ssInspector.getSelectedItem().toString().trim().equals("Select Inspector"))
        {
            Toast.makeText(getApplicationContext(),  "Inspector Required", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), users[position], Toast.LENGTH_LONG).show();
        }*/
    }


    boolean validateSpinner(Spinner spinner, String error) {

        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            if (selectedTextView.getText().equals("Select Inspector")) {
                selectedTextView.setError(error);
                Toast.makeText(getApplicationContext(), "Inspector Required", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class onNextClicked extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mprogress = new ProgressDialog(Export_Facility_Inspection_step0.this);

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
                    Intent intent = new Intent(Export_Facility_Inspection_step0.this, Export_Facility_Inspection_step1.class);
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
