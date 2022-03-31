package com.example.aulaarqsfwmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aulaarqsfwmobile.databinding.ActivityMainBinding;
import com.example.aulaarqsfwmobile.databinding.ActivityTela3Binding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Tela3 extends AppCompatActivity {

    //private ActivityTela3Binding binding;
    private TextView mensag;
    private Button btnIrParaTela4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        btnIrParaTela4 = findViewById(R.id.btnIrParaTela4);
        mensag = findViewById(R.id.textView4);

//        binding = ActivityTela3Binding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TELA", "Tela 3");
        startService(intent);

//        binding.btnIrParaTela4.setOnClickListener(view ->
//                Snackbar.make(view, "Não existe a tela 4 por enquanto", Snackbar.LENGTH_LONG).show()
//        );

        btnIrParaTela4.setOnClickListener(view->
            Snackbar.make(view, "Não existe a tela 4 por enquanto", Snackbar.LENGTH_LONG).show()
        );

        List<MyContact> contacts = ContactsHelper.getContacts(this);
        ArrayList<String> nomes = new ArrayList<>();

        if (contacts.size() >= 3){
            for (MyContact contact : contacts) {
                nomes.add(contact.getName());
                Log.d("APS", "ID: " + contact.getId() + ", Name: " + contact.getName());
            }

            mensag.setText(nomes.get(2));
        }
    }
}