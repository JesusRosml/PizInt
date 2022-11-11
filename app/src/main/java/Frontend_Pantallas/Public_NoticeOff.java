package Frontend_Pantallas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jesus.pizint.R;

public class Public_NoticeOff extends AppCompatActivity {

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
        String obtcont = contenido.getText().toString();
        String obttitu = titulo.getText().toString();

        if (!TextUtils.isEmpty(obtcont) && !TextUtils.isEmpty(obttitu)){
            String id = mDatabase.push().getKey();
            subirBD publicacion = new subirBD(id, obttitu,obtcont,null);
            mDatabase.child("Publicacion").child(id).setValue(publicacion);
            Toast.makeText(this,"Publicando...",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Rellene todos los campos",Toast.LENGTH_LONG).show();
        }

    }

}