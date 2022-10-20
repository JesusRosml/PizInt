package Frontend_Pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jesus.pizint.BarraNavegacionDesplegable;
import com.jesus.pizint.MainActivity;
import com.jesus.pizint.R;
import com.jesus.pizint.ui.slideshow.SlideshowFragment;

public class Exclusive_Login extends AppCompatActivity {
    ImageButton botonRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusive_login);

        botonRegresar = findViewById(R.id.boton_regresar);
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accion = new Intent(getBaseContext(), BarraNavegacionDesplegable.class);
                startActivity(accion);
            }
        });
    }
}