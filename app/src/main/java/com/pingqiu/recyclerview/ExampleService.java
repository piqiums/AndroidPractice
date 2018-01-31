package com.pingqiu.recyclerview;


import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class ExampleService extends IntentService {
    private static final String TAG = ExampleService.class.getSimpleName();
    public ExampleService() {
        super("ExampleService");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "in onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "in onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Messenger outMessenger =
                intent.getParcelableExtra("com.example.service.Messenger");

        for (int i = 0; i < 5; i++) {
            if (outMessenger != null) {
                try {
                    Message msg = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString("str", "hello, this is example app.");
                    msg.setData(bundle);
                    outMessenger.send(msg);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}