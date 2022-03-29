package com.example.aulaarqsfwmobile;

import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.List;

public class MyIntentService extends IntentService {

    String name;

    public MyIntentService() {
        super("MyIntentService");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            String name = intent.getStringExtra("TELA");

//            ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
//
//            if (activityManager != null) {
//                List<ActivityManager.AppTask> tasks = activityManager.getAppTasks();
//
//                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    name = tasks.get(0).getTaskInfo().topActivity.getClassName();
//                }else {
//                    name = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
//                }
//            }

            Toast.makeText(this, "Nome da Tela: " + name, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("APS", "Service on destroy");
    }
}