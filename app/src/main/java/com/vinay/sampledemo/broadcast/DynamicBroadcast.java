package com.vinay.sampledemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;
import com.vinay.sampledemo.broadcast.interfaces.BroadcastInterface;

public class DynamicBroadcast extends BroadcastReceiver {
    private BroadcastInterface listener;

    public DynamicBroadcast(BroadcastInterface listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Toast.makeText(context.getApplicationContext(), "Connectivity changed", Toast.LENGTH_SHORT).show();
            listener.onDataRecieved("Data Recieved from broadcast");
        }
    }
}
