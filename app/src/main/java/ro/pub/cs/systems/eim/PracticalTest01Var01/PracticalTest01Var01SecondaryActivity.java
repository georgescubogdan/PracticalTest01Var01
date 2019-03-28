package ro.pub.cs.systems.eim.PracticalTest01Var01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        Button reg = findViewById(R.id.buttonR);
        Button can = findViewById(R.id.buttonC);
        TextView t = findViewById(R.id.textView);

        Intent i = getIntent();

        final String dir = i.getStringExtra("instr");
        final Context c = this;
        t.setText(dir);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "Register", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "Cancel", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
