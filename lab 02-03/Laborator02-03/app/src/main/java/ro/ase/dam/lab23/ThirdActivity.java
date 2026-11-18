package ro.ase.dam.lab23;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends LoggedActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle date = getIntent().getExtras();
        if (date == null) {
            finish();
            return;
        }

        String mesaj = date.getString("mesaj", "");
        int a = date.getInt("valoare1", 0);
        int b = date.getInt("valoare2", 0);

        Toast.makeText(this, mesaj + " " + a + " " + b, Toast.LENGTH_LONG).show();

        TextView text = findViewById(R.id.thirdText);
        text.setText(mesaj + "\n" + a + " si " + b);

        EditText raspuns = findViewById(R.id.raspuns);
        findViewById(R.id.backWithResult).setOnClickListener(v -> {
            String textRaspuns = raspuns.getText().toString().trim();
            if (textRaspuns.isEmpty()) {
                textRaspuns = "Suma:";
            }

            Intent rezultat = new Intent();
            rezultat.putExtra("mesaj", textRaspuns);
            rezultat.putExtra("suma", a + b);
            setResult(Activity.RESULT_OK, rezultat);
            finish();
        });
    }
}
