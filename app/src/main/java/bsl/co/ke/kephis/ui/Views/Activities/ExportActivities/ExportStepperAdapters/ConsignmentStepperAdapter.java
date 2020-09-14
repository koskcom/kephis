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
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Consignment_Inspection_Step2;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Consignment_Inspection_Step3;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Consignment_Inspection_Step4;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Consignment_Inspection_Step5;

public class ConsignmentStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public ConsignmentStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final Export_Consignment_Inspection_Step2 step = new Export_Consignment_Inspection_Step2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final Export_Consignment_Inspection_Step3 step = new Export_Consignment_Inspection_Step3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final Export_Consignment_Inspection_Step4 step = new Export_Consignment_Inspection_Step4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final Export_Consignment_Inspection_Step4 step = new Export_Consignment_Inspection_Step4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final Export_Consignment_Inspection_Step5 step = new Export_Consignment_Inspection_Step5();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final Export_Consignment_Inspection_Step2 step = new Export_Consignment_Inspection_Step2();
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
                    .setTitle(R.string.producer)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.producer)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.producer)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.producer)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.producer)
                // .setEndButtonLabel(R.string.proceed)
                .create();
    }
}
