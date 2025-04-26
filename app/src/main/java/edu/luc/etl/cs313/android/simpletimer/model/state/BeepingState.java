package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

public class BeepingState implements TimerState {

    public BeepingState(final TimerSMStateView sm) { 
        this.sm = sm;
        playBeep();
        
}
    private final TimerSMStateView sm;
    
    private void playBeep() {
        Context context = sm.getActivity();
        MediaPlayer mediapalyer = MediaPlayer.create(context, R.raw.beep);
        mediaPlayer.start();
    }
        @Override
    public void updateView() { sm.updateUIRuntime(); }

    @Override
    public int getId() {
        return R.string.BEEPING;
    }

    @Override
    public void onButtonClicked() {
        sm.actionStop();
        sm.toStoppedState();
    }
    @Override
    public void onTick() {
        updateView();
    }
}
