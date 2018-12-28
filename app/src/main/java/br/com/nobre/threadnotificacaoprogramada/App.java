package br.com.nobre.threadnotificacaoprogramada;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CANAL_1_ID = "canal1";
    public static final String CANAL_2_ID = "canal2";

    @Override
    public void onCreate() {
        super.onCreate();

        criarCanaisNotificacao();
    }

    private void criarCanaisNotificacao() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel canal1 = new NotificationChannel(CANAL_1_ID, "Canal 1", NotificationManager.IMPORTANCE_HIGH);
            canal1.setDescription("Esse é o canal 1");

            NotificationChannel canal2 = new NotificationChannel(CANAL_2_ID, "Canal 2", NotificationManager.IMPORTANCE_LOW);
            canal2.setDescription("Esse é o canal 2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(canal1);
            notificationManager.createNotificationChannel(canal2);
        }
    }
}
