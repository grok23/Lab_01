package edu.amacdonald.lab_01;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText usersName = null;
    ImageView image;
    ImageView image2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //links Java usersName to XML component
        usersName = findViewById(R.id.editTextTextPersonName);

    }

    public void doName(View view) {
        String name = null;
        name = usersName.getText().toString();
        //change the image in imageView2 from background space to "not imposter" pic
        image = (ImageView) findViewById(R.id.imageView2);
        image.setImageResource(R.drawable.notimposterbackground1);

        Toast toast= Toast.makeText(getApplicationContext(),
                name + ", was not the impostor!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();

        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
            public void onFinish() {
                image2 = (ImageView) findViewById(R.id.imageView2);
                image2.setImageResource(R.drawable.spacebackground1);
                usersName.getText().clear();
            }
        }.start();

    }
}