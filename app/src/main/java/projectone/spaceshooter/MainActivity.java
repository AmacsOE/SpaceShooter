package projectone.spaceshooter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    ViewFlipper urhajo;
    Button jobbraButton;
    Button balraButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //teljes képernyős mód
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        urhajo = findViewById(R.id.urhajo);
        urhajo.startFlipping();


        jobbraButton = findViewById(R.id.jobbra_fordul);
        balraButton = findViewById(R.id.balra_fordul);

        //fordulás gombnyomásra
        jobbraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rot;
                rot = (int) urhajo.getRotation();
                rot += 1;
                urhajo.setRotation(rot);
            }
        });

        balraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rot;
                rot = (int) urhajo.getRotation();
                rot -= 1;
                urhajo.setRotation(rot);
            }
        });

}

}
