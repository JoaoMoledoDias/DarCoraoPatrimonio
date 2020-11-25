package pt.ipg.darcoraopatrimonio;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;



public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CircleMenu circleMenu = findViewById(R.id.circlemenu);
        final String[] menus = {
                "Ler QR-Code",
                "Quem Somos?"
        };

        circleMenu.setMainMenu(Color.parseColor("#0427A5"), R.drawable.ic_add_menuincial, R.drawable.ic_clear);
        circleMenu.addSubMenu(Color.parseColor("#F6E447"), R.drawable.ic_camara);
        circleMenu.addSubMenu(Color.parseColor("#F6E447"), R.drawable.ic_quemsomos);
        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {
                if (index == 0) {
                    mHandler.postDelayed(mUpdateTimeTask, 10000);
                    Toast.makeText(getApplicationContext(), "Ler Qr Code?", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, LerQRCode.class);
                    startActivity(intent);

                    if (index == 1) {
                        Toast.makeText(getApplicationContext(), "Você escoheu Quem Somos?", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(MainActivity.this, QuemSomos.class);
                        startActivity(intent2);
                    }
                }
            }
            private Runnable mUpdateTimeTask = new Runnable() {
                public void run() {
                    // do what you need to do here after the delay
                }
            };

        });
        };
    }