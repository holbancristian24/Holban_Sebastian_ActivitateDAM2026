package ro.ase.dam.lab23;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
public class LoggedActivity extends Activity {
    private void log(String event) {
        String tag = getClass().getSimpleName();
        Log.e(tag, event + " | error");
        Log.w(tag, event + " | warning");
        Log.d(tag, event + " | debug");
        Log.i(tag, event + " | info");
        Log.v(tag, event + " | verbose");
    }
    @Override protected void onCreate(Bundle state) { super.onCreate(state); log("onCreate"); }
    @Override protected void onStart() { super.onStart(); log("onStart"); }
    @Override protected void onResume() { super.onResume(); log("onResume"); }
    @Override protected void onPause() { log("onPause"); super.onPause(); }
    @Override protected void onStop() { log("onStop"); super.onStop(); }
}
