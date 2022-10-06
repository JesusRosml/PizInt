package com.jesus.pizint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import Frontend_Pantallas.Exclusive_Login;
import Frontend_Pantallas.Informacion_esc;
import Frontend_Pantallas.pantallaextra;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import meow.bottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    private final int ID_HOME = 1;
    private final int ID_MESSAGE = 2;
    private final int ID_NOTIFICATION = 3;
    private final int ID_ACCOUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView selected_page = findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        //ICONO DE LA BARRA
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_MESSAGE,R.drawable.ic_baseline_message_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATION,R.drawable.ic_baseline_notifications_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT,R.drawable.ic_baseline_account_circle_24));

        //MENSAJE DE SELECCION DE ITEM DE NAVEGACION
        /*bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Toast.makeText(MainActivity.this,"clicked item : " + model.getId(),Toast.LENGTH_SHORT).show();
                return null;
            }
        });*/
        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                String name;
                switch (model.getId()){
                    case ID_HOME: name = "Home";
                    break;

                    case ID_MESSAGE: name = "Videos";
                        Intent intent = new Intent(getApplicationContext(), pantallaextra.class);
                        startActivity(intent);
                    break;

                    case ID_NOTIFICATION: name = "Musica";
                        //pass
                    break;

                    case ID_ACCOUNT: name = "Info";
                        Intent intent2 = new Intent(getApplicationContext(), Informacion_esc.class);
                        startActivity(intent2);
                    break;

                    default: name = "";
                }
                //selected_page.setText(getString(R.string.main_page_selected, name));
                return null;
            }
        });
        //Agregar icono notificacion (ID_del_Icono, Cantidad de notificaciones
        //bottomNavigation.setCount(ID_NOTIFICATION, "4");
        bottomNavigation.show(ID_HOME, true);

    }
}