package ro.pub.cs.systems.eim.PracticalTest01Var01;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {
    static int num = 0;
    static String s = "";
    private TextView messageTextView;
    private StartedServiceBroadcastReceiver startedServiceBroadcastReceiver;
    private IntentFilter startedServiceIntentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        Intent i = new Intent();
        i.setComponent(new ComponentName("ro.pub.cs.systems.eim.PracticalTest01Var01", "ro.pub.cs.systems.eim.PracticalTest01Var01.PracticalTest01Var01Service"));
        startService(i);

        messageTextView = findViewById(R.id.textView2);
        startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver(messageTextView);
        startedServiceIntentFilter = new IntentFilter();
        startedServiceIntentFilter.addAction("1");

        Button north = findViewById(R.id.button);
        Button west = findViewById(R.id.button2);
        Button east = findViewById(R.id.button3);
        Button south = findViewById(R.id.button4);
        Button next = findViewById(R.id.button5);
        final TextView t = findViewById(R.id.textView);

        final Intent intent = new Intent(this, PracticalTest01Var01SecondaryActivity.class);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("instr", t.getText());
                startActivity(intent);
                //finish();
            }
        });

        north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                t.setText(t.getText() + ", North");
                s = t.getText().toString();
            }
        });

        south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                t.setText(t.getText() + ", South");
                s = t.getText().toString();
            }
        });

        west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                t.setText(t.getText() + ", West");
                s = t.getText().toString();
            }
        });

        east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                t.setText(t.getText() + ", East");
                s = t.getText().toString();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("num", num);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num = savedInstanceState.getInt("num");
    }

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(startedServiceBroadcastReceiver, startedServiceIntentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(startedServiceBroadcastReceiver);

        super.onPause();
    }

}

class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    public StartedServiceBroadcastReceiver() {
        this.messageTextView = null;
    }

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String data = null;
        data = intent.getStringExtra("data");
        if (messageTextView != null) {
            messageTextView.setText(data);
        }
    }
}

