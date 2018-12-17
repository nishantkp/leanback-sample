package com.lyphomed.nishant.tvsample;

import android.os.Bundle;
import android.support.v17.leanback.app.ErrorSupportFragment;
import android.support.v17.leanback.app.GuidedStepSupportFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        // If there is a guided fragment is present, don't add fragment again
        if (GuidedStepSupportFragment.getCurrentGuidedStepSupportFragment(getSupportFragmentManager()) != null) {
            return;
        }
        GuidedStepSupportFragment.add(getSupportFragmentManager(), new DialogExampleFragment());
    }

    private ErrorSupportFragment buildErrorFragment() {
        final ErrorSupportFragment errorFragment = new ErrorSupportFragment();
        errorFragment.setTitle("Oops");
        errorFragment.setMessage("No network connection!");
        errorFragment.setButtonText("close");
        errorFragment.setAllowEnterTransitionOverlap(true);
        errorFragment.setAllowReturnTransitionOverlap(true);
        errorFragment.setDefaultBackground(true);
        errorFragment.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().remove(errorFragment).commit();
                findViewById(R.id.try_me_button).setVisibility(View.VISIBLE);
            }
        });
        return errorFragment;
    }

    public void tryMe(View view) {
        view.setVisibility(View.GONE);
        ErrorSupportFragment errorSupportFragment = buildErrorFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.error_frame, errorSupportFragment).commit();
    }
}
