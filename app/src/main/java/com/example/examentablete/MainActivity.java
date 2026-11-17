package com.example.examentablete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    List<Tableta> listaTablete = new ArrayList<>();
    TextView contor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button adauga = findViewById(R.id.holban_sebastian_adauga);
        contor = findViewById(R.id.holban_sebastian_contor);

        adauga.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this, AdaugaTabletaActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                bundle.setClassLoader(Tableta.class.getClassLoader());
                Tableta tableta = (Tableta) bundle.getSerializable("tableta");
                if (tableta != null) {
                    listaTablete.add(tableta);
                    contor.setText(getString(R.string.contor, listaTablete.size()));
                }
            }
        }
    }
}
