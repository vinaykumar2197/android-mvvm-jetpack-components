package com.vinay.sampledemo.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.vinay.sampledemo.R;
import com.vinay.sampledemo.broadcast.interfaces.BroadcastInterface;
import com.vinay.sampledemo.view.ui.ui.main.DemoFragment;

public class DemoFActivity extends AppCompatActivity {

    private BroadcastInterface listener;

    public void setOnDataSentListener(BroadcastInterface listener){
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DemoFragment.newInstance())
                    .commitNow();
        }
    }
}