package ro.ase.dam.lab23;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends LoggedActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText mesaj = findViewById(R.id.mesaj);
        EditText nr1 = findViewById(R.id.nr1);
        EditText nr2 = findViewById(R.id.nr2);

        findViewById(R.id.sendThird).setOnClickListener(v -> {
            String text = mesaj.getText().toString().trim();
            String x = nr1.getText().toString().trim();
            String y = nr2.getText().toString().trim();

            if (text.isEmpty() || x.isEmpty() || y.isEmpty()) {
                Toast.makeText(this, "Completeaza toate campurile", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int a = Integer.parseInt(x);
                int b = Integer.parseInt(y);

                Bundle date = new Bundle();
                date.putString("mesaj", text);
                date.putInt("valoare1", a);
                date.putInt("valoare2", b);

                Intent intent = new Intent(this, ThirdActivity.class);
                intent.putExtras(date);
                startActivityForResult(intent, 1);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Numere invalide", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            String mesaj = data.getStringExtra("mesaj");
            int suma = data.getIntExtra("suma", 0);
            Toast.makeText(this, mesaj + " " + suma, Toast.LENGTH_LONG).show();
        }
    }
}
