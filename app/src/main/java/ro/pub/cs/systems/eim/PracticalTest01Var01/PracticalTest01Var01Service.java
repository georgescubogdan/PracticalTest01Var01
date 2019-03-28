package ro.pub.cs.systems.eim.PracticalTest01Var01;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var01Service extends Service {
    public PracticalTest01Var01Service() {
    }

    private int startMode;

    @Override
    public void onCreate() {
        super.onCreate();
        // ...
    }

    @Override
    public int onStartCommand(Intent intent,
                              int flags,
                              int startId) {
        // ...
        Log.d("myService", "onStartCommand() method was invoked");
        ProcessingThread processingThread = new ProcessingThread(this);
        processingThread.start();
        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // ...
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // ...
    }
}

class ProcessingThread extends Thread {

    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Log.d("myService", "Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
        sleep();
        sendMessage();
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("1");
        intent.putExtra("data", (PracticalTest01Var01MainActivity.s));
        Log.d("myService", PracticalTest01Var01MainActivity.s);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            Log.e("myService", interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    }

}

