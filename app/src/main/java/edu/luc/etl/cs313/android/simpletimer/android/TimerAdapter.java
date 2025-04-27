package edu.luc.etl.cs313.android.simpletimer.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


import java.util.Locale;

import edu.luc.etl.cs313.android.simpletimer.R;
import edu.luc.etl.cs313.android.simpletimer.common.Constants;
import edu.luc.etl.cs313.android.simpletimer.common.TimerModelListener;
import edu.luc.etl.cs313.android.simpletimer.model.ConcreteTimerModelFacade;
import edu.luc.etl.cs313.android.simpletimer.model.TimerModelFacade;

// A thin adapter component for the timer.

public class TimerAdapter extends Activity implements TimerModelListener {

    private static String TAG = "timer-android-activity";

    /**
     * The state-based dynamic model.
     */
    private TimerModelFacade model;

    protected void setModel(final TimerModelFacade model) {
        this.model = model;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inject dependency on view so this adapter receives UI events
        setContentView(R.layout.activity_main);
        // inject dependency on model into this so model receives UI events
        this.setModel(new ConcreteTimerModelFacade(this));
        // inject dependency on this into model to register for UI updates
        model.setModelListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        model.start(); // model will start when the activity is visible
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume any necessary resources or UI updates here
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause any ongoing operations or timers if needed
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cleanup resources or references if needed
    }

    /**
     * Updates the seconds and minutes in the UI.
     * @param time
     */
    public void onTimeUpdate(final int time) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(() -> {
            final TextView tvS = findViewById(R.id.seconds);
            final var locale = Locale.getDefault();
            tvS.setText(String.format(locale,"%02d", time)); // show time is 2-digit format
        });
    }

    /**
     * Updates the state name in the UI.
     * @param stateId
     */
    public void onStateUpdate(final int stateId) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(() -> { //updates UI from model thread safely
            final TextView stateName = findViewById(R.id.stateName);
            stateName.setText(getString(stateId)); //state label set
        });
    }

    // called when the user taps the butto
    // forward event listener methods to the model
    public void onButtonClicked(final View view) {
        model.onButtonClicked();
    }

}
