package ro.ase.dam.lab23;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends LoggedActivity {
    @Override public void onCreate(Bundle state) {
        super.onCreate(state); setContentView(R.layout.activity_main);
        Intent data = getIntent();
        if (data != null && data.hasExtra("suma")) {
            String message = data.getStringExtra("mesaj");
            int sum = data.getIntExtra("suma", 0);
            Toast.makeText(this, message + " | Suma = " + sum, Toast.LENGTH_LONG).show();
        }
        findViewById(R.id.openSecond).setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
    }
}
