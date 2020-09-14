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
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step10;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step2;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step3;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step4;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step5;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step6;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step7;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step8;
import bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.Export_Farm_inspection_Step9;

public class FarmStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public FarmStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final Export_Farm_inspection_Step2 step = new Export_Farm_inspection_Step2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final Export_Farm_inspection_Step3 step = new Export_Farm_inspection_Step3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final Export_Farm_inspection_Step4 step = new Export_Farm_inspection_Step4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final Export_Farm_inspection_Step5 step = new Export_Farm_inspection_Step5();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final Export_Farm_inspection_Step6 step = new Export_Farm_inspection_Step6();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 5) {
            final Export_Farm_inspection_Step7 step = new Export_Farm_inspection_Step7();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 6) {
            final Export_Farm_inspection_Step8 step = new Export_Farm_inspection_Step8();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 7) {
            final Export_Farm_inspection_Step9 step = new Export_Farm_inspection_Step9();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 8) {
            final Export_Farm_inspection_Step10 step = new Export_Farm_inspection_Step10();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final Export_Farm_inspection_Step2 step = new Export_Farm_inspection_Step2();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 11;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 5) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 6) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 7) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 8) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.farm_inspection)
                    // .setEndButtonLabel(R.string.proceed)
                    // .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.farm_inspection)
                // .setEndButtonLabel(R.string.proceed)
                .create();
    }
}
