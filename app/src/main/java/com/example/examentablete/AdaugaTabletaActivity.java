package com.example.examentablete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdaugaTabletaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_tableta);

        EditText id = findViewById(R.id.holban_sebastian_id);
        EditText model = findViewById(R.id.holban_sebastian_model);
        Spinner memorie = findViewById(R.id.holban_sebastian_memorie);
        CheckBox garantie = findViewById(R.id.holban_sebastian_garantie);
        Button salveaza = findViewById(R.id.holban_sebastian_salveaza);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.memorii, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        memorie.setAdapter(adapter);

        salveaza.setOnClickListener(v -> {
            String textId = id.getText().toString().trim();
            String textModel = model.getText().toString().trim();

            if (textId.isEmpty() || textModel.isEmpty()) {
                Toast.makeText(this, R.string.eroare, Toast.LENGTH_SHORT).show();
                return;
            }

            int idTableta = Integer.parseInt(textId);
            int spatiuMemorie = Integer.parseInt(
                    memorie.getSelectedItem().toString());
            boolean areGarantie = garantie.isChecked();

            Tableta tableta = new Tableta(
                    idTableta, textModel, spatiuMemorie, areGarantie);

            Bundle bundle = new Bundle();
            bundle.putSerializable("tableta", tableta);

            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
