package projectone.spaceshooter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    ViewFlipper urhajo;
    Button jobbraButton;
    Button balraButton;

    private boolean jobbraFolyamatosan = false;
    private boolean balraFolyamatosan = false;
    private final long REPEAT_DELAY = 10;
    private Handler repeatUpdateHandler = new Handler();


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

        class RepetitiveUpdater implements Runnable {

            @Override
            public void run() {
                if (jobbraFolyamatosan) {
                    jobbraFordul();
                    repeatUpdateHandler.postDelayed(new RepetitiveUpdater(), REPEAT_DELAY);
                } else if (balraFolyamatosan) {
                    balraFordul();
                    repeatUpdateHandler.postDelayed(new RepetitiveUpdater(), REPEAT_DELAY);
                }
            }

        }

        jobbraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobbraFordul();
            }
        });

        jobbraButton.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                jobbraFolyamatosan = true;
                repeatUpdateHandler.post(new RepetitiveUpdater());
                return false;
            }
        });

        jobbraButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && jobbraFolyamatosan) {
                    jobbraFolyamatosan = false;
                }
                return false;
            }
        });

        balraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balraFordul();
            }
        });

        balraButton.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                balraFolyamatosan = true;
                repeatUpdateHandler.post(new RepetitiveUpdater());
                return false;
            }
        });

        balraButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && balraFolyamatosan) {
                    balraFolyamatosan = false;
                }
                return false;
            }
        });

    }

    public void jobbraFordul() {
        int rot;
        rot = (int) urhajo.getRotation();
        if (rot == 359){
            rot = 0;
        }else rot += 1;
        urhajo.setRotation(rot);
        }

    public void balraFordul() {
        int rot;
        rot = (int) urhajo.getRotation();
        if (rot == 0){
            rot = 359;
        }else rot -= 1;
        urhajo.setRotation(rot);
    }

}