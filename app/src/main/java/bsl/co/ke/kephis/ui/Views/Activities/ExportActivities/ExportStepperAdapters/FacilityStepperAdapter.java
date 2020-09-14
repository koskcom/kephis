package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ExportStepperAdapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import bsl.co.ke.kephis.R;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Facility_Inspection_step1;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Facility_Inspection_step2;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Facility_Inspection_step3;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Facility_Inspection_step4;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Facility_Inspection_step5;

public class FacilityStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public FacilityStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final Export_Facility_Inspection_step1 step = new Export_Facility_Inspection_step1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final Export_Facility_Inspection_step2 step = new Export_Facility_Inspection_step2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final Export_Facility_Inspection_step3 step = new Export_Facility_Inspection_step3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final Export_Facility_Inspection_step4 step = new Export_Facility_Inspection_step4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final Export_Facility_Inspection_step5 step = new Export_Facility_Inspection_step5();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final Export_Facility_Inspection_step1 step = new Export_Facility_Inspection_step1();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.producer)
                    // .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.facility_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.facility_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.facility_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.facility_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.facility_inspection)
                // .setEndButtonLabel(R.string.proceed)
                .create();
    }
}
