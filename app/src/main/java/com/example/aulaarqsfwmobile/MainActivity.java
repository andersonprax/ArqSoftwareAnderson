package com.example.aulaarqsfwmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aulaarqsfwmobile.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ActivityMainBinding binding;
    private MyBroadcastReceiver receiver;
    private TextView mensag;
    private Button btnIrParaTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrParaTela2 = findViewById(R.id.btnIrParaTela2);
        mensag = findViewById(R.id.textView4);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TELA", "Tela 1");
        startService(intent);

//        binding.btnIrParaTela2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(), Tela2.class);
//                startActivity(intent);
//            }
//        });

        btnIrParaTela2.setOnClickListener(v->{
            Intent in = new Intent(this, Tela2.class);
            startActivity(in);
        });

        List<MyContact> contacts = ContactsHelper.getContacts(this);
        ArrayList<String> nomes = new ArrayList<>();

        if (contacts.size() >= 1){
            for (MyContact contact : contacts) {
                nomes.add(contact.getName());
                Log.d("APS", "ID: " + contact.getId() + ", Name: " + contact.getName());
            }

            mensag.setText(nomes.get(0));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        receiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        receiver = new MyBroadcastReceiver();
//        IntentFilter filter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
//        registerReceiver(receiver, filter);

        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            Log.d("APS", "O Status do Wi-Fi Mudou");
        }

    }
}