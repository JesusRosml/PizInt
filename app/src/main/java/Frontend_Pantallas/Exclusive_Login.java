package Frontend_Pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jesus.pizint.BarraNavegacionDesplegable;
import com.jesus.pizint.R;
import com.jesus.pizint.ui.home.HomeFragment;

public class Exclusive_Login extends AppCompatActivity {
    ImageButton botonRegresar;
    EditText usuario;
    EditText contrasena;
    Button ini_ses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusive_login);
        botonRegresar = findViewById(R.id.boton_regresar);
        usuario = (EditText) findViewById(R.id.editTextTextUsername);
        contrasena = (EditText) findViewById(R.id.editTextTextPassword);
        ini_ses = findViewById(R.id.button_iniciar_sesion);

        ini_ses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obtusuario = usuario.getText().toString();
                String obtcontra = contrasena.getText().toString();
                if (obtusuario.equals("ADMIN") && obtcontra.equals("admin")){
                    //showbutton();
                    Toast.makeText(getBaseContext(),"Datos Correctos",Toast.LENGTH_LONG).show();
                    //Intent accion = new Intent(getBaseContext(), BarraNavegacionDesplegable.class);
                    //startActivity(accion);


                }else{
                    Toast.makeText(getBaseContext(),"Introduzca correctamente los datos",Toast.LENGTH_LONG).show();
                }

            }
        });

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accion = new Intent(getBaseContext(), BarraNavegacionDesplegable.class);
                startActivity(accion);
            }
        });
    }

}