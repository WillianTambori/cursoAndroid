package devandroid.tambori.appgaseta.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.tambori.appgaseta.R;
import devandroid.tambori.appgaseta.database.GasEtaDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        comutarTelaSplash();
    }

    private void comutarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                GasEtaDB db = new GasEtaDB(SplashActivity.this);

                Intent telaPrincipal = new Intent(SplashActivity.this, GasEtaActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        },TIME_OUT_SPLASH);
    }
}