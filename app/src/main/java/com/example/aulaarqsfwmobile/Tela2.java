package com.example.aulaarqsfwmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aulaarqsfwmobile.databinding.ActivityMainBinding;
import com.example.aulaarqsfwmobile.databinding.ActivityTela2Binding;

import java.util.ArrayList;
import java.util.List;

public class Tela2 extends AppCompatActivity {

    //private ActivityTela2Binding binding;
    private TextView mensag;
    private Button btnIrParaTela3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        btnIrParaTela3 = findViewById(R.id.btnIrParaTela3);
        mensag = findViewById(R.id.textView4);

//        binding = ActivityTela2Binding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TELA", "Tela 2");
        startService(intent);

//        binding.btnIrParaTela3.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(), Tela3.class);
//                startActivity(intent);
//            }
//        });

        btnIrParaTela3.setOnClickListener(v->{
            Intent in = new Intent(this, Tela3.class);
            startActivity(in);
        });

        List<MyContact> contacts = ContactsHelper.getContacts(this);
        ArrayList<String> nomes = new ArrayList<>();

        if (contacts.size() >= 2){
            for (MyContact contact : contacts) {
                nomes.add(contact.getName());
                Log.d("APS", "ID: " + contact.getId() + ", Name: " + contact.getName());
            }

            mensag.setText(nomes.get(1));
        }

    }
}