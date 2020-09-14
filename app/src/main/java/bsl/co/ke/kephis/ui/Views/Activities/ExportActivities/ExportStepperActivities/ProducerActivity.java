package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportStepperActivities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.stepstone.stepper.StepperLayout;

import java.util.Objects;

import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportStepperAdapters.ProducerStepperAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProducerActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;
    @BindView(R.id.stepperLayout)
    StepperLayout stepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_records);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        stepperLayout.setAdapter(new ProducerStepperAdapter(getSupportFragmentManager(), this));

    }

    private static long back_pressed_time;
    private static long PERIOD = 2000;
    @Override
    public void onBackPressed()
    {
        if (back_pressed_time + PERIOD > System.currentTimeMillis()) super.onBackPressed();
        else
            //Toast.makeText(getBaseContext(), "Press Again To Exit!", Toast.LENGTH_SHORT).show();
            back_pressed_time = System.currentTimeMillis();

    }

    @Override
    public boolean onSupportNavigateUp()
    {

        onBackPressed();

        finish();
        return true;
    }
}