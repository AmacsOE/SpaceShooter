package projectone.spaceshooter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView urhajo;
    Button jobbraButton;
    Button balraButton;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        urhajo = findViewById(R.id.urhajo);
        jobbraButton = findViewById(R.id.jobbra_fordul);
        balraButton = findViewById(R.id.balra_fordul);

        final Animation jobbraAnimation = new AnimationUtils().loadAnimation(MainActivity.this, R.anim.fordul_jobbra);
        final Animation balraAnimation = new AnimationUtils().loadAnimation(MainActivity.this, R.anim.fordul_balra);


        jobbraButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    urhajo.startAnimation(jobbraAnimation);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    urhajo.clearAnimation();
                }
                return true;
            }
        });

        balraButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    urhajo.startAnimation(balraAnimation);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    urhajo.clearAnimation();
                }
                return true;
            }
        });



    }
}
