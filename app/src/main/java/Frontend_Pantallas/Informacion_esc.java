package Frontend_Pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jesus.pizint.MainActivity;
import com.jesus.pizint.R;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import meow.bottomnavigation.MeowBottomNavigation;

public class Informacion_esc extends AppCompatActivity {

    private final int ID_HOME = 1;
    private final int ID_MESSAGE = 2;
    private final int ID_NOTIFICATION = 3;
    private final int ID_ACCOUNT = 4;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_esc);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        //ICONO DE LA BARRA
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_MESSAGE,R.drawable.ic_baseline_message_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATION,R.drawable.ic_baseline_notifications_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT,R.drawable.ic_baseline_account_circle_24));

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                String name;
                switch (model.getId()){
                    case ID_HOME: name = "Home";
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;

                    case ID_MESSAGE: name = "Videos";
                        Intent intent2 = new Intent(getApplicationContext(), pantallaextra.class);
                        startActivity(intent2);
                        break;

                    case ID_NOTIFICATION: name = "Musica";
                        //pass
                        break;

                    case ID_ACCOUNT: name = "Info";
                        break;

                    default: name = "";
                }
                //selected_page.setText(getString(R.string.main_page_selected, name));
                return null;
            }
        });
        bottomNavigation.show(ID_ACCOUNT, true);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( Informacion_esc.this, Exclusive_Login.class));
            }
        });

    }
}