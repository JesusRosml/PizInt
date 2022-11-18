package Frontend_Pantallas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jesus.pizint.BarraNavegacionDesplegable;
import com.jesus.pizint.R;

public class Public_NoticeOff extends AppCompatActivity {

    ImageButton regresar;
    ImageView imageView;
    Button btn;
    TextInputEditText titulo;
    TextInputEditText contenido;
    Button publicar;


    private static final int SELECT_IMAGE = 100;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_notice_off);
        mDatabase = FirebaseDatabase.getInstance().getReference("subirBD");
        btn = findViewById(R.id.pickImage);
        imageView = findViewById(R.id.image);

        titulo = findViewById(R.id.txttitulo);
        contenido = findViewById(R.id.txtcontenido);
        publicar = findViewById(R.id.button_public);
        regresar = findViewById(R.id.boton_regresar2);

        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(
                        Intent.createChooser(intent,"Select Image"),
                        SELECT_IMAGE
                );
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getBaseContext(), BarraNavegacionDesplegable.class);
                startActivity(back);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_IMAGE && null != data)
        {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        }
    }

    public void registrar(){
        //Obteniendo contenido ingresado en los campos guardadolos en las variables en formato string
        String obtcont = contenido.getText().toString();
        String obttitu = titulo.getText().toString();
        //Condicion en donde no debe estar vacia las variables
        if (!TextUtils.isEmpty(obtcont) && !TextUtils.isEmpty(obttitu)){
            //Obtiene la id con la que se hara el push al FireBase
            String id = mDatabase.push().getKey();
            //Variable que contiene los datos de la publicacion
            subirBD publicacion = new subirBD(id, obttitu,obtcont,null);
            //La bd crea una "tabla" llamada publicacion y otra "tabla" bajo el nombre de la id
            //de la publicacion subida
            mDatabase.child("Publicacion").child(id).setValue(publicacion);
            //Mostramos un toast con el contenido publicando
            Toast.makeText(this,"Publicando...",Toast.LENGTH_LONG).show();
            //Salida despues de publicar el contenido
            Intent salir = new Intent(getBaseContext(), BarraNavegacionDesplegable.class);
            startActivity(salir);
            //Si por alguna razon esta vacia obligara a mostrar un toast diciendo que rellene TODOS los campos
        }else{
            Toast.makeText(this,"Rellene todos los campos",Toast.LENGTH_LONG).show();
        }

    }

}