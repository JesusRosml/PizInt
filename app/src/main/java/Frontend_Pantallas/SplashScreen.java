package Frontend_Pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jesus.pizint.BarraNavegacionDesplegable;
import com.jesus.pizint.MainActivity;
import com.jesus.pizint.R;
import com.jesus.pizint.ui.home.HomeFragment;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, BarraNavegacionDesplegable.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}