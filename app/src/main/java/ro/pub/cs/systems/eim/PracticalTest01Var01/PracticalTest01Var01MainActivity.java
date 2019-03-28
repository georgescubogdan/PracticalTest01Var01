package ro.pub.cs.systems.eim.PracticalTest01Var01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        Button north = findViewById(R.id.button);
        Button west = findViewById(R.id.button2);
        Button east = findViewById(R.id.button3);
        Button south = findViewById(R.id.button4);
    }
}
