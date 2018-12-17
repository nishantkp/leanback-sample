package com.lyphomed.nishant.tvsample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.GuidedStepSupportFragment;
import android.support.v17.leanback.widget.GuidanceStylist;
import android.support.v17.leanback.widget.GuidedAction;

import java.util.List;

/**
 * Dialog fragment for leanback
 */
public class DialogExampleFragment extends GuidedStepSupportFragment {

    private static final int ID_POSITIVE = 1;
    private static final int ID_NEGATIVE = 2;

    @NonNull
    @Override
    public GuidanceStylist.Guidance onCreateGuidance(Bundle savedInstanceState) {
        // Define a guided step fragment with title, description, breadcrumb and icon
        return new GuidanceStylist.Guidance("You are about to leave.",
                "Are you sure want to leave?",
                "Global Go",
                null);
    }

    @Override
    public void onCreateActions(@NonNull List<GuidedAction> actions, Bundle savedInstanceState) {
        // Add actions
        GuidedAction positiveAction = new GuidedAction.Builder(getActivity())
                .id(ID_POSITIVE)
                .title("Leave")
                .description("Close the app")
                .build();
        actions.add(positiveAction);
        GuidedAction negativeAction = new GuidedAction.Builder(getActivity())
                .id(ID_NEGATIVE)
                .title("Cancel")
                .description("Dismiss the dialog")
                .build();
        actions.add(negativeAction);
    }

    @Override
    public void onGuidedActionClicked(GuidedAction action) {
        // Define behaviour of each actions
        switch ((int) action.getId()) {
            case ID_NEGATIVE:
                // dismiss the guided step fragment
                finishGuidedStepSupportFragments();
                break;
            case ID_POSITIVE:
                getActivity().finish();
                break;
        }
    }

    @Override
    public int onProvideTheme() {
        return R.style.ExampleGuidedStep;
    }
}
